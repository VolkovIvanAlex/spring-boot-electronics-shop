package aim.traineeship.electronics.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.dao.CartEntryDAO;
import aim.traineeship.electronics.shop.entities.Cart;
import aim.traineeship.electronics.shop.entities.CartEntry;
import aim.traineeship.electronics.shop.entities.Product;
import aim.traineeship.electronics.shop.service.CartEntryService;


@Service
public class DefaultCartEntryService implements CartEntryService
{
	@Autowired
	private CartEntryDAO cartEntryDAO;

	@Override
	public void createCartEntry(final Product product, final Cart cart, final Integer quantity)
	{
		if (isEntryExist(product, cart))
		{
			final CartEntry existingCartEntry = cartEntryDAO.getSingleCartEntry(product.getId(), cart.getId()).get();
			cartEntryDAO.updateExistingEntry(product.getId(), cart.getId(),
					existingCartEntry.getQuantity() + quantity,
					existingCartEntry.getTotalPrice() + product.getPrice() * quantity);
		}
		else
		{
			createNewCartEntry(product, cart, quantity);
		}
	}

	@Override
	public boolean isEntryExist(final Product product, final Cart cart)
	{
		return cartEntryDAO.getSingleCartEntry(product.getId(), cart.getId()).isPresent();
	}

	private void createNewCartEntry(final Product product, final Cart cart, final Integer quantity)
	{
		final CartEntry cartEntry = new CartEntry();
		final Integer entryNumber = cartEntryDAO.getCurrentEntryNumber(cart.getId());

		cartEntry.setEntryNumber(entryNumber);

		cartEntry.setTotalPrice(product.getPrice() * quantity);
		cartEntry.setQuantity(quantity);
		cartEntry.setProduct(product);
		cartEntry.setCart(cart);
		cartEntryDAO.saveCartEntry(cartEntry);
	}
}
