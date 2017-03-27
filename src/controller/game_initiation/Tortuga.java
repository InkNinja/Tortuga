package controller.game_initiation;

import java.io.IOException;

import controller.game_controll.DefaultController;
import view.windows.MainWindow;

public class Tortuga {

	DefaultController logic;
	MainWindow window;
	
	
	
	public Tortuga() throws IOException{
		window = new MainWindow();
		logic = new DefaultController(window);
	}
	
	public static void main (String[] args) throws IOException{
		Tortuga game = new Tortuga();
		game.window.setVisible(true);
	}
	
}
