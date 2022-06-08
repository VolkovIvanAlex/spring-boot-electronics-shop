package aim.traineeship.electronics.shop.service;

import java.util.List;

import aim.traineeship.electronics.shop.dto.ProductDTO;


public interface ProductService
{
	List<ProductDTO> getProductsByCategoryCode(String categoryCode);

	ProductDTO getProductByCode(String productCode);
}
