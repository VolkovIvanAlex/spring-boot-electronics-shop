package aim.traineeship.electronics.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.dao.CartDAO;
import aim.traineeship.electronics.shop.dto.CartDTO;
import aim.traineeship.electronics.shop.dto.CartEntryDTO;


@Service
public class CartCalculationService
{
	@Autowired
	private CartDAO cartDao;

	public void setTotalPrice(final CartDTO cart, final CartEntryDTO cartEntry)
	{
		cartDao.updateCartTotalPrice(cart.getCode(), cart.getTotalPrice() + cartEntry.getTotalPrice());
	}
}
