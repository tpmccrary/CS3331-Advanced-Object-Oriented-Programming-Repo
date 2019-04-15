package edu.utep.cs.cs3331;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ItemDialogs
{
	private Main main;
	
	private JDialog dialog;
	
	private String itemName;
	private String itemUrl;
	
	
	public ItemDialogs(Main main)
	{
		this.main = main;
	}
	
	public void addItemDialog()
	{
		JFrame frame = new JFrame();
		
		JButton addButton = new JButton("Add");
		JButton cancelButton = new JButton("Cancel");
		
		JLabel nameLabel = new JLabel("Name:");
		JLabel urlLabel = new JLabel("URL:");
		
		JTextArea nameTextArea = new JTextArea("", 1, 15);
		JTextArea urlTextArea = new JTextArea("", 1, 15);
		
		dialog = new JDialog(frame, "Add an Item", true);
		dialog.setLayout(new FlowLayout());
		
		
		//addButton.addActionListener(this::addButtonClicked);
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
		dialog.setVisible(true);
		
		
	}
	
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
	
	
	public String getItemName()
	{
		return itemName;
	}

	public String getItemUrl()
	{
		return itemUrl;
	}
	
	
	

	
	
}
