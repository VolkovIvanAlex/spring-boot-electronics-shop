package aim.traineeship.electronics.shop.entities;

import java.util.Locale;


public enum Gender
{
	MALE("MALE"),
	FEMALE("FEMALE"),
	OTHER("OTHER");

	private final String title;

	public static boolean isInGenderEnum(final String gender)
	{
		for (final Gender g : Gender.values())
		{
			if (g.getTitle().equals(gender.toUpperCase(Locale.ROOT)))
			{
				return true;
			}
		}
		return false;
	}

	Gender(final String title)
	{
		this.title = title;
	}

	public String getTitle()
	{
		return title;
	}
}
