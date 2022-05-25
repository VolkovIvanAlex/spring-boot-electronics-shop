package aim.traineeship.electronics.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.converter.CustomerConverter;
import aim.traineeship.electronics.shop.dao.CustomerDAO;
import aim.traineeship.electronics.shop.dto.DefaultCustomerDTO;


@Service
public class CustomerRegistrationService
{
	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private CustomerConverter customerConverter;

	public void registerNewAccount(final DefaultCustomerDTO defaultCustomerDTO)
	{
		customerDAO.saveCustomer(customerConverter.convertToCustomer(defaultCustomerDTO));
	}
}
