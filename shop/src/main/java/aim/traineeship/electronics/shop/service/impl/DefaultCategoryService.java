package aim.traineeship.electronics.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.dao.CategoryDAO;
import aim.traineeship.electronics.shop.entities.Category;
import aim.traineeship.electronics.shop.service.CategoryService;

@Service
public class DefaultCategoryService implements CategoryService
{
	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	public List<Category> getCategories()
	{
		return categoryDAO.findCategories();
	}
}
