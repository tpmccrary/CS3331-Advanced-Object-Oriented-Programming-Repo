//Timothy P. McCrary

package edu.utep.cs.cs3331;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
* A dialog for tracking the price of an item.
*
* @author Yoonsik Cheon
*/
@SuppressWarnings("serial")
public class Main extends JFrame {

    /** Default dimension of the dialog. */
    private final static Dimension DEFAULT_SIZE = new Dimension(500, 700);
      
    /** Special panel to display the watched item. */
    //private ItemView itemView;
    
    private ItemList itemList;
    
    private MenuBar menuBar;
    
    private ItemManager itemManager;
    
    private ItemDialogs itemDialogs;
      
    /** Message bar to display various messages. */
    private JLabel msgBar = new JLabel(" ");

    /** Create a new dialog. */
    public Main() 
    {
    	this(DEFAULT_SIZE);
    }
    
    
    Item item = new Item("Logitech G610 Mechanical Keyboard",
    		"https://www.amazon.com/dp/B01CDYB8F6/?coliid=I3G9LP6LLUKNWS&colid=39N3ZBJ0BPD51&psc=0&ref_=lv_ov_lig_dp_it", 
    		PriceFinder.getPrice());
    Item item2 = new Item("Logitech G610 Mechanical Keyboard",
    		"https://www.amazon.com/dp/B01CDYB8F6/?coliid=I3G9LP6LLUKNWS&colid=39N3ZBJ0BPD51&psc=0&ref_=lv_ov_lig_dp_it", 
    		PriceFinder.getPrice());
    
    //NoApplet noapplet = new NoApplet();
    
    
    
    /** Create a new dialog of the given screen dimension. */
    public Main(Dimension dim) {
        super("Price Watcher");
        setSize(dim);
        
        itemList = new ItemList();
        itemManager = new ItemManager(this);
        menuBar = new MenuBar(this);
        itemDialogs = new ItemDialogs(this);
        
        //menuBar.getItemDialogs(itemDialogs);
        //itemDialogs.setItemManager(itemManager);
        
        configureUI();
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        //setResizable(false);
        showMessage("Welcome!"); 
        
        //itemManager = new ItemManager();
        
        //itemManager.addItem(item);
 
//        itemList.addToList(item);
//        itemList.addToList(item2);
        
//        itemManager.addItem(item, itemList);
//        itemManager.addItem(item2, itemList);
        
        
        
        
        
        //itemView.getItem(item);
        
        
        
    }
    
    public void menuAddButtonClicked(ActionEvent event)
    {
    	
    }
    public void addButtonClicked(ActionEvent event)
    {
    	
    }
    
  
    /** Callback to be invoked when the refresh button is clicked. 
     * Find the current price of the watched item and display it 
     * along with a percentage price change. */
    private void refreshButtonClicked(ActionEvent event) {
    	//--
    	//-- WRITE YOUR CODE HERE!
    	//--
    	
    	item.setCurrentPrice(PriceFinder.getPrice());
    	ComparePrice.getPriceChange(item.getCurrentPrice(), item.getOriginalPrice());
    	
    	
//    	if (item.getCurrentPrice() < item.getOriginalPrice())
//    	{
//        	noapplet.play("WW_Textbox_Open.wav");
//    	}
    	
    	
    	showMessage("Prices Updated!");
    	super.repaint();
    }
    
    
    /** Callback to be invoked when the view-page icon is clicked.
     * Launch a (default) web browser by supplying the URL of
     * the item. */
    public void viewPageClicked() 
    {    	
    	//--
    	//-- WRITE YOUR CODE HERE!
    	//--
    	
    	VisitUrl.goToUrl(item);
    	
    	showMessage("Going to website!");
    }
    
        
    /** Configure UI. */
    private void configureUI() 
    {
    	this.setJMenuBar(menuBar.createMenuBar());
    	//this.setJMenuBar(MenuBar.createMenuBar());
    	
        setLayout(new BorderLayout());
        
        JPanel control = makeControlPanel();
        control.setBorder(BorderFactory.createEmptyBorder(10,16,0,16)); 
        add(control, BorderLayout.NORTH);
        
        JPanel panelList = itemList.createList();
        panelList.setBorder(BorderFactory.createCompoundBorder(
        		BorderFactory.createEmptyBorder(10,16,0,16),
        		BorderFactory.createLineBorder(Color.GRAY)));
        add(panelList, BorderLayout.CENTER);
            
//        JPanel list = new JPanel();
//        list = itemList.createList();
//        list.setBorder(BorderFactory.createCompoundBorder(
//        		BorderFactory.createEmptyBorder(10,16,0,16),
//        		BorderFactory.createLineBorder(Color.GRAY)));
//        add(list, BorderLayout.CENTER);
        
//        JPanel board = new JPanel();
//        board.setBorder(BorderFactory.createCompoundBorder(
//        		BorderFactory.createEmptyBorder(10,16,0,16),
//        		BorderFactory.createLineBorder(Color.GRAY)));
//        board.setLayout(new GridLayout(1,1));
//        itemView = new ItemView();
//        
//        itemView.setClickListener(this::viewPageClicked);
//        board.add(itemView);
//        board.add(itemList);
//       
//        add(board, BorderLayout.CENTER);
        
        
        
        msgBar.setBorder(BorderFactory.createEmptyBorder(10,16,10,0));
        add(msgBar, BorderLayout.SOUTH);
    }
      
    /** Create a control panel consisting of a refresh button. */
    private JPanel makeControlPanel() 
    {
    	JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
    	JButton refreshButton = new JButton("Refresh");
    	refreshButton.setFocusPainted(false);
        refreshButton.addActionListener(this::refreshButtonClicked);
        panel.add(refreshButton);
        return panel;
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
