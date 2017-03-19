package model.game.ships;

public enum Faction {
	PIRATES,LOYALISTS;
	
	public Faction getEnemy(){
		return this==PIRATES?LOYALISTS:PIRATES;
	}
}
