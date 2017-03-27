package model.game.ship_collection;

import java.util.LinkedList;

import model.game.ships.*;

public interface IShipCollectionMaker {
	
	public abstract LinkedList<AbstractShip> makeShipCollection();
	
}
