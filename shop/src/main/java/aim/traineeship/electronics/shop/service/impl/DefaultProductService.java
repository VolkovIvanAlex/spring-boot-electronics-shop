package aim.traineeship.electronics.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.converter.impl.ProductConverter;
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
	public List<ProductDTO> getProductsByCategoryCode(final String categoryCode)
	{
		final List<Product> products = productDAO.findByCategoryCode(categoryCode);
		return productConverter.convertList(products);
	}

	@Override
	public ProductDTO getProductDTOByCode(final String productCode)
	{
		return productConverter.convert(productDAO.findByProductCode(productCode).orElseThrow());
	}

	@Override
	public Product getProductByCode(final String productCode)
	{
		return productDAO.findByProductCode(productCode).orElseThrow();
	}
}
