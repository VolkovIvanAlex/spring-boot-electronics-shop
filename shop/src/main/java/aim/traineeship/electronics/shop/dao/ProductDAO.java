package aim.traineeship.electronics.shop.dao;

import java.util.List;

import aim.traineeship.electronics.shop.entities.Product;


public interface ProductDAO
{
	List<Product> findByCategoryCode(String code);

	Product findByProductCode(String code);
}
