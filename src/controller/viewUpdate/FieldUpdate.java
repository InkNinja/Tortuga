package controller.viewUpdate;

import java.awt.Color;
import java.util.TreeMap;

import javax.swing.ImageIcon;

import controller.directions.ComplexDirection;

public class FieldUpdate {
	private ImageIcon shipIcon;
	private TreeMap<ComplexDirection,ImageIcon> directionMap;
	private Color background;
	public int x;
	public int y;
	
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
