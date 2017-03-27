package model.game.ship_collection;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import model.game.exceptions.ShipCollectionIsEmpty;
import model.game.ships.*;


public class ShipCollectionTest {

	
	
	ShipCollection ships;
	
	@Test
	public void shipCollectionStandardMakerTest(){
		IShipCollectionMaker maker = ShipCollectionStandardMaker.STANDARD;
		ships = new ShipCollection(maker);
		LinkedList<AbstractShip> list = new LinkedList<AbstractShip>();		
		AbstractShip next;
		while(true){
			try {
				next = ships.getShip();
				list.add(next);
			} catch (ShipCollectionIsEmpty e) {
				break;
			}
		}	
		assertEquals(list.size(),12);
		int pirates = 0;
		for(AbstractShip ship:list){
			pirates = ship.side==Faction.PIRATES?pirates+1:pirates;
		}
		assertEquals(pirates,6);
	}
	
	@Test
	public void shipCollectionCustomMakerAddTest() throws ShipCollectionIsEmpty{
		ShipCollectionCustomMaker maker = new ShipCollectionCustomMaker();
		MediumShip ship1 = new MediumShip(Faction.PIRATES);
		maker.add(2, true);
		ships = new ShipCollection(maker);	
		AbstractShip ship2 = ships.getShip();
		assertEquals(ship2.getClass(),ship1.getClass());
		assertEquals(ship2.side,ship1.side);
		assertEquals(ship2.face,ship1.face);
	}
	
	
	@Test
	public void shipCollectionCustomMakerOrderTest(){
		ShipCollectionCustomMaker maker = new ShipCollectionCustomMaker();
		MediumShip ship1 = new MediumShip(Faction.PIRATES);
		BigShip ship2 = new BigShip(Faction.LOYALISTS);
		maker.ships.add(ship1);
		maker.ships.add(ship2);
		ships = new ShipCollection(maker);
		LinkedList<AbstractShip> list = new LinkedList<AbstractShip>();		
		AbstractShip next;
		while(true){
			try {
				next = ships.getShip();
				list.addLast(next);
			} catch (ShipCollectionIsEmpty e) {
				break;
			}
		}
		assertEquals(list.size(),2);
		assertEquals(list.removeFirst(),ship1);
		assertEquals(list.removeFirst(),ship2);
	}

}
