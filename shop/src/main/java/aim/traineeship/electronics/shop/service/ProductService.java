package aim.traineeship.electronics.shop.service;

import java.util.List;

import aim.traineeship.electronics.shop.dto.ProductDTO;
import aim.traineeship.electronics.shop.entities.Product;


public interface ProductService
{
	List<ProductDTO> getProductsByCategoryCode(String categoryCode);

	ProductDTO getProductDTOByCode(String productCode);

	Product getProductByCode(String productCode);
}
