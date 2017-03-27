package view.update;

import java.io.IOException;
import java.util.LinkedList;

import view.panels.GameViewPanel;

public class BoardUpdate extends AbstractUpdate{
	
	public BoardUpdate(LinkedList<FieldUpdate> data) {
		super(data);
	}

	@Override
	public void applyChanges(GameViewPanel gameView) throws IOException {
		for(FieldUpdate update: data)
		{
			gameView.updateBoardPanel(update);
		}
	}

}
