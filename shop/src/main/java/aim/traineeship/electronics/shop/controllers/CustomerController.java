package aim.traineeship.electronics.shop.controllers;

import static aim.traineeship.electronics.shop.service.impl.DefaultCartService.ORDERS_TO_SHOW;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("/my-account")
	public String myAccount(final Model model)
	{
		final CustomerDTO customerDTO = customerService.getAuthenticatedCustomerDTO();
		model.addAttribute("customerDTO", customerDTO);
		return "myAccount";
	}

	@GetMapping("/my-orders/{pageNum}")
	public String myOrders(@PathVariable("pageNum") final Integer page, final Model model, final HttpSession session)
	{
		final CustomerDTO customer = customerService.getAuthenticatedCustomerDTO();
		final Page<CartDTO> orderPage = cartService.getOrdersByCustomerId(page, customer.getId(), session);
		model.addAttribute("orderPage", orderPage);
		model.addAttribute("customer", customer);
		return "myOrders";
	}

	@PostMapping("/my-orders/{pageNum}")
	public String myOrdersPost(@RequestParam(value = "ordersToShow") final Integer ordersToShow,
			@PathVariable("pageNum") final Integer page, final HttpSession session)
	{
		if (ordersToShow == session.getAttribute(ORDERS_TO_SHOW))
		{
			return "redirect:/my-orders/" + page;
		}
		session.setAttribute(ORDERS_TO_SHOW, ordersToShow);
		return "redirect:/my-orders/" + 0;
	}

	@ExceptionHandler(NoSuchElementException.class)
	public String noAuth()
	{
		return "redirect:/no-auth";
	}
}
