package aim.traineeship.electronics.shop.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import aim.traineeship.electronics.shop.entities.Product;


public class DefaultProductRowMapper implements RowMapper<Product>
{
	private static final String ID = "id";
	private static final String CODE = "code";
	private static final String NAME = "name";
	private static final String PRICE = "price";
	private static final String DESCRIPTION = "description";

	@Override
	public Product mapRow(final ResultSet rs, final int rowNum) throws SQLException
	{
		final Product product = new Product();
		product.setId(rs.getInt(ID));
		product.setCode(rs.getString(CODE));
		product.setName(rs.getString(NAME));
		product.setPrice(rs.getDouble(PRICE));
		product.setDescription(rs.getString(DESCRIPTION));
		return product;
	}
}
