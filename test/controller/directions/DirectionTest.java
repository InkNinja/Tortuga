package controller.directions;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.directions.Direction;

public class DirectionTest {
	
	@Test
	public void turnTest() {
		assertEquals(Direction.EAST,Direction.NORTH.turnRight());
		assertEquals(Direction.WEST,Direction.NORTH.turnLeft());
	}

	
}