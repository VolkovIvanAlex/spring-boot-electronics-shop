package aim.traineeship.electronics.shop.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.dao.CartDAO;
import aim.traineeship.electronics.shop.dto.AddToCartDTO;
import aim.traineeship.electronics.shop.entities.Cart;
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

	@Override
	public void addToCart(final AddToCartDTO addToCartDTO, final HttpSession session)
	{
		final Cart cart = getCurrentCart(session);
		final Product product = productService.getProductByCode(addToCartDTO.getProductCode());
		cartEntryService.addCartEntry(product, cart, addToCartDTO.getQuantity());

		calculationService.calculate(cart);
		session.setAttribute(CART, getCartByCode(cart.getCode()));
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
	public Cart getCartByCode(final String code)
	{
		return cartDao.findByCode(code);
	}

	private Cart createCart(final HttpSession session)
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
