// Timothy P. McCrary

package edu.utep.cs.cs3331;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.InputMismatchException;

public class VisitUrl
{
	public static void goToUrl(Item item)
	{
		try
		{
			java.awt.Desktop.getDesktop().browse(new URL(item.getUrl()).toURI());
		} 
		catch (IOException | URISyntaxException | InputMismatchException e)
		{
			//e.printStackTrace();
//			ui.notValidUrlMessage();
//			item.setUrl(ui.promptUserForUrl());
			System.out.println("Not a valid URL.");
			
		}
	}
	
	
}
