package controller.directions;

public enum ComplexDirection{
	
	NORTH(SimpleDirection.NORTH,SimpleDirection.NORTH,true),
	WEST(SimpleDirection.WEST,SimpleDirection.WEST,true),
	SOUTH(SimpleDirection.SOUTH,SimpleDirection.SOUTH,true),
	EAST(SimpleDirection.EAST,SimpleDirection.EAST,true),
	NORTHWEST(SimpleDirection.NORTH,SimpleDirection.WEST,false),
	NORTHEAST(SimpleDirection.NORTH,SimpleDirection.EAST,false),
	SOUTHEAST(SimpleDirection.SOUTH,SimpleDirection.EAST,false),
	SOUTHWEST(SimpleDirection.SOUTH,SimpleDirection.WEST,false);
	
	
	public SimpleDirection main,secondary;
	public boolean simple;
	
	private ComplexDirection(SimpleDirection main,SimpleDirection secondary, boolean simple) {
		this.main = main;
		this.secondary = secondary;
		this.simple = simple;
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
