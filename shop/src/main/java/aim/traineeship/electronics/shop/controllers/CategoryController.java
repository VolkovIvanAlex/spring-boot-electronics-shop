package aim.traineeship.electronics.shop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import aim.traineeship.electronics.shop.dto.CategoryDTO;
import aim.traineeship.electronics.shop.service.CategoryService;


@Controller
public class CategoryController
{
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/categories")
	public String categories(final Model model)
	{
		final List<CategoryDTO> categories = categoryService.getCategories();
		model.addAttribute("categories", categories);
		return "categories";
	}
}
