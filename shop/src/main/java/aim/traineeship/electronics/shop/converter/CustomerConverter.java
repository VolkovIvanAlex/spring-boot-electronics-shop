package aim.traineeship.electronics.shop.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.dto.SimpleCustomerDTO;
import aim.traineeship.electronics.shop.entities.Customer;
import aim.traineeship.electronics.shop.entities.Gender;


@Component
public class CustomerConverter implements Converter<SimpleCustomerDTO, Customer>
{
	private static final String DATE_PATTERN = "dd-MM-yyyy";

	@Override
	public Customer convert(final SimpleCustomerDTO customerDTO)
	{
		final SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);
		final Customer customer = new Customer();
		customer.setLogin(customerDTO.getLogin());
		customer.setPassword(customerDTO.getPassword());
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setGender(Gender.valueOf(customerDTO.getGender().toUpperCase(Locale.ROOT)));
		try
		{
			customer.setBirthDay(format.parse(customerDTO.getBirthDay()));
		}
		catch (final ParseException ignored)
		{
		}
		customer.setPhone(customerDTO.getPhone());
		return customer;
	}
}
