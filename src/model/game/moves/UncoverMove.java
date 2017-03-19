package model.game.moves;

import java.awt.Point;
import java.util.LinkedList;

import model.game.board.Game;
import model.game.exceptions.IllegalFieldException;
import model.game.exceptions.IllegalShipUncover;

public class UncoverMove extends AbstractMove{

	public UncoverMove(Point field)
	{
		this.field = field;
	}
	
	@Override
	public LinkedList<Point> makeMove(Game game) throws IllegalFieldException, IllegalShipUncover {
		game.uncover(field);
		LinkedList<Point> list = new LinkedList<Point>();
		list.add(field);
		return list;
	}

}
