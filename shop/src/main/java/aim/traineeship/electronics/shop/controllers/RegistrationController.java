package aim.traineeship.electronics.shop.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	@Autowired
	@Qualifier("customerValidator")
	private Validator customerValidator;

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

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

		try
		{
			customerValidator.validate(customerDTO, result);
			if (result.hasErrors())
			{
				model.addAttribute("genderValues", Gender.values());
				return "registration";
			}
			customerService.registerNewAccount(customerDTO);
			request.login(customerDTO.getLogin(), customerDTO.getPassword());
			return "redirect:/";
		}
		catch (final ServletException servletException)
		{
			LOGGER.error("Error during customer login {}", customerDTO.getLogin(), servletException);
			return "registration";
		}
	}
}
