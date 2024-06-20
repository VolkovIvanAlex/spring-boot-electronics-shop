package aim.traineeship.electronics.shop.entities;

public class CartEntry extends Entity
{
	private Product product;
	private Integer quantity;
	private Integer entryNumber;
	private Double totalPrice;
	private Cart cart;

	public CartEntry()
	{
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

	public Cart getCart()
	{
		return cart;
	}

	public void setCart(final Cart cart)
	{
		this.cart = cart;
	}
}

