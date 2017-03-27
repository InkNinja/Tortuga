package controller.game_controll;

import java.awt.Color;
import java.awt.Point;
import java.io.IOException;
import java.util.TreeMap;

import javax.swing.ImageIcon;

import model.game.board.Game;
import model.game.directions.ComplexDirection;
import model.game.directions.DirectionState;
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
import model.game.ship_collection.ShipCollectionStandardMaker;
import model.game.ships.Faction;
import model.sprites.LoadSprite;
import view.listeners_and_actions.DirectionPanelListener;
import view.listeners_and_actions.FieldPanelListener;
import view.listeners_and_actions.NewGameListener;
import view.params.Params;
import view.update.FieldUpdate;
import view.windows.MainWindow;

public class DefaultController {

	//TODO zmien controller na taki który inicjuje gre niezaleznie od jej trybu
	//dodaje funkcje wywo³ujace handlery
	//stworz handlery dla gry z czlowiekiem
	
	
	public MainWindow window;
	public Game model;
	
	public DefaultController(MainWindow window){
		this.window = window;
		DirectionPanelListener.game = this;
		FieldPanelListener.game = this;
		NewGameListener.game = this;
		FieldUpdate.game = this;
		model = new Game(ShipCollectionStandardMaker.STANDARD, Faction.LOYALISTS);
	}
	
	public void reset() throws IOException{
		window.reset();
		model = new Game(ShipCollectionStandardMaker.STANDARD,Faction.LOYALISTS);
	}
	
	
	
	public void FieldPressed(Point field) throws IllegalShipUncover, IOException, IllegalFieldException, FirstTurnExpectedException, ShipCollectionIsEmpty
	{		
		try{
			model.uncover(field);
			ImageIcon icon = LoadSprite.getSprite(model.getField(field).ship);
			Color color = model.getField(field).fog?Params.fieldFogBackground:Params.fieldClearBackground;
			window.gameView.activate(field);
			FieldUpdate data = new FieldUpdate(field,icon,color).getDirections();
			window.gameView.updateBoardPanel(data);
		}
		catch(IllegalShipUncover e){
			if(model.getField(field).ship!=null && model.getField(field).ship.side == model.getActiveFaction())
				window.gameView.activate(field);
		}
	}
	
	public void DirectionFieldPressed(Point field,ComplexDirection direction, DirectionState state) throws IllegalFieldException, NoShipToMoveException, OutOfBoardMoveException, FriendlyFireException, IllegalTurnException, IOException, FirstTurnExpectedException, IllegalMoveDirection, NotYourShipException{
		Point other = null;
		if(state == DirectionState.MOVE)
		{
			other = model.move(field, direction);		
		}
		else
		{
			model.turn(field, direction.getSimple());
		}
		window.gameView.desactivate(field);
		ImageIcon icon;
		if(model.getField(field).ship!=null)
			icon = LoadSprite.getSprite(model.getField(field).ship);
		else
			icon = null;
		Color color = model.getField(field).fog?Params.fieldFogBackground:Params.fieldClearBackground;
		FieldUpdate data = new FieldUpdate(field,icon,color).getDirections();
		window.gameView.updateBoardPanel(data);
		
		if(other!=null){
			if(model.getField(other).ship!=null)
				icon = LoadSprite.getSprite(model.getField(other).ship);
			else
				icon = null;
			color = model.getField(other).fog?Params.fieldFogBackground:Params.fieldClearBackground;
			data = new FieldUpdate(other,icon,color).getDirections();
			window.gameView.updateBoardPanel(data);
		}
		if(model.getWinner()!=null)
		{
			System.out.println(model.getWinner()+ " WON!");
			System.exit(0);
		}
	}
	
	public FieldUpdate addDirections(FieldUpdate data) throws IllegalFieldException{
		TreeMap<ComplexDirection,DirectionState> map = new TreeMap<ComplexDirection,DirectionState>();
		if(model.recentlyUncovered == data.field)
		{
			for(ComplexDirection direction: ComplexDirection.values()){
				DirectionState state = direction.simple?DirectionState.TURN:null;
				map.put(direction, state);
			}
		}
		else
		{
			if(model.getField(data.field).ship!=null)
				for(ComplexDirection direction: ComplexDirection.values()){
					if(model.getField(data.field).ship.canMove(direction))
					{
						map.put(direction, DirectionState.MOVE);
					}
					else
					{
						if(direction.simple &&
							model.getField(data.field).ship.canTurn(direction.getSimple())){
								map.put(direction, DirectionState.TURN);
							}
						else
							map.put(direction, null);
					}
				}
		}
		data.directionMap = map;
		return data;
	}
}
