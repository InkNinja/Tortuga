package model.game.board;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import model.game.directions.ComplexDirection;
import model.game.directions.SimpleDirection;
import model.game.exceptions.FirstTurnExpectedException;
import model.game.exceptions.FriendlyFireException;
import model.game.exceptions.IllegalFieldException;
import model.game.exceptions.IllegalMoveDirection;
import model.game.exceptions.IllegalShipUncover;
import model.game.exceptions.IllegalTurnException;
import model.game.exceptions.NoShipToMoveException;
import model.game.exceptions.NotYourShipException;
import model.game.exceptions.OutOfBoardMoveException;
import model.game.exceptions.ShipCollectionIsEmpty;
import model.game.ship_collection.IShipCollectionMaker;
import model.game.ship_collection.ShipCollectionCustomMaker;
import model.game.ships.AbstractShip;
import model.game.ships.Faction;
import model.game.ships.MediumShip;

public class GameUncoverTest {

	IShipCollectionMaker maker;
	Game game;
	
	@Test
	public void properUncoverTest() throws IllegalFieldException, IllegalShipUncover, FirstTurnExpectedException, ShipCollectionIsEmpty{
		maker = new ShipCollectionCustomMaker().add(2, true).add(3, false);
		game = new Game(maker,Faction.LOYALISTS);
		game.uncover(new Point(1,2));
		assertFalse(game.getField(new Point(1,2)).fog);
		assertTrue(game.getField(new Point(2,3)).fog);
		assertNull(game.getField(new Point(2,3)).ship);
		assertEquals(game.getField(new Point(1,2)).ship.getClass(),MediumShip.class);
		assertEquals(game.recentlyUncovered,new Point(1,2));
	}
	
	@Test
	public void illegalUncoverTest() throws IllegalFieldException, IllegalShipUncover, FirstTurnExpectedException, ShipCollectionIsEmpty, NoShipToMoveException, IllegalTurnException, OutOfBoardMoveException, FriendlyFireException, IllegalMoveDirection, NotYourShipException{
		maker = new ShipCollectionCustomMaker().add(2, true).add(3, false);
		game = new Game(maker,Faction.LOYALISTS);
		game.uncover(new Point(1,2));
		game.turn(new Point(1,2), SimpleDirection.EAST);
		AbstractShip ship = game.getField(new Point(1,2)).ship;
		try{
			game.uncover(new Point(1,2));
			fail();
		}
		catch(IllegalShipUncover e){
			assertEquals(game.getField(new Point(1,2)).ship,ship);
		}
		game.move(new Point(1,2), ComplexDirection.SOUTHEAST);
		try{
			game.uncover(new Point(1,2));
			fail();
		}
		catch(IllegalShipUncover e){
		}
		try{
			game.uncover(new Point(2,3));
			fail();
		}
		catch(IllegalShipUncover e){
		}
		game.uncover(new Point(2,1));
	}
	
}
