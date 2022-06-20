package aim.traineeship.electronics.shop.dto;

public class RemoveFromCartDTO
{
	private String productCode;
	private String cartCode;

	public RemoveFromCartDTO(final String productCode, final String cartCode)
	{
		this.productCode = productCode;
		this.cartCode = cartCode;
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
}
