package edu.utep.cs.cs3331;

import java.io.IOException;

import edu.utep.cs.cs3331.jsontools.JsonManager;

/** Manages item objects
 * 
 * @author Timothy P. McCrary
 * */
public class ItemManager
{
	
	/** The JsonManager to be used to load items from file*/
	@SuppressWarnings("unused")
	private JsonManager jsonManager;
	/** The access point to the main class.*/
	private Main main;
	
	/** The array that hold and keep track of items the user wants to track.*/
	private Item[] items;
	/** The number of items on the list.*/
	private int numItems = 0;
	
	/** Constructor for object, creates item list array.
	 * @param main The main class in order to have access to other objects.
	 * */
	public ItemManager(Main main)
	{
		try {
			jsonManager = new JsonManager();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Item[] itemsOnFile = jsonManager.readItemsFromFile();
		this.main = main;
		items = new Item[10];
		
	}
	
	/** Adds an item to the Item array and to the JList.
	 * @param item The item that will be added.
	 * */
	public void addItem(Item item)
	{
		for(int i = 0; i < items.length; i++)
		{
			if(items[i] == null)
			{
				items[i] = item;
				numItems++;
				main.getItemList().addToList(item);
				//System.out.println(numItems);
				return;
			}
		}
		
		Item[] tempItems = items;
		items = new Item[items.length + 5];
		
		for(int i = 0; i < tempItems.length; i++)
		{
			items[i] = tempItems[i];
		}
		items[tempItems.length] = item;
		numItems++;
		main.getItemList().addToList(item);
		//System.out.println(numItems);
		tempItems = null;
		return;
	}
	
	public void addItemNoWrite(Item item)
	{
		for(int i = 0; i < items.length; i++)
		{
			if(items[i] == null)
			{
				items[i] = item;
				numItems++;
				main.getItemList().addToListNoWrite(item);
				//System.out.println(numItems);
				return;
			}
		}
		
		Item[] tempItems = items;
		items = new Item[items.length + 5];
		
		for(int i = 0; i < tempItems.length; i++)
		{
			items[i] = tempItems[i];
		}
		items[tempItems.length] = item;
		numItems++;
		main.getItemList().addToListNoWrite(item);
		//System.out.println(numItems);
		tempItems = null;
		return;
	}
	
	/** Removes an item from the Item array and JList.
	 * @param itemIndex The index of where the item is stored in the array.
	 * */
	public void removeItem(int itemIndex)
	{
		Item[] tempItems = new Item[items.length];
		int j = 0;
		for(int i = 0; i < items.length; i++)
		{
			
			if(i == itemIndex)
			{
				i++;
			}
			tempItems[j] = items[i];
			j++;
		}
		
		main.getItemList().removeFromList(itemIndex);
		numItems--;
		items = tempItems;
		//System.out.println(numItems);
		tempItems = null;
	}
	
	/** Returns the index of the item that is selected through the JList by the user.
	 * @return The items index.
	 * */
	public int findSelectedItem()
	{
		for(int i = 0; i < numItems; i++)
		{
			if(items[i].isSelected() == true)
			{
				return i;
			}
		}
		return -1;
	}
	
	/** Updates the prices of all the items being tracked.*/
	public void updateItemPrices()
	{
		for(int i = 0; i < numItems; i++)
		{
			items[i].setCurrentPrice(WebPriceFinder.findPrice(items[i].getUrl()));
		}
		main.repaint();
	}
	
	/** Updates the price of a single item selected by the user.*/
	public void updateSingleItemPrice()
	{
		for(int i = 0; i < numItems; i++)
		{
			if(items[i].isSelected() == true)
			{
				items[i].setCurrentPrice(WebPriceFinder.findPrice(items[i].getUrl()));
				main.repaint();
				return;
			}
		}
	}

	
	public Item[] getItems()
	{
		return items;
	}
	
	public int getNumItems()
	{
		return numItems;
	}
	
}
