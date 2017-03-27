package model.game.moves;

import java.awt.Point;
import java.util.LinkedList;

import model.game.board.Game;
import model.game.directions.SimpleDirection;
import model.game.exceptions.FirstTurnExpectedException;
import model.game.exceptions.IllegalFieldException;
import model.game.exceptions.IllegalTurnException;
import model.game.exceptions.NoShipToMoveException;
import model.game.exceptions.NotYourShipException;

public class TurnMove extends AbstractMove{

	public SimpleDirection target;
	
	public TurnMove(Point field,SimpleDirection target)
	{
		this.field = field;
		this.target = target;
	}
	
	@Override
	public LinkedList<Point> makeMove(Game game) throws IllegalFieldException, NoShipToMoveException, IllegalTurnException, FirstTurnExpectedException, NotYourShipException {
		game.turn(field, target);
		LinkedList<Point> list = new LinkedList<Point>();
		list.add(field);
		return list;
	}

}
