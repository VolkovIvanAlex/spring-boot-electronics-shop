package aim.traineeship.electronics.shop.dao;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import aim.traineeship.electronics.shop.entities.Cart;


public interface CartDAO
{
	Integer saveCart(final Cart cart);

	Cart findByCode(final String code);

	Optional<Cart> findFullByCode(final String code);

	Page<Cart> findOrdersByCustomerId(final PageRequest page, final Integer customerId);

	void updateCartTotalPrice(final String code, final Double price);

	void saveAddress(final String cartCode, final Integer addressId);

	void savePlacedDate(final String cartCode, final Date date);

	void saveCustomer(final Integer anonymousId, final String code);
}
