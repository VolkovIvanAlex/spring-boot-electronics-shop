package aim.traineeship.electronics.shop.security;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import aim.traineeship.electronics.shop.entities.Address;
import aim.traineeship.electronics.shop.entities.Customer;


public class CustomerDetails implements UserDetails
{
	static final long serialVersionUID = 1L;
	private final Customer customer;

	public CustomerDetails(final Customer customer)
	{
		this.customer = customer;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return null;
	}

	@Override
	public String getPassword()
	{
		return customer.getPassword();
	}

	@Override
	public String getUsername()
	{
		return customer.getLogin();
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		return true;
	}

	public String getFirstName()
	{
		return customer.getFirstName();
	}

	public String getLastName()
	{
		return customer.getLastName();
	}

	public String getGender()
	{
		return customer.getGender();
	}

	public Date getBirthDay()
	{
		return customer.getBirthDay();
	}

	public String getPhone()
	{
		return customer.getPhone();
	}

	public Address getAddress()
	{
		return customer.getAddress();
	}
}
