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
	CustomerDAO customerDAO;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException
	{
		final Customer customer = customerDAO.findByUserName(username);
		return new CustomerDetails(customer);
	}
}
