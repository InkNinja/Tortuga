package view.update;

import java.util.LinkedList;

import view.panels.GameViewPanel;

public class BoardUpdate extends AbstractUpdate{
	
	public BoardUpdate(LinkedList<FieldUpdate> data) {
		super(data);
	}

	@Override
	public void applyChanges(GameViewPanel gameView) {
		for(FieldUpdate update: data)
		{
			gameView.updateBoardPanel(update);
		}
	}

}
