package panels;

import javax.swing.JPanel;

import directions.Direction;
import ships.AbstractShip;

public class FieldPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	AbstractShip covered;
	AbstractShip revealed;
	ShipPanel pane;
	DirectionPanel dirs[];
	
	public FieldPanel(AbstractShip covered){
		super();
		this.covered = covered;
		this.revealed =  null;
		this.pane = new ShipPanel();
		dirs = new DirectionPanel[8];
		DirectionPanel n = new DirectionPanel(Direction.NORTH);
		DirectionPanel ne = new DirectionPanel(Direction.NORTH,Direction.EAST);
		DirectionPanel nw = new DirectionPanel(Direction.NORTH,Direction.WEST);
		DirectionPanel w = new DirectionPanel(Direction.WEST);
		DirectionPanel e = new DirectionPanel(Direction.EAST);
		DirectionPanel s = new DirectionPanel(Direction.SOUTH);
		DirectionPanel sw = new DirectionPanel(Direction.SOUTH,Direction.WEST);
		DirectionPanel se = new DirectionPanel(Direction.SOUTH,Direction.EAST);
		dirs[0]=n;
		dirs[1]=ne;
		dirs[2]=nw;
		dirs[3]=e;
		dirs[4]=w;
		dirs[5]=s;
		dirs[6]=se;
		dirs[7]=sw;
		

	}
	
}
