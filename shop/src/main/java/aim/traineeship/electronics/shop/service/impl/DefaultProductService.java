package aim.traineeship.electronics.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public Page<ProductDTO> getProductsByCategoryCode(final PageRequest pageRequest, final String categoryCode)
	{
		final Page<Product> products = productDAO.findByCategoryCode(pageRequest, categoryCode);
		return products.map(productConverter::convert);
	}

	@Override
	public ProductDTO getProductDTOByCode(final String productCode)
	{
		return productConverter.convert(getProductByCode(productCode));
	}

	@Override
	public Product getProductByCode(final String productCode)
	{
		return productDAO.findByProductCode(productCode).orElseThrow();
	}
}
