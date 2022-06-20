package aim.traineeship.electronics.shop.dto;

import javax.validation.constraints.Min;


public class UpdateCartDTO
{
	private String productCode;
	private String cartCode;

	@Min(1)
	private Integer quantity;

	public UpdateCartDTO(final String productCode, final String cartCode, final Integer quantity)
	{
		this.productCode = productCode;
		this.cartCode = cartCode;
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

	public String getCartCode()
	{
		return cartCode;
	}

	public void setCartCode(final String cartCode)
	{
		this.cartCode = cartCode;
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

