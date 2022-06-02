package aim.traineeship.electronics.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.converter.CategoryConverter;
import aim.traineeship.electronics.shop.dao.CategoryDAO;
import aim.traineeship.electronics.shop.dto.CategoryDTO;
import aim.traineeship.electronics.shop.entities.Category;
import aim.traineeship.electronics.shop.service.CategoryService;


@Service
public class DefaultCategoryService implements CategoryService
{
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public List<CategoryDTO> getCategories()
	{
		final List<Category> categories = categoryDAO.findCategories();
		final List<CategoryDTO> categoryDTOList = new ArrayList<>();
		for (final Category category : categories)
		{
			final CategoryDTO categoryDTO = categoryConverter.convert(category);
			categoryDTOList.add(categoryDTO);
		}
		return categoryDTOList;
	}
}
