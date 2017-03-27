package model.game.directions;

import java.io.IOException;

import javax.swing.ImageIcon;

import model.sprites.LoadSprite;
import view.params.Params;

public enum DirectionState {
	MOVE(".\\img\\green.png"),TURN(".\\img\\yellow.png"),NONE(null);
	
	public String path;
	
	DirectionState(String path)
	{
		this.path = path;
	}
	
	public ImageIcon getIcon(boolean active) throws IOException{
		int size = active?Params.directionPanelSize():Params.flagIconSize();
		return LoadSprite.rescale(LoadSprite.getSprite(path),size);
	}
	
}
