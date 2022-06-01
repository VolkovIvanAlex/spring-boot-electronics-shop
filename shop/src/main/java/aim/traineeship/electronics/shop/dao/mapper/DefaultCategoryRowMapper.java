package aim.traineeship.electronics.shop.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import aim.traineeship.electronics.shop.entities.Category;


public class DefaultCategoryRowMapper implements RowMapper<Category>
{
	private static final String ID = "id";
	private static final String CODE = "code";
	private static final String NAME = "name";
	private static final String PRODUCTS = "products";

	@Override
	public Category mapRow(final ResultSet rs, final int rowNum) throws SQLException
	{
		final Category category = new Category();
		category.setId(rs.getInt(ID));
		category.setCode(rs.getString(CODE));
		category.setName(rs.getString(NAME));
		category.setProductsAmount(rs.getInt(PRODUCTS));
		return category;
	}
}

