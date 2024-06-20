package aim.traineeship.electronics.shop.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import aim.traineeship.electronics.shop.entities.Address;
import aim.traineeship.electronics.shop.entities.Cart;


public class FullCartRowMapper implements RowMapper<Cart>
{

	private static final String STREET = "street";
	private static final String TOWN = "town";
	private static final String ZIP_CODE = "zipCode";
	private static final String REGION = "region";
	private static final String COUNTRY = "country";

	@Override
	public Cart mapRow(final ResultSet rs, final int rowNum) throws SQLException
	{
		final DefaultCartRowMapper defaultCartRowMapper = new DefaultCartRowMapper();
		final Cart cart = defaultCartRowMapper.mapRow(rs, rowNum);

		final Address address = new Address();
		address.setStreet(rs.getString(STREET));
		address.setTown(rs.getString(TOWN));
		address.setRegion(rs.getString(REGION));
		address.setZipCode(rs.getString(ZIP_CODE));
		address.setCountry(rs.getString(COUNTRY));

		cart.setAddress(address);
		return cart;
	}
}
