package edu.utep.cs.cs3331;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ItemList extends JPanel
{

	DefaultListModel<Item> listModel;
	JList<Item> itemList;
	
	Item item1 = new Item("Item 1", "https://www.bing.com/", 1.0);
	Item item2 = new Item();
	Item item3 = new Item();

	
	
	public ItemList()
	{
		
		
		listModel = new DefaultListModel<>();

		itemList = new JList<>(listModel);
		
		add(new JScrollPane(itemList));
		itemList.setCellRenderer(new ItemViewRenderer());
	
	}
	
	
	public void addToList(Item item)
	{

		listModel.addElement(item);
		
	}
	
	public void removeFromList(int itemIndex)
	{
		listModel.remove(itemIndex);
	}


	public JPanel createList()
	{
		JPanel panel = new JPanel(new GridLayout(1,1));
		panel.add(new JScrollPane(itemList));
		return panel;
	}
	
}
