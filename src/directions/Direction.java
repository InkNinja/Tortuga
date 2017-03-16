package directions;

public enum Direction {
	NORTH,EAST,SOUTH,WEST;
	
	private boolean ifMain(){
		if(this == NORTH)
			return true;
		if(this == SOUTH)
			return true;
		return false;
	}

	public static boolean ifProper(Direction main, Direction secondary)
	{
		return main.ifMain() && !secondary.ifMain();
	}

	public boolean canTurn(Direction target){
		return turnRight() == target || turnLeft()==target;
	}
	
	public Direction turnRight(){
		switch(this)
		{
		case NORTH: return EAST;
		case EAST: return SOUTH;
		case SOUTH: return WEST;
		default: return NORTH;
		}
	}
	
	public Direction turnLeft(){
		switch(this)
		{
		case NORTH: return WEST;
		case EAST: return NORTH;
		case SOUTH: return EAST;
		default: return SOUTH;
		}
	}
}

