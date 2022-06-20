package aim.traineeship.electronics.shop.dao;

import java.util.List;
import java.util.Optional;

import aim.traineeship.electronics.shop.entities.CartEntry;


public interface CartEntryDAO
{
	void saveCartEntry(final CartEntry cartEntry);

	void updateExistingEntry(final Integer productId, final Integer cartId, final Integer quantity,
			final Double totalPrice);

	void deleteCartEntry(final Integer productId, final Integer cartId);

	Integer getMaxEntryNumber(final Integer cartId);

	List<CartEntry> getCartEntriesByCartId(final Integer cartId);

	Optional<CartEntry> getCartEntryByProductId(final Integer productId, final Integer cartId);
}
