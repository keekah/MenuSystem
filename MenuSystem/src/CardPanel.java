import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

// CardPanel holds a different card for every category in the SideButtonPanel and updates the 
// frame's BorderLayout.center area.


public class CardPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private List<Item> items;
	private List<Category> categories;
	private List<Category> mainCategories;
	
	
	public CardPanel(Home frame)
	{
		setLayout(new CardLayout());
		
		queryDB();
		
		mainCategories = new ArrayList<Category>();
		
		// Add all the button panels to the card layout. Welcome is the first card and therefore will be displayed initially.
		ButtonPanel welcome = new ButtonPanel("Jake's American Bar", null, this);
		add(welcome);
		
		for (Category c : categories)
		{
			if (c.isMain())
			{
				mainCategories.add(c);
				System.out.println("Main category: " + c.getName());
				List<String> items = new ArrayList<String>();
				
				for (Item i : c.getItemsInThisCategory())
				{
					System.out.println("Adding " + i.getName());
					items.add(i.getName());
				}
				
				ButtonPanel panel = new ButtonPanel(c.getName(), items, this);
				
				// Category name will be the identifier.
				add(panel, c.getName());
			}
		}
	}
	
	
	private void queryDB()
	{
		DatabaseTest dbTest = new DatabaseTest();
		Connection conn = null;
		try
		{
			conn = dbTest.getConnection();
			items = dbTest.getAllItems(conn);
			categories = dbTest.getAllCategories(conn);
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			Utilities.close(conn);
		}
	}
	
	public List<Category> getMainCategories()
	{
		return mainCategories;
	}
	
}
