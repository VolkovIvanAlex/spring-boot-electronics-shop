package aim.traineeship.electronics.shop.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import aim.traineeship.electronics.shop.dao.AddressDAO;
import aim.traineeship.electronics.shop.entities.Address;


@Repository
public class DefaultAddressDAO implements AddressDAO
{
	private final SimpleJdbcInsert simpleJdbcInsert;

	private static final String STREET = "street";
	private static final String TOWN = "town";
	private static final String ZIP_CODE = "zipCode";
	private static final String REGION = "region";
	private static final String COUNTRY = "country";

	@Autowired
	public DefaultAddressDAO(final DataSource dataSource)
	{
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
				.withTableName("Address").usingGeneratedKeyColumns("id");
	}

	@Override
	public Integer saveAddress(final Address address)
	{
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put(STREET, address.getStreet());
		parameters.put(TOWN, address.getTown());
		parameters.put(ZIP_CODE, address.getZipCode());
		parameters.put(REGION, address.getRegion());
		parameters.put(COUNTRY, address.getCountry());
		return simpleJdbcInsert.executeAndReturnKey(parameters).intValue();
	}
}
