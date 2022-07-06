package aim.traineeship.electronics.shop.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import aim.traineeship.electronics.shop.entities.Cart;
import aim.traineeship.electronics.shop.entities.Customer;


public class DefaultCartRowMapper implements RowMapper<Cart>
{
	private static final String ID = "id";
	private static final String CODE = "code";
	private static final String TOTAL_PRICE = "totalPrice";
	private static final String PLACED_DATE = "placedDate";
	private static final String LOGIN = "login";
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";

	@Override
	public Cart mapRow(final ResultSet rs, final int rowNum) throws SQLException
	{
		final Cart cart = new Cart();
		cart.setId(rs.getInt(ID));
		cart.setCode(rs.getString(CODE));
		cart.setTotalPrice(rs.getDouble(TOTAL_PRICE));
		cart.setPlacedDate(rs.getDate(PLACED_DATE));

		final Customer customer = new Customer();
		customer.setLogin(rs.getString(LOGIN));
		customer.setFirstName(rs.getString(FIRST_NAME));
		customer.setLastName(rs.getString(LAST_NAME));
		cart.setCustomer(customer);

		return cart;
	}
}
