package aim.traineeship.electronics.shop.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.dto.CategoryDTO;
import aim.traineeship.electronics.shop.entities.Category;


@Component
public class CategoryConverter implements Converter<Category, CategoryDTO>
{
	@Override
	public CategoryDTO convert(final Category category)
	{
		final CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setCode(category.getCode());
		categoryDTO.setName(category.getName());
		categoryDTO.setProductsAmount(category.getProductsAmount());
		return categoryDTO;
	}
}
