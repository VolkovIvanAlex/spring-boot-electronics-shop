package aim.traineeship.electronics.shop.converter.impl.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.converter.Converter;
import aim.traineeship.electronics.shop.dto.CartEntryDTO;
import aim.traineeship.electronics.shop.entities.CartEntry;


@Component
public class CartEntryDTOConverter implements Converter<CartEntryDTO, CartEntry>
{
	@Autowired
	private ProductDTOConverter productDTOConverter;

	@Autowired
	private CartDTOConverter cartDTOConverter;

	@Override
	public CartEntry convert(final CartEntryDTO cartEntryDTO)
	{
		final CartEntry cartEntry = new CartEntry();
		cartEntry.setEntryNumber(cartEntryDTO.getEntryNumber());
		cartEntry.setQuantity(cartEntryDTO.getQuantity());
		cartEntry.setTotalPrice(cartEntryDTO.getTotalPrice());
		cartEntry.setCart(cartDTOConverter.convert(cartEntryDTO.getCartDTO()));
		cartEntry.setProduct(productDTOConverter.convert(cartEntryDTO.getProductDTO()));
		return cartEntry;
	}
}
