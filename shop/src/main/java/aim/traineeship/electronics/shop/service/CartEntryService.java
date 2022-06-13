package aim.traineeship.electronics.shop.service;

import aim.traineeship.electronics.shop.dto.CartDTO;
import aim.traineeship.electronics.shop.dto.CartEntryDTO;
import aim.traineeship.electronics.shop.dto.ProductDTO;


public interface CartEntryService
{
	CartEntryDTO createCartEntry(final ProductDTO productDTO, final CartDTO cartDTO, final Integer quantity);
}
