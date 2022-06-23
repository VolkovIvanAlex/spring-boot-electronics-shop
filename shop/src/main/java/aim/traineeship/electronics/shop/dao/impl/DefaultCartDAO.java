package aim.traineeship.electronics.shop.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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

	private static final String CODE = "code";
	private static final String TOTAL_PRICE = "totalPrice";
	private static final String PLACED_DATE = "placedDate";
	private static final String CUSTOMER_ID = "customer_id";
	private static final String ADDRESS_ID = "address_id";

	private static final String INSERT_CART = "INSERT INTO Cart (code , totalPrice , placedDate , customer_id)"
			+ "VALUES (:code , :totalPrice , :placedDate , :customer_id)";

	private static final String SELECT_BY_CODE = "SELECT CA.id ,code ,totalPrice , placedDate , customer_id , "
			+ "login , password , firstName , lastName , gender , birthDay , phone "
			+ "FROM Cart AS CA JOIN Customer AS CU ON CA.customer_id = CU.id "
			+ "WHERE CA.code = :code ";

	private static final String SELECT_FULL_BY_CODE =
			"SELECT CA.id AS id ,code ,totalPrice , placedDate , customer_id , "
					+ " login , password , firstName , lastName , gender , birthDay , phone , street , town , region , zipCode , country "
					+ " FROM Cart AS CA JOIN Customer AS CU ON CA.customer_id = CU.id JOIN Address AS A ON address_id = A.id "
					+ " WHERE CA.code = :code";

	private static final String UPDATE_PRICE = "UPDATE Cart SET totalPrice = :totalPrice "
			+ "WHERE code = :code";

	private static final String UPDATE_ADDRESS = "UPDATE Cart SET address_id = :address_id "
			+ "WHERE code = :code";

	private static final String UPDATE_DATE = "UPDATE Cart SET placedDate = :placedDate "
			+ "WHERE code = :code";

	@Override
	public void saveCart(final Cart cart)
	{
		final Map<String, Object> parameter = new HashMap<>();
		parameter.put(CODE, cart.getCode());
		parameter.put(TOTAL_PRICE, cart.getTotalPrice());
		parameter.put(PLACED_DATE, cart.getPlacedDate());
		parameter.put(CUSTOMER_ID, cart.getCustomer().getId());
		namedParameterJdbcTemplate.update(INSERT_CART, parameter);
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
	public void updateCartTotalPrice(final String code, final Double price)
	{
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put(CODE, code);
		parameters.put(TOTAL_PRICE, price);
		namedParameterJdbcTemplate.update(UPDATE_PRICE, parameters);
	}

	@Override
	public void updateCartAddressId(final String cartCode, final Integer addressId)
	{
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put(CODE, cartCode);
		parameters.put(ADDRESS_ID, addressId);
		namedParameterJdbcTemplate.update(UPDATE_ADDRESS, parameters);
	}

	@Override
	public void updateCartPlacedDate(final String cartCode, final Date date)
	{
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put(CODE, cartCode);
		parameters.put(PLACED_DATE, date);
		namedParameterJdbcTemplate.update(UPDATE_DATE, parameters);
	}
}
