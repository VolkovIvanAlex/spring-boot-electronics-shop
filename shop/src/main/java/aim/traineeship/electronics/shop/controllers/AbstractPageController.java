package aim.traineeship.electronics.shop.controllers;

import org.springframework.data.domain.PageRequest;

public class AbstractPageController
{
	private static final Integer DEFAULT_PAGE_SIZE = 10;

	protected PageRequest getValidPageRequest(final Integer page, final Integer pageSize)
	{
		final PageRequest pageRequest;
		if (page < 0 || pageSize < 0)
		{
			pageRequest = PageRequest.of(0, DEFAULT_PAGE_SIZE);
		}
		else
		{
			pageRequest = PageRequest.of(page - 1, pageSize);
		}
		return  pageRequest;
	}
}
