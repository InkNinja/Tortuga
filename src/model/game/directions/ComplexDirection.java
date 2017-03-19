package model.game.directions;

import java.awt.Point;

public enum ComplexDirection{
	
	NORTH(SimpleDirection.NORTH,null),
	WEST(null,SimpleDirection.WEST),
	SOUTH(SimpleDirection.SOUTH,null),
	EAST(null,SimpleDirection.EAST),
	NORTHWEST(SimpleDirection.NORTH,SimpleDirection.WEST),
	NORTHEAST(SimpleDirection.NORTH,SimpleDirection.EAST),
	SOUTHEAST(SimpleDirection.SOUTH,SimpleDirection.EAST),
	SOUTHWEST(SimpleDirection.SOUTH,SimpleDirection.WEST);
	
	
	public SimpleDirection main,secondary;
	public boolean simple;
	
	private ComplexDirection(SimpleDirection main,SimpleDirection secondary) {
		this.main = main;
		this.secondary = secondary;
		this.simple = (main == null || secondary == null);
	}
	
	public Point getMove(){
		int y = (main==null)?0:main.value;
		int x = (secondary==null)?0:secondary.value;
		return new Point(x,y);
	}
	
	public boolean contain(SimpleDirection direction){
		return main == direction || secondary == direction;
	}
	
	public static ComplexDirection toComplex(SimpleDirection direction)
	{
		switch(direction)
		{
		case EAST:
			return EAST;
		case NORTH:
			return NORTH;
		case SOUTH:
			return SOUTH;
		case WEST:
			return WEST;		
		}
		return null;
	}
}
