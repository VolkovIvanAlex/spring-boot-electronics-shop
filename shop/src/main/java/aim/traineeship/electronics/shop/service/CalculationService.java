package aim.traineeship.electronics.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.dao.CartDAO;
import aim.traineeship.electronics.shop.dao.CartEntryDAO;
import aim.traineeship.electronics.shop.entities.Cart;
import aim.traineeship.electronics.shop.entities.CartEntry;


@Service
public class CalculationService
{
	@Autowired
	private CartDAO cartDao;

	@Autowired
	private CartEntryDAO cartEntryDAO;

	public void calculate(final Cart cart)
	{
		Integer entryNumber = 1;
		Double cartEntryTotalPrice = 0.0;

		Optional<CartEntry> cartEntry = cartEntryDAO.getCartEntryByCartId(cart.getId(), entryNumber++);
		while (cartEntry.isPresent())
		{
			cartEntryTotalPrice += cartEntry.get().getTotalPrice();
			cartEntry = cartEntryDAO.getCartEntryByCartId(cart.getId(), entryNumber++);
		}
		cartDao.updateCartTotalPrice(cart.getCode(), cartEntryTotalPrice);
	}
}
