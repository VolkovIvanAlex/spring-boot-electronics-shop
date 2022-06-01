package aim.traineeship.electronics.shop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aim.traineeship.electronics.shop.entities.Product;
import aim.traineeship.electronics.shop.service.ProductService;


@Controller
public class ProductController
{
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "categories/id/{categoryId}", method = RequestMethod.GET)
	public String laptops(final Model model, @PathVariable("categoryId") final String categoryId)
	{
		final List<Product> products = productService.getProductsByCategory(categoryId);
		model.addAttribute("products", products);
		return "plp";
	}
}
