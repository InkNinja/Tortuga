package view.panels;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JPanel;

import model.game.directions.ComplexDirection;
import model.game.directions.DirectionState;
import view.listeners_and_actions.FieldPanelListener;
import view.params.Params;
import view.update.FieldUpdate;

public class FieldPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	ShipPanel shipPane;
	LinkedList<DirectionPanel> dirs;
	private final static double weightShip = Params.getShipPanelWeight();
	private final static double weightDir = Params.getDirectionPanelWeight();
	private Dimension size = Params.getFieldPanelSize();
	Point coordinates;	
	private static FieldPanel active;
	
	public FieldPanel(Point coordinates){
		this.coordinates = coordinates;
		this.setSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setPreferredSize(size);
		this.setBackground(Params.fieldFogBackground);
		this.shipPane = new ShipPanel(coordinates);
		this.addMouseListener(new FieldPanelListener(coordinates));
		dirs = new LinkedList<DirectionPanel>();
		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		DirectionPanel nw = new DirectionPanel(ComplexDirection.NORTHWEST,coordinates);
		dirs.add(nw);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 0;
		c.gridy = 0;
		this.add(nw,c);
		
		c = new GridBagConstraints();
		DirectionPanel n = new DirectionPanel(ComplexDirection.NORTH,coordinates);
		dirs.add(n);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 1;
		c.gridy = 0;
		this.add(n,c);
		
		c = new GridBagConstraints();
		DirectionPanel ne = new DirectionPanel(ComplexDirection.NORTHEAST,coordinates);
		dirs.add(ne);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 2;
		c.gridy = 0;
		this.add(ne,c);
		
		c = new GridBagConstraints();
		DirectionPanel w = new DirectionPanel(ComplexDirection.WEST,coordinates);
		dirs.add(w);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 0;
		c.gridy = 1;
		this.add(w,c);
		
		c = new GridBagConstraints();
		DirectionPanel e = new DirectionPanel(ComplexDirection.EAST,coordinates);
		dirs.add(e);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 2;
		c.gridy = 1;
		this.add(e,c);
		
		c = new GridBagConstraints();
		DirectionPanel sw = new DirectionPanel(ComplexDirection.SOUTHWEST,coordinates);
		dirs.add(sw);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 0;
		c.gridy = 2;
		this.add(sw,c);
		
		c = new GridBagConstraints();
		DirectionPanel s = new DirectionPanel(ComplexDirection.SOUTH,coordinates);
		dirs.add(s);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 1;
		c.gridy = 2;
		this.add(s,c);
		
		c = new GridBagConstraints();
		DirectionPanel se = new DirectionPanel(ComplexDirection.SOUTHEAST,coordinates);
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
	
	public void setActive(){
		active.desactivate();
		active = this;
		activate();
	}
	
	public boolean active(){
		return active == this;
	}
	
	public void update(FieldUpdate data) throws IOException
	{
		shipPane.update(data.getShipIcon(),data.getBackground());
		for(DirectionPanel dPanel: dirs)
		{
			ComplexDirection direction = dPanel.direction;
			DirectionState state = data.directionMap.get(direction);
			dPanel.update(state,data.getBackground());
		}
		setBackground(data.getBackground());
	}
	
	public void activate(){
		for(DirectionPanel dir : dirs){
			try {
				dir.activate();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void desactivate(){
		for(DirectionPanel dir : dirs){
			try {
				dir.desactivate();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}