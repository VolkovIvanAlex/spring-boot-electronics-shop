package aim.traineeship.electronics.shop.dto;

public class NewProductDTO
{
	private String productCode;
	private Integer quantity;

	public NewProductDTO(final String productCode, final Integer quantity)
	{
		this.productCode = productCode;
		this.quantity = quantity;
	}

	public String getProductCode()
	{
		return productCode;
	}

	public void setProductCode(final String productCode)
	{
		this.productCode = productCode;
	}

	public Integer getQuantity()
	{
		return quantity;
	}

	public void setQuantity(final Integer quantity)
	{
		this.quantity = quantity;
	}
}
