package model.game.ships;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.game.directions.ComplexDirection;
import model.game.directions.SimpleDirection;

public class SmallShipTest {

	SmallShip ship;
	
	@Before
	public void prepare(){
		ship = new SmallShip(Faction.PIRATES);
	}
	
	@Test
	public void canMoveTest() {
		for(SimpleDirection face:SimpleDirection.values()){
			ship.turn(face);
			for(ComplexDirection target:ComplexDirection.values()){
				if(!target.simple){
					assertFalse(ship.canMove(target));
				}
				else
				{
					assertEquals((ship.face == target.getSimple()),ship.canMove(target));
				}
			}
		}
	}

}
