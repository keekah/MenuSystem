import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class DatabaseTest
{	
	public Connection getConnection() throws SQLException
	{
		Properties connectionProperties = new Properties();
		connectionProperties.put("user", "postgres");
		connectionProperties.put("password", "docker");
		
		String url = "jdbc:postgresql://localhost:5432/jakes";
		
		return DriverManager.getConnection(url, connectionProperties);
	}
	
	public void createTable(Connection conn) throws SQLException
	{
		String createString = "create schema if not exists jakes;" +
								"drop table if exists items;" +
								"create table if not exists items (id serial primary key, " +
								"name varchar(75) not null, " +
								"price integer not null constraint not_negative check (price >= 0), " +
								"label varchar(30)" +
								");";
		Statement stmt = conn.createStatement();
		try
		{
			stmt.executeUpdate(createString);
		}
		finally 
		{
			Utilities.close(stmt);
		}
	}
	
	// Return a list of all the items that are available.
	public List<Item> getAllItems(Connection conn)
	{
		List<Item> items = new ArrayList<Item>();
		
		String query = "SELECT item_id, item_name, item_price, item_label " +
						"FROM items " +
						"WHERE is_item_available = true;";
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next())
			{
				int id = rs.getInt("item_id");
				String name = rs.getString("item_name");
				int priceCents = rs.getInt("item_price");
				String label = rs.getString("item_label");
				
				List<Category> categories = getItemCategories(conn, id);
				
				items.add(new Item(id, name, priceCents, label, categories));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			Utilities.close(stmt);
			Utilities.close(rs);
		}
		
		return items;
	}
	
	// Return a list of the categories to which the given item belongs.
	public List<Category> getItemCategories(Connection conn, int itemID)
	{
		List<Category> categories = new ArrayList<Category>();
		
		String query = "SELECT categories.category_name, categories.is_main_category " +
						"FROM categories, items_categories " +
						"WHERE items_categories.item_id = ? " +
							"AND items_categories.category_id = categories.category_id;";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try
		{
			stmt = conn.prepareStatement(query);
			stmt.setInt(1,  itemID);
			
			rs = stmt.executeQuery();
			
			while (rs.next())
			{
				String name = rs.getString("category_name");
				boolean isMain = rs.getBoolean("is_main_category");
				
				categories.add(new Category(name, isMain));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			Utilities.close(stmt);
			Utilities.close(rs);
		}
		
		return categories;
	}
	
	
	// Return all the categories in the database.
	public List<Category> getAllCategories(Connection conn)
	{
		List<Category> categories = new ArrayList<Category>();
		
		String query = "SELECT category_id, category_name, is_main_category " +
						"FROM categories ";
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next())
			{
				int id = rs.getInt("category_id");
				String name = rs.getString("category_name");
				boolean isMain = rs.getBoolean("is_main_category");
				
				List<Item> items = getCategoryItems(conn, id);
				
				categories.add(new Category(name, isMain, items));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			Utilities.close(stmt);
			Utilities.close(rs);
		}
		
		
		return categories;
	}
	
	
	// Return a list of all available items belonging to the given category.
	public List<Item> getCategoryItems(Connection conn, int categoryID)
	{
		List<Item> items = new ArrayList<Item>();
		
		String query = "SELECT items.item_id, items.item_name, items.item_price " +
						"FROM items, items_categories " +
						"WHERE items_categories.category_id = ? " +
							"AND items_categories.item_id = items.item_id " + 
							"AND items.is_item_available = TRUE;";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try
		{
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, categoryID);
			
			rs = stmt.executeQuery();
			
			while (rs.next())
			{
				int id = rs.getInt("item_id");
				String name = rs.getString("item_name");
				int price = rs.getInt("item_price");
				
				items.add(new Item(id, name, price));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			Utilities.close(stmt);
			Utilities.close(rs);
		}
		
		return items;
	}
	
//	public static void main(String [] args)
//	{
//		DatabaseTest dbTest = new DatabaseTest();
//		Connection conn = null;
//		try
//		{
//			conn = dbTest.getConnection();
//			dbTest.getAllItems(conn);
//		} catch (SQLException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
