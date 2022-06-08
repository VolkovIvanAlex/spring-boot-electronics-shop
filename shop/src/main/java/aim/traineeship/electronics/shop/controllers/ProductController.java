package aim.traineeship.electronics.shop.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aim.traineeship.electronics.shop.dto.ProductDTO;
import aim.traineeship.electronics.shop.service.ProductService;


@Controller
public class ProductController
{
	@Autowired
	private ProductService productService;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@RequestMapping(value = "/products/{categoryCode}", method = RequestMethod.GET)
	public String products(final Model model, @PathVariable("categoryCode") final String categoryCode)
	{
		final List<ProductDTO> products = productService.getProductsByCategoryCode(categoryCode);
		model.addAttribute("products", products);
		return "plp";
	}

	@RequestMapping(value = "/product/code_input/{productCode}", method = RequestMethod.GET)
	public String productDetails(@PathVariable("productCode") final String productCode, final Model model)
	{
		try
		{
			final ProductDTO product = productService.getProductByCode(productCode);
			model.addAttribute("product", product);
		}
		catch (final NoSuchElementException noSuchElementException)
		{
			LOGGER.error("Error while trying to get product with code {}", productCode, noSuchElementException);
			model.addAttribute("noSuchElementException", noSuchElementException);
		}
		return "pdp";
	}
}
