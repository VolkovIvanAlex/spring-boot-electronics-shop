package aim.traineeship.electronics.shop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import aim.traineeship.electronics.shop.dto.ProductDTO;
import aim.traineeship.electronics.shop.entities.Product;


public interface ProductService
{
	Page<ProductDTO> getProductsByCategoryCode(PageRequest pageRequest, String categoryCode);

	ProductDTO getProductDTOByCode(String productCode);

	Product getProductByCode(String productCode);
}
