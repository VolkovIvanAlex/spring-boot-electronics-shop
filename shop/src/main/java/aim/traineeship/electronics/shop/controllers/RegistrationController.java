package aim.traineeship.electronics.shop.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import aim.traineeship.electronics.shop.dto.CustomerDTO;
import aim.traineeship.electronics.shop.entities.Gender;
import aim.traineeship.electronics.shop.service.CustomerService;


@Controller
public class RegistrationController
{
	@Autowired
	private CustomerService customerService;

	@Qualifier("simpleCustomerValidator")
	@Autowired
	private Validator customerValidator;

	@GetMapping("/registration")
	public String registration(final Model model)
	{
		model.addAttribute("customerDTO", new CustomerDTO());
		model.addAttribute("genderValues", Gender.values());
		return "registration";
	}

	@PostMapping("/registration")
	public String registrationCheck(@ModelAttribute("customerDTO") final CustomerDTO customerDTO,
			final Model model, final HttpServletRequest request, final BindingResult result)
	{
		model.addAttribute("genderValues", Gender.values());
		try
		{
			customerValidator.validate(customerDTO, result);
			if (result.hasErrors())
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
