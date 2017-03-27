package model.game.ship_collection;

import java.util.ArrayList;
import java.util.LinkedList;

import model.game.ships.AbstractShip;
import model.game.ships.BigShip;
import model.game.ships.Faction;
import model.game.ships.MediumShip;
import model.game.ships.SmallShip;

public class ShipCollectionCustomMaker implements IShipCollectionMaker {

	public ArrayList<AbstractShip> ships;

	public ShipCollectionCustomMaker(){
		ships = new ArrayList<AbstractShip>();
	}
	
	public ShipCollectionCustomMaker add(int size,boolean pirates)
	{
		AbstractShip ship;
		Faction side = pirates?Faction.PIRATES:Faction.LOYALISTS;
		switch(size)
		{
			case 1:{
				ship = new SmallShip(side);
				break;
			}
			case 2:{
				ship = new MediumShip(side);
				break;
			}
			case 3:{
				ship = new BigShip(side);
				break;
			}
			default:
				ship = new BigShip(side);		
		}
		ships.add(ship);
		return this;
	}	
	
	public LinkedList<AbstractShip> makeShipCollection() {
		return new LinkedList<AbstractShip>(ships);
	}

}
