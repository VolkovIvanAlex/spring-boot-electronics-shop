package aim.traineeship.electronics.shop.entities;

public class CartEntry extends Entity
{
	private Product product;
	private Integer quantity;
	private Integer entryNumber;
	private Double totalPrice;

	public CartEntry(final Product product, final Integer quantity, final Integer entryNumber,
			final Double totalPrice)
	{
		this.product = product;
		this.quantity = quantity;
		this.entryNumber = entryNumber;
		this.totalPrice = totalPrice;
	}

	public Integer getId()
	{
		return super.getId();
	}
	public void setId(final Integer id)
	{
		super.setId(id);
	}

	public Product getProduct()
	{
		return product;
	}

	public void setProduct(final Product product)
	{
		this.product = product;
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
}

