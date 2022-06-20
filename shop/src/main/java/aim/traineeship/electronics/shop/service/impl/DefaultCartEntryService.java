package aim.traineeship.electronics.shop.service.impl;

import java.util.List;
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
	@Autowired
	private CartEntryDAO cartEntryDAO;

	@Override
	public void addCartEntry(final Product product, final Cart cart, final Integer quantity)
	{
		final Optional<CartEntry> cartEntry = getCartEntry(product, cart);
		if (cartEntry.isPresent())
		{
			final CartEntry existingCartEntry = cartEntry.get();

			final int newQuantity = existingCartEntry.getQuantity() + quantity;
			final double newTotalPrice = existingCartEntry.getTotalPrice() + product.getPrice() * quantity;
			cartEntryDAO.updateExistingEntry(product.getId(), cart.getId(), newQuantity, newTotalPrice);
			return;
		}
		createNewCartEntry(product, cart, quantity);
	}

	@Override
	public void updateCartEntry(final Product product, final Cart cart, final Integer quantity, final Double totalPrice)
	{
		cartEntryDAO.updateExistingEntry(product.getId(), cart.getId(), quantity, totalPrice);
	}

	@Override
	public void deleteCartEntry(final Product product, final Cart cart)
	{
		cartEntryDAO.deleteCartEntry(product.getId(), cart.getId());
	}

	@Override
	public Optional<CartEntry> getCartEntry(final Product product, final Cart cart)
	{
		return cartEntryDAO.getCartEntryByProductId(product.getId(), cart.getId());
	}

	@Override
	public List<CartEntry> getCartEntries(final Cart cart)
	{
		return cartEntryDAO.getCartEntriesByCartId(cart.getId());
	}

	private void createNewCartEntry(final Product product, final Cart cart, final Integer quantity)
	{
		final CartEntry cartEntry = new CartEntry();
		final Integer entryNumber = cartEntryDAO.getMaxEntryNumber(cart.getId());

		cartEntry.setEntryNumber(entryNumber);

		cartEntry.setTotalPrice(product.getPrice() * quantity);
		cartEntry.setQuantity(quantity);
		cartEntry.setProduct(product);
		cartEntry.setCart(cart);
		cartEntryDAO.saveCartEntry(cartEntry);
	}
}
