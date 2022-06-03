package aim.traineeship.electronics.shop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aim.traineeship.electronics.shop.dto.ProductDTO;
import aim.traineeship.electronics.shop.service.ProductService;


@Controller
@RequestMapping(value = "/products")
public class ProductController
{
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
	public String products(final Model model, @PathVariable("categoryId") final String categoryId)
	{
		final List<ProductDTO> products = productService.getProductsByCategoryId(categoryId);
		model.addAttribute("products", products);
		return "plp";
	}

	@RequestMapping(value = "/{categoryId}/{productId}", method = RequestMethod.GET)
	public String productDetails(@PathVariable("categoryId") final String categoryId,
			@PathVariable("productId") final String productId, final Model model)
	{
		final ProductDTO product = productService.getProductById(productId);
		model.addAttribute("product", product);
		return "pdp";
	}
}
