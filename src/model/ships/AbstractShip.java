package model.ships;

import controller.directions.*;

public abstract class AbstractShip {
	
	public String spriteName;
	public SimpleDirection face;
	public Faction side;
	
	public AbstractShip(Faction side){
		this.side = side;
		face = SimpleDirection.EAST;
		makeSpriteName();
	}
	
	public void makeSpriteName() {
		this.spriteName =  ".\\img\\"+this.getClass().getSimpleName().toLowerCase() + "_" + this.side.name().toLowerCase()+".png";
	}
	
	public String getSpriteName()
	{
		return spriteName;
	}
	
	public boolean canTurn(ComplexDirection target){
		return face.canTurn(target);
	}
	
	public void turn(SimpleDirection target){
		face = target;
	}

	public abstract boolean canMove(ComplexDirection target);
	
}
