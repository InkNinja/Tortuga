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
import model.game.ships.Faction;

public class GameMoveTest {

	IShipCollectionMaker maker;
	Game game;
	
	@Test
	public void simpleMoveTest() throws IllegalFieldException, IllegalShipUncover, FirstTurnExpectedException, ShipCollectionIsEmpty, NoShipToMoveException, IllegalTurnException, NotYourShipException, OutOfBoardMoveException, FriendlyFireException, IllegalMoveDirection {
		maker = new ShipCollectionCustomMaker().add(2, true).add(3, false);
		game = new Game(maker,Faction.LOYALISTS);
		game.uncover(new Point(1,2));
		game.turn(new Point(1,2), SimpleDirection.EAST);
		game.move(new Point(1,2), ComplexDirection.SOUTHEAST);
	}

}
