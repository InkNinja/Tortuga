package model.game.moves;

import java.awt.Point;
import java.util.LinkedList;

import model.game.board.Game;
import model.game.directions.SimpleDirection;
import model.game.exceptions.IllegalFieldException;
import model.game.exceptions.IllegalTurnException;
import model.game.exceptions.NoShipToMoveException;

public class TurnMove extends AbstractMove{

	public SimpleDirection target;
	
	public TurnMove(Point field,SimpleDirection target)
	{
		this.field = field;
		this.target = target;
	}
	
	@Override
	public LinkedList<Point> makeMove(Game game) throws IllegalFieldException, NoShipToMoveException, IllegalTurnException {
		game.turn(field, target);
		LinkedList<Point> list = new LinkedList<Point>();
		list.add(field);
		return list;
	}

}
