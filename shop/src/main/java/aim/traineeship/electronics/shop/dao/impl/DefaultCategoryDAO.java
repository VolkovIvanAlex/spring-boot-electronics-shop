package aim.traineeship.electronics.shop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import aim.traineeship.electronics.shop.dao.CategoryDAO;
import aim.traineeship.electronics.shop.dao.mapper.DefaultCategoryRowMapper;
import aim.traineeship.electronics.shop.entities.Category;

@Repository
public class DefaultCategoryDAO implements CategoryDAO
{
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private static final String SELECT_CATEGORIES = "SELECT C.id , C.code ,C.name , COUNT(category_id) AS products "
			+ "FROM Category AS C LEFT JOIN Product AS P ON C.id = P.category_id "
			+ "GROUP BY C.code;";

	@Override
	public List<Category> findCategories()
	{
		final RowMapper<Category> mapper = new DefaultCategoryRowMapper();
		return namedParameterJdbcTemplate.query(SELECT_CATEGORIES , mapper);
	}
}
