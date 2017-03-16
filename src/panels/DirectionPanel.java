package panels;

import javax.swing.JPanel;

import directions.Direction;

public class DirectionPanel extends JPanel{
	
	Direction main;
	Direction secondary;
	
	public DirectionPanel(Direction main){
		super();
		this.main = main;
		this.secondary = main;
	}
	
	public DirectionPanel(Direction main, Direction secondary)
	{
		super();
		this.main = main;
		this.secondary = secondary;
	}
	
}
