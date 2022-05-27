package aim.traineeship.electronics.shop.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import aim.traineeship.electronics.shop.dao.CustomerDAO;
import aim.traineeship.electronics.shop.dto.SimpleCustomerDTO;
import aim.traineeship.electronics.shop.entities.Gender;


@PropertySource("classpath:error.properties")
@Component
public class SimpleCustomerValidator implements Validator
{
	@Autowired
	private CustomerDAO customerDAO;

	private static final String LOGIN = "login";
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String GENDER = "gender";
	private static final String BIRTHDAY = "birthDay";
	private static final String PHONE = "phone";

	private static final String EMAIL_PATTERN = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	private static final String DATE_PATTERN = "dd-MM-yyyy";
	private static final String PHONE_PATTERN = "[0-9]+";

	@Value("${custom.email.duplicate.msg}")
	private String USER_DUPLICATE_MSG;
	@Value("${custom.invalid.email.msg}")
	private String INVALID_EMAIL_MSG;
	@Value("${custom.bad.initials.msg}")
	private String BAD_INITIALS_MSG;
	@Value("${custom.unknown.gender.msg}")
	private String UNKNOWN_GENDER_MSG;
	@Value("${custom.invalid.date.format.msg}")
	private String BAD_DATE_MSG;
	@Value("${custom.invalid.phone.msg}")
	private String BAD_PHONE_MSG;

	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	@Override
	public boolean supports(final Class<?> clazz)
	{
		return SimpleCustomerDTO.class.equals(clazz);
	}

	@Override
	public void validate(final Object target, final Errors errors)
	{
		final SimpleCustomerDTO customerDTO = (SimpleCustomerDTO) target;
		checkDuplicate(customerDTO, errors);
		validateEmail(customerDTO, errors);
		validateFirstName(customerDTO, errors);
		validateLastName(customerDTO, errors);
		validateGender(customerDTO, errors);
		validateBirthDay(customerDTO, errors);
		validatePhone(customerDTO, errors);
	}

	private void checkDuplicate(final SimpleCustomerDTO customerDTO, final Errors errors)
	{
		if (customerDAO.findByLogin(customerDTO.getLogin()) != null)
		{
			errors.rejectValue(LOGIN, "email.duplicate", USER_DUPLICATE_MSG);
		}
	}

	private void validateEmail(final SimpleCustomerDTO customerDTO, final Errors errors)
	{
		final Matcher matcher = pattern.matcher(customerDTO.getLogin());
		if (!matcher.matches())
		{
			errors.rejectValue(LOGIN, "invalid.email.format", INVALID_EMAIL_MSG);
		}
	}

	private void validateFirstName(final SimpleCustomerDTO customerDTO, final Errors errors)
	{
		final char[] firstName = customerDTO.getFirstName().toCharArray();
		if (checkForDigits(firstName))
		{
			errors.rejectValue(FIRST_NAME, "invalid.first.name", BAD_INITIALS_MSG);
		}
	}

	private void validateLastName(final SimpleCustomerDTO customerDTO, final Errors errors)
	{
		final char[] lastName = customerDTO.getLastName().toCharArray();
		if (checkForDigits(lastName))
		{
			errors.rejectValue(LAST_NAME, "invalid.last.name", BAD_INITIALS_MSG);
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

	private void validateGender(final SimpleCustomerDTO customerDTO, final Errors errors)
	{
		final String gender = customerDTO.getGender();
		if (!isInGenderEnum(gender))
		{
			errors.rejectValue(GENDER, "unknown.gender", UNKNOWN_GENDER_MSG);
		}
	}

	private boolean isInGenderEnum(final String gender)
	{
		for (final Gender g : Gender.values())
		{
			if (g.getTitle().equals(gender))
			{
				return true;
			}
		}
		return false;
	}

	private void validateBirthDay(final SimpleCustomerDTO customerDTO, final Errors errors)
	{
		final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
		try
		{
			dateFormat.setLenient(false);
			dateFormat.parse(customerDTO.getBirthDay());
		}
		catch (final ParseException parseException)
		{
			errors.rejectValue(BIRTHDAY, "invalid.birthday.date", BAD_DATE_MSG);
		}
	}

	private void validatePhone(final SimpleCustomerDTO customerDTO, final Errors errors)
	{
		final String phone = customerDTO.getPhone();
		if (!phone.matches(PHONE_PATTERN) || phone.length() != 10)
		{
			errors.rejectValue(PHONE, "invalid.phone", BAD_PHONE_MSG);
		}
	}
}
