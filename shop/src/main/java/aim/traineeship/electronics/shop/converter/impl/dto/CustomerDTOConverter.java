package aim.traineeship.electronics.shop.converter.impl.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.dto.CustomerDTO;
import aim.traineeship.electronics.shop.entities.Customer;
import aim.traineeship.electronics.shop.entities.Gender;


@Component
public class CustomerDTOConverter implements Converter<CustomerDTO, Customer>
{
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDTOConverter.class);
	private static final String DATE_PATTERN = "dd-MM-yyyy";

	@Override
	public Customer convert(final CustomerDTO customerDTO)
	{
		final SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);
		final Customer customer = new Customer();
		customer.setId(customerDTO.getId());
		customer.setLogin(customerDTO.getLogin());
		customer.setPassword(customerDTO.getPassword());
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setGender(Gender.valueOf(customerDTO.getGender().toUpperCase(Locale.ROOT)));
		customer.setBirthDay(parseDate(customerDTO.getBirthDay(), format));
		customer.setPhone(customerDTO.getPhone());
		return customer;
	}

	private Date parseDate(final String date, final SimpleDateFormat format)
	{
		try
		{
			return format.parse(date);
		}
		catch (final ParseException parseException)
		{
			LOGGER.error("Error during parsing date {}", date, parseException);
			return null;
		}
	}
}
