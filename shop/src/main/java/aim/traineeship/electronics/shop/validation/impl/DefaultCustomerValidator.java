package aim.traineeship.electronics.shop.validation.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.dao.CustomerDAO;
import aim.traineeship.electronics.shop.dto.DefaultCustomerDTO;
import aim.traineeship.electronics.shop.exceptions.InvalidDateFormat;
import aim.traineeship.electronics.shop.exceptions.InvalidEmailException;
import aim.traineeship.electronics.shop.exceptions.InvalidInitialsException;
import aim.traineeship.electronics.shop.exceptions.InvalidPhoneException;
import aim.traineeship.electronics.shop.exceptions.UnknownGenderException;
import aim.traineeship.electronics.shop.exceptions.UserAlreadyExistsException;
import aim.traineeship.electronics.shop.validation.CustomerValidator;

@Component
public class DefaultCustomerValidator implements CustomerValidator
{
	@Autowired
	private CustomerDAO customerDAO;

	private final String MALE =  "Male";
	private final String FEMALE =  "Female";
	private final String OTHER =  "Other";
	private final String EMAIL_PATTERN = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	private final String DATE_PATTERN = "dd-MM-yyyy";
	private final String SQL_DATE_PATTERN = "yyyy-MM-dd";
	private final String PHONE_PATTERN = "[0-9]+";



	private final String USER_DUPLICATE_MSG = "This email already exists !";
	private final String INVALID_EMAIL_MSG = "login does not match the email format ! Accessible format : example@gmail.com";
	private final String BAD_INITIALS_MSG = "First name or last name contains digits.";
	private final String UNKNOWN_GENDER_MSG = "Unknown gender detected.";
	private final String BAD_DATE_MSG = "Bad date format . Try like this : 'dd-MM-yyyy'.";
	private final String BAD_PHONE_MSG = "Unknown characters detected or phone's length not equals 10";

	@Override
	public void checkDuplicateEmail(final DefaultCustomerDTO customerDTO)
			throws UserAlreadyExistsException
	{
		if (customerDAO.findByLogin(customerDTO.getLogin()) != null)
		{
			throw new UserAlreadyExistsException(USER_DUPLICATE_MSG);
		}
	}

	@Override
	public void validateEmail(final DefaultCustomerDTO customerDTO) throws InvalidEmailException
	{
		final Pattern pattern;
		final Matcher matcher;
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(customerDTO.getLogin());
		if (!(matcher.matches())) throw new InvalidEmailException(INVALID_EMAIL_MSG);
	}


	@Override
	public void validateFirstAndLastName(final DefaultCustomerDTO customerDTO) throws InvalidInitialsException
	{
		final char [] firstName = customerDTO.getFirstName().toCharArray();
		final char [] lastName = customerDTO.getLastName().toCharArray();
		for (final char ch : firstName)
			if (Character.isDigit(ch)) throw new InvalidInitialsException(BAD_INITIALS_MSG);
		for (final char ch : lastName)
			if (Character.isDigit(ch)) throw new InvalidInitialsException(BAD_INITIALS_MSG);
	}


	@Override
	public void validateGender(final DefaultCustomerDTO customerDTO) throws UnknownGenderException
	{
		final String gender =  customerDTO.getGender();
		if (!(gender.equals(MALE) || gender.equals(FEMALE) || gender.equals(OTHER)))throw new UnknownGenderException(UNKNOWN_GENDER_MSG);
	}

	@Override
	public void validateBirthDay(final DefaultCustomerDTO customerDTO) throws InvalidDateFormat
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
			throw new InvalidDateFormat(BAD_DATE_MSG);
		}
	}

	@Override
	public void validatePhone(final DefaultCustomerDTO customerDTO) throws InvalidPhoneException
	{
		final String phone =  customerDTO.getPhone();
		if (!(phone.matches(PHONE_PATTERN)) || phone.length()!=10) throw new InvalidPhoneException(BAD_PHONE_MSG);
	}
}
