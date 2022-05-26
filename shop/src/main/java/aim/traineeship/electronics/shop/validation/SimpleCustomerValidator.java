package aim.traineeship.electronics.shop.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import aim.traineeship.electronics.shop.dao.CustomerDAO;
import aim.traineeship.electronics.shop.dto.DefaultCustomerDTO;


@Component
public class DefaultCustomerValidator implements Validator
{
	@Autowired
	private CustomerDAO customerDAO;

	private static final String LOGIN = "login";
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String GENDER = "gender";
	private static final String BIRTHDAY = "birthDay";
	private static final String PHONE = "phone";
	private static final String MALE = "Male";
	private static final String FEMALE = "Female";
	private static final String OTHER = "Other";

	private static final String EMAIL_PATTERN = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	private static final String DATE_PATTERN = "dd-MM-yyyy";
	private static final String SQL_DATE_PATTERN = "yyyy-MM-dd";
	private static final String PHONE_PATTERN = "[0-9]+";

	private static final String USER_DUPLICATE_MSG = "This email already exists !";
	private static final String INVALID_EMAIL_MSG = "login does not match the email format ! Accessible format : example@gmail.com";
	private static final String BAD_INITIALS_MSG = "First name or last name contains digits.";
	private static final String UNKNOWN_GENDER_MSG = "Unknown gender detected.";
	private static final String BAD_DATE_MSG = "Bad date format . Try like this : 'dd-MM-yyyy'.";
	private static final String BAD_PHONE_MSG = "Unknown characters detected or phone's length not equals 10";

	@Override
	public boolean supports(final Class<?> clazz)
	{
		return DefaultCustomerDTO.class.equals(clazz);
	}

	@Override
	public void validate(final Object target, final Errors errors)
	{
		final DefaultCustomerDTO customerDTO = (DefaultCustomerDTO) target;
		if (customerDAO.findByLogin(customerDTO.getLogin()) != null)
		{
			errors.rejectValue(LOGIN, "1", USER_DUPLICATE_MSG);
		}
		if (!validateEmail(customerDTO))
		{
			errors.rejectValue(LOGIN, "2", INVALID_EMAIL_MSG);
		}
		if (!validateFirstName(customerDTO))
		{
			errors.rejectValue(FIRST_NAME, "", BAD_INITIALS_MSG);
		}
		if (!validateLastName(customerDTO))
		{
			errors.rejectValue(LAST_NAME, "", BAD_INITIALS_MSG);
		}
		if (!validateGender(customerDTO))
		{
			errors.rejectValue(GENDER, "", UNKNOWN_GENDER_MSG);
		}
		if (!validateBirthDay(customerDTO))
		{
			errors.rejectValue(BIRTHDAY, "", BAD_DATE_MSG);
		}
		if (!validatePhone(customerDTO))
		{
			errors.rejectValue(PHONE, "", BAD_PHONE_MSG);
		}
	}

	private boolean validateEmail(final DefaultCustomerDTO customerDTO)
	{
		final Pattern pattern;
		final Matcher matcher;
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(customerDTO.getLogin());
		return matcher.matches();
	}

	private boolean validateFirstName(final DefaultCustomerDTO customerDTO)
	{
		final char[] firstName = customerDTO.getFirstName().toCharArray();
		for (final char ch : firstName)
		{
			if (Character.isDigit(ch))
			{
				return false;
			}
		}
		return true;
	}

	private boolean validateLastName(final DefaultCustomerDTO customerDTO)
	{
		final char[] lastName = customerDTO.getLastName().toCharArray();
		for (final char ch : lastName)
		{
			if (Character.isDigit(ch))
			{
				return false;
			}
		}
		return true;
	}

	private boolean validateGender(final DefaultCustomerDTO customerDTO)
	{
		final String gender = customerDTO.getGender();
		return gender.equals(MALE) || gender.equals(FEMALE) || gender.equals(OTHER);
	}

	private boolean validateBirthDay(final DefaultCustomerDTO customerDTO)
	{
		final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
		try
		{
			dateFormat.setLenient(false);
			final Date birthDay = dateFormat.parse(customerDTO.getBirthDay());
			dateFormat.applyPattern(SQL_DATE_PATTERN);
			customerDTO.setBirthDay(dateFormat.format(birthDay));
		}
		catch (final ParseException parseException)
		{
			return false;
		}
		return true;
	}

	private boolean validatePhone(final DefaultCustomerDTO customerDTO)
	{
		final String phone = customerDTO.getPhone();
		return phone.matches(PHONE_PATTERN) && phone.length() == 10;
	}
}
