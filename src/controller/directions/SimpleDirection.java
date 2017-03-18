package controller.directions;

public enum SimpleDirection{
	NORTH,EAST,SOUTH,WEST;
	
	private boolean ifMain(){
		if(this == NORTH)
			return true;
		if(this == SOUTH)
			return true;
		return false;
	}

	public boolean canTurn(ComplexDirection target){
		return target.simple && target.main.ifMain()!=this.ifMain();
	}
}

