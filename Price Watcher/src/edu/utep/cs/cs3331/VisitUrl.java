package edu.utep.cs.cs3331;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.InputMismatchException;

/**
* Class to visit URL.
*
* @author Timothy P. McCrary
*/
@SuppressWarnings("serial")
public class VisitUrl extends Main
{
	/** Returns true if URl is valid.
	 * 
	 * @param item The item which we want to visit its web store.
	 * @return True if item URL is valid, otherwise false.
	 * */
	public static boolean goToUrl(Item item)
	{
		try
		{
			java.awt.Desktop.getDesktop().browse(new URL(item.getUrl()).toURI());
		} 
		catch (IOException | URISyntaxException | InputMismatchException e)
		{
			//System.out.println("Not a valid URL.");
			return false;
			
		}
		
		return true;
	}
	
	public static boolean validateURL(String url)
	{
		try
		{
			new URL(url).toURI();
		} 
		catch (IOException | URISyntaxException | InputMismatchException e)
		{
			//System.out.println("Not a valid URL.");
			return false;
			
		}
		
		return true;
	}
	
	
}
