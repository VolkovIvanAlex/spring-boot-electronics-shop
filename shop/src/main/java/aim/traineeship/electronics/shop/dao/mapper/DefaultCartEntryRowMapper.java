package aim.traineeship.electronics.shop.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import aim.traineeship.electronics.shop.entities.Cart;
import aim.traineeship.electronics.shop.entities.CartEntry;
import aim.traineeship.electronics.shop.entities.Product;


public class DefaultCartEntryRowMapper implements RowMapper<CartEntry>
{
	private static final String ENTRY_NUMBER = "entryNumber";
	private static final String PRODUCT_ID = "product_id";
	private static final String PRODUCT_CODE = "product_code";
	private static final String PRODUCT_NAME = "product_name";
	private static final String PRODUCT_PRICE = "product_price";
	private static final String TOTAL_PRICE = "totalPrice";
	private static final String QUANTITY = "quantity";
	private static final String CART_ID = "cart_id";
	private static final String CART_CODE = "cart_code";
	private static final String CART_TOTAL_PRICE = "cart_total_price";

	@Override
	public CartEntry mapRow(final ResultSet rs, final int rowNum) throws SQLException
	{
		final CartEntry cartEntry = new CartEntry();
		cartEntry.setEntryNumber(rs.getInt(ENTRY_NUMBER));

		final Product product = new Product();
		product.setId(rs.getInt(PRODUCT_ID));
		product.setCode(rs.getString(PRODUCT_CODE));
		product.setName(rs.getString(PRODUCT_NAME));
		product.setPrice(rs.getDouble(PRODUCT_PRICE));
		cartEntry.setProduct(product);

		cartEntry.setTotalPrice(rs.getDouble(TOTAL_PRICE));
		cartEntry.setQuantity(rs.getInt(QUANTITY));

		final Cart cart = new Cart();
		cart.setId(rs.getInt(CART_ID));
		cart.setCode(rs.getString(CART_CODE));
		cart.setTotalPrice(rs.getDouble(CART_TOTAL_PRICE));
		cartEntry.setCart(cart);

		return cartEntry;
	}
}
