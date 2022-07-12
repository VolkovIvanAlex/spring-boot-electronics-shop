package aim.traineeship.electronics.shop.controllers;

import org.springframework.data.domain.PageRequest;

public class AbstractPageController
{
	private static final Integer DEFAULT_PAGE_SIZE = 10;

	protected PageRequest getValidPageRequest(final Integer page, final Integer pageSize)
	{
		if (page < 0 || pageSize < 0)
		{
			return PageRequest.of(0, DEFAULT_PAGE_SIZE);
		}
		return PageRequest.of(page - 1, pageSize);
	}
}
