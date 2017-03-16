package ships;

import directions.Direction;

public class BigShip extends AbstractShip{

	public BigShip(Faction side) {
		super(side);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Direction main, Direction secondary) {
		if(Direction.ifProper(main, secondary))
		{
			return face == main || face == secondary;
		}
		else
		{
			return face == main && face == secondary;
		}
	}

}
