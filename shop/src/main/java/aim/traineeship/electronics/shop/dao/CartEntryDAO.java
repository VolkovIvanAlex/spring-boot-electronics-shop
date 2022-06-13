package aim.traineeship.electronics.shop.dao;

import java.util.Optional;

import aim.traineeship.electronics.shop.entities.CartEntry;


public interface CartEntryDAO
{
	void saveCartEntry(final CartEntry cartEntry);
	Optional<Integer> getCurrentEntryNumber(final Integer cartID);
}
