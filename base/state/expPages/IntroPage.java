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

public class IntroPage extends State {
	
	private Pieces[] pieces;
	
	public IntroPage(int w, int h) {
		super(w,h);
	}
	
	@Override
	public void render(int keepTime) {
		Square(100,50,1000,500,0xb38f60);
		Square(130,510,100,30,0x123456);
	}
	
	@Override
	public void write(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("Welcome to the game!", 150,100);
		g.drawString("You are going to learn a lot.", 150,120);
		
		g.drawString("The next screen you will see is the puzzle screen.", 150,160);
		g.drawString("Click on an icon to attempt a puzzle.", 150,180);
		g.drawString("The first 5 icons are not puzzles but are informational.", 150,200);
		g.drawString("Read these carefully so that you can solve the puzzles!", 150,220);
		
		g.drawString("As you solve puzzles new paths will open.", 150,260);
		g.drawString("Pay attention to the text at the top of the screen.", 150,280);
		g.drawString("It tells your status.", 150,300);
		
		g.drawString("Remember: Have fun! Learn a lot!", 150,340);
		g.drawString("And God bless!", 150,360);
		
		g.setColor(Color.ORANGE);
		g.drawString("CONTINUE", 150,530);
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
			State s = new PuzMenu(getWidth(), getHeight());
			return s;
		}
		return this;
	}
}