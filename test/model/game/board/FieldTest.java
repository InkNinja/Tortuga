package model.game.board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.game.directions.SimpleDirection;
import model.game.exceptions.IllegalShipUncover;
import model.game.exceptions.IllegalTurnException;
import model.game.exceptions.NoShipToMoveException;
import model.game.exceptions.ShipCollectionIsEmpty;
import model.game.ship_collection.ShipCollection;
import model.game.ship_collection.ShipCollectionCustomMaker;
import model.game.ships.AbstractShip;
import model.game.ships.Faction;
import model.game.ships.MediumShip;
import model.game.ships.SmallShip;

public class FieldTest {

	Field field;	
	ShipCollection ships;
	AbstractShip ship;
	
	
	@Before
	public void prepare(){
		field = new Field();
		ShipCollectionCustomMaker maker = new ShipCollectionCustomMaker();
		ship = new SmallShip(Faction.PIRATES);
		new MediumShip(Faction.LOYALISTS);
		maker.ships.add(ship);
		ships = new ShipCollection(maker);
	}
	
	
	@Test
	public void initialTest() {
		assertTrue(field.fog);
		assertNull(field.ship);
	}
	
	@Test
	public void uncoverTest() throws IllegalShipUncover, ShipCollectionIsEmpty{
		field.uncover(ships);
		assertEquals(field.ship,ship);
	}
	
	@Test
	public void firstTurnTest() throws IllegalShipUncover, NoShipToMoveException, ShipCollectionIsEmpty{
		for(SimpleDirection direction: SimpleDirection.values()){
			prepare();
			field.uncover(ships);
			field.firstTurnShip(direction);
			assertEquals(field.ship.face,direction);
		}
	}
	
	@Test
	public void afterFirstTurnTest() throws IllegalShipUncover, NoShipToMoveException, ShipCollectionIsEmpty{
		prepare();
		field.uncover(ships);
		try {
			field.turnShip(SimpleDirection.NORTH);
			assertEquals(field.ship.face,SimpleDirection.NORTH);
		} catch (IllegalTurnException e) {
			System.out.println(SimpleDirection.NORTH);
			fail();
		}
		
		prepare();
		field.uncover(ships);
		try {
			field.turnShip(SimpleDirection.SOUTH);
			assertEquals(field.ship.face,SimpleDirection.SOUTH);
		} catch (IllegalTurnException e) {
			System.out.println(SimpleDirection.SOUTH);
			fail();
		}
		
		prepare();
		field.uncover(ships);
		try {
			field.turnShip(SimpleDirection.EAST);
			System.out.println(SimpleDirection.EAST);
			fail();
		} catch (IllegalTurnException e) {
			assertEquals(field.ship.face,SimpleDirection.EAST);
		}
		
		prepare();
		field.uncover(ships);
		try {
			field.turnShip(SimpleDirection.WEST);
			System.out.println(SimpleDirection.WEST);
			fail();
		} catch (IllegalTurnException e) {
			assertEquals(field.ship.face,SimpleDirection.EAST);
		}
	}
	
	

}
