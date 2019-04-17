package edu.utep.cs.cs3331;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
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
    
    private PopUpMenu popupMenu;
    
    public JPopupMenu listPopupMenu;
    
    
      
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
        
        itemList = new ItemList(this);
        itemManager = new ItemManager(this);
        menuBar = new MenuBar(this);
        toolBar = new ToolBar(this);
        itemDialogs = new ItemDialogs(this);
        popupMenu = new PopUpMenu(this);
        
        listPopupMenu = popupMenu.createPopupMenu();
        
        
        
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
    
    
    public JPopupMenu getJPopupMenu()
    {
    	return listPopupMenu;
    }
    
    public PopUpMenu getPopupMenu()
	{
		return popupMenu;
	}
    
	public MenuBar getMyMenuBar()
    {
    	return menuBar;
    }
	
	public ItemManager getItemManager()
	{
		return itemManager;
	}

	public ItemDialogs getItemDialogs()
	{
		return itemDialogs;
	}

	public ItemList getItemList()
	{
		return itemList;
	}

	
	
    
	
    

}
