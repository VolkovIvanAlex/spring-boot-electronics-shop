package aim.traineeship.electronics.shop.converter.impl;

import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.converter.Converter;
import aim.traineeship.electronics.shop.dto.CustomerDTO;
import aim.traineeship.electronics.shop.entities.Customer;


@Component
public class CustomerConverter implements Converter<Customer, CustomerDTO>
{
	@Override
	public CustomerDTO convert(final Customer customer)
	{
		final CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setLogin(customer.getLogin());
		customerDTO.setPassword(customer.getPassword());
		customerDTO.setFirstName(customer.getFirstName());
		customerDTO.setLastName(customer.getLastName());
		if (customer.getGender() != null)
		{
			customerDTO.setGender(customer.getGender().name());
		}
		if (customer.getBirthDay() != null)
		{
			customerDTO.setBirthDay(customer.getBirthDay().toString());
		}
		customerDTO.setPhone(customer.getPhone());

		return customerDTO;
	}
}
