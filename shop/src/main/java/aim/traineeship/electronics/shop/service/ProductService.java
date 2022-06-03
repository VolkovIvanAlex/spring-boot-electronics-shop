package aim.traineeship.electronics.shop.service;

import java.util.List;

import aim.traineeship.electronics.shop.dto.ProductDTO;


public interface ProductService
{
	List<ProductDTO> getProductsByCategoryId(String categoryCode);

	ProductDTO getProductById(String productId);
}
