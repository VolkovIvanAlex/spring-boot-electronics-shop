package aim.traineeship.electronics.shop.entities;

public class Product extends Entity
{
	private String code;
	private String name;
	private Double price;
	private String description;
	private Category category;

	public Product(final String code, final String name, final Double price, final String description,
			final Category category)
	{
		this.code = code;
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
	}

	public Integer getId()
	{
		return super.getId();
	}
	public void setId(final Integer id)
	{
		super.setId(id);
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

	public Double getPrice()
	{
		return price;
	}

	public void setPrice(final Double price)
	{
		this.price = price;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	public Category getCategory()
	{
		return category;
	}

	public void setCategory(final Category category)
	{
		this.category = category;
	}
}
