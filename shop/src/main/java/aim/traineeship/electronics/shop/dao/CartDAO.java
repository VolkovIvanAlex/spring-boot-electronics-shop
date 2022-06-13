package aim.traineeship.electronics.shop.dao;

import java.util.Optional;

import aim.traineeship.electronics.shop.entities.Cart;


public interface CartDAO
{
	void saveCart(final Cart cart);

	Cart findByCode(String code);

	Optional<Integer> findBiggestCode();

	void updateCartTotalPrice(final String code, final Double price);
}
