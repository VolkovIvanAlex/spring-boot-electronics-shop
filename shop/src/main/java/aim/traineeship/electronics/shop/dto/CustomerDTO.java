package aim.traineeship.electronics.shop.dto;

public class CustomerDTO
{
	private String login;
	private String password;
	private String firstName;
	private String lastName;
	private String gender;
	private String birthDay;
	private String phone;

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

	public String getBirthDay()
	{
		return birthDay;
	}

	public void setBirthDay(final String birthDay)
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
}
