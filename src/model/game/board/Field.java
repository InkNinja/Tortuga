package model.game.board;

import java.awt.Point;

import model.game.directions.ComplexDirection;
import model.game.directions.SimpleDirection;
import model.game.exceptions.IllegalShipUncover;
import model.game.exceptions.IllegalTurnException;
import model.game.exceptions.NoShipToMoveException;
import model.game.ship_collection.ShipCollection;
import model.game.ships.AbstractShip;

public class Field{
	
	AbstractShip ship;
	boolean fog;	
	
	Field(){
		ship = null;
		fog = true;
	}
	
	public void updateShip(AbstractShip ship)
	{
		this.ship = ship;
	}
	
	public void uncover(ShipCollection collection) throws IllegalShipUncover{
		if(!fog || ship!=null)
			throw new IllegalShipUncover();
		fog = false;
		ship = collection.getShip();
	}
	
	public void turnShip(SimpleDirection target) throws NoShipToMoveException, IllegalTurnException{
		if(ship==null)
			throw new NoShipToMoveException();
		if(ship.canTurn(target))
			ship.face = target;
		else
			throw new IllegalTurnException();
	}
	
	public void firstTurnShip(SimpleDirection target){
		ship.face = target;
	}
	
	public Point getMove(ComplexDirection target) throws NoShipToMoveException{
		if(ship==null)
			throw new NoShipToMoveException();
		return target.getMove();
	}
	
}	