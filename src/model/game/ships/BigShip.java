package model.game.ships;

import model.game.directions.ComplexDirection;

public class BigShip extends AbstractShip{

	public BigShip(Faction side) {
		super(side);
	}

	@Override
	public boolean canMove(ComplexDirection target) {
		return target.contain(face);
	}

	@Override
	public int value() {
		return 3;
	}
}
