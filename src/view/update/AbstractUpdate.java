package view.update;

import java.io.IOException;
import java.util.LinkedList;

import view.panels.GameViewPanel;

public abstract class AbstractUpdate {
	
	public LinkedList<FieldUpdate> data;
	
	public AbstractUpdate(LinkedList<FieldUpdate> data){
		this.data = data;
	}
	
	public abstract void applyChanges(GameViewPanel gameView) throws IOException;
}
