package view.panels;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.directions.ComplexDirection;

public class DirectionPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int panelSize = 20;
	ComplexDirection direction;
	JLabel flag;
	
	public DirectionPanel(ComplexDirection direction)
	{
		this.direction = direction;
		this.setSize(new Dimension(panelSize,panelSize));
		this.setMaximumSize(new Dimension(panelSize,panelSize));
		this.setMinimumSize(new Dimension(panelSize,panelSize));
		this.setPreferredSize(new Dimension(panelSize,panelSize));
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
