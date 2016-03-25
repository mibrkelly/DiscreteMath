/*This exposition page tells the players the goals for this level 2 puzzle, building an xor gate from not and or gates.*/

package base.state.expPages;

import base.state.*;
import base.state.menu.PuzMenu;
import base.state.puzzles.AddPuz;
import java.awt.Graphics;
import java.awt.Color;

import base.state.puzzles.pieces.Pieces;
import base.state.puzzles.pieces.SourcePiece;
import base.state.puzzles.pieces.SinkPiece;
import base.state.puzzles.pieces.IffPiece;

public class LogicAddPg3Exp extends State {
	private Pieces[] pieces;
	
	public LogicAddPg3Exp(int w, int h) {
		super(w,h);
		pieces = new Pieces[2];
		
		pieces[0] = new SourcePiece(150,150,false,0);
		pieces[1] = new SourcePiece(200,150,false,0);
	}
	
	@Override
	public void render(int keepTime) {
		Square(100,50,1000,500,0xb38f60);
		Square(130,510,100,30,0x123456);
		Square(980,510,100,30,0x123456);
		
		for (int i = 0; i < pieces.length; i++) {
			pieces[i].draw();
		}
	}
	
	@Override
	public void write(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("Congratulations! You can now use logic to count up to 3 sources!", 150,100);
		g.drawString("There is one puzzle yet to go before you have finished.", 150,120);
		g.drawString("In this puzzle the sources have numbers as follows:", 150,140);
		g.drawString("You must build a gate that counts the sum of all the charges.", 150,200);
		g.drawString("Good luck!", 150,340);
		
		g.setColor(Color.GREEN);
		g.drawString("+1", 160,170);
		g.drawString("+2", 210,170);
		
		g.setColor(Color.ORANGE);
		g.drawString("RETURN", 150,530);
		g.drawString("PUZZLE", 1000,530);
	}
	
	@Override
	public boolean clickedAt(int x, int y) {
		if (510 < y && y < 540 && ((130 < x && x < 230) || (355 < x && x < 455) || (980 < x && x < 1080))) {
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
			State s = new PuzMenu(getWidth(), getHeight());
			return s;
		}
		if (980 < x && x < 1080 && 510 < y && y < 540) {
			State s = new AddPuz(getWidth(), getHeight());
			return s;
		}
		return this;
	}
}