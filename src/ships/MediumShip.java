package ships;

import directions.Direction;

public class MediumShip extends AbstractShip{

	public MediumShip(Faction side) {
		super(side);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Direction main, Direction secondary) {
		return Direction.ifProper(main,secondary)
				&& (face == main || face == secondary);
	}

}
