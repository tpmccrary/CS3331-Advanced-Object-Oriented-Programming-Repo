package edu.utep.cs.cs3331;
/** Manages item objects
 * 
 * @author Timothy P. McCrary
 * */
public class ItemManager
{
	private Main main;
	
	private Item[] items;
	private int numItems = 0;
	
	/** Creates item manager object, along with an item list.
	 * @param main The main class in order to have access to other objects.*/
	public ItemManager(Main main)
	{
		
		this.main = main;
		items = new Item[10];
	}
	
	
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
	
	
	public void updateItemPrices()
	{
		for(int i = 0; i < numItems; i++)
		{
			items[i].setCurrentPrice(PriceFinder.getPrice());
		}
		main.repaint();
	}
	
	
	public void updateSingleItemPrice()
	{
		for(int i = 0; i < numItems; i++)
		{
			if(items[i].isSelected() == true)
			{
				items[i].setCurrentPrice(PriceFinder.getPrice());
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
