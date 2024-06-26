package aim.traineeship.electronics.shop.service;

import java.util.List;

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
		final List<CartEntry> cartEntries = cartEntryDAO.getCartEntriesByCartId(cart.getId());
		final double cartTotalPrice = cartEntries.stream().mapToDouble(CartEntry::getTotalPrice).sum();
		cartDao.updateCartTotalPrice(cart.getCode(), cartTotalPrice);
	}
}
