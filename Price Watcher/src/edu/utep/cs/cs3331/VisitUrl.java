// Timothy P. McCrary

package edu.utep.cs.cs3331;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.InputMismatchException;

@SuppressWarnings("serial")
public class VisitUrl extends Main
{
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
	
	
}
