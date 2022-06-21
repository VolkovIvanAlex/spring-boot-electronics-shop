package aim.traineeship.electronics.shop.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.converter.Converter;
import aim.traineeship.electronics.shop.dto.CartEntryDTO;
import aim.traineeship.electronics.shop.dto.ProductDTO;
import aim.traineeship.electronics.shop.entities.CartEntry;
import aim.traineeship.electronics.shop.entities.Product;


@Component
public class CartEntryConverter implements Converter<CartEntry , CartEntryDTO>
{
	@Autowired
	private CartConverter cartConverter;

	@Autowired
	private ProductConverter productConverter;

	@Override
	public CartEntryDTO convert(final CartEntry cartEntry)
	{
		final CartEntryDTO cartEntryDTO = new CartEntryDTO();
		cartEntryDTO.setEntryNumber(cartEntry.getEntryNumber());
		cartEntryDTO.setQuantity(cartEntry.getQuantity());
		cartEntryDTO.setTotalPrice(cartEntry.getTotalPrice());

		final ProductDTO productDTO = new ProductDTO();
		final Product product = cartEntry.getProduct();
		productDTO.setId(product.getId());
		productDTO.setCode(product.getCode());
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setDescription(product.getDescription());

		cartEntryDTO.setProductDTO(productDTO);
		return cartEntryDTO;
	}
}
