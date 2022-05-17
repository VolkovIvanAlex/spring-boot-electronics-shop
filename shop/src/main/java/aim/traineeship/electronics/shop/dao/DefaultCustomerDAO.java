package aim.traineeship.electronics.shop.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import aim.traineeship.electronics.shop.entities.Customer;


@Repository
public class DefaultCustomerDAO implements CustomerDAO
{
	private JdbcTemplate jdbcTemplate;
	@Override
	@Autowired
	public void setDataSource(final DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public Customer findByUserName(final String userName)
	{
		final String sqlStr = "SELECT login,password FROM Customer WHERE login =? ";
		final Customer customer = new Customer();
		jdbcTemplate.query(sqlStr, new Object[] { userName },
				rs -> {
					customer.setLogin(rs.getString("login"));
					customer.setPassword(rs.getString("password"));
				});
		return customer;
	}
}
