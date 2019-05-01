package edu.utep.cs.cs3331;

import java.text.DecimalFormat;
import java.util.Calendar;

/** Class that stores item details.
 * 
 * @author Timothy P. McCrary
 * */
public class Item 
{
	/** The name of this item.*/
	private String itemName;
	/** The URL of this item.*/
	private String url;
	/** The current price of this item.*/
	private double currentPrice;
	/** The original price of this item.*/
	private double originalPrice;
	/** The date the item was added.*/
	private String dateAdded;
	
	/** The status of the selection of this item.*/
	private boolean isSelected = false;
	
	/** Creates item object given its name, URL, and price.)
	 * @param itemName The name the item will be given.
	 * @param url The URL the item will be given
	 * @param currentPrice The price the item will be given. 
	 * */
	public Item(String itemName, String url, double currentPrice)
	{
		this.itemName = itemName;
		this.url = url;
		this.currentPrice = currentPrice;
		this.originalPrice = currentPrice;
		this.dateAdded = generateDateAdded();
	}
	
	/** Creates item object without any item details.
	 * */
	public Item()
	{
		this("NAME", "URL", 0.0);
	}
	
	/** Returns date when the item object was created along with it original price.
	 * @return The date along with the original price.
	 * */
	public String generateDateAdded()
	{
		DecimalFormat numFormat = new DecimalFormat("#,###,###,##0.00");
		
		String day = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		String month = String.valueOf((Calendar.getInstance().get(Calendar.MONTH) + 1));
		String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		
		String dateAddedAndPrice = month + "/" + day + "/" + year + "  ($" + numFormat.format(currentPrice) + ")";
		
		return dateAddedAndPrice;
	}
	
	
	public boolean isSelected()
	{
		return isSelected;
	}

	public void setSelected(boolean isSelected)
	{
		this.isSelected = isSelected;
	}

	public String getItemName() 
	{
		return itemName;
	}

	public void setItemName(String itemName) 
	{
		this.itemName = itemName;
	}

	public String getUrl() 
	{
		return url;
	}

	public void setUrl(String url) 
	{
		this.url = url;
	}

	public double getCurrentPrice() 
	{
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) 
	{
		this.currentPrice = currentPrice;
	}

	public double getOriginalPrice() 
	{
		return originalPrice;
	}

	public void setOriginalPrice(double oldPrice) 
	{
		this.originalPrice = oldPrice;
	}

	public String getDateAdded()
	{
		return dateAdded;
	}

	public void setDateAdded(String dateAdded)
	{
		this.dateAdded = dateAdded;
	}
	
	@Override
	public String toString()
	{
		return itemName;
	}
	
}
