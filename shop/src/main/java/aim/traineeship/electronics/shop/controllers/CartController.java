package aim.traineeship.electronics.shop.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import aim.traineeship.electronics.shop.dto.AddToCartDTO;
import aim.traineeship.electronics.shop.dto.CartModificationDTO;
import aim.traineeship.electronics.shop.dto.RemoveFromCartDTO;
import aim.traineeship.electronics.shop.dto.UpdateCartDTO;
import aim.traineeship.electronics.shop.entities.Cart;
import aim.traineeship.electronics.shop.entities.CartEntry;
import aim.traineeship.electronics.shop.service.CartEntryService;
import aim.traineeship.electronics.shop.service.CartService;


@Controller
public class CartController
{
	@Autowired
	private CartService cartService;

	@Autowired
	private CartEntryService cartEntryService;

	@RequestMapping(value = "/cart/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<CartModificationDTO> addToCart(@Valid final AddToCartDTO addToCartDTO,
			final BindingResult bindingResult, final HttpSession session)
	{
		if (bindingResult.hasErrors())
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		cartService.addToCart(addToCartDTO, session);
		return new ResponseEntity<>(new CartModificationDTO(addToCartDTO.getProductCode(), addToCartDTO.getQuantity()),
				HttpStatus.OK);
	}

	@PostMapping("/cart/update")
	public String updateCartEntry(@Valid final UpdateCartDTO updateCartDTO, final BindingResult bindingResult,
			final HttpSession session)
	{
		if (bindingResult.hasErrors())
		{
			return "redirect:/cart";
		}
		cartService.updateCart(updateCartDTO, session);
		return "redirect:/cart";
	}

	@PostMapping("/cart/remove")
	public String removeFromCart(final RemoveFromCartDTO removeFromCartDTO, final HttpSession session)
	{
		cartService.removeFromCart(removeFromCartDTO, session);
		return "redirect:/cart";
	}

	@GetMapping("/cart")
	public String showCart(final HttpSession session, final Model model)
	{
		final Cart cart = cartService.getCurrentCart(session);
		final List<CartEntry> cartEntries = cartEntryService.getCartEntries(cart);
		if (cartEntries.size() > 0)
		{
			model.addAttribute("cartEntries", cartEntries);
		}
		return "cart";
	}
}



