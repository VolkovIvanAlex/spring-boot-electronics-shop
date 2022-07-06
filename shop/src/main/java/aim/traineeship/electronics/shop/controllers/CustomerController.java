package aim.traineeship.electronics.shop.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import aim.traineeship.electronics.shop.dto.CartDTO;
import aim.traineeship.electronics.shop.dto.CustomerDTO;
import aim.traineeship.electronics.shop.service.CartService;
import aim.traineeship.electronics.shop.service.CustomerService;


@Controller
public class CustomerController
{
	@Autowired
	private CustomerService customerService;

	@Autowired
	private CartService cartService;

	@GetMapping("/my-account")
	public String myAccount(final Model model)
	{
		final CustomerDTO customerDTO = customerService.getAuthenticatedCustomerDTO();
		model.addAttribute("customerDTO", customerDTO);
		return "myAccount";
	}

	@GetMapping("/my-orders")
	public String myOrders(final Model model)
	{
		final List<CartDTO> orders = cartService.getOrdersCurrentCustomer();
		model.addAttribute("orders", orders);
		return "myOrders";
	}

	@ExceptionHandler(NoSuchElementException.class)
	public String noAuth()
	{
		return "redirect:/no-auth";
	}
}
