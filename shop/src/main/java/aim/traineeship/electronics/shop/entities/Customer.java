package aim.traineeship.electronics.shop.entities;
import java.util.Date;

public class Customer extends Entity
{
	private String login;
	private String password;
	private String firstName;
	private String lastName;
	private String gender;
	private Date birthDay;
	private String phone;
	private Address address;

	public Customer(final String login, final String password, final String firstName,
			final String lastName, final String gender,
			final Date birthDay, final String phone, final Address address)
	{
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDay = birthDay;
		this.phone = phone;
		this.address = address;
	}

	public Integer getId()
	{
		return super.getId();
	}
	public void setId(final Integer id)
	{
		super.setId(id);
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(final String login)
	{
		this.login = login;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(final String password)
	{
		this.password = password;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(final String gender)
	{
		this.gender = gender;
	}

	public Date getBirthDay()
	{
		return birthDay;
	}

	public void setBirthDay(final Date birthDay)
	{
		this.birthDay = birthDay;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(final String phone)
	{
		this.phone = phone;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(final Address address)
	{
		this.address = address;
	}
}
