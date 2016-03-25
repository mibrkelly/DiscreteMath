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

public class SetComplimentExp extends State {
	
	private Pieces[] pieces;
	private int xx;
	
	public SetComplimentExp(int w, int h) {
		super(w,h);
		open(3);
		xx = 150;
	}
	
	@Override
	public void render(int keepTime) {
		Square(100,50,1000,500,0xb38f60);
		Square(130,510,100,30,0x123456);
		
		xx = 130;
		
		Square(10+xx,125,400,325,0x000000);
		drawCirc(35+xx,150,100,0x777777);
		drawAnnulus(135+xx,250,100, 250, 0xff33aa);
		
		xx += 450;
		
		Square(10+xx,125,400,325,0x777777);
		drawCirc(35+xx,150,100,0x000000);
		drawAnnulus(135+xx,250,100, 250, 0xff33aa);
	}
	
	@Override
	public void write(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("Welcome to the \"compliment\" page. Part of your adventure is to solve several logical puzzles!", 150,70);
		g.drawString("You will use tools such as compliment to solve these puzzles.", 150,90);
		g.drawString("A set is contained in some universe of things. A sets compliment is everything in the universe that is not in the set.", 150,110);
		g.drawString("The set A is gray in this picture.", 150,480);
		g.drawString("The compliment of the set A is gray in this picture.", 590,480);
		g.drawString("Best of luck!", 150,500);
		
		g.setColor(Color.GREEN);
		xx = 130;
		g.drawString("A", 115+xx, 170);
		g.drawString("Universe", 20+xx, 140);
		xx += 450;
		g.drawString("A", 115+xx, 170);
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
			State s = new PuzMenu(getWidth(), getHeight(),"You have opened the \"compliment\" path! Please select a puzzle.");
			return s;
		}
		return this;
	}
}