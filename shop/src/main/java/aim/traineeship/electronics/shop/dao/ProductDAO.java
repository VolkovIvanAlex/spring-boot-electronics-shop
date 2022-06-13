package aim.traineeship.electronics.shop.dao;

import java.util.List;
import java.util.Optional;

import aim.traineeship.electronics.shop.entities.Product;


public interface ProductDAO
{
	List<Product> findByCategoryCode(String code);

	Optional<Product> findByProductCode(String code);
}
