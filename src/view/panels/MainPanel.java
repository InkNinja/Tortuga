package view.panels;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.viewConfig.Params;
import controller.viewUpdate.FieldUpdate;

public class MainPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ScorePanel pirates;
	public ScorePanel loyalists;
	public BoardPanel board;
	public Dimension size = Params.getMainPanelSize();
	
	public MainPanel(){
		super();
		this.setSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setPreferredSize(size);
		pirates = new ScorePanel();
		loyalists = new ScorePanel();
		board = new BoardPanel();
		
		setLayout(new GridBagLayout());		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0,0,0,50);
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx=0;
		c.gridy=0;
		add(pirates, c);
		
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		add(board, c);
		
		c = new GridBagConstraints();
		c.insets = new Insets(0,50,0,0);
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx=2;
		c.gridy=0;
		add(loyalists, c);
	}
	
	public void updateScorePanel(ScorePanel panel,ImageIcon icon,int score)
	{
		panel.update(icon, score);
	}
	
	public void updateScorePanel(ScorePanel panel,ImageIcon icon,int shipToChange,int score, int sinken)
	{
		panel.update(icon, shipToChange, score, sinken);
	}
	
	public void updateBoardPanel(FieldUpdate data)
	{
		board.update(data);
	}
	
	public void resetPanels(){
		pirates = new ScorePanel();
		loyalists = new ScorePanel();
		board = new BoardPanel();
	}
	
	
}
