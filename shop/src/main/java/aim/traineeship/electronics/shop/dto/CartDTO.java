package aim.traineeship.electronics.shop.dto;

import java.util.List;


public class CartDTO
{
	private Integer id;
	private String code;
	private Double totalPrice;
	private String placedDate;
	private CustomerDTO customerDTO;
	private AddressDTO addressDTO;
	private List<CartEntryDTO> cartEntries;

	public Integer getId()
	{
		return id;
	}

	public void setId(final Integer id)
	{
		this.id = id;
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

	public String getPlacedDate()
	{
		return placedDate;
	}

	public void setPlacedDate(final String placedDate)
	{
		this.placedDate = placedDate;
	}

	public CustomerDTO getCustomerDTO()
	{
		return customerDTO;
	}

	public void setCustomerDTO(final CustomerDTO customerDTO)
	{
		this.customerDTO = customerDTO;
	}

	public AddressDTO getAddressDTO()
	{
		return addressDTO;
	}

	public void setAddressDTO(final AddressDTO addressDTO)
	{
		this.addressDTO = addressDTO;
	}

	public List<CartEntryDTO> getCartEntries()
	{
		return cartEntries;
	}

	public void setCartEntries(final List<CartEntryDTO> cartEntries)
	{
		this.cartEntries = cartEntries;
	}
}
