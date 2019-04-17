package edu.utep.cs.cs3331;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/** Class that creates all dialogs for application.
 * 
 * @author Timothy P. McCrary
 * */
public class ItemDialogs
{
	/** The access point to the main class.*/
	private Main main;
	
	/** The dialog itself.*/
	private JDialog dialog;
	
	/** The name that can be typed or edited for an item.*/
	private String itemName;
	/** The URL that can be typed or edited for an item.*/
	private String itemUrl;
	
	/** Creates dialog object.
	 * 
	 * @param main The main class of the program.
	 * */
	public ItemDialogs(Main main)
	{
		this.main = main;
	}
	
	/** Creates dialog to add an item in the application.*/
	public void addItemDialog() 
	{
		JFrame frame = new JFrame();
		
		JButton addButton = new JButton("Add");
		JButton cancelButton = new JButton("Cancel");
		
		JLabel nameLabel = new JLabel("Name:");
		JLabel urlLabel = new JLabel("URL:");
		
		JTextArea nameTextArea = new JTextArea("", 1, 15);
		JTextArea urlTextArea = new JTextArea("https://", 1, 15);
		
		nameTextArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		urlTextArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		
		dialog = new JDialog(frame, "Add an Item", true);
		dialog.setLayout(new FlowLayout());
		
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				itemName = nameTextArea.getText();
				nameTextArea.setText("");
				
				itemUrl = urlTextArea.getText();
				urlTextArea.setText("");
				
				main.getItemManager().addItem(new Item(itemName, itemUrl, PriceFinder.getPrice()));
				
				frame.dispose();
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				nameTextArea.setText("");
				urlTextArea.setText("");
				
				frame.dispose();
			}
		});
		
		
		dialog.add(nameLabel);
		dialog.add(nameTextArea);
		dialog.add(urlLabel);
		dialog.add(urlTextArea);
		dialog.add(addButton);
		dialog.add(cancelButton);
		dialog.setSize(250, 300);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(main.getContentPane());
		dialog.setVisible(true);
		
		
	}
	
	/** Creates dialog to remove item in the application.*/
	public void removeItemDialog(int itemIndex)
	{
		
		int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this item?","Remove item", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		
		
		
		if(response == JOptionPane.YES_OPTION)
		{
			main.getItemManager().removeItem(itemIndex);
			return;
		}
		
		return;
		
		
	}
	
	/** Creates dialog to edit an existing item in the application.*/
	public void editItemDialog(int itemIndex)
	{
		JFrame frame = new JFrame();
		
		JButton confirmButton = new JButton("Confirm");
		JButton cancelButton = new JButton("Cancel");
		
		JLabel nameLabel = new JLabel("Name:");
		JLabel urlLabel = new JLabel("URL:");
		
		JTextArea nameTextArea = new JTextArea(main.getItemManager().getItems()[itemIndex].getItemName(), 1, 15);
		JTextArea urlTextArea = new JTextArea(main.getItemManager().getItems()[itemIndex].getUrl(), 1, 15);
		
		nameTextArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		urlTextArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		
		dialog = new JDialog(frame, "Edit this Item", true);
		dialog.setLayout(new FlowLayout());
		
		
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				itemName = nameTextArea.getText();
				nameTextArea.setText("");
				
				itemUrl = urlTextArea.getText();
				urlTextArea.setText("");
				
				main.getItemManager().getItems()[itemIndex].setItemName(itemName);
				main.getItemManager().getItems()[itemIndex].setUrl(itemUrl);
				
				main.repaint();
				
				frame.dispose();
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				nameTextArea.setText("");
				urlTextArea.setText("");
				
				frame.dispose();
			}
		});
		
		
		
		dialog.add(nameLabel);
		dialog.add(nameTextArea);
		dialog.add(urlLabel);
		dialog.add(urlTextArea);
		dialog.add(confirmButton);
		dialog.add(cancelButton);
		dialog.setSize(250, 300);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(main.getContentPane());
		dialog.setVisible(true);
		
	}
	
	public String getItemName()
	{
		return itemName;
	}

	public String getItemUrl()
	{
		return itemUrl;
	}

	
	
	
	

	
	
}
