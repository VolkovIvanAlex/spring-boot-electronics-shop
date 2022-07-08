package aim.traineeship.electronics.shop.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aim.traineeship.electronics.shop.dto.CartDTO;
import aim.traineeship.electronics.shop.dto.CustomerDTO;
import aim.traineeship.electronics.shop.dto.PaginationDTO;
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
	public String myOrders(@RequestParam(name = "pageNum", defaultValue = "0") final Integer page,
			@RequestParam(name = "ordersToShow", defaultValue = "10") final Integer ordersToShow, final Model model)
	{
		final CustomerDTO customer = customerService.getAuthenticatedCustomerDTO();
		final Page<CartDTO> orderPage = cartService.getOrdersByCustomerId(page, ordersToShow, customer.getId());
		model.addAttribute("orderPage", orderPage);
		model.addAttribute("customer", customer);
		model.addAttribute("paginationDTO", new PaginationDTO(page, ordersToShow));
		return "myOrders";
	}

	@ExceptionHandler(NoSuchElementException.class)
	public String noAuth()
	{
		return "redirect:/no-auth";
	}
}
