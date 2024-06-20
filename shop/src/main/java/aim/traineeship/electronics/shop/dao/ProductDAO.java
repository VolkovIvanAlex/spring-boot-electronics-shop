package aim.traineeship.electronics.shop.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import aim.traineeship.electronics.shop.entities.Product;


public interface ProductDAO
{
	Page<Product> findByCategoryCode(PageRequest pageRequest, String code);

	Optional<Product> findByProductCode(String code);
}
