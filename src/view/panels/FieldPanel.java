package view.panels;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.directions.ComplexDirection;
import controller.viewConfig.Params;
import controller.viewUpdate.FieldUpdate;

public class FieldPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	ShipPanel shipPane;
	LinkedList<DirectionPanel> dirs;
	private final static double weightShip = Params.getShipPanelWeight();
	private final static double weightDir = Params.getDirectionPanelWeight();
	private Dimension size = Params.getFieldPanelSize();
	final int x;
	final int y;
	
	
	public FieldPanel(int x, int y){
		this.x =x;
		this.y =y;
		this.setSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setPreferredSize(size);
		this.shipPane = new ShipPanel(x,y);
		dirs = new LinkedList<DirectionPanel>();
		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		DirectionPanel nw = new DirectionPanel(ComplexDirection.NORTHWEST,x,y);
		dirs.add(nw);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 0;
		c.gridy = 0;
		this.add(nw,c);
		
		c = new GridBagConstraints();
		DirectionPanel n = new DirectionPanel(ComplexDirection.NORTH,x,y);
		dirs.add(n);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 1;
		c.gridy = 0;
		this.add(n,c);
		
		c = new GridBagConstraints();
		DirectionPanel ne = new DirectionPanel(ComplexDirection.NORTHEAST,x,y);
		dirs.add(ne);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 2;
		c.gridy = 0;
		this.add(ne,c);
		
		c = new GridBagConstraints();
		DirectionPanel w = new DirectionPanel(ComplexDirection.WEST,x,y);
		dirs.add(w);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 0;
		c.gridy = 1;
		this.add(w,c);
		
		c = new GridBagConstraints();
		DirectionPanel e = new DirectionPanel(ComplexDirection.EAST,x,y);
		dirs.add(e);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 2;
		c.gridy = 1;
		this.add(e,c);
		
		c = new GridBagConstraints();
		DirectionPanel sw = new DirectionPanel(ComplexDirection.SOUTHWEST,x,y);
		dirs.add(sw);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 0;
		c.gridy = 2;
		this.add(sw,c);
		
		c = new GridBagConstraints();
		DirectionPanel s = new DirectionPanel(ComplexDirection.SOUTH,x,y);
		dirs.add(s);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 1;
		c.gridy = 2;
		this.add(s,c);
		
		c = new GridBagConstraints();
		DirectionPanel se = new DirectionPanel(ComplexDirection.SOUTHEAST,x,y);
		dirs.add(se);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 2;
		c.gridy = 2;
		this.add(se,c);
		
		c = new GridBagConstraints();
		c.weightx = weightShip;
		c.weighty = weightShip;
		c.gridx = 1;
		c.gridy = 1;
		this.add(shipPane,c);	
	}
	
	public void update(FieldUpdate data)
	{
		shipPane.update(data.getShipIcon());
		for(DirectionPanel dPanel: dirs)
		{
			ComplexDirection direction = dPanel.direction;
			ImageIcon icon = data.getDirectionIcon(direction);
			dPanel.update(icon);
		}
		setBackground(data.getBackground());
	}
	
}