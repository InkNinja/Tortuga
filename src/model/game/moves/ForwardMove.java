package model.game.moves;

import java.awt.Point;
import java.util.LinkedList;

import model.game.board.Game;
import model.game.directions.ComplexDirection;
import model.game.exceptions.FriendlyFireException;
import model.game.exceptions.IllegalFieldException;
import model.game.exceptions.NoShipToMoveException;
import model.game.exceptions.OutOfBoardMoveException;

public class ForwardMove extends AbstractMove{

	ComplexDirection target;
	
	public ForwardMove(Point field, ComplexDirection target)
	{
		this.field = field;
		this.target = target;
	}
	
	@Override
	public LinkedList<Point> makeMove(Game game) throws IllegalFieldException, NoShipToMoveException, OutOfBoardMoveException, FriendlyFireException {
		Point attacked = game.move(field, target);
		LinkedList<Point> list = new LinkedList<Point>();
		list.add(field);
		list.add(attacked);
		return list;
	}
	
}
