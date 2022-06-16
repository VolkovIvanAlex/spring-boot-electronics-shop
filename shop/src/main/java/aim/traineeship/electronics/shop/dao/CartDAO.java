package aim.traineeship.electronics.shop.dao;

import aim.traineeship.electronics.shop.entities.Cart;


public interface CartDAO
{
	void saveCart(final Cart cart);

	Cart findByCode(String code);

	void updateCartTotalPrice(final String code, final Double price);
}
