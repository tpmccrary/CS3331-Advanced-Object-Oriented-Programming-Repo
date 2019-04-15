package edu.utep.cs.cs3331;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ScaleImage
{
	private static ImageIcon updateIcon = scaleImage(new ImageIcon("src/image/update icon.png"));
	private static ImageIcon plusIcon = scaleImage(new ImageIcon("src/image/Blue Plus icon.png"));
	private static ImageIcon removeIcon = scaleImage(new ImageIcon("src/image/remove icon.png"));
	private static ImageIcon editIcon = scaleImage(new ImageIcon("src/image/edit icon.png"));
	
	
	public static ImageIcon scaleImage(ImageIcon image)
	{
		Image img = image.getImage();
		Image newImg = img.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
		image = new ImageIcon(newImg);
		return image;
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
