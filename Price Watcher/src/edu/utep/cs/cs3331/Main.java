// Timothy P. McCrary

package edu.utep.cs.cs3331;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.InputMismatchException;
import java.net.URL;


public class Main 
{
	public void run()
	{
		Item item = new Item();
		ConsoleUi ui = new ConsoleUi();
		PriceFinder priceFinder = new PriceFinder();
		
		int userChoice = -1;
		
		ui.welcomeMessage();
		item = generateItem(item, ui, priceFinder);
		
		while(userChoice != 0)
		{
			ui.showItemDetails(item);
			userChoice = ui.promptUserChoice();
			
			if(userChoice == 1)
			{
				item.setCurrentPrice(priceFinder.getPrice());
			}
			else if(userChoice == 2)
			{
				try
				{
					java.awt.Desktop.getDesktop().browse(new URL(item.getUrl()).toURI());
				} 
				catch (IOException | URISyntaxException | InputMismatchException e)
				{
					//e.printStackTrace();
					ui.notValidUrlMessage();
					item.setUrl(ui.promptUserForUrl());
					
				}
			}
			else if(userChoice == 0)
			{
				ui.exitMessage();
				System.exit(0);
			}
			else
			{
				ui.notValidInputMessage();
			}
			
		}
		
		/*
		 * Repeat until user ask for quit
		 * print the item
		 * prompt the user
		 * process
		 */
		
		
		
	}

	public Item generateItem(Item item, ConsoleUi ui, PriceFinder priceFinder)
	{		
		String itemUrl;
		String itemName;
		double itemPrice;
		itemUrl = ui.promptUserForUrl();
		itemName = ui.promptUserItemName();
		itemPrice = priceFinder.getPrice();

		item.setItemName(itemName);
		item.setUrl(itemUrl);
		item.setCurrentPrice(itemPrice);
		item.setOldPrice(itemPrice);
		item.generateDateAdded(); 
		
		return item;
	}
	
	public static void main(String[] args)
	{
		new Main().run();
	}
}
