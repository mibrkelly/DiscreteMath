/*This exposition page tells the players the goals for this level 2 puzzle, building an xor gate from not and or gates.*/

package base.state.expPages;

import base.state.*;
import base.state.menu.PuzMenu;
import base.state.puzzles.InjectivePuz;
import java.awt.Graphics;
import java.awt.Color;

public class InjectiveExp extends State {
	
	public InjectiveExp(int w, int h) {
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
		g.drawString("This is the injective functions puzzle.", 150,100);
		g.drawString("You can create a function by linking each point in the domain to a point in the range.", 150,120);
		g.drawString("An injective function maps each point in the domain to a different point in the range.", 150,140);
		g.drawString("Good luck!", 150,220);
		g.setColor(Color.RED);
		g.drawString("Important to note:", 150,160);
		g.drawString("A function must map each point in the domain to some point in the range.", 150,180);
		g.drawString("If you do not map a point in the domain to any point in the range then it is not a function!.", 150,200);
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
			State s = new InjectivePuz(getWidth(), getHeight());
			return s;
		}
		return this;
	}
}