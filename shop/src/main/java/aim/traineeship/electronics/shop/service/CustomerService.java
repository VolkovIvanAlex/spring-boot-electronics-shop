package aim.traineeship.electronics.shop.service;

import java.util.Optional;

import aim.traineeship.electronics.shop.dto.AnonymousDTO;
import aim.traineeship.electronics.shop.dto.CustomerDTO;
import aim.traineeship.electronics.shop.entities.Customer;


public interface CustomerService
{
	void registerNewAccount(final CustomerDTO customerDTO);

	Integer registerAnonymousUser(final AnonymousDTO anonymousDTO);

	boolean isCustomerExist(final String login);

	Customer findCustomerByLogin(final String login);

	Optional<Customer> getAuthenticatedCustomer();

	Customer getAnonymous();
}
