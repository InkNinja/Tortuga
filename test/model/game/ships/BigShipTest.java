package model.game.ships;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.game.directions.ComplexDirection;
import model.game.directions.SimpleDirection;

public class BigShipTest {

	BigShip ship;
	
	@Before
	public void prepare(){
		ship = new BigShip(Faction.PIRATES);
	}
	
	@Test
	public void canMoveTest() {
		for(SimpleDirection face:SimpleDirection.values()){
			ship.turn(face);
			for(ComplexDirection target:ComplexDirection.values()){
				assertEquals((target.contain(ship.face)),ship.canMove(target));
			}
		}
	}
}
