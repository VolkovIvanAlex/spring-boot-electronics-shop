package aim.traineeship.electronics.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import aim.traineeship.electronics.shop.dao.CustomerDAO;
import aim.traineeship.electronics.shop.dto.SimpleCustomerDTO;
import aim.traineeship.electronics.shop.entities.Customer;
import aim.traineeship.electronics.shop.service.CustomerService;


@Service
public class DefaultCustomerService implements CustomerService
{
	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private Converter<SimpleCustomerDTO, Customer> customerConverter;

	@Qualifier("simpleCustomerValidator")
	@Autowired
	private Validator customerValidator;

	@Override
	public boolean checkValidation(final SimpleCustomerDTO customerDTO, final BindingResult result)
	{
		customerValidator.validate(customerDTO, result);
		return !result.hasErrors();
	}

	@Override
	public void registerNewAccount(final SimpleCustomerDTO defaultCustomerDTO)
	{
		customerDAO.saveCustomer(customerConverter.convert(defaultCustomerDTO));
	}
}
