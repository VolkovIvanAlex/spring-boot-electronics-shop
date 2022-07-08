package aim.traineeship.electronics.shop.dto;

public class PaginationDTO
{
	private Integer pageNum;
	private Integer ordersToShow;

	public PaginationDTO(final Integer pageNum, final Integer ordersToShow)
	{
		this.pageNum = pageNum;
		this.ordersToShow = ordersToShow;
	}

	public Integer getPageNum()
	{
		return pageNum;
	}

	public void setPageNum(final Integer pageNum)
	{
		this.pageNum = pageNum;
	}

	public Integer getOrdersToShow()
	{
		return ordersToShow;
	}

	public void setOrdersToShow(final Integer ordersToShow)
	{
		this.ordersToShow = ordersToShow;
	}
}
