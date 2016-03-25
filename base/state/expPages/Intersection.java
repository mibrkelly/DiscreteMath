/*This is the first exposition page. It is an introduction to the game.*/

package base.state.expPages;

import base.state.*;
import base.state.menu.PuzMenu;
import java.awt.Graphics;
import java.awt.Color;
import base.state.puzzles.pieces.Pieces;
import base.state.puzzles.pieces.OrPiece;
import base.state.puzzles.pieces.NotPiece;
import base.state.puzzles.pieces.SourcePiece;
import base.state.puzzles.pieces.SinkPiece;

public class Intersection extends State {
	
	private Pieces[] pieces;
	private int xx;
	
	public Intersection(int w, int h) {
		super(w,h);
		open(4);
		xx = 150;
	}
	
	@Override
	public void render(int keepTime) {
		Square(100,50,1000,500,0xb38f60);
		Square(130,510,100,30,0x123456);
		
		Square(10+xx,125,400,325,0x000000);
		drawCirc(35+xx,150,100,0x000000);
		drawCirc(160+xx,150,100,0x000000);
		drawAnnulus(135+xx,250,100, 250, 0xff33aa);
		drawAnnulus(260+xx,250,100,250, 0xff33aa);
		for(int i = 35; i < 360; i++) {
			for(int j = 150; j < 425; j++) {
				if ((i-135)*(i-135)+(j-250)*(j-250) < 100*100 && (i-260)*(i-260)+(j-250)*(j-250) < 100*100 && (i-200)*(i-200)+(j-325)*(j-325) < 100*100)
					pix[i+xx][j] = 0x777777;
			}
		}
		for(int i = 35; i < 360; i++) {
			for(int j = 150; j < 425; j++) {
				if ((i-135)*(i-135)+(j-250)*(j-250) < 100*100 && (i-260)*(i-260)+(j-250)*(j-250) < 100*100 && (i-200)*(i-200)+(j-325)*(j-325) > 100*100)
					pix[i+xx][j] = 0x777777;
			}
		}
	}
	
	@Override
	public void write(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("Welcome to the \"intersection\" page. Part of your adventure is to solve several logical puzzles!", 150,80);
		g.drawString("One of the tools you will use to solve these puzzles is set intersection.", 150,100);
		g.drawString("The intersection of A and B is the set of elements common to both A and B.", 150,480);
		g.drawString("Best of luck!", 150,500);
		
		g.setColor(Color.GREEN);
		g.drawString("A", 115+xx, 170);
		g.drawString("B", 280+xx, 170);
		g.drawString("Universe", 20+xx, 140);

		g.setColor(Color.ORANGE);
		g.drawString("RETURN", 150,530);
	}
	
	@Override
	public boolean clickedAt(int x, int y) {
		if (130 < x && x < 230 && 510 < y && y < 540) {
			return true;
		}
		return false;
	}
	
	@Override
	public void pressedAt(int x, int y) {
		
	}
		
	@Override
	public void draggedTo(int x, int y) {
		
	}
	
	@Override
	public void released() {
	}
	
	@Override
	public State whichState(int x, int y) {
		if (130 < x && x < 230 && 510 < y && y < 540) {
			State s = new PuzMenu(getWidth(), getHeight(),"You have opened the \"intersection\" path! Please select a puzzle.");
			return s;
		}
		return this;
	}
}