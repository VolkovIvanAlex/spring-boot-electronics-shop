package aim.traineeship.electronics.shop.dao;

import java.util.List;

import aim.traineeship.electronics.shop.entities.Category;


public interface CategoryDAO
{
	List<Category> findCategories();
}
