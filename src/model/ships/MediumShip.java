package model.ships;

import controller.directions.Direction;
import controller.directions.IllegalDirection;

public class MediumShip extends AbstractShip{

	public MediumShip(Faction side) {
		super(side);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Direction main, Direction secondary) throws IllegalDirection {
		try{
			Direction.ifProper(main, secondary);
			return face == main || face == secondary;
		}
		catch(IllegalDirection e)
		{
			if(main != secondary)
				throw e;
			else
				return false;
		}
	}

}
