package aim.traineeship.electronics.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PageNotFoundException extends RuntimeException
{
	public PageNotFoundException(final String message)
	{
		super(message);
	}

	public PageNotFoundException(final String message, final Throwable cause)
	{
		super(message, cause);
	}
}
