package model.game.directions;

public enum SimpleDirection{

	NORTH(1),EAST(1),SOUTH(-1),WEST(-1);
	
	public final int value;

	

	SimpleDirection(int value)
	{
		this.value = value;
	}
	
	private boolean ifMain(){
		if(this == NORTH)
			return true;
		if(this == SOUTH)
			return true;
		return false;
	}

	public boolean canTurn(SimpleDirection target){
		return target.ifMain()!=this.ifMain();
	}
}

