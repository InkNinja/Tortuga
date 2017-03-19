package controller.viewUpdate;

import java.awt.Color;
import java.io.IOException;
import java.util.TreeMap;

import javax.swing.ImageIcon;

import controller.directions.ComplexDirection;

public class FieldUpdate {
	private ImageIcon shipIcon;
	public TreeMap<ComplexDirection,ImageIcon> directionMap;
	private Color background;
	public int x;
	public int y;
	
	public FieldUpdate(int x, int y,ImageIcon icon,Color background)
	{
		this.x = x;
		this.y = y;
		this.shipIcon = icon;
		this.background = background;
		directionMap = new TreeMap<ComplexDirection,ImageIcon>();
	}
	
	public ImageIcon getShipIcon()
	{
		return shipIcon;
	}
	
	public Color getBackground()
	{
		return background;
	}
	
	public ImageIcon getDirectionIcon(ComplexDirection direction)
	{
		return directionMap.get(direction);
	}
	
}
