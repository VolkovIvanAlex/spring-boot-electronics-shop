package aim.traineeship.electronics.shop.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import aim.traineeship.electronics.shop.dto.CartDTO;
import aim.traineeship.electronics.shop.dto.CartEntryDTO;
import aim.traineeship.electronics.shop.dto.ProductDTO;
import aim.traineeship.electronics.shop.service.CartCalculationService;
import aim.traineeship.electronics.shop.service.CartEntryService;
import aim.traineeship.electronics.shop.service.CartService;
import aim.traineeship.electronics.shop.service.ProductService;


@Controller
public class CartController
{
	@Autowired
	private ProductService productService;

	@Autowired
	private CartService cartService;

	@Autowired
	private CartEntryService cartEntryService;

	@Autowired
	private CartCalculationService cartCalculationService;

	@RequestMapping(value = "/products/addToCart", method = RequestMethod.POST)
	public String singleAddToCart(@RequestParam("productCode") final String productCode,
			@RequestParam("quantity") final Integer quantity, @RequestParam("pageName") final String pageName,
			final HttpSession session)
	{
		cartService.createCart(session);

		final ProductDTO product = productService.getProductByCode(productCode);
		final CartDTO cartDTO = (CartDTO) session.getAttribute("cart");
		final CartEntryDTO cartEntry = cartEntryService.createCartEntry(product, cartDTO, quantity);

		cartCalculationService.setTotalPrice(cartDTO, cartEntry);
		session.setAttribute("cart", cartService.getByCode(cartDTO.getCode()));
		switch (pageName)
		{
			case "plp" : return "redirect:/products/" + product.getCategoryDTO().getCode();
			case "pdp" : return "redirect:/product/" + product.getCode();
		}
		return "redirect:/";
	}
}
