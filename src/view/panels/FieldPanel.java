package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.directions.ComplexDirection;
import controller.viewUpdate.FieldUpdate;

public class FieldPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	ShipPanel shipPane;
	LinkedList<DirectionPanel> dirs;
	private final static double weightShip = ShipPanel.size/(ShipPanel.size+2*DirectionPanel.panelSize);
	private final static double weightDir = DirectionPanel.panelSize/(ShipPanel.size+2*DirectionPanel.panelSize);
	
	
	public FieldPanel() throws IOException{
		int size = ShipPanel.size+2*DirectionPanel.panelSize;
		this.setSize(new Dimension(size,size));
		this.setMaximumSize(new Dimension(size,size));
		this.setMinimumSize(new Dimension(size,size));
		this.setPreferredSize(new Dimension(size,size));
		setBorder(BorderFactory.createLineBorder(Color.black));
		this.shipPane = new ShipPanel();
		dirs = new LinkedList<DirectionPanel>();
		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		DirectionPanel nw = new DirectionPanel(ComplexDirection.NORTHWEST);
		dirs.add(nw);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 0;
		c.gridy = 0;
		this.add(nw,c);
		
		c = new GridBagConstraints();
		DirectionPanel n = new DirectionPanel(ComplexDirection.NORTH);
		dirs.add(n);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 1;
		c.gridy = 0;
		this.add(n,c);
		
		c = new GridBagConstraints();
		DirectionPanel ne = new DirectionPanel(ComplexDirection.NORTHEAST);
		dirs.add(ne);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 2;
		c.gridy = 0;
		this.add(ne,c);
		
		c = new GridBagConstraints();
		DirectionPanel w = new DirectionPanel(ComplexDirection.WEST);
		dirs.add(w);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 0;
		c.gridy = 1;
		this.add(w,c);
		
		c = new GridBagConstraints();
		DirectionPanel e = new DirectionPanel(ComplexDirection.EAST);
		dirs.add(e);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 2;
		c.gridy = 1;
		this.add(e,c);
		
		c = new GridBagConstraints();
		DirectionPanel sw = new DirectionPanel(ComplexDirection.SOUTHWEST);
		dirs.add(sw);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 0;
		c.gridy = 2;
		this.add(sw,c);
		
		c = new GridBagConstraints();
		DirectionPanel s = new DirectionPanel(ComplexDirection.SOUTH);
		dirs.add(s);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 1;
		c.gridy = 2;
		this.add(s,c);
		
		c = new GridBagConstraints();
		DirectionPanel se = new DirectionPanel(ComplexDirection.SOUTHEAST);
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