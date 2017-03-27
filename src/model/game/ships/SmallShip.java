package model.game.ships;

import model.game.directions.ComplexDirection;

public class SmallShip extends AbstractShip{

	public SmallShip(Faction side) {
		super(side);
	}

	@Override
	public boolean canMove(ComplexDirection target) {
		return target.contain(face) && target.simple;
	}

	@Override
	public int value() {
		return 1;
	}


}
