package model.ships;

import controller.directions.*;

public abstract class AbstractShip {
	
	public String spriteName;
	public Direction face;
	public Faction side;
	
	public AbstractShip(Faction side){
		this.side = side;
		face = Direction.EAST;
		makeSpriteName();
	}
	
	public void makeSpriteName() {
		this.spriteName =  ".\\img\\"+this.getClass().getSimpleName().toLowerCase() + "_" + this.side.name().toLowerCase()+".png";
	}
	
	public String getSpriteName()
	{
		return spriteName;
	}
	
	public boolean canTurn(Direction target){
		return face.canTurn(target);
	}
	
	public void turn(Direction target) throws CannotTurnException{
		if(face.canTurn(target))
		{
			face = target;
		}
		else
		{
			throw new CannotTurnException();
		}
	}

	public abstract boolean canMove(Direction main,Direction secondary) throws IllegalDirection;
	
}
