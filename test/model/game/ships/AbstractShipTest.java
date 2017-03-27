package model.game.ships;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.game.directions.SimpleDirection;

public class AbstractShipTest {

	AbstractShip ship;
	
	@Before
	public void prepare(){
		ship = new SmallShip(Faction.LOYALISTS);
	}
	
	@Test
	public void turnTest() {
		for(SimpleDirection direction: SimpleDirection.values()){
			ship.turn(direction);
			assertTrue(ship.face == direction);
		}
	}
	
	
	@Test
	public void canTurnTest() {
		for(SimpleDirection direction: SimpleDirection.values()){
			ship.face = direction;
			for(SimpleDirection direction2: SimpleDirection.values()){
				assertTrue(ship.canTurn(direction2)==direction.canTurn(direction2));
			}
		}
	}

}
