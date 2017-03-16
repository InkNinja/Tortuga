package ships;

import directions.Direction;

public class SmallShip extends AbstractShip{

	public SmallShip(Faction side) {
		super(side);
	}

	@Override
	public boolean canMove(Direction main, Direction secondary) {
		return main==secondary && main == face;
	}

}
