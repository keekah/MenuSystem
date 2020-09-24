import java.util.List;

public class Category
{
	private String name;
	private boolean isMainCategory;
	private List<Item> itemsInThisCategory;
	
	public Category(String name, boolean mainCategory, List<Item> items)
	{
		this.name = name;
		isMainCategory = mainCategory;
		itemsInThisCategory = items;
	}
	
	public Category(String name, boolean mainCategory)
	{
		this.name = name;
		isMainCategory = mainCategory;
		itemsInThisCategory = null;
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean isMain()
	{
		return isMainCategory;
	}
	
	public List<Item> getItemsInThisCategory()
	{
		return itemsInThisCategory;
	}
	
	public String toString()
	{
		return name + (isMain() ? " (Main Category)" : "");
	}
	
	public void printCategoryInfo()
	{
		System.out.println(name + ":");
		
		for (Item i : getItemsInThisCategory())
			System.out.println("\t" + i.getName());
	}

}
