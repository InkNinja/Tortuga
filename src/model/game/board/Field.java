package model.game.board;

import java.awt.Point;

import model.game.directions.ComplexDirection;
import model.game.directions.SimpleDirection;
import model.game.exceptions.FriendlyFireException;
import model.game.exceptions.IllegalMoveDirection;
import model.game.exceptions.IllegalShipUncover;
import model.game.exceptions.IllegalTurnException;
import model.game.exceptions.NoShipToMoveException;
import model.game.exceptions.ShipCollectionIsEmpty;
import model.game.ship_collection.ShipCollection;
import model.game.ships.AbstractShip;

public class Field{
	
	public AbstractShip ship;
	public boolean fog;	
	
	Field(){
		ship = null;
		fog = true;
	}

	public void updateShip(AbstractShip ship) throws FriendlyFireException
	{
		if(this.ship == null || ship == null || this.ship.side!=ship.side)
			this.ship = ship;
		else
			throw new FriendlyFireException();
	}
	
	public void uncover(ShipCollection collection) throws IllegalShipUncover, ShipCollectionIsEmpty{
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
	
	public void firstTurnShip(SimpleDirection target) throws NoShipToMoveException{
		if(ship==null)
			throw new NoShipToMoveException();
		ship.face = target;
	}
	
	public Point getMove(ComplexDirection target) throws NoShipToMoveException, IllegalMoveDirection{
		if(ship==null)
			throw new NoShipToMoveException();
		if(!ship.canMove(target))
			throw new IllegalMoveDirection();
		return target.getMove();
	}
	
}	