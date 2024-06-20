package aim.traineeship.electronics.shop.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import aim.traineeship.electronics.shop.entities.Category;
import aim.traineeship.electronics.shop.entities.Product;


public class DefaultProductRowMapper implements RowMapper<Product>
{
	private static final String ID = "id";
	private static final String CODE = "code";
	private static final String NAME = "name";
	private static final String PRICE = "price";
	private static final String DESCRIPTION = "description";
	private static final String CATEGORY_ID = "category_id";
	private static final String CATEGORY_CODE = "category_code";
	private static final String CATEGORY_NAME = "category_name";

	@Override
	public Product mapRow(final ResultSet rs, final int rowNum) throws SQLException
	{
		final Product product = new Product();
		product.setId(rs.getInt(ID));
		product.setCode(rs.getString(CODE));
		product.setName(rs.getString(NAME));
		product.setPrice(rs.getDouble(PRICE));
		product.setDescription(rs.getString(DESCRIPTION));

		final Category category = new Category();
		category.setId(rs.getInt(CATEGORY_ID));
		category.setCode(rs.getString(CATEGORY_CODE));
		category.setName(rs.getString(CATEGORY_NAME));

		product.setCategory(category);
		return product;
	}
}
