package aim.traineeship.electronics.shop.service;

import org.springframework.validation.BindingResult;

import aim.traineeship.electronics.shop.dto.SimpleCustomerDTO;


public interface CustomerService
{
	boolean checkValidation(final SimpleCustomerDTO customerDTO, final BindingResult result);

	void registerNewAccount(final SimpleCustomerDTO defaultCustomerDTO);
}
