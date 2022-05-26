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

import aim.traineeship.electronics.shop.dto.DefaultCustomerDTO;
import aim.traineeship.electronics.shop.service.CustomerRegistrationService;


@Controller
public class RegistryController
{
	@Autowired
	private CustomerRegistrationService service;

	@Qualifier("defaultCustomerValidator")
	@Autowired
	private Validator customerValidator;

	@Autowired
	private DefaultCustomerDTO customerDTO;

	@GetMapping("/registry")
	public String registry(final Model model)
	{
		model.addAttribute("customerDTO", customerDTO);

		return "registry";
	}

	@PostMapping("/registry")
	public String registryCheck(@ModelAttribute("customerDTO") final DefaultCustomerDTO customerDTO,
			final HttpServletRequest request, final BindingResult result)
	{
		try
		{
			customerValidator.validate(customerDTO, result);
			if (result.hasErrors())
			{
				return "registry";
			}
			service.registerNewAccount(customerDTO);
			request.login(customerDTO.getLogin(), customerDTO.getPassword());
			return "redirect:/";
		}
		catch (final ServletException servletException)
		{
			servletException.printStackTrace();
			return "registry";
		}
	}
}
