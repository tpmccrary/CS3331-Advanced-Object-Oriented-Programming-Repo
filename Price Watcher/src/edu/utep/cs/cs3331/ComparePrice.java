package edu.utep.cs.cs3331;

/**
* Class that check current and original price of an item.
*
* @author Timothy P. McCrary
*/
public class ComparePrice
{
	/** Returns percentage change between current and original price of an item.
	 * 
	 * @param currentPrice The current price of an item.
	 * @param originalPrice The original price of an item.
	 * @return The percentage change between the two prices.
	 * */
	public static double getPriceChange(double currentPrice, double originalPrice)
	{
		double change = (originalPrice - currentPrice) / originalPrice;
		
		change = change * 100;
		
		return change;
	}
	
	
}
