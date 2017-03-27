package view.panels;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.game.directions.ComplexDirection;
import model.game.directions.DirectionState;
import view.listeners_and_actions.DirectionPanelListener;
import view.params.Params;

public class DirectionPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Dimension size = Params.getDirectionPanelSize();
	ComplexDirection direction;
	DirectionState state;
	DirectionPanelListener listener;
	JLabel flag;
	Point coordinates;
	boolean active;
	
	public DirectionPanel(ComplexDirection direction,Point coordinates)
	{
		this.coordinates = coordinates;
		this.direction = direction;
		this.setSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setPreferredSize(size);
		this.state = null;
		this.active = false;
		this.listener = new DirectionPanelListener(coordinates,direction);
		this.setBackground(Params.fieldFogBackground);
		this.addMouseListener(listener);
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


	public void update(DirectionState state,Color background) throws IOException
	{
		//TODO popraw
		ImageIcon img;
		if(state!=null)
			img = state.getIcon(active);
		else
			img = null;
		flag.setIcon(img);
		listener.state = state;
		this.setBackground(background);
	}
	
	public void activate() throws IOException{
		active = true;
		listener.setActive(active);
		ImageIcon img;
		if(state != null)
			img = state.getIcon(active);
		else
			img = null;
		flag.setIcon(img);
	}
	
	public void desactivate() throws IOException{
		active = false;
		listener.setActive(active);
		ImageIcon img;
		if(state != null)
			img = state.getIcon(active);
		else
			img = null;
		flag.setIcon(img);
	}
	
}
