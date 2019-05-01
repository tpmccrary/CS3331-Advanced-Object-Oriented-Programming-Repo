package edu.utep.cs.cs3331;

/**
* Class that updates price of items.
*
* @author Timothy P. McCrary
*/
public class PriceFinder
{
	/** Returns price of an item.
	 * 
	 * @return Item price.*/
	public static double getPrice()
	{
		double price = Math.random() * 99 + 1;
		return price;
	}

}
