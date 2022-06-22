package aim.traineeship.electronics.shop.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.converter.Converter;
import aim.traineeship.electronics.shop.dto.ProductDTO;
import aim.traineeship.electronics.shop.entities.Category;
import aim.traineeship.electronics.shop.entities.Product;


@Component
public class ProductConverter implements Converter<Product, ProductDTO>
{
	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public ProductDTO convert(final Product product)
	{
		final ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setCode(product.getCode());
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setDescription(product.getDescription());

		final Category category = product.getCategory();
		if (category != null)
		{
			productDTO.setCategoryDTO(categoryConverter.convert(category));
		}

		return productDTO;
	}
}
