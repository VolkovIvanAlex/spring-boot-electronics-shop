package aim.traineeship.electronics.shop.dao.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import aim.traineeship.electronics.shop.dao.CartEntryDAO;
import aim.traineeship.electronics.shop.entities.CartEntry;


@Repository
public class DefaultCartEntryDAO implements CartEntryDAO
{
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private static  final String ENTRY_NUMBER = "entryNumber";
	private static  final String PRODUCT_ID = "product_id";
	private static  final String TOTAL_PRICE = "totalPrice";
	private static  final String QUANTITY = "quantity";
	private static  final String CART_ID = "cart_id";

	private static final String INSERT_CART_ENTRY = "INSERT INTO CartEntry (entryNumber , product_id , totalPrice , quantity ,cart_id)"
			+ "VALUES (:entryNumber , :product_id , :totalPrice , :quantity ,:cart_id)";

	private static final String SELECT_CURRENT_ENTRY_NUMBER = "SELECT MAX(entryNumber) AS entryNumber FROM CartEntry "
			+ "WHERE cart_id = :cart_id";


	@Override
	public void saveCartEntry(final CartEntry cartEntry)
	{
		final Map<String , Object> parameters = new HashMap<>();
		parameters.put(ENTRY_NUMBER , cartEntry.getEntryNumber());
		parameters.put(PRODUCT_ID , cartEntry.getProduct().getId());
		parameters.put(TOTAL_PRICE , cartEntry.getTotalPrice());
		parameters.put(QUANTITY , cartEntry.getQuantity());
		parameters.put(CART_ID , cartEntry.getCart().getId());
		namedParameterJdbcTemplate.update(INSERT_CART_ENTRY , parameters);
	}

	@Override
	public Optional<Integer> getCurrentEntryNumber(final Integer cartID)
	{
		final Map<String , Object> parameter = new HashMap<>();
		parameter.put(CART_ID , cartID);
		final Integer result = namedParameterJdbcTemplate.queryForObject(SELECT_CURRENT_ENTRY_NUMBER , parameter , Integer.class);
		return Optional.ofNullable(result);
	}
}
