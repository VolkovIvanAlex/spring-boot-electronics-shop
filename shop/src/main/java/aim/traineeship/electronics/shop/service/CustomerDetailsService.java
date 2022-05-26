package aim.traineeship.electronics.shop.service;

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

	private static final String USER_NOT_FOUND_MSG = "user not found ...";

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException
	{
		final Customer customer = customerDAO.findByLogin(username);
		if (customer == null)
		{
			throw new UsernameNotFoundException(USER_NOT_FOUND_MSG);
		}
		return new CustomerDetails(customer);
	}
}
