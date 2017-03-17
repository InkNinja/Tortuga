package controller.directions;

public class IllegalDirection extends Exception{

	Direction main;
	Direction secondary;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IllegalDirection(Direction main,Direction secondary){
		this.main = main;
		this.secondary = secondary;
	}
	
	public String getMessage(){
		return super.getMessage()+"Illegal direction "+main.toString()+" "+secondary.toString()+"\n";
	}
	
}
