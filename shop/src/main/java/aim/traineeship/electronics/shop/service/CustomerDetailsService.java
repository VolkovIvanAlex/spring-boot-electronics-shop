package aim.traineeship.electronics.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.dao.CustomerDAO;
import aim.traineeship.electronics.shop.entities.Customer;
import aim.traineeship.electronics.shop.security.CustomerDetails;


@Service
public class CustomerDetailsService implements UserDetailsService
{
	@Autowired
	private CustomerDAO customerDAO;

	private static final String USER_NOT_FOUND_MSG = "Not found user with username : ";

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException
	{
		final Optional<Customer> customerOptional = customerDAO.findByLogin(username);
		final Customer customer = customerOptional.orElseThrow(
				() -> new UsernameNotFoundException(USER_NOT_FOUND_MSG + username));
		return new CustomerDetails(customer);
	}
}
