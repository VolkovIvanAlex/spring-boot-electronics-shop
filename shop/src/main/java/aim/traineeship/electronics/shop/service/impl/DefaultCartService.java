package aim.traineeship.electronics.shop.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.converter.Converter;
import aim.traineeship.electronics.shop.dao.CartDAO;
import aim.traineeship.electronics.shop.dto.CartDTO;
import aim.traineeship.electronics.shop.dto.CustomerDTO;
import aim.traineeship.electronics.shop.entities.Cart;
import aim.traineeship.electronics.shop.service.CartService;
import aim.traineeship.electronics.shop.service.CustomerDetailsService;


@Service
public class DefaultCartService implements CartService
{
	private static final Double DEFAULT_TOTAL_PRICE = 0.0;

	@Autowired
	private CartDAO cartDao;

	@Autowired
	private CustomerDetailsService customerDetailsService;

	@Autowired
	private Converter<CartDTO , Cart> cartDTOConverter;

	@Autowired
	private Converter<Cart, CartDTO> cartConverter;

	@Override
	public void createCart(final HttpSession session)
	{
		if (session.getAttribute("cart") == null)
		{
			final CartDTO cart = new CartDTO();
			final UserDetails principal = (UserDetails) SecurityContextHolder.getContext()
					.getAuthentication()
					.getPrincipal();
			cart.setCode(String.valueOf((int)System.currentTimeMillis()));
			final CustomerDTO customer = customerDetailsService.getCustomerDTO(principal);
			cart.setCustomerDTO(customer);
			cart.setTotalPrice(DEFAULT_TOTAL_PRICE);
			cartDao.saveCart(cartDTOConverter.convert(cart));
			session.setAttribute("cart", getByCode(cart.getCode()));
		}
	}

	@Override
	public CartDTO getByCode(final String code)
	{
		return cartConverter.convert(cartDao.findByCode(code));
	}
}
