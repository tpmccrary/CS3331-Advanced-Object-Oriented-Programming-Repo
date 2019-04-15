package edu.utep.cs.cs3331;

import java.awt.Image;
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
	
	
	
	
	ImageIcon updateIcon = new ImageIcon("src/image/update icon.png");
	ImageIcon plusIcon = new ImageIcon("src/image/Blue Plus icon.png");
	ImageIcon removeIcon = new ImageIcon("src/image/remove icon.png");
	
	public MenuBar(Main main)
	{
		this.main = main;
		
		Image img = updateIcon.getImage();
		Image newImg = img.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
		updateIcon = new ImageIcon(newImg);
		
		img = plusIcon.getImage();
		newImg = img.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
		plusIcon = new ImageIcon(newImg);
		
		img = removeIcon.getImage();
		newImg = img.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
		removeIcon = new ImageIcon(newImg);
		
	}
	

	public JMenuBar createMenuBar()
	{
		
		
		JMenuBar menuBar;
		
		JMenu menu;
		JMenu subMenu;
		JMenuItem menuItem;
		JMenuItem menuUpdate;
		JMenuItem menuAdd;
		JMenuItem menuRemove;
		
		menuBar = new JMenuBar();
		
		menu = new JMenu("Items");
		menu.setMnemonic(KeyEvent.VK_I);
		//menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		menuBar.add(menu);
		
		//a group of JMenuItems
		
		menuUpdate = createMenuItemUpdate();
		menu.add(menuUpdate);
		
		
		menuAdd = createMenuItemAdd();
		menu.add(menuAdd);
		
		menuRemove = createMenuItemRemove();
		menu.add(menuRemove);

		
		menu.addSeparator();
		subMenu = new JMenu("A submenu");
		subMenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("An item in the submenu");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_2, ActionEvent.ALT_MASK));
		subMenu.add(menuItem);

		menuItem = new JMenuItem("Another item");
		subMenu.add(menuItem);
		menu.add(subMenu);
		
		return menuBar;
		
	
	}
	
	private JMenuItem createMenuItemUpdate()
	{
		JMenuItem menuUpdate;
		menuUpdate = new JMenuItem("Update Prices", updateIcon);
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
	
	
	
	
}
