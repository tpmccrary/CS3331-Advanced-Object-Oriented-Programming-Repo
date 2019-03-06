// Timothy P. McCrary

package edu.utep.cs.cs3331;

import java.text.DecimalFormat;
import java.util.Calendar;

public class Item 
{
	private String itemName;
	private String url;
	private double currentPrice;
	private double originalPrice;
	private String dateAdded;
	
	public Item(String itemName, String url, double currentPrice)
	{
		this.itemName = itemName;
		this.url = url;
		this.currentPrice = currentPrice;
		this.originalPrice = currentPrice;
		this.dateAdded = generateDateAdded();
	}
	
	public String generateDateAdded()
	{
		DecimalFormat numFormat = new DecimalFormat("#,###,###,##0.00");
		
		String day = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		String month = String.valueOf((Calendar.getInstance().get(Calendar.MONTH) + 1));
		String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		
		String dateAddedAndPrice = month + "/" + day + "/" + year + "  ($" + numFormat.format(currentPrice) + ")";
		
		return dateAddedAndPrice;
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
	
	
}
