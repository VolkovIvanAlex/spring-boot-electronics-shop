package aim.traineeship.electronics.shop.service;

import javax.servlet.http.HttpSession;

import aim.traineeship.electronics.shop.dto.CartDTO;
import aim.traineeship.electronics.shop.dto.NewProductDTO;


public interface CartService
{
	void addToCart(final NewProductDTO newProductDTO, final HttpSession session);

	CartDTO getByCode(String code);
}
