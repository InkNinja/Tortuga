package model.game.ship_collection;

import java.util.LinkedList;

import model.game.exceptions.ShipCollectionIsEmpty;
import model.game.ships.*;

public class ShipCollection {

	private LinkedList<AbstractShip> ships;
	
	public AbstractShip getShip() throws ShipCollectionIsEmpty{
		if(ships.isEmpty())
			throw new ShipCollectionIsEmpty();
		return ships.removeFirst();
	}
	
	public ShipCollection(IShipCollectionMaker maker)
	{
		ships = maker.makeShipCollection();
	}
	
}
