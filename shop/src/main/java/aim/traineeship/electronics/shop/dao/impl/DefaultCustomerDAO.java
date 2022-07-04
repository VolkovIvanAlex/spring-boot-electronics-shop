package aim.traineeship.electronics.shop.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import aim.traineeship.electronics.shop.dao.CustomerDAO;
import aim.traineeship.electronics.shop.dao.mapper.AnonymousCustomerRowMapper;
import aim.traineeship.electronics.shop.dao.mapper.DefaultCustomerRowMapper;
import aim.traineeship.electronics.shop.entities.Customer;


@Repository
public class DefaultCustomerDAO implements CustomerDAO
{
	@Autowired
	private PasswordEncoder passwordEncoder;

	private final SimpleJdbcInsert simpleJdbcInsert;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String GENDER = "gender";
	private static final String BIRTHDAY = "birthDay";
	private static final String PHONE = "phone";

	private static final String FIND_BY_LOGIN = "SELECT id,login,password,firstName,lastName,gender,birthDay,phone "
			+ "FROM Customer WHERE login = :login ";

	private static final String FIND_BY_LOGIN_ANONYMOUS = "SELECT id,login,firstName,lastName,phone "
			+ "FROM Customer WHERE login = :login ";

	private static final String INSERT_CUSTOMER =
			"INSERT INTO Customer (login, password, firstName, lastName, gender, birthDay, phone)" +
					"VALUES (:login, :password, :firstName, :lastName, :gender, :birthDay, :phone)";

	@Autowired
	public DefaultCustomerDAO(final DataSource dataSource)
	{
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
				.withTableName("Customer").usingGeneratedKeyColumns("id");
	}

	@Override
	public Optional<Customer> findByLogin(final String login)
	{
		final RowMapper<Customer> mapper = new DefaultCustomerRowMapper();
		final Map<String, Object> param = new HashMap<>();
		param.put(LOGIN, login);
		final List<Customer> customerList = this.namedParameterJdbcTemplate.query(FIND_BY_LOGIN, param, mapper);
		return customerList.stream().findFirst();
	}

	@Override
	public Optional<Customer> findByLoginAnonymous(final String login)
	{
		final RowMapper<Customer> mapper = new AnonymousCustomerRowMapper();
		final Map<String, Object> param = new HashMap<>();
		param.put(LOGIN, login);
		final List<Customer> customerList = this.namedParameterJdbcTemplate.query(FIND_BY_LOGIN_ANONYMOUS, param,
				mapper);
		return customerList.stream().findFirst();
	}

	@Override
	public void saveCustomer(final Customer customer)
	{
		final Map<String, Object> params = new HashMap<>();
		params.put(LOGIN, customer.getLogin());
		params.put(PASSWORD, passwordEncoder.encode(customer.getPassword()));
		params.put(FIRST_NAME, customer.getFirstName());
		params.put(LAST_NAME, customer.getLastName());
		params.put(GENDER, customer.getGender().name());
		params.put(BIRTHDAY, customer.getBirthDay());
		params.put(PHONE, customer.getPhone());
		namedParameterJdbcTemplate.update(INSERT_CUSTOMER, params);
	}

	@Override
	public Integer saveAnonymousCustomer(final Customer customer)
	{
		final Map<String, Object> params = new HashMap<>();
		params.put(FIRST_NAME, customer.getFirstName());
		params.put(LAST_NAME, customer.getLastName());
		params.put(LOGIN, customer.getLogin());
		params.put(PHONE, customer.getPhone());
		return simpleJdbcInsert.executeAndReturnKey(params).intValue();
	}
}