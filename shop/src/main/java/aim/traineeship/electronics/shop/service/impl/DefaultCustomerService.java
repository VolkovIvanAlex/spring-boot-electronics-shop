package aim.traineeship.electronics.shop.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.converter.impl.dto.AnonymousDTOConverter;
import aim.traineeship.electronics.shop.converter.impl.dto.CustomerDTOConverter;
import aim.traineeship.electronics.shop.dao.CustomerDAO;
import aim.traineeship.electronics.shop.dto.AnonymousDTO;
import aim.traineeship.electronics.shop.dto.CustomerDTO;
import aim.traineeship.electronics.shop.entities.Customer;
import aim.traineeship.electronics.shop.service.CustomerService;


@Service
public class DefaultCustomerService implements CustomerService
{
	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private CustomerDTOConverter customerDTOConverter;

	@Autowired
	private AnonymousDTOConverter anonymousConverter;

	private static final String USER_NOT_FOUND_MSG = "Not found user with username : ";
	public static final String ANONYMOUS_LOGIN = "anonymous";

	@Override
	public void registerNewAccount(final CustomerDTO customerDTO)
	{
		customerDAO.saveCustomer(customerDTOConverter.convert(customerDTO));
	}

	@Override
	public Integer registerAnonymousUser(final AnonymousDTO anonymousDTO)
	{
		final String anonymousLogin = UUID.randomUUID().toString();
		anonymousDTO.setLogin(anonymousDTO.getLogin() + "|" + anonymousLogin);
		return customerDAO.saveAnonymousCustomer(anonymousConverter.convert(anonymousDTO));
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

	@Override
	public Optional<Customer> getAuthenticatedCustomer()
	{
		Optional<Customer> customer = Optional.empty();
		try
		{
			final UserDetails principal = (UserDetails) SecurityContextHolder.getContext()
					.getAuthentication()
					.getPrincipal();
			customer = Optional.ofNullable(findCustomerByLogin(principal.getUsername()));
			return customer;
		}
		catch (final ClassCastException castException)
		{
			return customer;
		}
	}

	@Override
	public Customer getDefaultAnonymous()
	{
		return customerDAO.findByLogin(ANONYMOUS_LOGIN).orElseThrow();
	}
}
