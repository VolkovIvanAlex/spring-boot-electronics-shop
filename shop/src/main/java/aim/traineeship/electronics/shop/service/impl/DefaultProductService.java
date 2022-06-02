package aim.traineeship.electronics.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.converter.ProductConverter;
import aim.traineeship.electronics.shop.dao.ProductDAO;
import aim.traineeship.electronics.shop.dto.ProductDTO;
import aim.traineeship.electronics.shop.entities.Product;
import aim.traineeship.electronics.shop.service.ProductService;


@Service
public class DefaultProductService implements ProductService
{
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private ProductConverter productConverter;

	@Override
	public List<ProductDTO> getProductsByCategoryId(final String categoryId)
	{
		final List<Product> products = productDAO.findByCategoryId(categoryId);
		final List<ProductDTO> productDTOList = new ArrayList<>();
		for (final Product product : products)
		{
			final ProductDTO productDTO = productConverter.convert(product);
			productDTOList.add(productDTO);
		}
		return productDTOList;
	}
}
