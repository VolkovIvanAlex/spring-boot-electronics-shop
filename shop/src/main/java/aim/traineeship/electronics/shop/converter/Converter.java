package aim.traineeship.electronics.shop.converter;

import java.util.ArrayList;
import java.util.List;


public interface Converter<S , T>
{
	T convert(S source);

	default List<T> convertList(final List<S> sourceList)
	{
		final List<T> targetList = new ArrayList<>();
		for (final S sourceListItem : sourceList)
		{
			final T targetListItem = convert(sourceListItem);
			targetList.add(targetListItem);
		}
		return targetList;
	}
}
