package aim.traineeship.electronics.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController
{
	@GetMapping("/login_page")
	public String login(){
		return "login";
	}
}
