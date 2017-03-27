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
import model.game.ships.Faction;

public class GameTurnTests {

	IShipCollectionMaker maker;
	Game game;
	
	@Test
	public void firstTurnTest() throws IllegalFieldException, IllegalShipUncover, FirstTurnExpectedException, ShipCollectionIsEmpty, NoShipToMoveException, IllegalTurnException, NotYourShipException {
		maker = new ShipCollectionCustomMaker().add(2, true).add(3, false);
		game = new Game(maker,Faction.LOYALISTS);
		game.uncover(new Point(1,2));
		game.turn(new Point(1,2), SimpleDirection.WEST);
		assertNull(game.recentlyUncovered);
	}
	
	@Test
	public void afterFirstTurnTest() throws IllegalFieldException, IllegalShipUncover, FirstTurnExpectedException, ShipCollectionIsEmpty, NoShipToMoveException, IllegalTurnException, NotYourShipException{
		maker = new ShipCollectionCustomMaker().add(2, true).add(3, false);
		game = new Game(maker,Faction.LOYALISTS);
		game.uncover(new Point(1,2));
		game.turn(new Point(1,2), SimpleDirection.WEST);
		try{
			game.turn(new Point(1,2), SimpleDirection.EAST);
			fail();
		}
		catch(IllegalTurnException e){
		}
		try{
			game.turn(new Point(1,2), SimpleDirection.WEST);
			fail();
		}
		catch(IllegalTurnException e){
		}
		game.turn(new Point(1,2), SimpleDirection.NORTH);
		assertEquals(game.getField(new Point(1,2)).ship.face,SimpleDirection.NORTH);
	}

	@Test
	public void noFirstTurnTest() throws IllegalFieldException, IllegalShipUncover, FirstTurnExpectedException, ShipCollectionIsEmpty, NoShipToMoveException, IllegalTurnException, NotYourShipException{
		maker = new ShipCollectionCustomMaker().add(2, true).add(3, false);
		game = new Game(maker,Faction.LOYALISTS);
		game.uncover(new Point(1,2));
		game.turn(new Point(1,2), SimpleDirection.WEST);
		game.uncover(new Point(1,3));
		try{
			game.turn(new Point(1,2), SimpleDirection.NORTH);
			fail();
		}
		catch(FirstTurnExpectedException e){
			assertNotEquals(game.getField(new Point(1,2)).ship.face,SimpleDirection.NORTH);
		}
	}

}
