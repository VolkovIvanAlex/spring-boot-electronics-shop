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

	private static final Integer DEFAULT_PAGE_SIZE = 10;

	@Override
	public Page<ProductDTO> getProductsByCategoryCode(final Integer page, final Integer pageSize,
			final String categoryCode)
	{
		final PageRequest pageRequest;
		if (page < 0 || pageSize < 0)
		{
			pageRequest = PageRequest.of(0, DEFAULT_PAGE_SIZE);
		}
		else
		{
			pageRequest = PageRequest.of(page - 1, pageSize);
		}
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
