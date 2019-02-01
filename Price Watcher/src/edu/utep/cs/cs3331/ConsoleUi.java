package edu.utep.cs.cs3331;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUi 
{

	public void welcomeMessage() 
	{
		// TODO Auto-generated method stub
		System.out.println("Welcome to Price Watcher!");
		
	}

	public void showItemDetails(Item item) 
	{
		// TODO Auto-generated method stub
		DecimalFormat numFormat = new DecimalFormat("#,###,###,##0.00");
		
		System.out.println("______________________________\n" +
				"Name: " + item.getItemName() + "\n" +
				"URL: " + item.getUrl() + "\n" +
				"Price: $" + numFormat.format(item.getCurrentPrice()) + "\n" +
				"Change: " + numFormat.format(item.getPriceChange()) + "%\n" +
				"Date Added: " + item.getDateAdded() + "\n" +
				"______________________________\n");
	}

	public int promptUserChoice() 
	{
		// TODO Auto-generated method stub
		System.out.println("Please enter \"1\" to update price,\"2\" to visit webpage, and \"0\" to exit: ");
		Scanner userInput = new Scanner(System.in);
		
		int choice;
		
		try
		{
			choice = userInput.nextInt();
		}
		catch(InputMismatchException e)
		{
			System.out.println("INVALID INPUT: Must be number 1, 2, or 0.");
			choice = promptUserChoice();
		}
		
		return choice;
	}
	
	public String promptUserForUrl()
	{
		System.out.println("Please enter URL of the item: ");
		Scanner userInput = new Scanner(System.in);
		
		String url = userInput.nextLine();
		
		
		return url;
	}

	public String promptUserItemName() 
	{
		// TODO Auto-generated method stub
		System.out.println("Please enter your item name: ");
		Scanner userInput = new Scanner(System.in);
		
		String name = userInput.nextLine();
		
		return name;
	}

	public void exitMessage()
	{
		// TODO Auto-generated method stub
		System.out.println("Thank you and have a nice day!");
	}

	public void notValidInputMessage(int userChoice)
	{
		// TODO Auto-generated method stub
		System.out.println("NOT A VALID INPUT: " + userChoice);
	}
	
	public void notValidUrl()
	{
		System.out.println("Not a valid URL.");
	}
	
}
