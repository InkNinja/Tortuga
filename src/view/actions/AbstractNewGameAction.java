package view.actions;

import gameConfig.GameType;

public abstract class AbstractNewGameAction {
	
	public abstract void createNewGame(GameType type);
	
	public abstract void addPlayers();
	
	public abstract void resetBoard();
	
	public abstract void startGame();
	
}
