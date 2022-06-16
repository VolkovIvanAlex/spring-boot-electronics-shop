package aim.traineeship.electronics.shop.dao;

import java.util.List;
import java.util.Optional;

import aim.traineeship.electronics.shop.entities.CartEntry;


public interface CartEntryDAO
{
	void saveCartEntry(final CartEntry cartEntry);

	Integer getCurrentEntryNumber(final Integer cartId);

	List<CartEntry> getCartEntriesByCartId(final Integer cartId);

	Optional<CartEntry> getSingleCartEntry(final Integer productId, final Integer cartId);

	void updateExistingEntry(final Integer productId, final Integer cartId, final Integer quantity,
			final Double totalPrice);
}
