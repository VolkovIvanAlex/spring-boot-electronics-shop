package aim.traineeship.electronics.shop.dao.impl;

import java.util.HashMap;
import java.util.List;
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
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String GENDER = "gender";
	private static final String BIRTHDAY = "birthDay";
	private static final String PHONE = "phone";

	private static final String FIND_BY_LOGIN = "SELECT id,login,password,firstName,lastName,gender,birthDay,phone "
			+ "FROM Customer WHERE login = :login ";
	private static final String INSERT_CUSTOMER =
			"INSERT INTO Customer (login, password, firstName, lastName, gender, birthDay, phone)" +
					"VALUES (:login, :password, :firstName, :lastName, :gender, :birthDay, :phone)";

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Customer findByLogin(final String login)
	{
		final RowMapper<Customer> mapper = new DefaultCustomerRawMapper();
		final Map<String, Object> param = new HashMap<>();
		param.put(LOGIN, login);
		final List<Customer> customerList = this.namedParameterJdbcTemplate.query(FIND_BY_LOGIN, param, mapper);
		return customerList.size() > 0 ? customerList.get(0) : null;
	}

	@Override
	public void saveCustomer(final Customer customer)
	{
		final Map<String, Object> params = new HashMap();
		params.put(LOGIN, customer.getLogin());
		params.put(PASSWORD, customer.getPassword());
		params.put(FIRST_NAME, customer.getFirstName());
		params.put(LAST_NAME, customer.getLastName());
		params.put(GENDER, customer.getGender());
		params.put(BIRTHDAY, customer.getBirthDay());
		params.put(PHONE, customer.getPhone());
		namedParameterJdbcTemplate.update(INSERT_CUSTOMER, params);
	}
}