package aim.traineeship.electronics.shop.converter.impl;

import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.converter.Converter;
import aim.traineeship.electronics.shop.dto.ProductDTO;
import aim.traineeship.electronics.shop.entities.Product;


@Component
public class ProductConverter implements Converter<Product, ProductDTO>
{
	@Override
	public ProductDTO convert(final Product product)
	{
		final ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setCode(product.getCode());
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setDescription(product.getDescription());
		return productDTO;
	}
}
