package edu.utep.cs.cs3331;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
* Class that creates popup menu for application.
*
* @author Timothy P. McCrary
*/
public class PopUpMenu
{
	/** The access point to the main class.*/
	private Main main;
	
	/** Constructor for object.
	 * 
	 * @param main The main class of the program.
	 * */
	public PopUpMenu(Main main)
	{
		this.main = main;
	}
	
	/** Returns the popup menu.
	 * 
	 * @return Popup menu.*/
	public JPopupMenu createPopupMenu()
	{
		JPopupMenu popupMenu = new JPopupMenu();
		
		JMenuItem updateItem = main.getMyMenuBar().createMenuItemSingleUpdate();
		JMenuItem removeItem = main.getMyMenuBar().createMenuItemRemove();
		JMenuItem editItem = main.getMyMenuBar().createMenuItemEdit();
		JMenuItem visitItemLink = main.getMyMenuBar().createMenuItemWebLink();
		
		popupMenu.add(updateItem);
		popupMenu.add(removeItem);
		popupMenu.add(editItem);
		popupMenu.add(visitItemLink);
		
		
		return popupMenu;
		
		
	}
}
