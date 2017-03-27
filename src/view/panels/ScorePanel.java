package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import view.params.Params;

public class ScorePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ShipPanel[] ships;
	public static final Dimension size = Params.getScorePanelSize();
	public static final int gapsSize = Params.getfieldGapsSize();
	private final Color background = Params.boardBackground;
	private final Color water = Params.fieldClearBackground;
	private int sunk; 
	
	public ScorePanel(){
		super();
		sunk = 0;
		this.setSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setPreferredSize(size);
		this.setBackground(background);
		ships = new ShipPanel[5];
		GridLayout layout = new GridLayout(5,1);
		layout.setHgap(gapsSize);
		layout.setVgap(gapsSize);
		setLayout(layout);
		for(int i = 0; i < 5; i++)
		{
			ships[i]=new ShipPanel(new Point(0,i));
			add(ships[i]);
		}
		
	}
	
	public void update(ImageIcon icon)
	{
		ships[sunk].update(icon,water);
		sunk++;
	}
	
}
