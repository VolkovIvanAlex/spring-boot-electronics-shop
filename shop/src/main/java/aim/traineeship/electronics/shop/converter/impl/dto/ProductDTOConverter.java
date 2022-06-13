package aim.traineeship.electronics.shop.converter.impl.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.converter.Converter;
import aim.traineeship.electronics.shop.dto.ProductDTO;
import aim.traineeship.electronics.shop.entities.Product;

@Component
public class ProductDTOConverter implements Converter<ProductDTO , Product>
{
	@Autowired
	private CategoryDTOConverter categoryDTOConverter;
	@Override
	public Product convert(final ProductDTO productDTO)
	{
		final Product product = new Product();
		product.setId(productDTO.getId());
		product.setCode(productDTO.getCode());
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setDescription(productDTO.getDescription());
		product.setCategory(categoryDTOConverter.convert(productDTO.getCategoryDTO()));
		return product;
	}
}
