package aim.traineeship.electronics.shop.converter.impl.dto;

import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.converter.Converter;
import aim.traineeship.electronics.shop.dto.AnonymousDTO;
import aim.traineeship.electronics.shop.entities.Customer;

@Component
public class AnonymousDTOConverter implements Converter<AnonymousDTO, Customer>
{
	@Override
	public Customer convert(final AnonymousDTO anonymous)
	{
		final Customer customer = new Customer();
		customer.setFirstName(anonymous.getFirstName());
		customer.setLastName(anonymous.getLastName());
		customer.setLogin(anonymous.getLogin());
		customer.setPhone(anonymous.getPhone());
		return customer;
	}
}
