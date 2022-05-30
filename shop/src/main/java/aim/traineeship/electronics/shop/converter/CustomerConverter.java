package aim.traineeship.electronics.shop.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.dto.CustomerDTO;
import aim.traineeship.electronics.shop.entities.Customer;
import aim.traineeship.electronics.shop.entities.Gender;


@Component
public class CustomerConverter implements Converter<CustomerDTO, Customer>
{
	private static final String DATE_PATTERN = "dd-MM-yyyy";
	private static final SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);

	@Override
	public Customer convert(final CustomerDTO customerDTO)
	{
		final Customer customer = new Customer();
		customer.setLogin(customerDTO.getLogin());
		customer.setPassword(customerDTO.getPassword());
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setGender(Gender.valueOf(customerDTO.getGender().toUpperCase(Locale.ROOT)));
		customer.setBirthDay(parseDate(customerDTO.getBirthDay()).get());
		customer.setPhone(customerDTO.getPhone());
		return customer;
	}

	private Optional<Date> parseDate(final String date)
	{
		Optional<Date> result = Optional.empty();
		try
		{
			result = Optional.ofNullable(format.parse(date));
		}
		catch (final ParseException ignored)
		{
		}
		return result.stream().findFirst();
	}
}
