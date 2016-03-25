/*This exposition page tells the players the goals for the first puzzle and the means to solve the puzzle.
The puzzle is to build a logical and gate from only or and not gates.*/

package base.state.expPages;

import base.state.*;
import base.state.menu.PuzMenu;
import base.state.puzzles.LogicDeMorganPuz;
import java.awt.Graphics;
import java.awt.Color;

public class LogicDeMorgansExp extends State {
	
	public LogicDeMorgansExp(int w, int h) {
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
		g.drawString("This is the \"De Morgan's logic\" puzzle!", 150,100);
		g.drawString("You will use a version of the logic calculator to explore how AND and OR gates relate.", 150,120);
		g.drawString("In the \"logical and\" puzzle you used De Morgan's law, though you may not have known it!", 150,140);
		g.drawString("Using only OR and NOT gates you were able to build and AND gate.", 150,160);
		g.drawString("In the following puzzle, you will be able to use the NOT operation freely.", 150,180);
		g.drawString("You will be asked to use the OR operation to build an AND operation or vice versa.", 150,200);
		g.drawString("This puzzle shows that you really only need the OR operation or the AND operation, but you do not need both.", 150,220);
		g.drawString("However, it is convenient to use both so we do not have to keep building one out of the other!", 150,240);
		g.drawString("De Morgan's is an important identity, so pay attention!", 150,260);
		g.drawString("Good luck!", 150,280);
		
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
			State s = new LogicDeMorganPuz();
			return s;
		}
		return this;
	}
}