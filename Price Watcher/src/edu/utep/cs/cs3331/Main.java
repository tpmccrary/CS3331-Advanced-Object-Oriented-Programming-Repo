package edu.utep.cs.cs3331;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.InputMismatchException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Calendar;

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
					// TODO Auto-generated catch block
					//e.printStackTrace();
					ui.notValidUrl();
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
				ui.notValidInputMessage(userChoice);
			}
			
		}
		
		/*
		 * Repeat until user ask for quit
		 * print the item
		 * prompt the user
		 * process
		 */
//		int request = -1;
//		do
//		{
//			ui.showItem();
//			request = ui.promptUser();
//			
//			switch(request)
//			{
//			case 1:
//				break;
//			case 2:
//				break;
//			}
//		}
//		while(request != -1);
		
		
		
	}

	public Item generateItem(Item item, ConsoleUi ui, PriceFinder priceFinder)
	{
		DecimalFormat numFormat = new DecimalFormat("#,###,###,##0.00");
		
		String itemUrl;
		String itemName;
		double itemPrice;
		itemUrl = ui.promptUserForUrl();
		itemName = ui.promptUserItemName();
		itemPrice = priceFinder.getPrice();
		
		String day = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		String month = String.valueOf(Calendar.getInstance().get(Calendar.MONTH));
		String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		
		item.setItemName(itemName);
		item.setUrl(itemUrl);
		item.setCurrentPrice(itemPrice);
		item.setOldPrice(itemPrice);
		item.setDateAdded(month + "/" + day + "/" + year + "  ($" + numFormat.format(itemPrice) + ")");
		
		return item;
	}
	
	public static void main(String[] args)
	{
		new Main().run();
	}
}
