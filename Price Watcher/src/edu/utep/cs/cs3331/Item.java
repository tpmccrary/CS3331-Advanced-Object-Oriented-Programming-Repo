// Timothy P. McCrary


package edu.utep.cs.cs3331;

import java.text.DecimalFormat;
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
	
	public void generateDateAdded()
	{
		DecimalFormat numFormat = new DecimalFormat("#,###,###,##0.00");
		
		String day = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		String month = String.valueOf((Calendar.getInstance().get(Calendar.MONTH) + 1));
		String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		
		dateAdded = month + "/" + day + "/" + year + "  ($" + numFormat.format(currentPrice) + ")";
	}
	
	public double getPriceChange()
	{
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
