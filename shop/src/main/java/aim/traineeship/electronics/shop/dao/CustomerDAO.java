package aim.traineeship.electronics.shop.dao;

import aim.traineeship.electronics.shop.entities.Customer;


public interface CustomerDAO
{
	Customer findByLogin(final String login);

	void saveCustomer(final Customer customer);
}
