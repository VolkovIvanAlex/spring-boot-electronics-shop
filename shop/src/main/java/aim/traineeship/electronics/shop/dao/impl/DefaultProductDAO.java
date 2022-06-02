package aim.traineeship.electronics.shop.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import aim.traineeship.electronics.shop.dao.ProductDAO;
import aim.traineeship.electronics.shop.dao.mapper.DefaultProductRowMapper;
import aim.traineeship.electronics.shop.entities.Product;


@Repository
public class DefaultProductDAO implements ProductDAO
{
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private static final String ID = "id";

	private static final String FIND_BY_CATEGORY = "SELECT id,code,P.name,price,description FROM Product AS P "
			+ "WHERE category_id = :id ";

	@Override
	public List<Product> findByCategoryId(final String id)
	{
		final RowMapper<Product> mapper = new DefaultProductRowMapper();
		final Map<String, Object> parameter = new HashMap<>();
		parameter.put(ID, id);
		return this.namedParameterJdbcTemplate.query(FIND_BY_CATEGORY, parameter, mapper);
	}
}
