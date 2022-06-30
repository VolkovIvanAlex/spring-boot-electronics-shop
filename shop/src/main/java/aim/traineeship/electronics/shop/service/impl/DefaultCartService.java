package aim.traineeship.electronics.shop.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.converter.impl.CartConverter;
import aim.traineeship.electronics.shop.dao.CartDAO;
import aim.traineeship.electronics.shop.dto.AddToCartDTO;
import aim.traineeship.electronics.shop.dto.AddressDTO;
import aim.traineeship.electronics.shop.dto.AnonymousDTO;
import aim.traineeship.electronics.shop.dto.CartDTO;
import aim.traineeship.electronics.shop.dto.CheckoutDTO;
import aim.traineeship.electronics.shop.entities.Cart;
import aim.traineeship.electronics.shop.entities.CartEntry;
import aim.traineeship.electronics.shop.entities.Customer;
import aim.traineeship.electronics.shop.entities.Product;
import aim.traineeship.electronics.shop.service.AddressService;
import aim.traineeship.electronics.shop.service.CalculationService;
import aim.traineeship.electronics.shop.service.CartEntryService;
import aim.traineeship.electronics.shop.service.CartService;
import aim.traineeship.electronics.shop.service.CustomerService;
import aim.traineeship.electronics.shop.service.ProductService;


@Service
public class DefaultCartService implements CartService
{
	private static final Double DEFAULT_TOTAL_PRICE = 0.0;
	private static final String CART = "cart";

	private static final LocalDate date = LocalDate.now();
	private static final ZoneId defaultZoneId = ZoneId.systemDefault();

	@Autowired
	private CartDAO cartDao;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CartEntryService cartEntryService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private CalculationService calculationService;

	@Autowired
	private CartConverter cartConverter;

	@Override
	public void addToCart(final AddToCartDTO addToCartDTO, final HttpSession session)
	{
		final Cart cart = getCurrentCart(session);
		final Product product = productService.getProductByCode(addToCartDTO.getProductCode());
		cartEntryService.addCartEntry(product, cart, addToCartDTO.getQuantity());

		final Double cartTotalPrice = calculationService.calculate(cart);
		cart.setTotalPrice(cartTotalPrice);
		cart.setCartEntries(cartEntryService.getCartEntries(cart));
		session.setAttribute(CART, cart);
	}

	@Override
	public Cart getCurrentCart(final HttpSession session)
	{
		Cart cart = (Cart) session.getAttribute(CART);
		if (cart != null)
		{
			return cart;
		}
		cart = createCart(session);
		return cart;
	}

	@Override
	public CartDTO getCurrentCartDTO(final HttpSession session)
	{
		final Cart cart = getCurrentCart(session);
		final Optional<Customer> customer = getAuthenticatedCustomer();
		if (customer.isPresent())
		{
			cart.setCustomer(customer.get());
			updateCustomer(cart.getCustomer().getId(), cart);
		}
		return cartConverter.convert(cart);
	}

	@Override
	public Cart getCartByCode(final String code)
	{
		return cartDao.findByCode(code);
	}

	@Override
	public CartDTO geFullCartDTO(final String code)
	{
		final Cart cart;
		if (getAuthenticatedCustomer().isEmpty())
		{
			cart = cartDao.findFullByCodeAnonymous(code).orElseThrow();
		}
		else
		{
			cart = cartDao.findFullByCode(code).orElseThrow();
		}

		cart.setCartEntries(cartEntryService.getCartEntries(cart));
		return cartConverter.convert(cart);
	}

	@Override
	public void updateCart(final AddToCartDTO addToCartDTO, final HttpSession session)
	{
		final Product product = productService.getProductByCode(addToCartDTO.getProductCode());
		final Cart cart = getCurrentCart(session);
		final List<CartEntry> cartEntries;

		if (addToCartDTO.getQuantity() == 0)
		{
			cartEntryService.deleteCartEntry(product, cart);
			cartEntries = cartEntryService.updateEntryNumbers(cart);
		}
		else
		{
			final int newQuantity = addToCartDTO.getQuantity();
			final double newTotalPrice = product.getPrice() * newQuantity;
			cartEntryService.updateCartEntry(product, cart, newQuantity, newTotalPrice);
			cartEntries = cartEntryService.getCartEntries(cart);
		}
		cart.setCartEntries(cartEntries);

		final Double cartTotalPrice = calculationService.calculate(cart);
		cart.setTotalPrice(cartTotalPrice);

		session.setAttribute(CART, cart);
	}

	@Override
	public void submitCart(final CheckoutDTO checkoutDTO, final HttpSession session)
	{
		final Cart cart = getCurrentCart(session);

		final AddressDTO addressDTO = checkoutDTO.getAddressDTO();
		final Integer addressId = addressService.saveAddress(addressDTO);
		addressDTO.setId(addressId);
		updateAddress(addressDTO, cart);

		if (cart.getCustomer() == null)
		{
			final Integer anonymousId = customerService.registerAnonymousUser(new AnonymousDTO(checkoutDTO));
			updateCustomer(anonymousId, cart);
		}

		updatePlacedDate(cart);
		session.removeAttribute(CART);
	}

	private Cart createCart(final HttpSession session)
	{
		final Cart newCart = new Cart();

		newCart.setCode(String.valueOf((int) System.currentTimeMillis()));
		newCart.setTotalPrice(DEFAULT_TOTAL_PRICE);

		final Optional<Customer> authenticatedCustomer = getAuthenticatedCustomer();
		authenticatedCustomer.ifPresent(newCart::setCustomer);

		final Integer cartId = cartDao.saveCart(newCart);
		newCart.setId(cartId);
		session.setAttribute(CART, newCart);
		return newCart;
	}

	private Optional<Customer> getAuthenticatedCustomer()
	{
		Optional<Customer> customer = Optional.empty();
		try
		{
			final UserDetails principal = (UserDetails) SecurityContextHolder.getContext()
					.getAuthentication()
					.getPrincipal();
			customer = Optional.ofNullable(customerService.findCustomerByLogin(principal.getUsername()));
			return customer;
		}
		catch (final ClassCastException castException)
		{
			return customer;
		}
	}

	private void updateAddress(final AddressDTO addressDTO, final Cart cart)
	{
		cartDao.saveAddress(cart.getCode(), addressDTO.getId());
	}

	private void updatePlacedDate(final Cart cart)
	{
		final Date placedDate = Date.from(date.atStartOfDay(defaultZoneId).toInstant());
		cartDao.savePlacedDate(cart.getCode(), placedDate);
	}

	private void updateCustomer(final Integer customerId, final Cart cart)
	{
		cartDao.saveCustomer(customerId, cart.getCode());
	}
}
