package model.game.directions;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class DirectionTest {
	
	
	@Test
	public void simpleDirectionTurnTest() {
		assertTrue(SimpleDirection.EAST.canTurn(SimpleDirection.NORTH));
		assertTrue(SimpleDirection.EAST.canTurn(SimpleDirection.SOUTH));
		assertTrue(SimpleDirection.WEST.canTurn(SimpleDirection.NORTH));
		assertTrue(SimpleDirection.WEST.canTurn(SimpleDirection.SOUTH));
		assertTrue(SimpleDirection.NORTH.canTurn(SimpleDirection.EAST));
		assertTrue(SimpleDirection.NORTH.canTurn(SimpleDirection.WEST));
		assertTrue(SimpleDirection.SOUTH.canTurn(SimpleDirection.EAST));
		assertTrue(SimpleDirection.SOUTH.canTurn(SimpleDirection.WEST));
		
		assertFalse(SimpleDirection.EAST.canTurn(SimpleDirection.EAST));
		assertFalse(SimpleDirection.EAST.canTurn(SimpleDirection.WEST));
		assertFalse(SimpleDirection.WEST.canTurn(SimpleDirection.EAST));
		assertFalse(SimpleDirection.WEST.canTurn(SimpleDirection.WEST));
		assertFalse(SimpleDirection.NORTH.canTurn(SimpleDirection.SOUTH));
		assertFalse(SimpleDirection.NORTH.canTurn(SimpleDirection.NORTH));
		assertFalse(SimpleDirection.SOUTH.canTurn(SimpleDirection.SOUTH));	
		assertFalse(SimpleDirection.SOUTH.canTurn(SimpleDirection.NORTH));
	}
	
	@Test
	public void complexDirectionGetMoveTest(){
		assertEquals(ComplexDirection.EAST.getMove(),new Point(1,0));
		assertEquals(ComplexDirection.WEST.getMove(),new Point(-1,0));
		assertEquals(ComplexDirection.NORTH.getMove(),new Point(0,-1));
		assertEquals(ComplexDirection.SOUTH.getMove(),new Point(0,1));
		assertEquals(ComplexDirection.NORTHEAST.getMove(),new Point(1,-1));
		assertEquals(ComplexDirection.NORTHWEST.getMove(),new Point(-1,-1));
		assertEquals(ComplexDirection.SOUTHEAST.getMove(),new Point(1,1));
		assertEquals(ComplexDirection.SOUTHWEST.getMove(),new Point(-1,1));
	}

	@Test
	public void complexDirectionIsSimpleTest(){
		assertTrue(ComplexDirection.EAST.simple);
		assertTrue(ComplexDirection.WEST.simple);
		assertTrue(ComplexDirection.NORTH.simple);
		assertTrue(ComplexDirection.SOUTH.simple);
		assertFalse(ComplexDirection.NORTHEAST.simple);
		assertFalse(ComplexDirection.NORTHWEST.simple);
		assertFalse(ComplexDirection.SOUTHEAST.simple);
		assertFalse(ComplexDirection.SOUTHWEST.simple);
	}
	
	@Test
	public void complexToSimpleTest(){
		for(ComplexDirection direction: ComplexDirection.values())
		{
			if(direction.simple)
			{
				assertNotNull(direction.getSimple());
			}
			else
			{
				assertNull(direction.getSimple());
			}
		}
	}
	
}
