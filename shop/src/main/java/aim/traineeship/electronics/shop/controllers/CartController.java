package aim.traineeship.electronics.shop.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import aim.traineeship.electronics.shop.dto.AddToCartDTO;
import aim.traineeship.electronics.shop.dto.CartModificationDTO;
import aim.traineeship.electronics.shop.service.CartService;


@RestController
public class CartController
{
	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/cart/add", method = RequestMethod.POST)
	public ResponseEntity<CartModificationDTO> addToCart(@Valid final AddToCartDTO addToCartDTO,
			final BindingResult bindingResult,
			final HttpSession session)
	{
		if (bindingResult.hasErrors())
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		cartService.addToCart(addToCartDTO, session);
		return new ResponseEntity<>(new CartModificationDTO(addToCartDTO), HttpStatus.OK);
	}
}

