package aim.traineeship.electronics.shop.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import aim.traineeship.electronics.shop.dao.CustomerDAO;
import aim.traineeship.electronics.shop.dao.mapper.DefaultCustomerRawMapper;
import aim.traineeship.electronics.shop.entities.Customer;


@Repository
public class DefaultCustomerDAO implements CustomerDAO
{
	private final String LOGIN = "login";
	private final String FIND_BY_LOGIN = "SELECT id,login,password,firstName,lastName,gender,birthDay,phone "
			+ "FROM Customer WHERE login = :login ";

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Customer findByLogin(final String login)
	{
		final RowMapper<Customer> mapper = new DefaultCustomerRawMapper();
		final Map<String, Object> param = new HashMap<>();
		param.put(LOGIN, login);
		return this.namedParameterJdbcTemplate.queryForObject(FIND_BY_LOGIN, param, mapper);
	}
}