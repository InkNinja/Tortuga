package model.game.ship_collection;

import java.util.ArrayList;
import java.util.LinkedList;

import model.game.ships.AbstractShip;
import model.game.ships.BigShip;
import model.game.ships.Faction;
import model.game.ships.MediumShip;
import model.game.ships.SmallShip;

public class ShipCollectionCustomMaker implements ShipCollectionAbstractMaker {

	public ArrayList<AbstractShip> ships;

	public ShipCollectionCustomMaker(){
		ships = new ArrayList<AbstractShip>();
	}
	
	public void add(int size,boolean pirates)
	{
		AbstractShip ship;
		Faction side = pirates?Faction.PIRATES:Faction.LOYALISTS;
		switch(size)
		{
		case 1:
			ship = new SmallShip(side);
		case 2:
			ship = new MediumShip(side);
		case 3:
			ship = new BigShip(side);
		default:
			ship = new BigShip(side);		
		}
		ships.add(ship);
	}	
	
	public LinkedList<AbstractShip> makeShipCollection() {
		return new LinkedList<AbstractShip>(ships);
	}

}
