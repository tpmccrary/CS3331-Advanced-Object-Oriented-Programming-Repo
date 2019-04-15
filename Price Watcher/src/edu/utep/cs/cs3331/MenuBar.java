package edu.utep.cs.cs3331;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar
{
	private Main main;
	
	
	ImageIcon updateIcon;
	ImageIcon plusIcon;
	ImageIcon removeIcon;
	ImageIcon editIcon;
	
	public MenuBar(Main main)
	{
		this.main = main;
		
		updateIcon = ScaleImage.getUpdateIcon();
		plusIcon = ScaleImage.getPlusIcon();
		removeIcon = ScaleImage.getRemoveIcon();
		editIcon = ScaleImage.getEditIcon();
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
		
		// Creates main menu bar.
		menuBar = new JMenuBar();
		
		//Creates Items menu in the menu bar.
		menu = new JMenu("Items");
		menu.setMnemonic(KeyEvent.VK_I);
		menuBar.add(menu);
		
		//Creates update and add to Items menu.
		menuUpdate = createMenuItemUpdate();
		menu.add(menuUpdate);
		updateIcon = null;
		menuAdd = createMenuItemAdd();
		menu.add(menuAdd);
		plusIcon = null;
		
		menu.addSeparator();
		
		subMenu = new JMenu("Selected");
		subMenu.setMnemonic(KeyEvent.VK_S);

		menuRemove = createMenuItemRemove();
		subMenu.add(menuRemove);
		removeIcon = null;
		
		menuEdit = createMenuItemEdit();
		subMenu.add(menuEdit);
		editIcon = null;
		
		menu.add(subMenu);
		
		return menuBar;	
	
	}
	
	


	private JMenuItem createMenuItemUpdate()
	{
		JMenuItem menuUpdate;
		menuUpdate = new JMenuItem("Update prices", updateIcon);
		menuUpdate.setMnemonic(KeyEvent.VK_U);
		menuUpdate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuUpdate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				
				main.getItemManager().updateItemPrices();
				if(main.getItemManager().getNumItems() == 0)
				{
					main.showMessage("There are no items to update!");
				}
				else
				{
					main.showMessage("Prices updated!");
				}
			}
		});
		
		return menuUpdate;
	}

	
	
	private JMenuItem createMenuItemAdd()
	{
		JMenuItem menuAdd;
		
		menuAdd = new JMenuItem("Add item", plusIcon);
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
	
	private JMenuItem createMenuItemRemove()
	{
		JMenuItem menuRemove;
		
		menuRemove = new JMenuItem("Remove item", removeIcon);
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
	
	
	private JMenuItem createMenuItemEdit()
	{
		JMenuItem menuEdit;
		
		menuEdit = new JMenuItem("Edit item", editIcon);
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
	
	
	
}
