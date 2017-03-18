package model.ships;

import controller.directions.ComplexDirection;

public class SmallShip extends AbstractShip{

	public SmallShip(Faction side) {
		super(side);
	}

	@Override
	public boolean canMove(ComplexDirection target) {
		return target.simple && target.main == face;
	}


}
