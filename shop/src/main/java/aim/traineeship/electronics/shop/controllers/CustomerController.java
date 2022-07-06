package aim.traineeship.electronics.shop.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import aim.traineeship.electronics.shop.dto.CustomerDTO;
import aim.traineeship.electronics.shop.service.CustomerService;


@Controller
public class CustomerController
{
	@Autowired
	private CustomerService customerService;

	@GetMapping("/my-account")
	public String myAccount(final Model model)
	{
		final CustomerDTO customerDTO = customerService.getAuthenticatedCustomerDTO();
		model.addAttribute("customerDTO" , customerDTO);
		return "myAccount";
	}

	@ExceptionHandler(NoSuchElementException.class)
	public String noAuth()
	{
		return "redirect:/no-auth";
	}
}
