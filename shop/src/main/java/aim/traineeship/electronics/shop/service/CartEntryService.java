package aim.traineeship.electronics.shop.service;

import java.util.List;
import java.util.Optional;

import aim.traineeship.electronics.shop.entities.Cart;
import aim.traineeship.electronics.shop.entities.CartEntry;
import aim.traineeship.electronics.shop.entities.Product;


public interface CartEntryService
{
	void addCartEntry(final Product product, final Cart cart, final Integer quantity);

	void updateCartEntry(final Product product, final Cart cart, final Integer quantity, final Double totalPrice);

	void deleteCartEntry(final Product product, final Cart cart);

	Optional<CartEntry> getCartEntry(final Product product, final Cart cart);

	List<CartEntry> getCartEntries(final Cart cart);

	List<CartEntry> updateEntryNumbers(final List<CartEntry> cartEntries);
}
