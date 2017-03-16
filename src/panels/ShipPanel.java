package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import directions.Direction;
import ships.*;

public class ShipPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	public AbstractShip ship;
	
	
	public ShipPanel(AbstractShip ship)
	{
		super();
		this.ship = ship;
		this.setPreferredSize(new Dimension(80,80));
		String path = ship.spriteName;
		System.out.println(path);
		BufferedImage img;
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("Sprite file not found at: "+path);
			return;
		}
		
		//TODO wywal to do zwrotu
		switch(ship.face)
		{
			case NORTH:
			{	
				BufferedImage img2 = new BufferedImage( 80, 80 , img.getType()  );
				for( int x = 0; x < 80; x++ ) {
					for( int y = 0; y < 80; y++ ) 
					{
						img2.setRGB(79-y, x, img.getRGB(x,y));
					}
				}
				img = img2;
				break;
			}
			case SOUTH:
			{
				BufferedImage img2 = new BufferedImage( 80, 80 , img.getType()  );
				for( int x = 0; x < 80; x++ ) {
					for( int y = 0; y < 80; y++ ) 
					{
						img2.setRGB(y,79 - x, img.getRGB(x,y));
					}
				}
				img = img2;
				break;
			}
			case EAST:
			{	
				AffineTransform tx = AffineTransform.getScaleInstance(-1, 1); 
				tx.translate(-img.getHeight(),0);
				AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
				img = op.filter(img, null);
				break;
			}
		}
		
		JLabel picLabel = new JLabel(new ImageIcon(img));
		add(picLabel);
		this.setMaximumSize(this.getPreferredSize());
	}
	
	public ShipPanel(){
		super();
		this.ship = null;
		this.setPreferredSize(new Dimension(80,80));
	}
	
	public static void main(String [] args)
	{
		AbstractShip ship = new BigShip(Faction.PIRATES);
		ship.face = Direction.EAST;
		ShipPanel p = new ShipPanel(ship);
		JFrame f = new JFrame();
		p.setBackground(Color.CYAN);
		f.setPreferredSize(new Dimension(80,80));
		f.add(p);
		f.setVisible(true);
	}
}
