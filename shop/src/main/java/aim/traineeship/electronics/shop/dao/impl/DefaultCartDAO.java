package aim.traineeship.electronics.shop.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import aim.traineeship.electronics.shop.dao.CartDAO;
import aim.traineeship.electronics.shop.dao.mapper.DefaultCartRowMapper;
import aim.traineeship.electronics.shop.dao.mapper.FullCartRowMapper;
import aim.traineeship.electronics.shop.entities.Cart;


@Repository
public class DefaultCartDAO implements CartDAO
{
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private final SimpleJdbcInsert simpleJdbcInsert;

	private static final String CODE = "code";
	private static final String TOTAL_PRICE = "totalPrice";
	private static final String PLACED_DATE = "placedDate";
	private static final String CUSTOMER_ID = "customer_id";
	private static final String ADDRESS_ID = "address_id";

	private static final String SELECT_BY_CODE = "SELECT CA.id ,code ,totalPrice , placedDate , customer_id , "
			+ "login ,firstName , lastName , phone "
			+ "FROM Cart AS CA JOIN Customer AS CU ON CA.customer_id = CU.id "
			+ "WHERE CA.code = :code ";

	private static final String SELECT_FULL_BY_CODE =
			"SELECT CA.id AS id ,code ,totalPrice , placedDate , customer_id , "
					+ " login , firstName , lastName , phone , street , town , region , zipCode , country "
					+ " FROM Cart AS CA JOIN Customer AS CU ON CA.customer_id = CU.id JOIN Address AS A ON address_id = A.id "
					+ " WHERE CA.code = :code";

	private static final String SELECT_BY_CUSTOMER_ID =
			"SELECT CA.id AS id ,code ,totalPrice , placedDate , customer_id , "
					+ " login , firstName , lastName , phone ,  street , town , region , zipCode , country "
					+ " FROM Cart AS CA JOIN Customer AS CU ON CA.customer_id = CU.id JOIN Address AS A ON address_id = A.id "
					+ " WHERE customer_id = :customer_id "
					+ " ORDER BY placedDate DESC ";

	private static final String UPDATE_PRICE = "UPDATE Cart SET totalPrice = :totalPrice "
			+ "WHERE code = :code";

	private static final String UPDATE_ADDRESS = "UPDATE Cart SET address_id = :address_id "
			+ "WHERE code = :code";

	private static final String UPDATE_DATE = "UPDATE Cart SET placedDate = :placedDate "
			+ "WHERE code = :code";

	private static final String UPDATE_CUSTOMER = "UPDATE Cart SET customer_id = :customer_id "
			+ "WHERE code = :code";

	@Autowired
	public DefaultCartDAO(final DataSource dataSource)
	{
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
				.withTableName("Cart").usingGeneratedKeyColumns("id");
	}

	@Override
	public Integer saveCart(final Cart cart)
	{
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put(CODE, cart.getCode());
		parameters.put(TOTAL_PRICE, cart.getTotalPrice());
		parameters.put(PLACED_DATE, cart.getPlacedDate());
		parameters.put(CUSTOMER_ID, cart.getCustomer().getId());
		return simpleJdbcInsert.executeAndReturnKey(parameters).intValue();
	}

	@Override
	public Cart findByCode(final String code)
	{
		final Map<String, Object> parameter = new HashMap<>();
		final RowMapper<Cart> mapper = new DefaultCartRowMapper();
		parameter.put(CODE, code);
		final List<Cart> result = namedParameterJdbcTemplate.query(SELECT_BY_CODE, parameter, mapper);
		return result.get(0);
	}

	@Override
	public Optional<Cart> findFullByCode(final String code)
	{
		final Map<String, Object> parameter = new HashMap<>();
		final RowMapper<Cart> mapper = new FullCartRowMapper();
		parameter.put(CODE, code);
		final List<Cart> result = namedParameterJdbcTemplate.query(SELECT_FULL_BY_CODE, parameter, mapper);
		return result.stream().findFirst();
	}

	@Override
	public List<Cart> findOrdersByCustomerId(final Integer customerId)
	{
		final RowMapper<Cart> mapper = new FullCartRowMapper();
		final Map<String, Object> parameter = new HashMap<>();
		parameter.put(CUSTOMER_ID, customerId);
		return namedParameterJdbcTemplate.query(SELECT_BY_CUSTOMER_ID, parameter, mapper);
	}

	@Override
	public void updateCartTotalPrice(final String code, final Double price)
	{
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put(CODE, code);
		parameters.put(TOTAL_PRICE, price);
		namedParameterJdbcTemplate.update(UPDATE_PRICE, parameters);
	}

	@Override
	public void saveAddress(final String cartCode, final Integer addressId)
	{
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put(CODE, cartCode);
		parameters.put(ADDRESS_ID, addressId);
		namedParameterJdbcTemplate.update(UPDATE_ADDRESS, parameters);
	}

	@Override
	public void savePlacedDate(final String cartCode, final Date date)
	{
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put(CODE, cartCode);
		parameters.put(PLACED_DATE, date);
		namedParameterJdbcTemplate.update(UPDATE_DATE, parameters);
	}

	@Override
	public void saveCustomer(final Integer customerId, final String code)
	{
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put(CODE, code);
		parameters.put(CUSTOMER_ID, customerId);
		namedParameterJdbcTemplate.update(UPDATE_CUSTOMER, parameters);
	}
}
