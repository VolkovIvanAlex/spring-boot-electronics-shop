package aim.traineeship.electronics.shop.dto;

import javax.validation.constraints.NotEmpty;


public class AddressDTO
{
	private Integer id;
	@NotEmpty
	private String street;
	@NotEmpty
	private String zipCode;
	@NotEmpty
	private String town;
	@NotEmpty
	private String region;
	@NotEmpty
	private String country;

	public Integer getId()
	{
		return id;
	}

	public void setId(final Integer id)
	{
		this.id = id;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(final String street)
	{
		this.street = street;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(final String zipCode)
	{
		this.zipCode = zipCode;
	}

	public String getTown()
	{
		return town;
	}

	public void setTown(final String town)
	{
		this.town = town;
	}

	public String getRegion()
	{
		return region;
	}

	public void setRegion(final String region)
	{
		this.region = region;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(final String country)
	{
		this.country = country;
	}
}
