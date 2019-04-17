package edu.utep.cs.cs3331;

import java.awt.Component;


import javax.swing.JList;
import javax.swing.ListCellRenderer;
/**
* Custom renderer in order to have images and text in item list.
*
* @author Timothy P. McCrary
*/
@SuppressWarnings("serial")
public class ItemViewRenderer extends ItemView implements ListCellRenderer<Item>
{	
	
	
	
	@Override
	public Component getListCellRendererComponent(JList<? extends Item> list, Item item, int index, boolean isSelected, boolean cellHasFocus)
	{
		
		this.getItem(item);
		
		if (isSelected) 
		{
		    setBackground(list.getSelectionBackground()); 
		    setForeground(list.getSelectionForeground()); 
		    item.setSelected(true);
		    
		} else 
		{ 
		    setBackground(list.getBackground()); 
		    setForeground(list.getForeground()); 
		    item.setSelected(false);
		    
		}
		return this;
	}
}
