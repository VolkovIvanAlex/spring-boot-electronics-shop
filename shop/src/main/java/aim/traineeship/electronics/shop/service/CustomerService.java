package aim.traineeship.electronics.shop.service;

import aim.traineeship.electronics.shop.dto.CustomerDTO;
import aim.traineeship.electronics.shop.entities.Customer;


public interface CustomerService
{
	void registerNewAccount(final CustomerDTO customerDTO);

	boolean isCustomerExist(final String login);

	Customer findCustomerByLogin(final String login);
}
