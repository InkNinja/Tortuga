package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.game.ships.Faction;
import view.params.Params;
import view.update.FieldUpdate;

public class GameViewPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BoardPanel board;
	public Dimension size = Params.getMainPanelSize();
	private final Color background = Params.boardBackground;
	public TreeMap<Faction,ScorePanel> map;
	
	public GameViewPanel(){
		super();
		this.setSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setPreferredSize(size);
		this.setBackground(background);
		map = new TreeMap<Faction,ScorePanel>();
		map.put(Faction.LOYALISTS, new ScorePanel());
		map.put(Faction.PIRATES, new ScorePanel());
		board = new BoardPanel();
		
		setLayout(new GridBagLayout());		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(25,35,25,25);
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx=0;
		c.gridy=0;
		add(map.get(Faction.PIRATES), c);
		
		c = new GridBagConstraints();
		c.insets = new Insets(25,25,25,25);
		c.gridx = 1;
		c.gridy = 0;
		add(board, c);
		
		c = new GridBagConstraints();
		c.insets = new Insets(25,25,25,35);
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx=2;
		c.gridy=0;
		add(map.get(Faction.LOYALISTS), c);
	}
	
	public void updateScorePanel(Faction side,ImageIcon icon)
	{
		map.get(side).update(icon);
	}
	
	public void updateBoardPanel(FieldUpdate data)
	{
		board.update(data);
	}
	
	public void resetPanels(){
		map = new TreeMap<Faction,ScorePanel>();
		map.put(Faction.LOYALISTS, new ScorePanel());
		map.put(Faction.PIRATES, new ScorePanel());
		board = new BoardPanel();
	}
	
	
}
