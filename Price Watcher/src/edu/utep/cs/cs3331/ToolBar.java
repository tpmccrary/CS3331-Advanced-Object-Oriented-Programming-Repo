package edu.utep.cs.cs3331;



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
		
		return toolBar;
	}
	
	private JButton createAddButton()
	{
		JButton addButton = new JButton();
		addButton.setIcon(ScaleImage.getPlusIcon());
		
		addButton.setToolTipText("Add and item to the list.");
		
		return addButton;
	}
	
	private JButton createUpdateButton()
	{
		JButton updateButton = new JButton();
		updateButton.setIcon(ScaleImage.getUpdateIcon());
		
		updateButton.setToolTipText("Update prices for all items.");
		
		
		return updateButton;
	}
	
	private JButton createRemoveButton()
	{
		JButton removeButton = new JButton();
		removeButton.setIcon(ScaleImage.getRemoveIcon());
		
		removeButton.setToolTipText("Remove selected item from list.");
		
		return removeButton;
	}
	
	private JButton createEditButton()
	{
		JButton editButton = new JButton();
		editButton.setIcon(ScaleImage.getEditIcon());
		
		editButton.setToolTipText("Edit selected item.");
		
		return editButton;
	}
}
