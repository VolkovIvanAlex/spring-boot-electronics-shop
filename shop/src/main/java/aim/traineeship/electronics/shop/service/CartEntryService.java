package aim.traineeship.electronics.shop.service;

import aim.traineeship.electronics.shop.entities.Cart;
import aim.traineeship.electronics.shop.entities.Product;


public interface CartEntryService
{
	void createCartEntry(final Product product, final Cart cart, final Integer quantity);

	boolean isEntryExist(final Product product, final Cart cart);
}
