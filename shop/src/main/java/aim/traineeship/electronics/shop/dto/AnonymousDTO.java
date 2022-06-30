package aim.traineeship.electronics.shop.dto;

public class AnonymousDTO
{
	private String login;
	private String firstName;
	private String lastName;
	private String phone;

	public AnonymousDTO(final CheckoutDTO checkoutDTO)
	{
		this.login = checkoutDTO.getLogin();
		this.firstName = checkoutDTO.getFirstName();
		this.lastName = checkoutDTO.getLastName();
		this.phone = checkoutDTO.getPhone();
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(final String login)
	{
		this.login = login;
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

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(final String phone)
	{
		this.phone = phone;
	}
}
