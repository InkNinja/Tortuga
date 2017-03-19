package view.update;

import java.util.LinkedList;

import model.game.ships.Faction;
import view.panels.GameViewPanel;

public class ScoreUpdate extends AbstractUpdate{

	Faction side;
	
	public ScoreUpdate(LinkedList<FieldUpdate> data,Faction side) {
		super(data);
	}

	@Override
	public void applyChanges(GameViewPanel gameView) {
		for(FieldUpdate update: data)
		{
			gameView.updateScorePanel(side, update.getShipIcon());
		}
	}

}
