package aim.traineeship.electronics.shop.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import aim.traineeship.electronics.shop.dao.mapper.DefaultCustomerRawMapper;
import aim.traineeship.electronics.shop.entities.Customer;


@Repository
public class DefaultCustomerDAO implements CustomerDAO
{
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	void setJdbcTemplate(final DataSource dataSource)
	{
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	final String sql = "SELECT id,login,password,firstName,lastName,gender,birthDay,phone "
			+ "FROM Customer WHERE login = :login ";

	@Override
	public Customer findByLogin(final String login)
	{
		final RowMapper<Customer> mapper = new DefaultCustomerRawMapper();
		final Map<String, Object> param = new HashMap<>();
		param.put("login", login);
		return this.namedParameterJdbcTemplate.queryForObject(sql, param, mapper);
	}
}