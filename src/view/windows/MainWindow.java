package view.windows;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.viewConfig.Params;
import view.listeners.NewPvP1PCGameListener;
import view.panels.MainPanel;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JMenuBar menu;
	public MainPanel board;
	public Dimension size = Params.getMainWindowSize();
	
	
	public MainWindow(){
		super("Tortuga");
		this.setSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setPreferredSize(size);
		this.setResizable(false);
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
	
	public static void main (String[] args)
	{
		MainWindow game = new MainWindow();
		game.setVisible(true);
	}
	
}
