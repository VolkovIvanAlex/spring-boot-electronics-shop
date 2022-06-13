package aim.traineeship.electronics.shop.dto;

public class CartEntryDTO
{
	private ProductDTO productDTO;
	private Integer quantity;
	private Integer entryNumber;
	private Double totalPrice;
	private CartDTO cartDTO;

	public ProductDTO getProductDTO()
	{
		return productDTO;
	}

	public void setProductDTO(final ProductDTO productDTO)
	{
		this.productDTO = productDTO;
	}

	public Integer getQuantity()
	{
		return quantity;
	}

	public void setQuantity(final Integer quantity)
	{
		this.quantity = quantity;
	}

	public Integer getEntryNumber()
	{
		return entryNumber;
	}

	public void setEntryNumber(final Integer entryNumber)
	{
		this.entryNumber = entryNumber;
	}

	public Double getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(final Double totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public CartDTO getCartDTO()
	{
		return cartDTO;
	}

	public void setCartDTO(final CartDTO cartDTO)
	{
		this.cartDTO = cartDTO;
	}
}
