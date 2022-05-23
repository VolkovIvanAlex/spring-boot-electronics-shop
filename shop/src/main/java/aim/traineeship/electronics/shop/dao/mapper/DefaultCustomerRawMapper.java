package aim.traineeship.electronics.shop.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import aim.traineeship.electronics.shop.entities.Customer;


public class DefaultCustomerRawMapper implements RowMapper
{
	private static final String ID = "id";
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String GENDER = "gender";
	private static final String BIRTHDAY = "birthDay";
	private static final String PHONE = "phone";

	@Override
	public Customer mapRow(final ResultSet rs, final int rowNum) throws SQLException
	{
		final Customer customer = new Customer();
		customer.setId(rs.getInt(ID));
		customer.setLogin(rs.getString(LOGIN));
		customer.setPassword(rs.getString(PASSWORD));
		customer.setFirstName(rs.getString(FIRST_NAME));
		customer.setLastName(rs.getString(LAST_NAME));
		customer.setGender(rs.getString(GENDER));
		customer.setBirthDay(rs.getString(BIRTHDAY));
		customer.setPhone(rs.getString(PHONE));
		return customer;
	}
}
