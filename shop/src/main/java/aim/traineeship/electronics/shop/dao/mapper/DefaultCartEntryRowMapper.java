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
	private static final String TOTAL_PRICE = "totalPrice";
	private static final String QUANTITY = "quantity";
	private static final String CART_ID = "cart_id";

	@Override
	public CartEntry mapRow(final ResultSet rs, final int rowNum) throws SQLException
	{
		final CartEntry cartEntry = new CartEntry();
		cartEntry.setEntryNumber(rs.getInt(ENTRY_NUMBER));

		final Product product = new Product();
		product.setId(rs.getInt(PRODUCT_ID));
		cartEntry.setProduct(product);

		cartEntry.setTotalPrice(rs.getDouble(TOTAL_PRICE));
		cartEntry.setQuantity(rs.getInt(QUANTITY));

		final Cart cart = new Cart();
		cart.setId(rs.getInt(CART_ID));

		cartEntry.setCart(cart);
		return cartEntry;
	}
}
