package view.update;

import java.awt.Color;
import java.awt.Point;
import java.util.TreeMap;

import javax.swing.ImageIcon;

import controller.game_controll.DefaultController;
import model.game.directions.ComplexDirection;
import model.game.directions.DirectionState;
import model.game.exceptions.IllegalFieldException;

public class FieldUpdate {
	private ImageIcon shipIcon;
	public TreeMap<ComplexDirection,DirectionState> directionMap;
	private Color background;
	public Point field;
	public static DefaultController game;
	
	public FieldUpdate(Point field,ImageIcon icon,Color background)
	{
		this.field = field;
		this.shipIcon = icon;
		this.background = background;
		directionMap = new TreeMap<ComplexDirection,DirectionState>();
	}
	
	public FieldUpdate getDirections() throws IllegalFieldException
	{
		return game.addDirections(this);
	}
	
	
	public ImageIcon getShipIcon()
	{
		return shipIcon;
	}
	
	public Color getBackground()
	{
		return background;
	}
	
}
