package model.game.ship_collection;

import java.util.LinkedList;

import model.game.ships.*;

public class ShipCollection {

	private LinkedList<AbstractShip> ships;
	
	public AbstractShip getShip(){
		return ships.removeFirst();
	}
	
	public ShipCollection(ShipCollectionAbstractMaker maker)
	{
		ships = maker.makeShipCollection();
	}
	
}
