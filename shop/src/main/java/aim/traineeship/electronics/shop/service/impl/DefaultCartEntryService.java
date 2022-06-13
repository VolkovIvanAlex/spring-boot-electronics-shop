package aim.traineeship.electronics.shop.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.converter.Converter;
import aim.traineeship.electronics.shop.dao.CartEntryDAO;
import aim.traineeship.electronics.shop.dto.CartDTO;
import aim.traineeship.electronics.shop.dto.CartEntryDTO;
import aim.traineeship.electronics.shop.dto.ProductDTO;
import aim.traineeship.electronics.shop.entities.CartEntry;
import aim.traineeship.electronics.shop.service.CartEntryService;


@Service
public class DefaultCartEntryService implements CartEntryService
{
	private static final Integer DEFAULT_ENTRY_NUMBER = 1;
	@Autowired
	private CartEntryDAO cartEntryDAO;

	@Autowired
	private Converter<CartEntryDTO, CartEntry> cartEntryDTOConverter;

	@Override
	public CartEntryDTO createCartEntry(final ProductDTO productDTO, final CartDTO cartDTO, final Integer quantity)
	{
		final CartEntryDTO cartEntryDTO = new CartEntryDTO();

		final Optional<Integer> entryNumber = cartEntryDAO.getCurrentEntryNumber(cartDTO.getId());
		if (entryNumber.isPresent())
		{
			cartEntryDTO.setEntryNumber(entryNumber.get()+1);
		}
		else cartEntryDTO.setEntryNumber(DEFAULT_ENTRY_NUMBER);

		cartEntryDTO.setTotalPrice(productDTO.getPrice() * quantity);
		cartEntryDTO.setQuantity(quantity);
		cartEntryDTO.setProductDTO(productDTO);
		cartEntryDTO.setCartDTO(cartDTO);
		cartEntryDAO.saveCartEntry(cartEntryDTOConverter.convert(cartEntryDTO));
		return cartEntryDTO;
	}
}
