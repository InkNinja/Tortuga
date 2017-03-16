package directions;

import static org.junit.Assert.*;

import org.junit.Test;

import directions.Direction;
import ships.*;

public class DirectionTest {
	
	@Test
	public void turnTest() {
		assertEquals(Direction.EAST,Direction.NORTH.turnRight());
		assertEquals(Direction.WEST,Direction.NORTH.turnLeft());
	}
	
}
