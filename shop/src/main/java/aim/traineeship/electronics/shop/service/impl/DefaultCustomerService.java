package aim.traineeship.electronics.shop.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.converter.impl.dto.CustomerDTOConverter;
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
	private CustomerDTOConverter customerConverter;

	private static final String USER_NOT_FOUND_MSG = "Not found user with username : ";

	@Override
	public void registerNewAccount(final CustomerDTO customerDTO)
	{
		customerDAO.saveCustomer(customerConverter.convert(customerDTO));
	}

	@Override
	public boolean isCustomerExist(final String login)
	{
		return customerDAO.findByLogin(login).isPresent();
	}

	@Override
	public Customer findCustomerByLogin(final String login)
	{
		final Optional<Customer> customerOptional = customerDAO.findByLogin(login);
		return customerOptional.orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND_MSG + login));
	}
}
