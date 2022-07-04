package aim.traineeship.electronics.shop.controllers;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import aim.traineeship.electronics.shop.dto.CartDTO;
import aim.traineeship.electronics.shop.dto.CheckoutDTO;
import aim.traineeship.electronics.shop.service.CartService;
import aim.traineeship.electronics.shop.validation.CheckoutValidator;


@Controller
public class CheckoutController
{
	private static final String CART = "cart";

	@Autowired
	private CartService cartService;

	@Autowired
	private CheckoutValidator checkoutValidator;

	@GetMapping("/checkout")
	public String checkout(final HttpSession session, final Model model)
	{
		final CartDTO cartDTO = cartService.getCurrentCartDTO(session);
		model.addAttribute(CART, cartDTO);
		model.addAttribute("checkoutDTO", new CheckoutDTO());
		return "checkout";
	}

	@PostMapping("/checkout/address")
	public String submitCart(@Valid @ModelAttribute("checkoutDTO") final CheckoutDTO checkoutDTO,
			final BindingResult result, final HttpSession session, final Model model)
	{
		final CartDTO cartDTO = cartService.getCurrentCartDTO(session);
		checkoutValidator.validate(checkoutDTO, result);
		if (result.hasErrors())
		{
			model.addAttribute(CART, cartDTO);
			return "checkout";
		}
		cartService.submitCart(checkoutDTO, session);
		return "redirect:/confirmation/" + cartDTO.getCode();
	}

	@GetMapping("/confirmation/{cartCode}")
	public String confirmation(@PathVariable("cartCode") final String cartCode, final Model model)
	{
		final CartDTO cart = cartService.geFullCartDTO(cartCode);
		model.addAttribute(CART, cart);
		return "confirmation";
	}

	@ExceptionHandler(NoSuchElementException.class)
	public String noElement()
	{
		return "redirect:/404";
	}
}
