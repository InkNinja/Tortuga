package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import directions.Direction;
import rules.IllegalMove;
import ships.AbstractShip;
import ships.BigShip;
import ships.Faction;

public class FieldPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	AbstractShip covered;
	AbstractShip revealed;
	ShipPanel shipPane;
	LinkedList<DirectionPanel> dirs;
	private final static double weightShip = ShipPanel.size/(ShipPanel.size+2*DirectionPanel.panelSize);
	private final static double weightDir = DirectionPanel.panelSize/(ShipPanel.size+2*DirectionPanel.panelSize);
	
	
	public FieldPanel(AbstractShip covered) throws IOException{
		this.covered = covered;
		this.revealed =  null;
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
		DirectionPanel nw = new DirectionPanel(Direction.NORTH,Direction.WEST);
		dirs.add(nw);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 0;
		c.gridy = 0;
		this.add(nw,c);
		
		c = new GridBagConstraints();
		DirectionPanel n = new DirectionPanel(Direction.NORTH,Direction.NORTH);
		dirs.add(n);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 1;
		c.gridy = 0;
		this.add(n,c);
		
		c = new GridBagConstraints();
		DirectionPanel ne = new DirectionPanel(Direction.NORTH,Direction.EAST);
		dirs.add(ne);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 2;
		c.gridy = 0;
		this.add(ne,c);
		
		c = new GridBagConstraints();
		DirectionPanel w = new DirectionPanel(Direction.WEST,Direction.WEST);
		dirs.add(w);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 0;
		c.gridy = 1;
		this.add(w,c);
		
		c = new GridBagConstraints();
		DirectionPanel e = new DirectionPanel(Direction.EAST,Direction.EAST);
		dirs.add(e);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 2;
		c.gridy = 1;
		this.add(e,c);
		
		c = new GridBagConstraints();
		DirectionPanel sw = new DirectionPanel(Direction.SOUTH,Direction.WEST);
		dirs.add(sw);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 0;
		c.gridy = 2;
		this.add(sw,c);
		
		c = new GridBagConstraints();
		DirectionPanel s = new DirectionPanel(Direction.SOUTH,Direction.SOUTH);
		dirs.add(s);
		c.weightx = weightDir;
		c.weighty = weightDir;
		c.gridx = 1;
		c.gridy = 2;
		this.add(s,c);
		
		c = new GridBagConstraints();
		DirectionPanel se = new DirectionPanel(Direction.SOUTH,Direction.EAST);
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
	
	public void uncover() throws IllegalMove, IOException
	{
		if(revealed !=null || covered == null)
			throw new IllegalMove();
		else
		{
			revealed = covered;
			covered = null;
			shipPane.setShip(revealed);
		}
		//TODO
	}
	
	public void moveOut() throws IOException, IllegalMove{
		if(revealed == null)
			throw new IllegalMove();
		else
		{
			revealed = null;
			shipPane.setShip(null);
		}
	}
	
	public void MoveIn(AbstractShip ship){
		//TODO
	}
	
	public static void main(String [] args) throws IOException
	{
		AbstractShip ship = new BigShip(Faction.PIRATES);
		ship.face = Direction.EAST;
		FieldPanel field  = new FieldPanel(ship);
		JFrame f = new JFrame();
		JPanel inner = new JPanel();
		f.add(inner);
		inner.add(field);
		f.pack();
		f.setVisible(true);
	}

	
}
