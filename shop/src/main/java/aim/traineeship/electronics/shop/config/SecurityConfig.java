package aim.traineeship.electronics.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

	@Override
	@Bean
	public UserDetailsService userDetailsService() {
		final InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withDefaultPasswordEncoder()
				.username("Ivan").password("ddd").roles("USER").build());
		return manager;
	}

	@Override
	public void configure(final HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity
				.authorizeRequests()
				.antMatchers("/home").hasRole("USER")
				.and()
				.formLogin()
				.loginPage("/login_page").defaultSuccessUrl("/home")
				.permitAll()

		;
	}
}
