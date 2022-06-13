package aim.traineeship.electronics.shop.converter.impl.dto;

import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.converter.Converter;
import aim.traineeship.electronics.shop.dto.CategoryDTO;
import aim.traineeship.electronics.shop.entities.Category;

@Component
public class CategoryDTOConverter implements Converter<CategoryDTO , Category>
{
	@Override
	public Category convert(final CategoryDTO categoryDTO)
	{
		final Category category = new Category();
		category.setId(categoryDTO.getId());
		category.setCode(categoryDTO.getCode());
		category.setName(categoryDTO.getName());
		category.setProductsAmount(categoryDTO.getProductsAmount());
		return category;
	}
}
