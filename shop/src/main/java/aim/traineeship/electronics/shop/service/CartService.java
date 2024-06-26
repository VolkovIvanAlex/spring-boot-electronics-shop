package aim.traineeship.electronics.shop.service;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import aim.traineeship.electronics.shop.dto.AddToCartDTO;
import aim.traineeship.electronics.shop.dto.CartDTO;
import aim.traineeship.electronics.shop.dto.CheckoutDTO;
import aim.traineeship.electronics.shop.entities.Cart;


public interface CartService
{
	void addToCart(final AddToCartDTO newProductDTO, final HttpSession session);

	void updateCart(final AddToCartDTO addToCartDTO, final HttpSession session);

	void submitCart(CheckoutDTO addressDTO, final HttpSession session);

	Cart getCurrentCart(final HttpSession session);

	CartDTO getCurrentCartDTO(final HttpSession session);

	Cart getCartByCode(final String code);

	CartDTO geFullCartDTO(final String code);

	Page<CartDTO> getOrdersByCustomerId(PageRequest pageRequest, final Integer customerId);
}