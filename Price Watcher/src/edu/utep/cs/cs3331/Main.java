package edu.utep.cs.cs3331;

public class Main 
{
	public void run()
	{
		Item item = new Item();
		ConsoleUi ui = new ConsoleUi();
		ui.welcomeMessage();
		
		/*
		 * Repeat until user ask for quit
		 * print the item
		 * prompt the user
		 * process
		 */
		int request = -1;
		do
		{
			ui.showItem();
			request = ui.promptUser();
			
			switch(request)
			{
			case 1:
				break;
			case 2:
				break;
			}
		}
		while(request != -1);
	}
	
	public static void main(String[] args)
	{
		new Main().run();
	}
}
