package aim.traineeship.electronics.shop.service;

import javax.servlet.http.HttpSession;

import aim.traineeship.electronics.shop.dto.AddToCartDTO;
import aim.traineeship.electronics.shop.entities.Cart;


public interface CartService
{
	void addToCart(final AddToCartDTO newProductDTO, final HttpSession session);

	Cart getCurrentCart(final HttpSession session);

	Cart getCartByCode(String code);
}
