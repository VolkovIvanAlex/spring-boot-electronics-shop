package aim.traineeship.electronics.shop.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import aim.traineeship.electronics.shop.entities.Customer;


public class DefaultCustomerRawMapper implements RowMapper
{
	@Override
	public Customer mapRow(final ResultSet rs, final int rowNum) throws SQLException
	{
		final Customer customer = new Customer();
		customer.setId(rs.getInt("id"));
		customer.setLogin(rs.getString("login"));
		customer.setPassword(rs.getString("password"));
		customer.setFirstName(rs.getString("firstName"));
		customer.setLastName(rs.getString("lastName"));
		customer.setGender(rs.getString("gender"));
		customer.setBirthDay(rs.getDate("birthDay"));
		customer.setPhone(rs.getString("phone"));
		return customer;
	}
}
