package aim.traineeship.electronics.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import aim.traineeship.electronics.shop.dto.DefaultCustomerDTO;
import aim.traineeship.electronics.shop.exceptions.UserAlreadyExistsException;
import aim.traineeship.electronics.shop.service.CustomerRegistrationService;


@Controller
public class RegistryController
{
	@Autowired
	CustomerRegistrationService service;

	@GetMapping("/registry")
	public String registry(final Model model)
	{
		model.addAttribute("customerDTO" , new DefaultCustomerDTO());
		return "registry";
	}

	//TODO validate input data
	@PostMapping("/registry")
	public String registryCheck(@ModelAttribute("customerDTO") final DefaultCustomerDTO customerDTO) throws UserAlreadyExistsException
	{
		try
		{
			service.registerNewAccount(customerDTO);
			//TODO provide auto authentication
		}catch (final UserAlreadyExistsException exception){
			exception.printStackTrace();
			return "registry";
		}
		return "redirect:/";
	}
}
