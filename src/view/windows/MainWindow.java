package view.windows;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import view.panels.GameViewPanel;
import view.params.Params;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JMenuBar menu;
	public GameViewPanel gameView;
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
		gameView = new GameViewPanel();
		JMenu newGameMenu = new JMenu("New Game");
		JMenuItem pvp1PCGame = new JMenuItem("Player vs Player (1PC)");
		newGameMenu.add(pvp1PCGame);
		menu.add(newGameMenu);
		setJMenuBar(menu);
		add(gameView);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);		
	}	
	
}
