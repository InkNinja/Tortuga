package model.game.ship_collection;

import java.util.Collections;
import java.util.LinkedList;

import model.game.ships.*;

public enum ShipCollectionStandardMaker implements IShipCollectionMaker {

	STANDARD;
	
	private LinkedList<AbstractShip> ships;
	
	ShipCollectionStandardMaker(){
		ships = new LinkedList<AbstractShip>();
		for(Faction f : Faction.values())
		{
			for(int i = 0; i < 2; i++)
			{
				ships.add(new BigShip(f));
				ships.add(new MediumShip(f));
				ships.add(new SmallShip(f));
			}
		}
	}
	
	public LinkedList<AbstractShip> makeShipCollection() {
		LinkedList<AbstractShip> collection = new LinkedList<AbstractShip>(ships);		
		Collections.shuffle(collection);
		return collection;
	}
	
	

}
