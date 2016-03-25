/*This exposition page tells the players the goals for this level 2 puzzle, building an xor gate from not and or gates.*/

package base.state.expPages;

import base.state.*;
import base.state.menu.PuzMenu;
import base.state.puzzles.NumberPuz;
import java.awt.Graphics;
import java.awt.Color;

import base.state.puzzles.pieces.Pieces;
import base.state.puzzles.pieces.SourcePiece;
import base.state.puzzles.pieces.SinkPiece;
import base.state.puzzles.pieces.XorPiece;

public class NumbersExp extends State {
	private Pieces[] pieces;
	
	public NumbersExp(int w, int h) {
		super(w,h);
	}
	
	@Override
	public void render(int keepTime) {
		Square(100,50,1000,500,0xb38f60);
		Square(130,510,100,30,0x123456);
		Square(980,510,100,30,0x123456);
	}
	
	@Override
	public void write(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("We are now ready to use our charges to create numbers!", 150,100);
		g.drawString("In the previous puzzle we used SOURCE and SINK gates to represent various numbers.", 150,120);
		g.drawString("In this puzzle you will see that with binary we can represent any number.", 150,140);
		g.drawString("You will be given 5 random numbers from 0 to 31.", 150,160);
		g.drawString("Your goal is to find the binary representation of the number.", 150,180);
		g.drawString("Once this puzzle is complete, you will have a representation of numbers using SOURCE and SINK gates!", 150,200);
		g.drawString("Do not forget to check the calculators to see what you have unlocked.", 150,220);
		g.drawString("Good luck!", 150,240);
		
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
			State s = new NumberPuz(getWidth(), getHeight());
			return s;
		}
		return this;
	}
}