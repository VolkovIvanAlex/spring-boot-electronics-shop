package aim.traineeship.electronics.shop.service;

import java.util.List;

import aim.traineeship.electronics.shop.entities.Product;


public interface ProductService
{
	List<Product> getProductsByCategory(String categoryCode);
}
