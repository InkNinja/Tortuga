package view.panels;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.config.*;

import controller.directions.ComplexDirection;

public class DirectionPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Dimension size = Params.getDirectionPanelSize();
	ComplexDirection direction;
	JLabel flag;
	final int x,y;
	
	public DirectionPanel(ComplexDirection direction,int x, int y)
	{
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.setSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setPreferredSize(size);
		setLayout(new GridBagLayout());
		flag = new JLabel();

		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		this.add(flag,c);		
	}
	
	public void update(ImageIcon img)
	{
		flag.setIcon(img);
	}
	
}
