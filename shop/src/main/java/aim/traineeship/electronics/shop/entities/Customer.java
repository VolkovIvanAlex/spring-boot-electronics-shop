package aim.traineeship.electronics.shop.entities;

import java.util.Date;


public class Customer extends Entity
{
	private String login;
	private String password;
	private String firstName;
	private String lastName;
	private Gender gender;
	private Date birthDay;
	private String phone;
	private Address address;

	public Customer()
	{
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

	public Gender getGender()
	{
		return gender;
	}

	public void setGender(final Gender gender)
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
