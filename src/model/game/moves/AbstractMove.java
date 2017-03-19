package model.game.moves;

import java.awt.Point;
import java.util.LinkedList;

import model.game.board.Game;
import model.game.exceptions.FriendlyFireException;
import model.game.exceptions.IllegalFieldException;
import model.game.exceptions.IllegalShipUncover;
import model.game.exceptions.IllegalTurnException;
import model.game.exceptions.NoShipToMoveException;
import model.game.exceptions.OutOfBoardMoveException;



public abstract class AbstractMove {
	Point field;
	
	public abstract LinkedList<Point> makeMove(Game game) throws IllegalFieldException, IllegalShipUncover, NoShipToMoveException, IllegalTurnException, OutOfBoardMoveException, FriendlyFireException;
	
}
