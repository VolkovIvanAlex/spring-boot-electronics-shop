package aim.traineeship.electronics.shop.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


@Configuration
public class SpringJdbcConfig
{
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private void setJdbcTemplate(final DataSource dataSource)
	{
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
}
