package aim.traineeship.electronics.shop.entities;

import java.util.Arrays;


public enum Gender
{
	MALE,
	FEMALE,
	OTHER;

	public static boolean isInGenderEnum(final String gender)
	{
		return Arrays.stream(Gender.values()).anyMatch(g -> g.name().equals(gender));
	}
}
