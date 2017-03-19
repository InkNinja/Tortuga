package view.listeners.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gameConfig.GameType;
import view.actions.AbstractNewGameAction;

public abstract class AbstractNewGameListener implements ActionListener{
	
	protected GameType type;	
	protected AbstractNewGameAction action;	
	
	public void actionPerformed(ActionEvent e) {            
        action.createNewGame(type);
    }    
	
}
