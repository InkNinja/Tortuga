package view.listeners.windows;

import gameConfig.GameType;
import view.actions.NewPvP1PCGameAction;

public class NewPvP1PCGameListener extends AbstractNewGameListener{

	public NewPvP1PCGameListener()
	{
		this.type = GameType.PvP1PC;	
		this.action = new NewPvP1PCGameAction();	
	}
	
}
