package model.game.exceptions;

public class ShipCollectionIsEmpty extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage(){
		return "FATAL ERROR: this should not be possible";
	}

}
