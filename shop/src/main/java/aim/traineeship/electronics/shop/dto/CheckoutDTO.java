package aim.traineeship.electronics.shop.dto;

public class CheckoutDTO
{
	private AddressDTO addressDTO;
	private String login;
	private String firstName;
	private String lastName;
	private String phone;

	public CheckoutDTO(final AddressDTO addressDTO)
	{
		this.addressDTO = addressDTO;
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

	public AddressDTO getAddressDTO()
	{
		return addressDTO;
	}

	public void setAddressDTO(final AddressDTO addressDTO)
	{
		this.addressDTO = addressDTO;
	}
}
