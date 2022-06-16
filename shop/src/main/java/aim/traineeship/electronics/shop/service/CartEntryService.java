package aim.traineeship.electronics.shop.service;

import java.util.Optional;

import aim.traineeship.electronics.shop.entities.Cart;
import aim.traineeship.electronics.shop.entities.CartEntry;
import aim.traineeship.electronics.shop.entities.Product;


public interface CartEntryService
{
	void addCartEntry(final Product product, final Cart cart, final Integer quantity);

	Optional<CartEntry> getCartEntry(final Product product, final Cart cart);
}
