package aim.traineeship.electronics.shop.dao;

import javax.sql.DataSource;

import aim.traineeship.electronics.shop.entities.Customer;


public interface CustomerDAO
{
	void setDataSource(final DataSource dataSource);
	Customer findByUserName(final String userName);
}
