package edu.utep.cs.cs3331;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
* Class that creates menu bar for application.
*
* @author Timothy P. McCrary
*/
public class MenuBar
{
	private Main main;
	
	
	public MenuBar(Main main)
	{
		this.main = main;
	}
	
	/** Creates menu bar. */
	public JMenuBar createMenuBar()
	{
		JMenuBar menuBar;
		
		JMenu menu;
		JMenu subMenu;
		//JMenuItem menuItem;
		JMenuItem menuUpdate;
		JMenuItem menuAdd;
		JMenuItem menuRemove;
		JMenuItem menuEdit;
		JMenuItem menuWebLink;
		
		// Creates main menu bar.
		menuBar = new JMenuBar();
		
		//Creates Items menu in the menu bar.
		menu = new JMenu("Items");
		menu.setMnemonic(KeyEvent.VK_I);
		menuBar.add(menu);
		
		//Creates update and add to Items menu.
		menuUpdate = createMenuItemUpdate();
		menu.add(menuUpdate);
		
		menuAdd = createMenuItemAdd();
		menu.add(menuAdd);
		
		
		menu.addSeparator();
		
		subMenu = new JMenu("Selected");
		subMenu.setMnemonic(KeyEvent.VK_S);

		menuRemove = createMenuItemRemove();
		subMenu.add(menuRemove);
		
		menuEdit = createMenuItemEdit();
		subMenu.add(menuEdit);
		
		menuWebLink = createMenuItemWebLink();
		subMenu.add(menuWebLink);
		
		menu.add(subMenu);
		
		return menuBar;	
	
	}
	
	public JMenuItem createMenuItemWebLink()
	{
		JMenuItem menuWebLink;
		menuWebLink = new JMenuItem("Visit website", ScaleImage.getWebLinkIcon());
		menuWebLink.setMnemonic(KeyEvent.VK_V);
		menuWebLink.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.ALT_MASK));
		menuWebLink.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				
				
				int selectedItem = main.getItemManager().findSelectedItem();
				if(selectedItem != -1)
				{
					if(VisitUrl.goToUrl(main.getItemManager().getItems()[selectedItem]) == true)
					{
						return;
					}
					else
					{
						main.showMessage("Not a valid URL (i.e \"https://www.bing.com/\").");
					}
				}
				else
				{
					main.showMessage("No item selected!");
					return;
				}
			}
		});
		
		return menuWebLink;
	}


	public JMenuItem createMenuItemUpdate()
	{
		JMenuItem menuUpdate;
		menuUpdate = new JMenuItem("Update prices", ScaleImage.getUpdateIcon());
		menuUpdate.setMnemonic(KeyEvent.VK_U);
		menuUpdate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuUpdate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				
				
				if(main.getItemManager().getNumItems() == 0)
				{
					main.showMessage("There are no items to update!");
				}
				else
				{
					main.showMessage("Prices updated!");
					main.getItemManager().updateItemPrices();
				}
			}
		});
		
		return menuUpdate;
	}

	
	
	public JMenuItem createMenuItemAdd()
	{
		JMenuItem menuAdd;
		
		menuAdd = new JMenuItem("Add item", ScaleImage.getPlusIcon());
		menuAdd.setMnemonic(KeyEvent.VK_A);
		menuAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		menuAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				main.getItemDialogs().addItemDialog();
				
			}
		});
		
		return menuAdd;
		
	}
	
	public JMenuItem createMenuItemRemove()
	{
		JMenuItem menuRemove;
		
		menuRemove = new JMenuItem("Remove item", ScaleImage.getRemoveIcon());
		menuRemove.setMnemonic(KeyEvent.VK_R);
		menuRemove.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
		menuRemove.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				int selectedItem = main.getItemManager().findSelectedItem();
				if(selectedItem != -1)
				{
					main.getItemDialogs().removeItemDialog(selectedItem);
					return;
				}
				else
				{
					main.showMessage("No item selected!");
					return;
				}
				
			}
		});
		
		return menuRemove;
		
	}
	
	
	public JMenuItem createMenuItemEdit()
	{
		JMenuItem menuEdit;
		
		menuEdit = new JMenuItem("Edit item", ScaleImage.getEditIcon());
		menuEdit.setMnemonic(KeyEvent.VK_E);
		menuEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
		menuEdit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				int selectedItem = main.getItemManager().findSelectedItem();
				if(selectedItem != -1)
				{
					main.getItemDialogs().editItemDialog(selectedItem);
					return;
				}
				else
				{
					main.showMessage("No item selected!");
					return;
				}
			}
		});
		
		return menuEdit;
	}
	
	public JMenuItem createMenuItemSingleUpdate()
	{
		JMenuItem menuUpdate;
		menuUpdate = new JMenuItem("Update price", ScaleImage.getUpdateIcon());
		menuUpdate.setMnemonic(KeyEvent.VK_U);
		menuUpdate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuUpdate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				
				
				if(main.getItemManager().getNumItems() == 0)
				{
					main.showMessage("There are no item selected to update!");
				}
				else
				{
					main.showMessage("Prices updated!");
					main.getItemManager().updateSingleItemPrice();
				}
			}
		});
		
		return menuUpdate;
	}
	
	
	
}
