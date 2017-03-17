package model.ships;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.directions.Direction;
import controller.directions.IllegalDirection;
import model.ships.BigShip;
import model.ships.Faction;
import model.ships.MediumShip;
import model.ships.SmallShip;

public class ShipCanMoveTest {

	BigShip big = new BigShip(Faction.PIRATES);
	MediumShip medium = new MediumShip(Faction.PIRATES);
	SmallShip small = new SmallShip(Faction.PIRATES);
	
	@Test
	public void smallMoveTest() throws IllegalDirection {
		small.face = Direction.NORTH;
		assertFalse(small.canMove(Direction.NORTH, Direction.EAST));
		assertTrue(small.canMove(Direction.NORTH, Direction.NORTH));
	}
	
	@Test
	public void mediumMoveTest() throws IllegalDirection {
		medium.face = Direction.NORTH;
		assertTrue(medium.canMove(Direction.NORTH, Direction.EAST));
		assertFalse(medium.canMove(Direction.NORTH, Direction.NORTH));
	}
	
	@Test
	public void bigMoveTest() throws IllegalDirection {
		big.face  = Direction.NORTH;
		assertTrue(big.canMove(Direction.NORTH, Direction.EAST));
		assertTrue(big.canMove(Direction.NORTH, Direction.NORTH));
	}
}
