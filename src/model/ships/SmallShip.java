package model.ships;

import controller.directions.Direction;
import controller.directions.IllegalDirection;

public class SmallShip extends AbstractShip{

	public SmallShip(Faction side) {
		super(side);
	}

	@Override
	public boolean canMove(Direction main, Direction secondary) throws IllegalDirection {
		if(main==secondary && main == face)
			return true;
		else
		{
			Direction.ifProper(main, secondary);
			return false;
		}
	}

}