package aim.traineeship.electronics.shop.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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

	private static final String CODE = "code";
	private static final String PAGE_SIZE = "pageSize";
	private static final String OFFSET = "offset";

	private static final String FIND_BY_CATEGORY_CODE =
			"SELECT P.id, P.code, P.name, price, description, category_id , C.code AS category_code, C.name AS category_name FROM Product AS P "
					+ "JOIN Category AS C ON P.category_id = C.id "
					+ "WHERE C.code = :code "
					+ "LIMIT :pageSize OFFSET :offset";

	private static final String COUNT_BY_CATEGORY_CODE =
			"SELECT COUNT(*) FROM Product AS P "
					+ "JOIN Category AS C ON P.category_id = C.id "
					+ "WHERE C.code = :code";

	private static final String FIND_BY_PRODUCT_CODE =
			"SELECT P.id, P.code, P.name, price, description, category_id , C.code AS category_code, C.name AS category_name FROM Product AS P "
					+ "JOIN Category AS C ON P.category_id = C.id "
					+ "WHERE P.code = :code";

	@Override
	public Page<Product> findByCategoryCode(final PageRequest pageRequest, final String code)
	{
		final Integer totalProducts = countProducts(code);
		final RowMapper<Product> mapper = new DefaultProductRowMapper();
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put(CODE, code);
		parameters.put(PAGE_SIZE, pageRequest.getPageSize());
		parameters.put(OFFSET, pageRequest.getOffset());
		final List<Product> products = this.namedParameterJdbcTemplate.query(FIND_BY_CATEGORY_CODE, parameters, mapper);
		return new PageImpl<>(products, pageRequest, totalProducts);
	}

	@Override
	public Optional<Product> findByProductCode(final String code)
	{
		final RowMapper<Product> mapper = new DefaultProductRowMapper();
		final Map<String, Object> parameter = new HashMap<>();
		parameter.put(CODE, code);
		final List<Product> product = this.namedParameterJdbcTemplate.query(FIND_BY_PRODUCT_CODE, parameter, mapper);
		return product.stream().findFirst();
	}

	private Integer countProducts(final String code)
	{
		final Map<String, Object> parameter = new HashMap<>();
		parameter.put(CODE, code);
		return namedParameterJdbcTemplate.queryForObject(COUNT_BY_CATEGORY_CODE, parameter, Integer.class);
	}
}
