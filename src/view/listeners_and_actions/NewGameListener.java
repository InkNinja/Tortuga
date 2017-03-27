package view.listeners_and_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import controller.game_controll.DefaultController;

public class NewGameListener implements ActionListener{

	public static DefaultController game;

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			game.reset();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
}
