package edu.utep.cs.cs3331;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBar
{
	private Main main;
	
	public ToolBar(Main main)
	{
		this.main = main;
	}
	
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
