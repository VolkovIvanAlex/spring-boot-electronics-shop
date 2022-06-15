package aim.traineeship.electronics.shop.service.impl;

import java.util.Optional;

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
	private static final Integer DEFAULT_ENTRY_NUMBER = 1;
	@Autowired
	private CartEntryDAO cartEntryDAO;

	@Override
	public CartEntry createCartEntry(final Product product, final Cart cart, final Integer quantity)
	{
		final CartEntry cartEntry = new CartEntry();

		final Optional<Integer> entryNumber = cartEntryDAO.getCurrentEntryNumber(cart.getId());

		cartEntry.setEntryNumber(chooseEntryNumber(entryNumber));
		cartEntry.setTotalPrice(product.getPrice() * quantity);
		cartEntry.setQuantity(quantity);
		cartEntry.setProduct(product);
		cartEntry.setCart(cart);

		cartEntryDAO.saveCartEntry(cartEntry);
		return cartEntry;
	}

	private Integer chooseEntryNumber(final Optional<Integer> entryNumber)
	{
		return entryNumber.map(integer -> integer + 1).orElse(DEFAULT_ENTRY_NUMBER);
	}
}
