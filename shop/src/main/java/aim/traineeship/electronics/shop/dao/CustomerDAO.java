package aim.traineeship.electronics.shop.dao;

import java.util.Optional;

import aim.traineeship.electronics.shop.entities.Customer;


public interface CustomerDAO
{
	Optional<Customer> findByLogin(final String login);

	void saveCustomer(final Customer customer);

	Integer saveAnonymousCustomer(final Customer customer);
}
