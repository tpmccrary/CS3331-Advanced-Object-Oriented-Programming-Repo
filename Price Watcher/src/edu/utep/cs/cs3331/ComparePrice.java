// Timothy P. McCrary

package edu.utep.cs.cs3331;

public class ComparePrice
{
	public static double getPriceChange(double currentPrice, double originalPrice)
	{
		double change = (originalPrice - currentPrice) / originalPrice;
		
		change = change * 100;
		
		return change;
	}
	
	
}
