package panels;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import directions.LoadSprite;
import ships.*;

public class ShipPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	public final static int size = 80;
	
	public AbstractShip ship;
	JLabel picLabel;	
	
	public ShipPanel(){
		this.ship = null;
		setSize(new Dimension(size,size));
		setMaximumSize(new Dimension(size,size));
		setMinimumSize(new Dimension(size,size));
		setPreferredSize(new Dimension(size,size));	
		picLabel = new JLabel();
		add(picLabel);
	}
	
	public void setShip(AbstractShip ship) throws IOException
	{
		this.ship = ship;
		update();
	}
	
	public void update() throws IOException{
		if(ship==null)
		{
			picLabel.setIcon(null);
		}
		else
		{
			picLabel.setIcon(LoadSprite.getSprite(ship));
		}
	}
}
