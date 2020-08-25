import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

// CardPanel holds a different card for every category in the SideButtonPanel and updates the 
// frame's BorderLayout.center area. For now things are hard-coded but will eventually be read in 
// from a database.


public class CardPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	// categories
	private List<String> kidsList;
	private List<String> appsList;
	private List<String> mainsList;
	private List<String> sidesList;
	private List<String> dessertsList;
	private List<String> beveragesList;
	private List<String> barList;
	
	// items
	
	
	// modifiers
	private List<String> sodasList;
	private List<String> juicesList;
	private List<String> milksList;
	
	
	public CardPanel(Home frame)
	{
		setLayout(new CardLayout());
		
		populateLists();
		
		ButtonPanel welcome = new ButtonPanel("Jake's American Bar", null, this);
		ButtonPanel kids = new ButtonPanel("Kids", kidsList, this);
		ButtonPanel apps = new ButtonPanel("App/Soup/Salad", appsList, this);
		ButtonPanel mains = new ButtonPanel("Main Dishes", mainsList, this);
		ButtonPanel sides = new ButtonPanel("Sides", sidesList, this);
		ButtonPanel desserts = new ButtonPanel("Desserts", dessertsList, this);
		ButtonPanel beverages = new ButtonPanel("Beverages", beveragesList, this);
		ButtonPanel bar = new ButtonPanel("Bar", barList, this);
		
		ButtonPanel soda = new ModifiersPanel("Soda", sodasList, this);
		ButtonPanel juice = new ModifiersPanel("Juice", juicesList, this);
		ButtonPanel milk = new ModifiersPanel("Milk", milksList, this);
		
		// Add the cards to the card panel and supply an identifier for the card
		add(welcome);
		add(kids, "Kids");
		add(apps, "App/Soup/Salad");
		add(mains, "Main Dishes");
		add(sides, "Sides");
		add(desserts, "Desserts");
		add(beverages, "Beverages");
		add(bar, "Bar");
		
		add(soda, "Soda");
		add(juice, "Juice");
		add(milk, "Milk");
	}
	
	private void populateLists()
	{
		kidsList = new ArrayList<String>();
		kidsList.add("K Burger");
		kidsList.add("K Grilled Cheese");
		kidsList.add("K Hot Dog");
		kidsList.add("K Mac");
		kidsList.add("K Pizza");
		kidsList.add("K Quesadilla");
		kidsList.add("K Spaghetti");
		
		appsList = new ArrayList<String>();
		appsList.add("Calamari");
		appsList.add("Charcuterie");
		appsList.add("Cheese Board");
		appsList.add("Fly Boy Fries");
		appsList.add("Hot Wings");
		appsList.add("Hummus Platter");
		appsList.add("Pretzel Rods");
		
		mainsList = new ArrayList<String>();
		mainsList.add("Filet Mignon");
		mainsList.add("Fish & Chips");
		mainsList.add("Half Chicken");
		mainsList.add("Jake's Ribeye");
		mainsList.add("Seared Cobia");
		mainsList.add("Short Rib");
		mainsList.add("Vegan Lasagna");
		
		sidesList = new ArrayList<String>();
		sidesList.add("French Fries");
		sidesList.add("Sweet Fries");
		sidesList.add("Onion Rings");
		sidesList.add("Apple Wedges");
		sidesList.add("Broccoli");
		sidesList.add("Carrots & Celery");
		sidesList.add("Fruit");
		sidesList.add("Side House Salad");
		sidesList.add("Side Caesar Salad");
		sidesList.add("Asparagus");
		sidesList.add("Brussels Sprouts");
		sidesList.add("Mashed Potatoes");
		sidesList.add("Roasted Potatoes");
		sidesList.add("Truffle Fries");

		dessertsList = new ArrayList<String>();
		dessertsList.add("Churro Pudding");
		dessertsList.add("Ice Cream");
		dessertsList.add("Nutella Cupcake");
		dessertsList.add("Oreo Jar");
		
		beveragesList = new ArrayList<String>();
		beveragesList.add("Ice Water");
		beveragesList.add("Soda");
		beveragesList.add("Juice");
		beveragesList.add("Milk");
		beveragesList.add("Iced Tea");
		beveragesList.add("Sweet Tea");
		beveragesList.add("Hot Tea");
		beveragesList.add("Coffee");
		beveragesList.add("Latte");
		
		sodasList = new ArrayList<String>();
		sodasList.add("Coke");
		sodasList.add("Diet Coke");
		sodasList.add("Sprite");
		sodasList.add("Lemonade");
		sodasList.add("Fanta Orange");
		sodasList.add("Root Beer");
		sodasList.add("Soda Water");
		sodasList.add("Tonic Water");
		sodasList.add("Ginger Ale");
		
		juicesList = new ArrayList<String>();
		juicesList.add("Apple Juice");
		juicesList.add("Cranberry Juice");
		juicesList.add("Guava Juice");
		juicesList.add("Mango Juice");
		juicesList.add("Orange Juice");
		juicesList.add("Pineapple Juice");
		juicesList.add("Tomato Juice");
		
		milksList = new ArrayList<String>();
		milksList.add("Skim Milk");
		milksList.add("2% Milk");
		milksList.add("Whole Milk");
		milksList.add("Chocolate Milk");
		milksList.add("Almond Milk");
		milksList.add("Soy Milk");
		
	}
}
