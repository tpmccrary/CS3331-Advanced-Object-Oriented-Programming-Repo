package edu.utep.cs.cs3331;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopUpMenu
{
	private Main main;
	
	public PopUpMenu(Main main)
	{
		this.main = main;
	}
	
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
