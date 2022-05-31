package aim.traineeship.electronics.shop.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import aim.traineeship.electronics.shop.dto.CustomerDTO;
import aim.traineeship.electronics.shop.entities.Gender;
import aim.traineeship.electronics.shop.service.impl.DefaultCustomerService;


@Component
public class CustomerValidator implements Validator
{
	@Autowired
	private DefaultCustomerService customerService;

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerValidator.class);

	private static final String LOGIN = "login";
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String GENDER = "gender";
	private static final String BIRTHDAY = "birthDay";
	private static final String PHONE = "phone";

	private static final String EMAIL_PATTERN = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	private static final String DATE_PATTERN = "dd-MM-yyyy";
	private static final String PHONE_PATTERN = "[0-9]+";

	private static final String DUPLICATE_EMAIL_CODE = "custom.email.duplicate";
	private static final String INVALID_EMAIL_CODE = "custom.invalid.email";
	private static final String INVALID_FIRST_NAME_CODE = "custom.bad.first.name";
	private static final String INVALID_LAST_NAME_CODE = "custom.bad.last.name";
	private static final String UNKNOWN_GENDER_CODE = "custom.unknown.gender";
	private static final String INVALID_DATE_CODE = "custom.invalid.date.format";
	private static final String INVALID_PHONE_CODE = "custom.invalid.phone";
	private static final String PARSE_EXCEPTION = "Parse exception detected while parsing date field in String type from CustomerDTO , due to invalid format given.";

	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	@Override
	public boolean supports(final Class<?> clazz)
	{
		return CustomerDTO.class.equals(clazz);
	}

	@Override
	public void validate(final Object target, final Errors errors)
	{
		final CustomerDTO customerDTO = (CustomerDTO) target;
		checkDuplicate(customerDTO, errors);
		validateEmail(customerDTO, errors);
		validateFirstName(customerDTO, errors);
		validateLastName(customerDTO, errors);
		validateGender(customerDTO, errors);
		validateBirthDay(customerDTO, errors);
		validatePhone(customerDTO, errors);
	}

	private void checkDuplicate(final CustomerDTO customerDTO, final Errors errors)
	{
		if (customerService.isCustomerExist(customerDTO.getLogin()))
		{
			errors.rejectValue(LOGIN, DUPLICATE_EMAIL_CODE);
		}
	}

	private void validateEmail(final CustomerDTO customerDTO, final Errors errors)
	{
		final Matcher matcher = pattern.matcher(customerDTO.getLogin());
		if (!matcher.matches())
		{
			errors.rejectValue(LOGIN, INVALID_EMAIL_CODE);
		}
	}

	private void validateFirstName(final CustomerDTO customerDTO, final Errors errors)
	{
		final char[] firstName = customerDTO.getFirstName().toCharArray();
		if (checkForDigits(firstName))
		{
			errors.rejectValue(FIRST_NAME, INVALID_FIRST_NAME_CODE);
		}
	}

	private void validateLastName(final CustomerDTO customerDTO, final Errors errors)
	{
		final char[] lastName = customerDTO.getLastName().toCharArray();
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

	private void validateGender(final CustomerDTO customerDTO, final Errors errors)
	{
		final String gender = customerDTO.getGender();
		if (!Gender.isInGenderEnum(gender))
		{
			errors.rejectValue(GENDER, UNKNOWN_GENDER_CODE);
		}
	}

	private void validateBirthDay(final CustomerDTO customerDTO, final Errors errors)
	{
		final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
		try
		{
			dateFormat.setLenient(false);
			dateFormat.parse(customerDTO.getBirthDay());
		}
		catch (final ParseException parseException)
		{
			LOGGER.error("Error during parsing date {} {}", customerDTO.getBirthDay(), PARSE_EXCEPTION);
			errors.rejectValue(BIRTHDAY, INVALID_DATE_CODE);
		}
	}

	private void validatePhone(final CustomerDTO customerDTO, final Errors errors)
	{
		final String phone = customerDTO.getPhone();
		if (!phone.matches(PHONE_PATTERN) || phone.length() != 10)
		{
			errors.rejectValue(PHONE, INVALID_PHONE_CODE);
		}
	}
}
