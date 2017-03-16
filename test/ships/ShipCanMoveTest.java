package ships;

import static org.junit.Assert.*;

import org.junit.Test;

import directions.Direction;

public class ShipCanMoveTest {

	BigShip big = new BigShip(Faction.PIRATES);
	MediumShip medium = new MediumShip(Faction.PIRATES);
	SmallShip small = new SmallShip(Faction.PIRATES);
	
	@Test
	public void smallMoveTest() {
		small.face = Direction.NORTH;
		assertFalse(small.canMove(Direction.NORTH, Direction.EAST));
		assertTrue(small.canMove(Direction.NORTH, Direction.NORTH));
	}
	
	@Test
	public void mediumMoveTest() {
		medium.face = Direction.NORTH;
		assertTrue(medium.canMove(Direction.NORTH, Direction.EAST));
		assertFalse(medium.canMove(Direction.NORTH, Direction.NORTH));
	}
	
	@Test
	public void bigMoveTest() {
		big.face  = Direction.NORTH;
		assertTrue(big.canMove(Direction.NORTH, Direction.EAST));
		assertTrue(big.canMove(Direction.NORTH, Direction.NORTH));
	}
}
