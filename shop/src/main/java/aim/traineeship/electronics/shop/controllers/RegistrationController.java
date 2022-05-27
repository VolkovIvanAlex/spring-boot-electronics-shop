package aim.traineeship.electronics.shop.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import aim.traineeship.electronics.shop.dto.SimpleCustomerDTO;
import aim.traineeship.electronics.shop.service.CustomerService;


@Controller
public class RegistrationController
{
	@Autowired
	private CustomerService customerService;

	@GetMapping("/registration")
	public String registration(final Model model)
	{
		model.addAttribute("customerDTO", new SimpleCustomerDTO());
		return "registration";
	}

	@PostMapping("/registration")
	public String registrationCheck(@ModelAttribute("customerDTO") final SimpleCustomerDTO customerDTO,
			final HttpServletRequest request, final BindingResult result)
	{
		try
		{
			if (!customerService.checkValidation(customerDTO, result))
			{
				return "registration";
			}
			customerService.registerNewAccount(customerDTO);
			request.login(customerDTO.getLogin(), customerDTO.getPassword());
			return "redirect:/";
		}
		catch (final ServletException servletException)
		{
			return "registration";
		}
	}
}
