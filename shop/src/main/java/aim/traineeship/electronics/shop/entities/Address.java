package aim.traineeship.electronics.shop.entities;

public class Address extends Entity
{
	private String street;
	private String zipCode;
	private String town;
	private String region;
	private String country;

	public Address(final String street, final String zipCode, final String town, final String region,
			final String country)
	{
		this.street = street;
		this.zipCode = zipCode;
		this.town = town;
		this.region = region;
		this.country = country;
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
