import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Item
{
	private int id;
	private String name;	
	private int price;		// in cents
	private String label; 	// shortened name to be displayed on UI buttons. may often be null
	private List<Category> categoriesThisItemBelongsTo; 
	
	
	public Item(int id, String name, int price)
	{
		this.id = id;
		this.name = name;
		this.price = price;
		label = null;
		categoriesThisItemBelongsTo = null;
	}
	
	public Item(int id, String name, int price, String label, List<Category> categories)
	{
		this.id = id;
		this.name = name;
		this.price = price;
		this.label = label;
		categoriesThisItemBelongsTo = categories;
	}
	
	public int getID()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	
	public String toString()
	{
		return name + " " + price;
	}
	
	public void printItemInfo()
	{
		if (label != null)
			System.out.print(label);
		else
			System.out.print(name);
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
		
		double displayPrice = price / 100.0;
		
		System.out.println(" " + nf.format(displayPrice));
		System.out.println("\tCategories: ");
		
		for (Category c : categoriesThisItemBelongsTo)
		System.out.println("\t\t" + c);
		
		System.out.println();
	}
	
}
