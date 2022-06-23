package aim.traineeship.electronics.shop.dao;

import java.util.Date;
import java.util.Optional;

import aim.traineeship.electronics.shop.entities.Cart;


public interface CartDAO
{
	void saveCart(final Cart cart);

	Cart findByCode(String code);

	Optional<Cart> findFullByCode(String code);

	void updateCartTotalPrice(final String code, final Double price);

	void saveAddress(final String cartCode, final Integer addressId);

	void savePlacedDate(final String cartCode, final Date date);
}
