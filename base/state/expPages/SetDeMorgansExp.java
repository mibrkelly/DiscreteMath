/*This exposition page tells the players the goals for the first puzzle and the means to solve the puzzle.
The puzzle is to build a logical and gate from only or and not gates.*/

package base.state.expPages;

import base.state.*;
import base.state.menu.PuzMenu;
import base.state.puzzles.SetDeMorganPuz;
import java.awt.Graphics;
import java.awt.Color;

public class SetDeMorgansExp extends State {
	
	public SetDeMorgansExp(int w, int h) {
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
		g.drawString("This is the \"set De Morgan's\" puzzle!", 150,100);
		g.drawString("You will be asked to find the set outside of A and B in two different ways.", 150,120);
		g.drawString("You will also be asked to find the set that does not include A intersect B in two different ways.", 150,140);
		g.drawString("One time you will you AND for each puzzle and the other time you will use OR.", 150,160);
		g.drawString("Note: The points common to A and B is the intersection of A and B.", 150,180);
		g.drawString("Good luck!", 150,200);
		
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
			State s = new SetDeMorganPuz();
			return s;
		}
		return this;
	}
}