package model.game.ship_collection;

import java.util.LinkedList;

import model.game.ships.*;

public interface ShipCollectionAbstractMaker {
	
	public abstract LinkedList<AbstractShip> makeShipCollection();
	
}
