package edu.utep.cs.cs3331;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
/**
* Class that creates list to display the items.
*
* @author Timothy P. McCrary
*/
@SuppressWarnings("serial")
public class ItemList extends JPanel
{
	/** The default list model of a JList for an item.*/
	DefaultListModel<Item> listModel;
	/** The list that will hold the items.*/
	JList<Item> itemList;
	
	/** The access point to the main class.*/
	Main main;
	
	/** Creates list object.
	 * 
	 * @param main The main class of the program.
	 * */
	public ItemList(Main main)
	{
		this.main = main;
		
		listModel = new DefaultListModel<>();

		itemList = new JList<>(listModel);
		
		add(new JScrollPane(itemList));
		itemList.setCellRenderer(new ItemViewRenderer());
		
		itemList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e))
				{
					main.getJPopupMenu().show(itemList, e.getX(), e.getY());
				}
			}
		});
	
	}
	
	/** Adds item to list.
	 * 
	 * @param item The item being added.
	 * */
	public void addToList(Item item)
	{

		listModel.addElement(item);
		
	}
	
	/** Removes item from list.
	 * 
	 * @param itemIndex The index of the item that is being removed.
	 * */
	public void removeFromList(int itemIndex)
	{
		listModel.remove(itemIndex);
	}

	/** Creates list.
	 * 
	 * @return The JPanel the list is in.
	 * */
	public JPanel createList()
	{
		JPanel panel = new JPanel(new GridLayout(1,1));
		panel.add(new JScrollPane(itemList));
		return panel;
	}
	
}
