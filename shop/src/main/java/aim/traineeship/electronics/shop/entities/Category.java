package aim.traineeship.electronics.shop.entities;

public class Category extends Entity
{
	private String code;
	private String name;
	private Integer productsAmount;

	public Category()
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
