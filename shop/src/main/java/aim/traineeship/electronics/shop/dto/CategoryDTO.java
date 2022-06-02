package aim.traineeship.electronics.shop.dto;

public class CategoryDTO
{
	private Integer id;
	private String code;
	private String name;
	private Integer productsAmount;

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

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public Integer getProductsAmount()
	{
		return productsAmount;
	}

	public void setProductsAmount(final Integer productsAmount)
	{
		this.productsAmount = productsAmount;
	}
}
