/*This exposition page tells the players the goals for this level 2 puzzle, building an xor gate from not and or gates.*/

package base.state.expPages;

import base.state.*;
import base.state.menu.PuzMenu;
import base.state.puzzles.OrderPuz;
import java.awt.Graphics;
import java.awt.Color;

import base.state.puzzles.pieces.Pieces;
import base.state.puzzles.pieces.ProofPiece;

public class OrderExp extends State {
	private Pieces[] pieces;
	
	public OrderExp(int w, int h) {
		super(w,h);
		pieces = new Pieces[4];
		
		pieces[0] = new ProofPiece(150,150,0x00ff00);
		pieces[1] = new ProofPiece(150,210,0xff0000);
		pieces[2] = new ProofPiece(230,210,0x0000ff);
		pieces[3] = new ProofPiece(310,210,0xffffff);
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
		g.drawString("Welcome to the order puzzle!", 150,100);
		g.drawString("Need to change this.", 150,120);
		
		g.setColor(Color.WHITE);
		g.drawString("+", 200, 230);
		g.drawString("->", 280,230);
		
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
			State s = new OrderPuz(getWidth(), getHeight());
			return s;
		}
		return this;
	}
}