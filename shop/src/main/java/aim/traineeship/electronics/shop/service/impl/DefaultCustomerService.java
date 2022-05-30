package aim.traineeship.electronics.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.dao.CustomerDAO;
import aim.traineeship.electronics.shop.dto.CustomerDTO;
import aim.traineeship.electronics.shop.entities.Customer;
import aim.traineeship.electronics.shop.service.CustomerService;


@Service
public class DefaultCustomerService implements CustomerService
{
	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private Converter<CustomerDTO, Customer> customerConverter;

	@Override
	public void registerNewAccount(final CustomerDTO customerDTO)
	{
		customerDAO.saveCustomer(customerConverter.convert(customerDTO));
	}

	@Override
	public boolean checkDuplicate(final CustomerDTO customerDTO)
	{
		return customerDAO.findByLogin(customerDTO.getLogin()).isPresent();
	}
}
