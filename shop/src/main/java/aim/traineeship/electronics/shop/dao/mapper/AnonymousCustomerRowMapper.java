package aim.traineeship.electronics.shop.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import aim.traineeship.electronics.shop.entities.Customer;


public class AnonymousCustomerRowMapper implements RowMapper<Customer>
{
	private static final String ID = "id";
	private static final String LOGIN = "login";
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String PHONE = "phone";

	@Override
	public Customer mapRow(final ResultSet rs, final int rowNum) throws SQLException
	{
		final Customer customer = new Customer();
		customer.setId(rs.getInt(ID));
		customer.setLogin(rs.getString(LOGIN));
		customer.setFirstName(rs.getString(FIRST_NAME));
		customer.setLastName(rs.getString(LAST_NAME));
		customer.setPhone(rs.getString(PHONE));
		return customer;
	}
}
