package edu.utep.cs.cs3331;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

/**
* Class that creates tool bar for application.
*
* @author Timothy P. McCrary
*/
public class ToolBar
{
	/** Access point the main class.*/
	private Main main;
	
	/** Constructor for object.
	 * 
	 * @param main Main class of program.
	 * */
	public ToolBar(Main main)
	{
		this.main = main;
	}
	
	/** Returns constructed tool bar.
	 * 
	 * @return A tool bar.
	 * */
	public JToolBar createToolBar()
	{
		JToolBar toolBar = new JToolBar();
		
		JButton addButton = createAddButton();
		JButton updateButton = createUpdateButton();
		JButton removeButton = createRemoveButton();
		JButton editButton = createEditButton();
		
		toolBar.add(updateButton);
		toolBar.add(addButton);
		
		toolBar.addSeparator();
		
		toolBar.add(removeButton);
		toolBar.add(editButton);
		toolBar.add(createVisitUrlButton());
		
		return toolBar;
	}
	
	/** Returns a button to visit web store.
	 * 
	 * @return Visit URL button.
	 * */
	private JButton createVisitUrlButton()
	{
		JButton visitUrlButton = new JButton();
		visitUrlButton.setIcon(ScaleImage.getWebLinkIcon());
		
		visitUrlButton.setToolTipText("Visit webpage of item.");
		
		visitUrlButton.addActionListener(new ActionListener() 
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
		
		return visitUrlButton;
	}
	
	/** Returns button to add an item.
	 * 
	 * @return Add item button.
	 * */
	private JButton createAddButton()
	{
		JButton addButton = new JButton();
		addButton.setIcon(ScaleImage.getPlusIcon());
		
		addButton.setToolTipText("Add and item to the list.");
		
		addButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				main.getItemDialogs().addItemDialog();
				
			}
		});
		
		return addButton;
	}
	
	/** Returns button to update item prices.
	 * 
	 * @return Update item prices button.
	 * */
	private JButton createUpdateButton()
	{
		JButton updateButton = new JButton();
		updateButton.setIcon(ScaleImage.getUpdateIcon());
		
		updateButton.setToolTipText("Update prices for all items.");
		
		updateButton.addActionListener(new ActionListener() 
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
		
		return updateButton;
	}
	
	/** Returns button to remove an item.
	 * 
	 * @return Remove item button.
	 * */
	private JButton createRemoveButton()
	{
		JButton removeButton = new JButton();
		removeButton.setIcon(ScaleImage.getRemoveIcon());
		
		removeButton.setToolTipText("Remove selected item from list.");
		
		removeButton.addActionListener(new ActionListener() 
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
		
		return removeButton;
	}
	
	/** Returns button to edit an item.
	 * 
	 * @return Edit item button.
	 * */
	private JButton createEditButton()
	{
		JButton editButton = new JButton();
		editButton.setIcon(ScaleImage.getEditIcon());
		
		editButton.setToolTipText("Edit selected item.");
		
		editButton.addActionListener(new ActionListener() 
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
		
		return editButton;
	}
}
