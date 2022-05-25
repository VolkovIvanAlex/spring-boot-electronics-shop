package aim.traineeship.electronics.shop.controllers;

import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import aim.traineeship.electronics.shop.dto.DefaultCustomerDTO;
import aim.traineeship.electronics.shop.exceptions.InvalidDateFormat;
import aim.traineeship.electronics.shop.exceptions.InvalidEmailException;
import aim.traineeship.electronics.shop.exceptions.InvalidInitialsException;
import aim.traineeship.electronics.shop.exceptions.InvalidPhoneException;
import aim.traineeship.electronics.shop.exceptions.UnknownGenderException;
import aim.traineeship.electronics.shop.exceptions.UserAlreadyExistsException;
import aim.traineeship.electronics.shop.service.CustomerRegistrationService;
import aim.traineeship.electronics.shop.validation.CustomerValidator;


@Controller
public class RegistryController
{
	@Autowired
	CustomerRegistrationService service;

	@Autowired
	CustomerValidator customerValidator;

	@Autowired
	DefaultCustomerDTO customerDTO;

	@GetMapping("/registry")
	public String registry(final Model model)
	{
		model.addAttribute("customerDTO", customerDTO);

		return "registry";
	}

	@PostMapping("/registry")
	public String registryCheck(@ModelAttribute("customerDTO") final DefaultCustomerDTO customerDTO,
			final HttpServletRequest request, final Model model)
	{
		try
		{
			customerValidator.checkDuplicateEmail(customerDTO);
			customerValidator.validateEmail(customerDTO);
			customerValidator.validateFirstAndLastName(customerDTO);
			customerValidator.validateGender(customerDTO);
			customerValidator.validateBirthDay(customerDTO);
			customerValidator.validatePhone(customerDTO);
			service.registerNewAccount(customerDTO);
			request.login(customerDTO.getLogin(), customerDTO.getPassword());
			return "redirect:/";
		}
		catch (final ServletException | ParseException servletException)
		{
			servletException.printStackTrace();
		}
		catch (final UserAlreadyExistsException userAlreadyExistsException)
		{
			model.addAttribute("userAlreadyExistsException", userAlreadyExistsException.getMessage());
		}
		catch (final InvalidEmailException invalidEmailException)
		{
			model.addAttribute("invalidEmailException", invalidEmailException.getMessage());
		}
		catch (final InvalidInitialsException invalidInitialsException)
		{
			model.addAttribute("invalidInitialsException", invalidInitialsException.getMessage());
		}
		catch (final UnknownGenderException unknownGenderException)
		{
			model.addAttribute("unknownGenderException", unknownGenderException.getMessage());
		}
		catch (final InvalidDateFormat invalidDateFormat)
		{
			model.addAttribute("invalidDateFormat", invalidDateFormat.getMessage());
		}
		catch (final InvalidPhoneException invalidPhoneException)
		{
			model.addAttribute("invalidPhoneException", invalidPhoneException.getMessage());
		}
		return "registry";
	}
}
