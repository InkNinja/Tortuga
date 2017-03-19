package model.game.board;

import java.awt.Point;
import java.util.LinkedList;
import java.util.TreeMap;

import model.game.directions.ComplexDirection;
import model.game.directions.SimpleDirection;
import model.game.exceptions.FriendlyFireException;
import model.game.exceptions.IllegalFieldException;
import model.game.exceptions.IllegalShipUncover;
import model.game.exceptions.IllegalTurnException;
import model.game.exceptions.NoShipToMoveException;
import model.game.exceptions.OutOfBoardMoveException;
import model.game.ship_collection.ShipCollection;
import model.game.ship_collection.ShipCollectionAbstractMaker;
import model.game.ships.AbstractShip;
import model.game.ships.Faction;

public class Game {
	
	private ShipCollection ships;
	private Field board[][];
	private Point recentlyUncovered;
	private TreeMap<Faction,LinkedList<AbstractShip>>score;
	
	public Game(ShipCollectionAbstractMaker maker){
		ships = new ShipCollection(maker);
		board = new Field[4][4];
		recentlyUncovered = null;
		score = new TreeMap<Faction,LinkedList<AbstractShip>>();
		score.put(Faction.LOYALISTS, new LinkedList<AbstractShip>());
		score.put(Faction.PIRATES, new LinkedList<AbstractShip>());
		for(int x = 0; x < 4; x++)
		{
			for(int y =0; y < 4; y++)
			{
				if(!illegal(x,y))
				{
					board[x][y]= new Field();
				}
				else
				{
					board[x][y]=null;
				}
			}
		}
	}
	
	private Field getField(Point field){
		int x = field.x;
		int y = field.y;
		return board[x][y];
	}
	
	private boolean illegal(int x, int y){
		return x<0 || x>3 || y<0 || y > 3 || (x%3==0 && y%3 == 0);
	}
	
	public void uncover(Point field) throws IllegalFieldException, IllegalShipUncover{
		if(illegal(field.x,field.y))
			throw new IllegalFieldException();
		getField(field).uncover(ships);
		recentlyUncovered = field;
	}
	
	public void turn(Point field,SimpleDirection target) throws IllegalFieldException, NoShipToMoveException, IllegalTurnException{
		if(illegal(field.x,field.y))
			throw new IllegalFieldException();
		if(recentlyUncovered == field)
			getField(field).firstTurnShip(target);
		else
			getField(field).turnShip(target);
		recentlyUncovered = null;
	}
	
	public Point move(Point field,ComplexDirection target) throws IllegalFieldException, NoShipToMoveException, OutOfBoardMoveException, FriendlyFireException{
		Point newPoint = new Point(field);
		if(illegal(field.x,field.y))
			throw new IllegalFieldException();
		Field oldField = getField(field);
		Point translate = getField(field).getMove(target);
		int dx = translate.x;
		int dy = translate.y;
		newPoint.translate(dx, dy);
		if(illegal(newPoint.x,newPoint.y))
			throw new OutOfBoardMoveException();
		Field newField = getField(field);
		if(oldField.ship.side == newField.ship.side)
			throw new FriendlyFireException();
		AbstractShip ship = oldField.ship;
		AbstractShip sunk = newField.ship;
		score.get(sunk.side.getEnemy()).addLast(sunk);
		oldField.updateShip(null);
		newField.updateShip(ship);
		return newPoint;
	}
	
	public Faction getWinner()
	{
		for(Faction faction : Faction.values())
		{
			int points = 0;
			for(AbstractShip ship: score.get(faction)){
				points+=ship.value();
			}
			if(points>=7)
				return faction;
		}
		return null;
	}
	
}
