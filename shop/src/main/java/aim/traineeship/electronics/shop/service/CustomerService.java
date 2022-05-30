package aim.traineeship.electronics.shop.service;

import aim.traineeship.electronics.shop.dto.CustomerDTO;


public interface CustomerService
{
	void registerNewAccount(final CustomerDTO customerDTO);

	boolean checkDuplicate(final CustomerDTO customerDTO);
}
