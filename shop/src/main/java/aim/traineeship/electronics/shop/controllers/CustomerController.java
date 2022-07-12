package aim.traineeship.electronics.shop.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@Autowired
	private PaginationController paginationController;

	@GetMapping("/my-account")
	public String myAccount(final Model model)
	{
		final CustomerDTO customerDTO = customerService.getAuthenticatedCustomerDTO();
		model.addAttribute("customerDTO", customerDTO);
		return "myAccount";
	}

	@GetMapping("/my-orders")
	public String myOrders(@RequestParam(name = "page", defaultValue = "1") final Integer page,
			@RequestParam(name = "size", defaultValue = "10") final Integer pageSize, final Model model)
	{
		final PageRequest pageRequest = paginationController.getValidPageRequest(page, pageSize);
		final CustomerDTO customer = customerService.getAuthenticatedCustomerDTO();
		final Page<CartDTO> orderPage = cartService.getOrdersByCustomerId(pageRequest, customer.getId());
		model.addAttribute("orderPage", orderPage);
		model.addAttribute("customer", customer);
		return "myOrders";
	}

	@ExceptionHandler(NoSuchElementException.class)
	public String noAuth()
	{
		return "redirect:/no-auth";
	}

	@ExceptionHandler(NumberFormatException.class)
	public String invalidFormat()
	{
		return "redirect:/404";
	}
}
