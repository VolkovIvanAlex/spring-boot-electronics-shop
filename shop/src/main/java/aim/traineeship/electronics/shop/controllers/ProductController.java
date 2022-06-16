package aim.traineeship.electronics.shop.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

	@RequestMapping(value = "/products/{categoryCode}", method = RequestMethod.GET)
	public String products(final Model model, @PathVariable("categoryCode") final String categoryCode)
	{
		final List<ProductDTO> products = productService.getProductsByCategoryCode(categoryCode);
		model.addAttribute("products", products);
		return "plp";
	}

	@RequestMapping(value = "/product/{productCode}", method = RequestMethod.GET)
	public String productDetails(@PathVariable("productCode") final String productCode, final Model model)
	{
		final ProductDTO product = productService.getProductDTOByCode(productCode);
		model.addAttribute("product", product);
		return "pdp";
	}

	@ExceptionHandler(NoSuchElementException.class)
	public String noElement()
	{
		return "redirect:/404";
	}
}
