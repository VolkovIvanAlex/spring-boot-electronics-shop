package aim.traineeship.electronics.shop.service;

import javax.servlet.http.HttpSession;

import aim.traineeship.electronics.shop.dto.CartDTO;


public interface CartService
{
	void createCart(final HttpSession session);

	CartDTO getByCode(String code);
}
