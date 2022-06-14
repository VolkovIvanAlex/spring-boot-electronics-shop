package aim.traineeship.electronics.shop.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.converter.Converter;
import aim.traineeship.electronics.shop.dao.CartDAO;
import aim.traineeship.electronics.shop.dto.CartDTO;
import aim.traineeship.electronics.shop.dto.CartEntryDTO;
import aim.traineeship.electronics.shop.dto.CustomerDTO;
import aim.traineeship.electronics.shop.dto.NewProductDTO;
import aim.traineeship.electronics.shop.dto.ProductDTO;
import aim.traineeship.electronics.shop.entities.Cart;
import aim.traineeship.electronics.shop.service.CartCalculationService;
import aim.traineeship.electronics.shop.service.CartEntryService;
import aim.traineeship.electronics.shop.service.CartService;
import aim.traineeship.electronics.shop.service.CustomerDetailsService;
import aim.traineeship.electronics.shop.service.ProductService;


@Service
public class DefaultCartService implements CartService
{
	private static final Double DEFAULT_TOTAL_PRICE = 0.0;

	@Autowired
	private CartDAO cartDao;

	@Autowired
	private Converter<CartDTO, Cart> cartDTOConverter;

	@Autowired
	private Converter<Cart, CartDTO> cartConverter;

	@Autowired
	private CustomerDetailsService customerDetailsService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CartEntryService cartEntryService;

	@Autowired
	private CartCalculationService cartCalculationService;

	@Override
	public void addToCart(final NewProductDTO newProductDTO, final HttpSession session)
	{
		CartDTO cartDTO = (CartDTO) session.getAttribute("cart");
		if (cartDTO == null)
		{
			final CartDTO cart = new CartDTO();
			final UserDetails principal = (UserDetails) SecurityContextHolder.getContext()
					.getAuthentication()
					.getPrincipal();
			cart.setCode(String.valueOf((int) System.currentTimeMillis()));
			final CustomerDTO customer = customerDetailsService.getCustomerDTO(principal);
			cart.setCustomerDTO(customer);
			cart.setTotalPrice(DEFAULT_TOTAL_PRICE);
			cartDao.saveCart(cartDTOConverter.convert(cart));
			session.setAttribute("cart", getByCode(cart.getCode()));
			cartDTO = (CartDTO) session.getAttribute("cart");
		}
		final ProductDTO product = productService.getProductByCode(newProductDTO.getProductCode());
		final CartEntryDTO cartEntry = cartEntryService.createCartEntry(product, cartDTO,
				newProductDTO.getQuantity());

		cartCalculationService.calculate(cartDTO, cartEntry);
		session.setAttribute("cart", getByCode(cartDTO.getCode()));
	}

	@Override
	public CartDTO getByCode(final String code)
	{
		return cartConverter.convert(cartDao.findByCode(code));
	}
}
