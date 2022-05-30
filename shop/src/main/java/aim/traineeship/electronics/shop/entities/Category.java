package aim.traineeship.electronics.shop.entities;

public class Category extends Entity
{
	private String code;
	private String name;
	private Integer products;

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

	public Integer getProducts()
	{
		return products;
	}

	public void setProducts(final Integer products)
	{
		this.products = products;
	}
}
