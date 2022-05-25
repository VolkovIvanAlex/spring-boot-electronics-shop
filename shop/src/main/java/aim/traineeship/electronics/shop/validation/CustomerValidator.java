package aim.traineeship.electronics.shop.validation;

import java.text.ParseException;

import aim.traineeship.electronics.shop.dto.DefaultCustomerDTO;
import aim.traineeship.electronics.shop.exceptions.InvalidDateFormat;
import aim.traineeship.electronics.shop.exceptions.InvalidEmailException;
import aim.traineeship.electronics.shop.exceptions.InvalidInitialsException;
import aim.traineeship.electronics.shop.exceptions.InvalidPhoneException;
import aim.traineeship.electronics.shop.exceptions.UnknownGenderException;
import aim.traineeship.electronics.shop.exceptions.UserAlreadyExistsException;


public interface CustomerValidator
{
	void checkDuplicateEmail(DefaultCustomerDTO customerDTO) throws UserAlreadyExistsException;
	void validateEmail(DefaultCustomerDTO customerDTO) throws InvalidEmailException;
	void validateFirstAndLastName(DefaultCustomerDTO customerDTO) throws InvalidInitialsException;
	void validateGender(DefaultCustomerDTO customerDTO) throws UnknownGenderException;
	void validateBirthDay(DefaultCustomerDTO customerDTO) throws ParseException, InvalidDateFormat;
	void validatePhone(DefaultCustomerDTO customerDTO) throws InvalidPhoneException;
}
