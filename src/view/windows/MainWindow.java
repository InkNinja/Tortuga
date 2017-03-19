package view.windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.directions.ComplexDirection;
import controller.directions.SimpleDirection;
import controller.viewConfig.Params;
import controller.viewUpdate.FieldUpdate;
import model.ships.Faction;
import view.listeners.windows.NewPvP1PCGameListener;
import view.panels.MainPanel;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JMenuBar menu;
	public MainPanel board;
	public Dimension size = Params.getMainWindowSize();
	private final Color background = Params.boardBackground;
	
	public MainWindow(){
		super("Tortuga");
		this.setSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setPreferredSize(size);
		this.setResizable(false);
		this.setBackground(background);
		menu = new JMenuBar();
		board = new MainPanel();
		JMenu newGameMenu = new JMenu("New Game");
		JMenuItem pvp1PCGame = new JMenuItem("Player vs Player (1PC)");
		ActionListener listener = new NewPvP1PCGameListener();
		pvp1PCGame.addActionListener(listener);
		newGameMenu.add(pvp1PCGame);
		menu.add(newGameMenu);
		setJMenuBar(menu);
		add(board);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);		
	}
	
	public static void main (String[] args) throws IOException
	{
		MainWindow game = new MainWindow();
		game.setVisible(true);
		model.ships.AbstractShip ship= new model.ships.BigShip(Faction.LOYALISTS);
		FieldUpdate data = new FieldUpdate(1,2,model.sprites.LoadSprite.getSprite(ship),Params.fieldClearBackground);
		try {
			data.directionMap.put(ComplexDirection.NORTH, model.sprites.LoadSprite.getSprite(20, ".\\img\\yellow.png"));
			data.directionMap.put(ComplexDirection.SOUTH, model.sprites.LoadSprite.getSprite(20, ".\\img\\yellow.png"));
			data.directionMap.put(ComplexDirection.SOUTHEAST, model.sprites.LoadSprite.getSprite(20, ".\\img\\green.png"));
			data.directionMap.put(ComplexDirection.NORTHEAST, model.sprites.LoadSprite.getSprite(20, ".\\img\\green.png"));
			data.directionMap.put(ComplexDirection.EAST, model.sprites.LoadSprite.getSprite(20, ".\\img\\green.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		game.board.updateBoardPanel(data);
		
		ship= new model.ships.MediumShip(Faction.PIRATES);
		ship.face = SimpleDirection.WEST;
		data = new FieldUpdate(2,3,model.sprites.LoadSprite.getSprite(ship),Params.fieldClearBackground);
		try {
			data.directionMap.put(ComplexDirection.NORTH, model.sprites.LoadSprite.getSprite(10, ".\\img\\yellow.png"));
			data.directionMap.put(ComplexDirection.SOUTH, model.sprites.LoadSprite.getSprite(10, ".\\img\\yellow.png"));
			data.directionMap.put(ComplexDirection.SOUTHWEST, model.sprites.LoadSprite.getSprite(10, ".\\img\\green.png"));
			data.directionMap.put(ComplexDirection.NORTHWEST, model.sprites.LoadSprite.getSprite(10, ".\\img\\green.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		game.board.updateBoardPanel(data);
		
	}
	
}
