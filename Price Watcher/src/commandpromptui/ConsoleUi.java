// Timothy P. McCrary

package commandpromptui;

import java.text.DecimalFormat;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.utep.cs.cs3331.Item;

public class ConsoleUi 
{

	public void welcomeMessage() 
	{
		System.out.println("Welcome to Price Watcher!");
		
	}

	public void showItemDetails(Item item) 
	{
		DecimalFormat numFormat = new DecimalFormat("#,###,###,##0.00");
		
		System.out.println("________________________________________\n" +
				"Name: " + item.getItemName() + "\n" +
				"URL: " + item.getUrl() + "\n" +
				"Price: $" + numFormat.format(item.getCurrentPrice()) + "\n" +
				"Change: " + numFormat.format(item.getPriceChange()) + "%\n" +
				"Date Added: " + item.getDateAdded() + "\n" +
				"________________________________________\n");
	}

	public int promptUserChoice() 
	{
		System.out.println("Please enter \"1\" to update price,\"2\" to visit webpage, and \"0\" to exit: ");
		Scanner userInput = new Scanner(System.in);
		
		int choice;
		
		try
		{
			choice = userInput.nextInt();
		}
		catch(NoSuchElementException e )
		{
			//System.out.println("INVALID INPUT: Must be number 1, 2, or 0.");
			//choice = promptUserChoice();
			return -1;
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
		System.out.println("Please enter your item name: ");
		Scanner userInput = new Scanner(System.in);
		
		String name = userInput.nextLine();
		
		return name;
	}

	public void exitMessage()
	{
		System.out.println("Thank you and have a nice day!");
	}

	public void notValidInputMessage()
	{
		System.out.println("INVALID INPUT: Must be number 1, 2, or 0.");
	}
	
	public void notValidUrlMessage()
	{
		System.out.println("Not a valid URL.");
	}
	
}
