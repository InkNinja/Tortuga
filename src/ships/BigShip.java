package ships;

import directions.Direction;
import directions.IllegalDirection;

public class BigShip extends AbstractShip{

	public BigShip(Faction side) {
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
			if (face == main && face == secondary)
				return true;
			else
			{
				if(main != secondary)
					throw e;
			}
		}
		return false;
	}

}
