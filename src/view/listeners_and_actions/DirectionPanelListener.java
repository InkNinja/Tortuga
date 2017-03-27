package view.listeners_and_actions;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import controller.game_controll.DefaultController;
import model.game.directions.ComplexDirection;
import model.game.directions.DirectionState;
import model.game.exceptions.FirstTurnExpectedException;
import model.game.exceptions.FriendlyFireException;
import model.game.exceptions.IllegalFieldException;
import model.game.exceptions.IllegalMoveDirection;
import model.game.exceptions.IllegalTurnException;
import model.game.exceptions.NoShipToMoveException;
import model.game.exceptions.NotYourShipException;
import model.game.exceptions.OutOfBoardMoveException;

public class DirectionPanelListener implements MouseListener{

	public Point field;
	public ComplexDirection direction;
	public DirectionState state;
	public static DefaultController game;
	private boolean active;
	
	public DirectionPanelListener(Point field,ComplexDirection direction){
		this.direction = direction;
		this.field = field;
		this.active = false;
		state = null;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {	
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if(state != null && active)
			try {
				game.DirectionFieldPressed(field, direction,state);
			} catch (IllegalFieldException | NoShipToMoveException | OutOfBoardMoveException | FriendlyFireException
					| IllegalTurnException | IOException | FirstTurnExpectedException | IllegalMoveDirection | NotYourShipException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
	}
	
	public void setActive(boolean active){
		this.active = active;
	}
}
