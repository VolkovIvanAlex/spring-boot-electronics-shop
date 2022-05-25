package aim.traineeship.electronics.shop.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.dto.DefaultCustomerDTO;
import aim.traineeship.electronics.shop.entities.Customer;

@Component
public class CustomerConverter
{
	public Customer convertToCustomer(final DefaultCustomerDTO customerDTO){
		final Customer customer = new Customer();
		customer.setLogin(customerDTO.getLogin());
		customer.setPassword(passwordEncoder().encode(customerDTO.getPassword()));
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setGender(customerDTO.getGender());
		customer.setBirthDay(customerDTO.getBirthDay());
		customer.setPhone(customerDTO.getPhone());
		return customer;
	}

	private PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

}
