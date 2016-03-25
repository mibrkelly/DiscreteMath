/*This exposition page tells the players the goals for this level 2 puzzle, building an xor gate from not and or gates.*/

package base.state.expPages;

import base.state.*;
import base.state.menu.PuzMenu;
import base.state.puzzles.LogicAddTwoPuz;
import java.awt.Graphics;
import java.awt.Color;

import base.state.puzzles.pieces.Pieces;
import base.state.puzzles.pieces.SinkPiece;

public class LogicAddExp extends State {
	private Pieces[] pieces;
	
	public LogicAddExp(int w, int h) {
		super(w,h);
		pieces = new Pieces[2];
		pieces[0] = new SinkPiece(150,130);
		pieces[1] = new SinkPiece(200,130);
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
		g.drawString("In this puzzle you build a box that counts the number of sources that are on.", 150,100);
		g.drawString("The SINK pieces now have a numerical value:", 150,120);
		g.drawString("When a charge hits the SINK piece the SINK adds the value to the output.", 150,180);
		g.drawString("You goal is have the correct output whether 0, 1 or 2 sources are on.", 150, 200);
		g.drawString("Pay attention to the white output box at the lower right hand of the screen.", 150, 220);
		g.drawString("Good luck!", 150,240);
		
		g.setColor(Color.RED);
		g.drawString("+1", 155, 150);
		g.drawString("+2", 205,150);
		
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
			State s = new LogicAddTwoPuz(getWidth(), getHeight());
			return s;
		}
		return this;
	}
}