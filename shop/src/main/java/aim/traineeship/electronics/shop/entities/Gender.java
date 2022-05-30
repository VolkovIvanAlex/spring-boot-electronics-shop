package aim.traineeship.electronics.shop.entities;

public enum Gender
{
	MALE,
	FEMALE,
	OTHER;

	public static boolean isInGenderEnum(final String gender)
	{
		try
		{
			Gender.valueOf(gender);
			return true;
		}
		catch (final IllegalArgumentException exception)
		{
			return false;
		}
	}
}
