package controller.viewConfig;

import java.awt.Color;
import java.awt.Dimension;

public final class Params {

	private final static int shipPanelSize = 80;
	private final static int directionPanelSize = 20;
	private final static int flagIconSize = 10;
	private static int fieldGapsSize = 10;
	private final static Color boardBackground = new Color(150,75,0);
	private final static int mainPanelWidth = 800;
	//private final static Color fogBackground;
	//private final static Color waterBackground;
	
	private static int fieldPanelSize(){
		return 2*directionPanelSize+shipPanelSize;
	}
	
	private static int boardPanelSize(){
		return 4*fieldPanelSize() + 3*fieldGapsSize;
	}
	
	public static Color getBoardBackground(){
		return boardBackground;
	}
	
	public static int scorePanelSize(){
		return 5*shipPanelSize + 4* fieldGapsSize;
	}
	
	public static int mainPanelWidth(){
		int width = shipPanelSize*2+boardPanelSize()+100;
		return mainPanelWidth>width?mainPanelWidth:width;
	}
	
	public static Dimension getMainWindowSize(){
		return new Dimension(mainPanelWidth(),mainPanelHeigth()+50);
	}
	
	public static Dimension getMainPanelSize(){
		return new Dimension(mainPanelWidth(),mainPanelHeigth());
	}
	
	public static int mainPanelHeigth(){
		return (8*directionPanelSize-shipPanelSize-fieldGapsSize>0?boardPanelSize():scorePanelSize());
	}
	
	public static Dimension getScorePanelSize(){
		return new Dimension(shipPanelSize,scorePanelSize());
	}
	
	public static Dimension getBoardPanelSize(){
		return new Dimension(boardPanelSize(),boardPanelSize());
	}
	
	public static int getfieldGapsSize(){
		return fieldGapsSize;
	}
	
	public static Dimension getShipPanelSize(){
		return new Dimension(shipPanelSize,shipPanelSize);
	}
	
	public static Dimension getDirectionPanelSize(){
		return new Dimension(directionPanelSize,directionPanelSize);
	}
	
	public static Dimension getFlagIconSize(){
		return new Dimension(flagIconSize,flagIconSize);
	}
	
	public static Dimension getFieldPanelSize(){
		return new Dimension(fieldPanelSize(),fieldPanelSize());
	}
	
	public static double getShipPanelWeight(){
		return shipPanelSize/fieldPanelSize();
	}
	
	public static double getDirectionPanelWeight()
	{
		return directionPanelSize/fieldPanelSize();
	}
	
}
