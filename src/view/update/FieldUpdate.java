package view.update;

import java.awt.Color;
import java.awt.Point;
import java.util.TreeMap;

import javax.swing.ImageIcon;

import model.game.directions.ComplexDirection;

public class FieldUpdate {
	private ImageIcon shipIcon;
	public TreeMap<ComplexDirection,ImageIcon> directionMap;
	private Color background;
	public Point field;
	
	public FieldUpdate(Point field,ImageIcon icon,Color background)
	{
		this.field = field;
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
