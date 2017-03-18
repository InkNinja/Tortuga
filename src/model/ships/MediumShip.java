package model.ships;

import controller.directions.ComplexDirection;

public class MediumShip extends AbstractShip{

	public MediumShip(Faction side) {
		super(side);
	}

	@Override
	public boolean canMove(ComplexDirection target) {
		// ^ - xor
		return target.main == face ^ target.secondary == face;
			
	}

}
