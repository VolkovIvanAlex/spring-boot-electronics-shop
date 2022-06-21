package aim.traineeship.electronics.shop.dto;

import javax.validation.constraints.Min;


public class AddToCartDTO
{
	private String productCode;

	@Min(1)
	private Integer quantity;

	public AddToCartDTO(final String productCode, final Integer quantity)
	{
		this.productCode = productCode;
		this.quantity = quantity;
	}

	public AddToCartDTO()
	{
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
