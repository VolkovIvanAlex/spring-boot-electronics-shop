package aim.traineeship.electronics.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.dao.CustomerDAO;
import aim.traineeship.electronics.shop.dto.DefaultCustomerDTO;
import aim.traineeship.electronics.shop.entities.Customer;


@Service
public class CustomerRegistrationService
{
	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private Converter<DefaultCustomerDTO, Customer> customerConverter;

	public void registerNewAccount(final DefaultCustomerDTO defaultCustomerDTO)
	{
		customerDAO.saveCustomer(customerConverter.convert(defaultCustomerDTO));
	}
}
