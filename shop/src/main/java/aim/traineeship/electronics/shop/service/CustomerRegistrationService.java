package aim.traineeship.electronics.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.dao.CustomerDAO;
import aim.traineeship.electronics.shop.dto.DefaultCustomerDTO;
import aim.traineeship.electronics.shop.entities.Customer;
import aim.traineeship.electronics.shop.exceptions.UserAlreadyExistsException;


@Service
public class CustomerRegistrationService
{
	@Autowired
	private CustomerDAO customerDAO;

	public void registerNewAccount(final DefaultCustomerDTO defaultCustomerDTO) throws UserAlreadyExistsException
	{
		if (customerDAO.findByLogin(defaultCustomerDTO.getLogin()) != null)
		{
			throw new UserAlreadyExistsException("This email already exists !");
		}
		final Customer customer = new Customer();
		customer.setLogin(defaultCustomerDTO.getLogin());
		customer.setPassword(passwordEncoder().encode(defaultCustomerDTO.getPassword()));
		customer.setFirstName(defaultCustomerDTO.getFirstName());
		customer.setLastName(defaultCustomerDTO.getLastName());
		customer.setGender(defaultCustomerDTO.getGender());
		customer.setBirthDay(defaultCustomerDTO.getBirthDay());
		customer.setPhone(defaultCustomerDTO.getPhone());
		customerDAO.saveCustomer(customer);
	}

	private PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
