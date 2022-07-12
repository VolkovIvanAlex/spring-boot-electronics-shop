package aim.traineeship.electronics.shop.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorHandlerController
{
	@GetMapping("/404")
	public String notFoundShow()
	{
		return "error/404";
	}

	@GetMapping("/no-auth")
	public String notAuth()
	{
		return "error/noAuth";
	}
}
