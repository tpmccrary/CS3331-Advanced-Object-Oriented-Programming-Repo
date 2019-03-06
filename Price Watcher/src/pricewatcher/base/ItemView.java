//Timothy P. McCrary

package pricewatcher.base;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import edu.utep.cs.cs3331.ComparePrice;
import edu.utep.cs.cs3331.Item;
import edu.utep.cs.cs3331.PriceFinder;
import edu.utep.cs.cs3331.VisitUrl;;

/** A special panel to display the detail of an item. */

@SuppressWarnings("serial")
public class ItemView extends JPanel {
    
	/** Interface to notify a click on the view page icon. */
	public interface ClickListener {
		
		/** Callback to be invoked when the view page icon is clicked. */
		void clicked();
	}
	
	/** Directory for image files: src/image in Eclipse. */
	private final static String IMAGE_DIR = "/image/";
        
	/** View-page clicking listener. */
    private ClickListener listener;
    
    /** Create a new instance. */
    public ItemView() {
    	setPreferredSize(new Dimension(100, 160));
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	if (isViewPageClicked(e.getX(), e.getY()) && listener != null) {
            		listener.clicked();
            	}
            }
        });
    }
        
    /** Set the view-page click listener. */
    public void setClickListener(ClickListener listener) {
    	this.listener = listener;
    }
    
    // Formats numbers to look nice.
    DecimalFormat numFormat = new DecimalFormat("#,###,###,##0.00");
    
    // Declares Item variable to store Item object.
    Item item;
    
    /** Overridden here to display the details of the item. */
    @Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        //Dimension dim = getSize();
        
        //--
        //-- WRITE YOUR CODE HERE!
        //--
        
        
        
        int x = 20, y = 30;
        // g.drawImage(getImage("view.png"), x, y)
        Image image = getImage("keyboard.jpg");
        g.drawImage(image, x, y - 30, 128, 64, this);
        //g.setFont(getFont().deriveFont(Font.BOLD));
        //g.drawString("[View]", x, y);
        y += 45;
        g.drawString("Name: " + item.getItemName(), x, y);
        y += 20;
        g.drawString("URL: " + item.getUrl(), x, y);
        y += 20;
        
        if (item.getCurrentPrice() < item.getOriginalPrice())
        {
        	g.drawString("Price: ", x, y);
        	g.setColor(Color.BLUE);
        	g.drawString("$" + String.valueOf(numFormat.format(item.getCurrentPrice())), x + 34, y);
        	g.setColor(Color.BLACK);
        }
        else
        {
        	g.drawString("Price: $" + String.valueOf(numFormat.format(item.getCurrentPrice())), x, y);
        }
        
        y += 20;
        g.drawString("Change: " + String.valueOf(numFormat.format(ComparePrice.getPriceChange(item.getCurrentPrice(), item.getOriginalPrice()))) + "%", x, y);
        y += 20;
        g.drawString("Added: " + item.getDateAdded(), x, y);
        
        
    }
    
    /** Return true if the given screen coordinate is inside the viewPage icon. */
    private boolean isViewPageClicked(int x, int y) {
    	//--
    	//-- WRITE YOUR CODE HERE
    	//--
    	
    	return new Rectangle(20, 0, 128, 64).contains(x,  y);
    }
    
    // Getter for the Item object 
    public void getItem(Item item)
    {
    	this.item = item;
    }
    
        
    /** Return the image stored in the given file. */
    public Image getImage(String file) {
        try {
        	URL url = new URL(getClass().getResource(IMAGE_DIR), file);
            return ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
