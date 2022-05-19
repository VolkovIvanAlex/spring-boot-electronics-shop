package aim.traineeship.electronics.shop.entities;
import java.util.Date;
import java.util.List;

public class Cart extends Entity
{
	private String code;
	private Double totalPrice;
	private Date placedDate;
	private List<CartEntry> cartEntries;
	private Customer customer;
	private Address address;

	public Cart()
	{
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(final String code)
	{
		this.code = code;
	}

	public Double getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(final Double totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public Date getPlacedDate()
	{
		return placedDate;
	}

	public void setPlacedDate(final Date placedDate)
	{
		this.placedDate = placedDate;
	}

	public List<CartEntry> getCartEntries()
	{
		return cartEntries;
	}

	public void setCartEntries(final List<CartEntry> cartEntries)
	{
		this.cartEntries = cartEntries;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(final Customer customer)
	{
		this.customer = customer;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(final Address address)
	{
		this.address = address;
	}
}
