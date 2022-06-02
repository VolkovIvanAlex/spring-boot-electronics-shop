package aim.traineeship.electronics.shop.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.dto.ProductDTO;
import aim.traineeship.electronics.shop.entities.Product;

@Component
public class ProductConverter implements Converter<List<Product> , List<ProductDTO>>
{
	@Override
	public List<ProductDTO> convert(final List<Product> productList)
	{
		final List<ProductDTO> productDTOList = new ArrayList<>();
		for (final Product product : productList)
		{
			final ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setCode(product.getCode());
			productDTO.setName(product.getName());
			productDTO.setPrice(product.getPrice());
			productDTO.setDescription(product.getDescription());
			productDTOList.add(productDTO);
		}
		return productDTOList;
	}
}
