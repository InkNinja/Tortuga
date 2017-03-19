package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.viewConfig.Params;

public class ShipPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	public final static Dimension size = Params.getShipPanelSize();
	JLabel picLabel;	
	final int x, y;
	
	public ShipPanel(int x, int y){
		this.x = x;
		this.y = y;
		setSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
		setPreferredSize(size);	
		picLabel = new JLabel();
		this.setBackground(Color.BLUE);
		add(picLabel);
	}
	
	public void update(ImageIcon icon)
	{
		picLabel.setIcon(icon);
	}
}
