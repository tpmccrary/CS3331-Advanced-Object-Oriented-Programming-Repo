package edu.utep.cs.cs3331;

import java.util.Calendar;

public class Item 
{
	private String itemName;
	private String url;
	private double currentPrice;
	private double oldPrice;
	private String dateAdded;
	
	public Item()
	{
		
		
	}
	
	public double getPriceChange()
	{
//		if(oldPrice == currentPrice)
//		{
//			return 0.0;
//		}
//		else if(currentPrice == 0)
//		{
//			return 100;
//		}
		
		double change = (oldPrice - currentPrice) / oldPrice;
		
		change = change * 100;
		
		return change;
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

	public double getOldPrice() 
	{
		return oldPrice;
	}

	public void setOldPrice(double oldPrice) 
	{
		this.oldPrice = oldPrice;
	}

	public String getDateAdded()
	{
		return dateAdded;
	}

	public void setDateAdded(String dateAdded)
	{
		this.dateAdded = dateAdded;
	}
	
	
}
