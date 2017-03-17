package view.panels;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShipPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	public final static int size = 80;
	JLabel picLabel;	
	
	public ShipPanel(){
		setSize(new Dimension(size,size));
		setMaximumSize(new Dimension(size,size));
		setMinimumSize(new Dimension(size,size));
		setPreferredSize(new Dimension(size,size));	
		picLabel = new JLabel();
		add(picLabel);
	}
	
	public void update(ImageIcon icon)
	{
		picLabel.setIcon(icon);
	}
}
