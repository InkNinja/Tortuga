package model.game.board;

import java.awt.Point;
import java.util.LinkedList;
import java.util.TreeMap;

import model.game.directions.*;
import model.game.exceptions.*;
import model.game.ship_collection.ShipCollection;
import model.game.ship_collection.IShipCollectionMaker;
import model.game.ships.*;

public class Game {
	
	public ShipCollection ships;
	private Field board[][];
	public Point recentlyUncovered;
	private TreeMap<Faction,LinkedList<AbstractShip>>score;
	protected Faction activeFaction;
	
	public Faction getActiveFaction(){
		return activeFaction;
	}
	
	
	public Game(IShipCollectionMaker maker,Faction whoStarts){
		ships = new ShipCollection(maker);
		board = new Field[4][4];
		recentlyUncovered = null;
		activeFaction = whoStarts;
		score = new TreeMap<Faction,LinkedList<AbstractShip>>();
		score.put(Faction.LOYALISTS, new LinkedList<AbstractShip>());
		score.put(Faction.PIRATES, new LinkedList<AbstractShip>());
		for(int x = 0; x < 4; x++)
			for(int y =0; y < 4; y++)
				try{
					illegalTest(x,y);
					board[x][y]= new Field();
				}
				catch(IllegalFieldException e){	
					board[x][y]=null;
				}
	}
	
	public Field getField(Point field) throws IllegalFieldException{
		int x = field.x;
		int y = field.y;
		illegalTest(x,y);
		return board[x][y];
	}
	
	private void illegalTest(int x, int y) throws IllegalFieldException{
		if(x<0 || x>3 || y<0 || y > 3 || (x%3==0 && y%3 == 0))
			throw new IllegalFieldException();
	}
	
	public void uncover(Point field) throws 
													IllegalFieldException, 
													IllegalShipUncover, 
													FirstTurnExpectedException, 
													ShipCollectionIsEmpty{
		if(recentlyUncovered!=null)
			throw new FirstTurnExpectedException();		
		getField(field).uncover(ships);
		recentlyUncovered = field;
	}
	
	public void turn(Point field,SimpleDirection target) throws 
													IllegalFieldException, 
													NoShipToMoveException, 
													IllegalTurnException, 
													FirstTurnExpectedException, 
													NotYourShipException{
		if(field.equals(recentlyUncovered)){
			getField(field).firstTurnShip(target);
			recentlyUncovered = null;
			activeFaction = activeFaction.getEnemy();
			return;
		}
		if(recentlyUncovered!=null)
			throw new FirstTurnExpectedException();
		if(getField(field).ship!=null)
			if(getField(field).ship.side != activeFaction)
				throw new NotYourShipException();
		getField(field).turnShip(target);
		activeFaction = activeFaction.getEnemy();
	}
	
	private Point getNewPoint(Point oldPoint,ComplexDirection target) throws 
													IllegalFieldException, 
													NoShipToMoveException, 
													IllegalMoveDirection{
		Point newPoint = new Point(oldPoint);
		Point translate = getField(oldPoint).getMove(target);
		System.out.println(target);
		System.out.println(translate.x+ " "+translate.y);
		newPoint.translate(translate.x,translate.y);
		illegalTest(newPoint.x,newPoint.y);
		return newPoint;
	}
	
	public Point move(Point oldPoint,ComplexDirection target) throws 
													IllegalFieldException, 
													NoShipToMoveException, 
													OutOfBoardMoveException, 
													FriendlyFireException, 
													FirstTurnExpectedException, 
													IllegalMoveDirection, 
													NotYourShipException{
		if(getField(oldPoint).ship!=null)
			if(getField(oldPoint).ship.side != activeFaction)
				throw new NotYourShipException();
		if(recentlyUncovered!=null)
			throw new FirstTurnExpectedException();
		Point newPoint = getNewPoint(oldPoint,target);
		Field oldField = getField(oldPoint);
		Field newField = getField(newPoint);
		AbstractShip movingShip = oldField.ship;
		AbstractShip sunk = newField.ship;
		if(sunk != null)
			score.get(sunk.side.getEnemy()).addLast(sunk);
		oldField.updateShip(null);
		newField.updateShip(movingShip);
		activeFaction = activeFaction.getEnemy();
		System.out.println(oldPoint.x + " "+oldPoint.y);
		System.out.println(newPoint.x + " "+newPoint.y);
		return newPoint;
	}
	
	public Faction getWinner(){
		for(Faction faction : Faction.values()){
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
