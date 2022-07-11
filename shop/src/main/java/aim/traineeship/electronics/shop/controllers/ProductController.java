package aim.traineeship.electronics.shop.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import aim.traineeship.electronics.shop.dto.ProductDTO;
import aim.traineeship.electronics.shop.service.ProductService;


@Controller
public class ProductController
{
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/products/{categoryCode}", method = RequestMethod.GET)
	public String products(@RequestParam(name = "page", defaultValue = "1") final Integer page,
			@RequestParam(name = "size", defaultValue = "10") final Integer pageSize, final Model model,
			@PathVariable("categoryCode") final String categoryCode)
	{
		final Page<ProductDTO> productsPage = productService.getProductsByCategoryCode(page, pageSize, categoryCode);
		model.addAttribute("productsPage", productsPage);
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

	@ExceptionHandler(NumberFormatException.class)
	public String invalidFormat()
	{
		return "redirect:/404";
	}
}
