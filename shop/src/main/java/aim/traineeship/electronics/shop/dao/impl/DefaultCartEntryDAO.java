package aim.traineeship.electronics.shop.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import aim.traineeship.electronics.shop.dao.CartEntryDAO;
import aim.traineeship.electronics.shop.dao.mapper.DefaultCartEntryRowMapper;
import aim.traineeship.electronics.shop.entities.CartEntry;


@Repository
public class DefaultCartEntryDAO implements CartEntryDAO
{
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private static final String ENTRY_NUMBER = "entryNumber";
	private static final String PRODUCT_ID = "product_id";
	private static final String TOTAL_PRICE = "totalPrice";
	private static final String QUANTITY = "quantity";
	private static final String CART_ID = "cart_id";

	private static final Integer DEFAULT_ENTRY_NUMBER = 1;

	private static final String INSERT_CART_ENTRY =
			"INSERT INTO CartEntry (entryNumber , product_id , totalPrice , quantity ,cart_id)"
					+ "VALUES (:entryNumber , :product_id , :totalPrice , :quantity ,:cart_id)";

	private static final String SELECT_CURRENT_ENTRY_NUMBER = "SELECT MAX(entryNumber) AS entryNumber FROM CartEntry "
			+ "WHERE cart_id = :cart_id";

	private static final String SELECT_CART_ENTRIES_BY_CART_ID =
			"SELECT entryNumber , product_id , totalPrice , quantity , cart_id "
					+ "FROM CartEntry "
					+ "WHERE cart_id = :cart_id ";

	private static final String SELECT_SINGLE_CART_ENTRY =
			"SELECT entryNumber , product_id , totalPrice , quantity , cart_id "
					+ "FROM CartEntry "
					+ "WHERE cart_id = :cart_id AND product_id = :product_id ";

	private static final String UPDATE_PRICE_AND_QUANTITY =
			"UPDATE CartEntry SET totalPrice = :totalPrice , quantity = :quantity "
					+ "WHERE cart_id = :cart_id AND product_id = :product_id ";

	@Override
	public void saveCartEntry(final CartEntry cartEntry)
	{
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put(ENTRY_NUMBER, cartEntry.getEntryNumber());
		parameters.put(PRODUCT_ID, cartEntry.getProduct().getId());
		parameters.put(TOTAL_PRICE, cartEntry.getTotalPrice());
		parameters.put(QUANTITY, cartEntry.getQuantity());
		parameters.put(CART_ID, cartEntry.getCart().getId());
		namedParameterJdbcTemplate.update(INSERT_CART_ENTRY, parameters);
	}

	@Override
	public Integer getCurrentEntryNumber(final Integer cartId)
	{
		final Map<String, Object> parameter = new HashMap<>();
		parameter.put(CART_ID, cartId);
		final Integer result = namedParameterJdbcTemplate.queryForObject(SELECT_CURRENT_ENTRY_NUMBER, parameter,
				Integer.class);
		return result != null ? result + 1 : DEFAULT_ENTRY_NUMBER;
	}

	@Override
	public List<CartEntry> getCartEntriesByCartId(final Integer cartId)
	{
		final RowMapper<CartEntry> mapper = new DefaultCartEntryRowMapper();
		final Map<String, Object> parameter = new HashMap<>();
		parameter.put(CART_ID, cartId);
		return namedParameterJdbcTemplate.query(SELECT_CART_ENTRIES_BY_CART_ID, parameter, mapper);
	}

	@Override
	public Optional<CartEntry> getSingleCartEntry(final Integer productId, final Integer cartId)
	{
		final RowMapper<CartEntry> mapper = new DefaultCartEntryRowMapper();
		final Map<String, Object> parameter = new HashMap<>();
		parameter.put(PRODUCT_ID, productId);
		parameter.put(CART_ID, cartId);
		final List<CartEntry> cartEntry = namedParameterJdbcTemplate.query(SELECT_SINGLE_CART_ENTRY, parameter, mapper);
		return cartEntry.stream().findFirst();
	}

	@Override
	public void updateExistingEntry(final Integer productId, final Integer cartId, final Integer quantity,
			final Double totalPrice)
	{
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put(PRODUCT_ID, productId);
		parameters.put(TOTAL_PRICE, totalPrice);
		parameters.put(QUANTITY, quantity);
		parameters.put(CART_ID, cartId);
		namedParameterJdbcTemplate.update(UPDATE_PRICE_AND_QUANTITY, parameters);
	}
}
