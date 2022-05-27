package aim.traineeship.electronics.shop.entities;

public enum Gender
{
	MALE("Male"),
	FEMALE("Female"),
	OTHER("Other");

	private final String title;

	Gender(final String title)
	{
		this.title = title;
	}

	public String getTitle()
	{
		return title;
	}
}
