package edu.utep.cs.cs3331;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
* Class that scales images to right size for application.
*
* @author Timothy P. McCrary
*/
public class ScaleImage
{
	/** Web link icon.*/
	private static ImageIcon webLinkIcon = scaleImage(new ImageIcon("src/image/web link.png"));
	/** Update icon.*/
	private static ImageIcon updateIcon = scaleImage(new ImageIcon("src/image/update icon.png"));
	/** Plus icon.*/
	private static ImageIcon plusIcon = scaleImage(new ImageIcon("src/image/plus icon.png"));
	/** Remove icon.*/
	private static ImageIcon removeIcon = scaleImage(new ImageIcon("src/image/remove icon.png"));
	/** Edit icon.*/
	private static ImageIcon editIcon = scaleImage(new ImageIcon("src/image/edit icon.png"));
	
	/** Scales image down to right size.
	 * 
	 * @param image The icon that will be scaled.
	 * */
	public static ImageIcon scaleImage(ImageIcon image)
	{
		Image img = image.getImage();
		Image newImg = img.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
		image = new ImageIcon(newImg);
		return image;
	}
	
	
	public static ImageIcon getWebLinkIcon()
	{
		return webLinkIcon;
	}
	public static void setWebLinkIcon(ImageIcon webLinkIcon)
	{
		ScaleImage.webLinkIcon = webLinkIcon;
	}
	public static ImageIcon getUpdateIcon()
	{
		return updateIcon;
	}
	public static void setUpdateIcon(ImageIcon updateIcon)
	{
		ScaleImage.updateIcon = updateIcon;
	}
	public static ImageIcon getPlusIcon()
	{
		return plusIcon;
	}
	public static void setPlusIcon(ImageIcon plusIcon)
	{
		ScaleImage.plusIcon = plusIcon;
	}
	public static ImageIcon getRemoveIcon()
	{
		return removeIcon;
	}
	public static void setRemoveIcon(ImageIcon removeIcon)
	{
		ScaleImage.removeIcon = removeIcon;
	}
	public static ImageIcon getEditIcon()
	{
		return editIcon;
	}
	public static void setEditIcon(ImageIcon editIcon)
	{
		ScaleImage.editIcon = editIcon;
	}
	
	
}
