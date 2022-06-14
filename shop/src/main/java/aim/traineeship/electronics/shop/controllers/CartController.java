package aim.traineeship.electronics.shop.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aim.traineeship.electronics.shop.dto.NewProductDTO;
import aim.traineeship.electronics.shop.service.CartService;


@RestController
public class CartController
{
	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/product/addToCart", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public void addToCart(final NewProductDTO newProductDTO, final HttpSession session)
	{
		cartService.addToCart(newProductDTO, session);
	}
}
