package aim.traineeship.electronics.shop.service;

import javax.servlet.http.HttpSession;

import aim.traineeship.electronics.shop.dto.AddToCartDTO;
import aim.traineeship.electronics.shop.dto.RemoveFromCartDTO;
import aim.traineeship.electronics.shop.dto.UpdateCartDTO;
import aim.traineeship.electronics.shop.entities.Cart;


public interface CartService
{
	void addToCart(final AddToCartDTO newProductDTO, final HttpSession session);

	void updateCart(final UpdateCartDTO updateCartDTO, final HttpSession session);

	void removeFromCart(final RemoveFromCartDTO removeFromCartDTO, final HttpSession session);

	Cart getCurrentCart(final HttpSession session);

	Cart getCartByCode(final String code);
}