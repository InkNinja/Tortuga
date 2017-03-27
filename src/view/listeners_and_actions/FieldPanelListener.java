package view.listeners_and_actions;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import controller.game_controll.DefaultController;
import model.game.exceptions.FirstTurnExpectedException;
import model.game.exceptions.IllegalFieldException;
import model.game.exceptions.IllegalShipUncover;
import model.game.exceptions.ShipCollectionIsEmpty;

public class FieldPanelListener implements MouseListener{

	public Point field;
	public static DefaultController game;
	
	public FieldPanelListener(Point field)
	{
		this.field = field;
	}

	@Override
	public void mouseClicked(MouseEvent e) {		
	}

	@Override
	public void mouseEntered(MouseEvent e) {	
	}

	@Override
	public void mouseExited(MouseEvent e) {		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		try {
			game.FieldPressed(field);
		} catch (IllegalShipUncover | IOException | IllegalFieldException | FirstTurnExpectedException
				| ShipCollectionIsEmpty e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
	}
	

}
