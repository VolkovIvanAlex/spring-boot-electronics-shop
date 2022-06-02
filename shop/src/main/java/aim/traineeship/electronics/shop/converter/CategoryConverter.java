package aim.traineeship.electronics.shop.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.dto.CategoryDTO;
import aim.traineeship.electronics.shop.entities.Category;


@Component
public class CategoryConverter implements Converter<List<Category>, List<CategoryDTO>>
{
	@Override
	public List<CategoryDTO> convert(final List<Category> categoryList)
	{
		final List<CategoryDTO> categoryDTOList = new ArrayList<>();
		for (final Category category : categoryList)
		{
			final CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO.setId(category.getId());
			categoryDTO.setCode(category.getCode());
			categoryDTO.setName(category.getName());
			categoryDTO.setProductsAmount(category.getProductsAmount());
			categoryDTOList.add(categoryDTO);
		}
		return categoryDTOList;
	}
}
