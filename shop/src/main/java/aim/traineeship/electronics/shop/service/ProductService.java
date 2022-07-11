package aim.traineeship.electronics.shop.service;

import org.springframework.data.domain.Page;

import aim.traineeship.electronics.shop.dto.ProductDTO;
import aim.traineeship.electronics.shop.entities.Product;


public interface ProductService
{
	Page<ProductDTO> getProductsByCategoryCode(final Integer page, final Integer pageSize, String categoryCode);

	ProductDTO getProductDTOByCode(String productCode);

	Product getProductByCode(String productCode);
}
