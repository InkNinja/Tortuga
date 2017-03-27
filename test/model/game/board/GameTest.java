package model.game.board;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import model.game.directions.SimpleDirection;
import model.game.exceptions.FirstTurnExpectedException;
import model.game.exceptions.IllegalFieldException;
import model.game.exceptions.IllegalShipUncover;
import model.game.exceptions.IllegalTurnException;
import model.game.exceptions.NoShipToMoveException;
import model.game.exceptions.NotYourShipException;
import model.game.exceptions.ShipCollectionIsEmpty;
import model.game.ship_collection.IShipCollectionMaker;
import model.game.ship_collection.ShipCollectionCustomMaker;
import model.game.ship_collection.ShipCollectionStandardMaker;
import model.game.ships.Faction;

public class GameTest {

	IShipCollectionMaker maker;
	Game game;
	
	@Test
	public void initailTest() {
		maker = ShipCollectionStandardMaker.STANDARD;
		game = new Game(maker,Faction.LOYALISTS);
		int illegal=0;
		for(int x = 0;x<4;x++)
			for(int y = 0; y < 4; y++)
				try {
					game.getField(new Point(x,y));
				} catch (IllegalFieldException e) {
					illegal++;
					assertTrue(x==0 || x==3);
					assertTrue(y==0 || y==3);
				}
		assertEquals(illegal,4);
	}
	
	@Test
	public void getFieldTest() throws IllegalFieldException{
		maker = ShipCollectionStandardMaker.STANDARD;
		game = new Game(maker,Faction.LOYALISTS);
		game.getField(new Point(2,3)).fog = false;
		assertTrue(game.getField(new Point(1,2)).fog);
		assertFalse(game.getField(new Point(2,3)).fog);
	}	

	public void changeActiveFaction() throws IllegalFieldException, IllegalShipUncover, FirstTurnExpectedException, ShipCollectionIsEmpty, NoShipToMoveException, IllegalTurnException, NotYourShipException{
		maker = new ShipCollectionCustomMaker().add(2, true).add(3, false);
		game = new Game(maker,Faction.LOYALISTS);
		game.uncover(new Point(1,2));
		assertEquals(game.activeFaction,Faction.LOYALISTS);
		game.turn(new Point(1,2), SimpleDirection.EAST);
		assertEquals(game.activeFaction,Faction.PIRATES);
		game.uncover(new Point(2,1));
		assertEquals(game.activeFaction,Faction.PIRATES);
		game.turn(new Point(2,1), SimpleDirection.WEST);
		assertEquals(game.activeFaction,Faction.LOYALISTS);
		game.turn(new Point(2,1), SimpleDirection.NORTH);
		assertEquals(game.activeFaction,Faction.PIRATES);
	}
	
}
