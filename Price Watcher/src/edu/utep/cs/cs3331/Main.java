package edu.utep.cs.cs3331;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
* A dialog for tracking the price of an item.
*
* @author Timothy P. McCrary
*/
@SuppressWarnings("serial")
public class Main extends JFrame {

    /** Default dimension of the dialog. */
    private final static Dimension DEFAULT_SIZE = new Dimension(500, 700);
      
    /** Special panel to display the watched item. */
    //private ItemView itemView;
    
    private ItemList itemList;
    
    private MenuBar menuBar;
    
    private ToolBar toolBar;
    
    private ItemManager itemManager;
    
    private ItemDialogs itemDialogs;
    
    
      
    /** Message bar to display various messages. */
    private JLabel msgBar = new JLabel(" ");

    /** Create a new dialog. */
    public Main() 
    {
    	this(DEFAULT_SIZE);
    }
    
    
    
    
    /** Create a new dialog of the given screen dimension. */
    public Main(Dimension dim) {
        super("Price Watcher");
        setSize(dim);
        
        itemList = new ItemList();
        itemManager = new ItemManager(this);
        menuBar = new MenuBar(this);
        toolBar = new ToolBar(this);
        itemDialogs = new ItemDialogs(this);
        
        //menuBar.getItemDialogs(itemDialogs);
        //itemDialogs.setItemManager(itemManager);
        
        configureUI();
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        //setResizable(false);
        showMessage("Welcome!");   
    }
    
    
    /** Callback to be invoked when the view-page icon is clicked.
     * Launch a (default) web browser by supplying the URL of
     * the item. */
    public void viewPageClicked() 
    {    	
    	//--
    	//-- WRITE YOUR CODE HERE!
    	//--
    	
    	//VisitUrl.goToUrl(item);
    	
    	showMessage("Going to website!");
    }
    
        
    /** Configure UI. */
    private void configureUI() 
    {
    	this.setJMenuBar(menuBar.createMenuBar());
    	
        setLayout(new BorderLayout());
        
        add(toolBar.createToolBar(), BorderLayout.NORTH);
        
        
        JPanel panelList = itemList.createList();
        panelList.setBorder(BorderFactory.createCompoundBorder(
        		BorderFactory.createEmptyBorder(10,16,0,16),
        		BorderFactory.createLineBorder(Color.GRAY)));
        add(panelList, BorderLayout.CENTER);
           
                   
        msgBar.setBorder(BorderFactory.createEmptyBorder(10,16,10,0));
        add(msgBar, BorderLayout.SOUTH);
    }
      
    /** Create a control panel consisting of a refresh button. */
//    private JPanel makeControlPanel() 
//    {
//    	JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
//    	JButton refreshButton = new JButton("Refresh");
//    	refreshButton.setFocusPainted(false);
//        refreshButton.addActionListener(this::refreshButtonClicked);
//        panel.add(refreshButton);
//        return panel;
//    }

    /** Show briefly the given string in the message bar. */
    public void showMessage(String msg) 
    {
        msgBar.setText(msg);
        new Thread(() -> {
        	try {
				Thread.sleep(3 * 1000); // 3 seconds
			} catch (InterruptedException e) {
			}
        	if (msg.equals(msgBar.getText())) {
        		SwingUtilities.invokeLater(() -> msgBar.setText(" "));
        	}
        }).start();
    }
    
    public static void main(String[] args) {
        new Main();
    }
    
    public MenuBar getMenuBar1()
    {
    	return menuBar;
    }

	public void setMenuBar(MenuBar menuBar)
	{
		this.menuBar = menuBar;
	}

	public ItemManager getItemManager()
	{
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager)
	{
		this.itemManager = itemManager;
	}

	public ItemDialogs getItemDialogs()
	{
		return itemDialogs;
	}

	public void setItemDialogs(ItemDialogs itemDialogs)
	{
		this.itemDialogs = itemDialogs;
	}

	public ItemList getItemList()
	{
		return itemList;
	}

	public void setItemList(ItemList itemList)
	{
		this.itemList = itemList;
	}
    
	
    

}
