package aim.traineeship.electronics.shop.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.dto.DefaultCustomerDTO;
import aim.traineeship.electronics.shop.entities.Customer;


@Component
public class CustomerConverter implements Converter<DefaultCustomerDTO, Customer>
{
	@Override
	public Customer convert(final DefaultCustomerDTO customerDTO)
	{
		final Customer customer = new Customer();
		customer.setLogin(customerDTO.getLogin());
		customer.setPassword(customerDTO.getPassword());
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setGender(customerDTO.getGender());
		customer.setBirthDay(customerDTO.getBirthDay());
		customer.setPhone(customerDTO.getPhone());
		return customer;
	}
}
