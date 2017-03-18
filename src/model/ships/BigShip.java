package model.ships;

import controller.directions.ComplexDirection;

public class BigShip extends AbstractShip{

	public BigShip(Faction side) {
		super(side);
	}

	@Override
	public boolean canMove(ComplexDirection target) {
		return target.main == face;
	}
}
