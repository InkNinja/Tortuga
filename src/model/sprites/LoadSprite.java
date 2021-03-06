package model.sprites;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import model.game.ships.AbstractShip;
import view.params.Params;

public class LoadSprite {
	
	private final static int iconSize = Params.shipIconSize();
	//TODO zmodyfikuj i zastan�w si� w jakim pakiecie umiescic
	
	public static BufferedImage getSprite(String path) throws IOException
	{
		BufferedImage img;	
		if(path == null)
			img = null;
		else
			img = ImageIO.read(new File(path));
		return img;
	}
	
	public static ImageIcon rescale(BufferedImage img,int size){
		ImageIcon newimg;
		if(img == null)
			newimg = null;
		else
			newimg = new ImageIcon(img.getScaledInstance(size, size,  java.awt.Image.SCALE_SMOOTH));
		return newimg;
	}
	
	
	public static ImageIcon getSprite(AbstractShip ship) throws IOException
	{
		String path = ship.spriteName;		
		BufferedImage img;
		img = ImageIO.read(new File(path));
		switch(ship.face)
		{
			case NORTH:
			{	
				BufferedImage img2 = new BufferedImage( iconSize, iconSize , img.getType()  );
				for( int x = 0; x < iconSize; x++ ) {
					for( int y = 0; y < iconSize; y++ ) 
					{
						img2.setRGB(iconSize - 1-y, x, img.getRGB(x,y));
					}
				}
				img = img2;
				break;
			}
			case SOUTH:
			{
				BufferedImage img2 = new BufferedImage( iconSize, iconSize , img.getType()  );
				for( int x = 0; x < iconSize; x++ ) {
					for( int y = 0; y < iconSize; y++ ) 
					{
						img2.setRGB(y,iconSize - 1 - x, img.getRGB(x,y));
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
		case WEST:
			break;
		default:
			break;
		}
		return new ImageIcon(img);
	}
}
