package aim.traineeship.electronics.shop.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.converter.Converter;
import aim.traineeship.electronics.shop.dto.CartEntryDTO;
import aim.traineeship.electronics.shop.entities.CartEntry;


@Component
public class CartEntryConverter implements Converter<CartEntry, CartEntryDTO>
{
	@Autowired
	private ProductConverter productConverter;

	@Override
	public CartEntryDTO convert(final CartEntry cartEntry)
	{
		final CartEntryDTO cartEntryDTO = new CartEntryDTO();
		cartEntryDTO.setEntryNumber(cartEntry.getEntryNumber());
		cartEntryDTO.setQuantity(cartEntry.getQuantity());
		cartEntryDTO.setTotalPrice(cartEntry.getTotalPrice());

		cartEntryDTO.setProductDTO(productConverter.convert(cartEntry.getProduct()));
		return cartEntryDTO;
	}
}
