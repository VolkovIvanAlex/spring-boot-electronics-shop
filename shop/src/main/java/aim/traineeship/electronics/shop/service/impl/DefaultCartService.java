package aim.traineeship.electronics.shop.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.converter.impl.CartConverter;
import aim.traineeship.electronics.shop.converter.impl.CartEntryConverter;
import aim.traineeship.electronics.shop.dao.CartDAO;
import aim.traineeship.electronics.shop.dto.AddToCartDTO;
import aim.traineeship.electronics.shop.dto.CartDTO;
import aim.traineeship.electronics.shop.entities.Cart;
import aim.traineeship.electronics.shop.entities.CartEntry;
import aim.traineeship.electronics.shop.entities.Customer;
import aim.traineeship.electronics.shop.entities.Product;
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

	@Autowired
	private CartDAO cartDao;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CartEntryService cartEntryService;

	@Autowired
	private CalculationService calculationService;

	@Autowired
	private CartConverter cartConverter;

	@Autowired
	private CartEntryConverter cartEntryConverter;

	@Override
	public void addToCart(final AddToCartDTO addToCartDTO, final HttpSession session)
	{
		Cart cart = getCurrentCart(session);
		final Product product = productService.getProductByCode(addToCartDTO.getProductCode());
		cartEntryService.addCartEntry(product, cart, addToCartDTO.getQuantity());

		calculationService.calculate(cart);
		cart = getCartByCode(cart.getCode());
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
		cart = createCart();
		return cart;
	}

	@Override
	public CartDTO getCurrentCartDTO(final HttpSession session)
	{
		final Cart cart = getCurrentCart(session);
		final CartDTO cartDTO = cartConverter.convert(cart);
		if (cartEntryService.getCartEntries(cart).size() > 0)
		{
			cartDTO.setCartEntries(cartEntryConverter.convertList(cart.getCartEntries()));
		}
		session.setAttribute(CART, cart);
		return cartDTO;
	}

	@Override
	public Cart getCartByCode(final String code)
	{
		return cartDao.findByCode(code);
	}

	@Override
	public void updateCart(final AddToCartDTO addToCartDTO, final HttpSession session)
	{
		final Product product = productService.getProductByCode(addToCartDTO.getProductCode());
		Cart cart = getCurrentCart(session);

		final int newQuantity = addToCartDTO.getQuantity();
		final double newTotalPrice = product.getPrice() * newQuantity;
		cartEntryService.updateCartEntry(product, cart, newQuantity, newTotalPrice);

		calculationService.calculate(cart);
		cart = getCartByCode(cart.getCode());
		cart.setCartEntries(cartEntryService.getCartEntries(cart));
		session.setAttribute(CART, cart);
	}

	@Override
	public void removeFromCart(final AddToCartDTO addToCartDTO, final HttpSession session)
	{
		final Product product = productService.getProductByCode(addToCartDTO.getProductCode());
		Cart cart = getCurrentCart(session);

		cartEntryService.deleteCartEntry(product, cart);
		List<CartEntry> cartEntries = cartEntryService.getCartEntries(cart);
		cartEntries = cartEntryService.updateEntryNumbers(cartEntries);

		calculationService.calculate(cart);
		cart = getCartByCode(cart.getCode());
		cart.setCartEntries(cartEntries);
		session.setAttribute(CART, cart);
	}

	private Cart createCart()
	{
		Cart newCart = new Cart();

		final UserDetails principal = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication()
				.getPrincipal();

		final Customer customer = customerService.findCustomerByLogin(principal.getUsername());
		newCart.setCustomer(customer);

		newCart.setCode(String.valueOf((int) System.currentTimeMillis()));
		newCart.setTotalPrice(DEFAULT_TOTAL_PRICE);

		cartDao.saveCart(newCart);
		newCart = getCartByCode(newCart.getCode());
		return newCart;
	}
}
