package view.panels;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.viewConfig.*;

public class ScorePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//public Faction side;
	public ShipPanel[] ships;
	public static final Dimension size = Params.getScorePanelSize();
	public static final int gapsSize = Params.getfieldGapsSize();
	private int sinken; 
	private int score;
	
	public ScorePanel(){
		super();
		sinken = 0;
		score = 0;
		this.setSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setPreferredSize(size);
		ships = new ShipPanel[5];
		GridLayout layout = new GridLayout(5,1);
		layout.setHgap(gapsSize);
		layout.setVgap(gapsSize);
		setLayout(layout);
		for(int i = 0; i < 5; i++)
		{
			ships[i]=new ShipPanel(0,i);
			add(ships[i]);
		}
		
	}
	
	public void update(ImageIcon icon, int score)
	{
		ships[sinken].update(icon);
		sinken++;
		this.score+=score;
	}
	
	public void update(ImageIcon icon, int shipToChange,int score,int sinken)
	{
		ships[shipToChange].update(icon);
		this.score += score;
		this.sinken+=sinken;
	}
	
	public int getScore()
	{
		return score;
	}
}
