package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.io.IOException;

import javax.swing.JPanel;

import view.params.Params;
import view.update.FieldUpdate;

public class BoardPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private final Dimension size = Params.getBoardPanelSize();
	private final int gapsSize = Params.getfieldGapsSize();
	private final Color background = Params.boardBackground;
	FieldPanel board[][];
	
	public BoardPanel() throws IOException{
		super();
		this.setSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setPreferredSize(size);
		GridLayout layout = new GridLayout(4,4);
		layout.setHgap(gapsSize);
		layout.setVgap(gapsSize);
		setLayout(layout);
		setBackground(background);
		board = new FieldPanel[4][4];
		for(int y = 0; y < 4 ;y++)
			for(int x = 0;x<4;x++)
			{
				board[x][y] = new FieldPanel(new Point(x,y));
				add(board[x][y]);
				if(x%3 == 0 && y%3 == 0)
				{
					view.update.FieldUpdate data = new view.update.FieldUpdate(new Point(x,y), null, Params.boardBackground);
					update(data);
				}
			}
	}
	
	public void update(FieldUpdate data) throws IOException{
		int x = data.field.x;
		int y = data.field.y;
		board[x][y].update(data);
	}
	
	public void activate(Point field){
		int x = field.x;
		int y = field.y;
		board[x][y].activate();
	}
	
	public void desactivate(Point field){
		int x = field.x;
		int y = field.y;
		board[x][y].desactivate();
	}
	
	
}
