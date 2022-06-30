package aim.traineeship.electronics.shop.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import aim.traineeship.electronics.shop.dto.CheckoutDTO;
import aim.traineeship.electronics.shop.service.impl.DefaultCustomerService;


@Component
public class CheckoutValidator implements Validator
{

	@Autowired
	private DefaultCustomerService customerService;

	private static final String LOGIN = "login";
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String PHONE = "phone";

	private static final String EMAIL_PATTERN = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	private static final String PHONE_PATTERN = "[0-9]+";

	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	private static final String DUPLICATE_EMAIL_CODE = "custom.email.duplicate";
	private static final String INVALID_EMAIL_CODE = "custom.invalid.email";
	private static final String INVALID_FIRST_NAME_CODE = "custom.bad.first.name";
	private static final String INVALID_LAST_NAME_CODE = "custom.bad.last.name";
	private static final String INVALID_PHONE_CODE = "custom.invalid.phone";

	@Override
	public boolean supports(final Class<?> clazz)
	{
		return CheckoutDTO.class.equals(clazz);
	}

	@Override
	public void validate(final Object target, final Errors errors)
	{
		final CheckoutDTO checkoutDTO = (CheckoutDTO) target;
		checkDuplicate(checkoutDTO, errors);
		validateEmail(checkoutDTO, errors);
		validateFirstName(checkoutDTO, errors);
		validateLastName(checkoutDTO, errors);
		validatePhone(checkoutDTO, errors);
	}

	private void checkDuplicate(final CheckoutDTO checkoutDTO, final Errors errors)
	{
		if (customerService.isCustomerExist(checkoutDTO.getLogin()))
		{
			errors.rejectValue(LOGIN, DUPLICATE_EMAIL_CODE);
		}
	}

	private void validateEmail(final CheckoutDTO checkoutDTO, final Errors errors)
	{
		final Matcher matcher = pattern.matcher(checkoutDTO.getLogin());
		if (!matcher.matches())
		{
			errors.rejectValue(LOGIN, INVALID_EMAIL_CODE);
		}
	}

	private void validateFirstName(final CheckoutDTO checkoutDTO, final Errors errors)
	{
		final char[] firstName = checkoutDTO.getFirstName().toCharArray();
		if (checkForDigits(firstName))
		{
			errors.rejectValue(FIRST_NAME, INVALID_FIRST_NAME_CODE);
		}
	}

	private void validateLastName(final CheckoutDTO checkoutDTO, final Errors errors)
	{
		final char[] lastName = checkoutDTO.getLastName().toCharArray();
		if (checkForDigits(lastName))
		{
			errors.rejectValue(LAST_NAME, INVALID_LAST_NAME_CODE);
		}
	}

	private boolean checkForDigits(final char[] string)
	{
		for (final char ch : string)
		{
			if (Character.isDigit(ch))
			{
				return true;
			}
		}
		return false;
	}

	private void validatePhone(final CheckoutDTO checkoutDTO, final Errors errors)
	{
		final String phone = checkoutDTO.getPhone();
		if (!phone.matches(PHONE_PATTERN) || phone.length() != 10)
		{
			errors.rejectValue(PHONE, INVALID_PHONE_CODE);
		}
	}
}
