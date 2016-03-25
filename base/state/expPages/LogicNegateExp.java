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

public class LogicNegateExp extends State {
	
	private Pieces[] pieces;
	
	public LogicNegateExp(int w, int h) {
		super(w,h);
		
		open(1);
		
		pieces = new Pieces[10];
		pieces[0] = new SourcePiece(150,150,false,0);
		pieces[1] = new SourcePiece(250,150,false,1);
		pieces[2] = new SourcePiece(600,290,false,0);
		pieces[3] = new SourcePiece(780,290,false,1);
		pieces[4] = new NotPiece(600,210);
		pieces[5] = new NotPiece(660,290);
		pieces[6] = new NotPiece(840,290);
		pieces[7] = new SinkPiece(150,260);
		pieces[8] = new SinkPiece(720,290);
		pieces[9] = new SinkPiece(900,290);
	}
	
	@Override
	public void render(int keepTime) {
		Square(100,50,1000,500,0xb38f60);
		Square(130,510,100,30,0x123456);
		
		drawLn(pieces[0].getX()+90,pieces[0].getY()+15,pieces[0].getX()+15,pieces[0].getY()+15,0x636773);
		drawLnOn(keepTime,pieces[1].getX()+90,pieces[1].getY()+15,pieces[1].getX()+15,pieces[1].getY()+15,0xffffff,0xf7f30a);
		drawLn(pieces[5].getX()+15,pieces[5].getY()+15,pieces[2].getX()+15,pieces[2].getY()+15,0x636773);
		drawLnOn(keepTime,pieces[8].getX()+15,pieces[8].getY()+15,pieces[5].getX()+15,pieces[5].getY()+15,0xffffff,0xf7f30a);
		drawLnOn(keepTime,pieces[6].getX()+15,pieces[6].getY()+15,pieces[3].getX()+15,pieces[3].getY()+15,0xffffff,0xf7f30a);
		drawLn(pieces[9].getX()+15,pieces[9].getY()+15,pieces[6].getX()+15,pieces[6].getY()+15,0x636773);
		
		for (int i = 0; i < pieces.length; i++) {
			pieces[i].draw();
		}
	}
	
	@Override
	public void write(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("Welcome to the \"logical negation\" page. Part of your adventure is to solve several logical puzzles!", 150,100);
		g.drawString("You will first need to know about a SOURCE gate, which is a source of energy.", 150,120);
		g.drawString("This is a SOURCE gate:", 150,140);
		g.drawString("The red SOURCE is off and the yellow SOURCE is on.", 150,200);
		g.drawString("If a SOURCE is on then energy will flow through.", 150,220);
		g.drawString("This is a SINK:", 150,250);
		g.drawString("The SINK is always the last gate in the puzzle. It is the output.", 150,310);
		
		g.drawString("This is a NOT gate:", 600,200);
		g.drawString("The NOT gate gives out the opposite of whatever it gets in.", 600,260);
		g.drawString("Here are examples with the NOT gate:", 600,280);
		
		g.setColor(Color.RED);
		g.drawString("Important instructions!", 150,340);
		g.drawString("In a puzzle you can click and drag a NOT gate around the screen.", 150,380);
		g.drawString("A single click will select the NOT gate.", 150,400);
		g.drawString("You can then click on another gate to be the input for the NOT gate.", 150,420);
		g.drawString("If you click on a NOT gate a second time it will be deselected.", 150,440);
		g.drawString("Use these gates to build new gates!", 150,480);
		g.drawString("Best of luck!", 150,500);
		
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
			State s = new PuzMenu(getWidth(), getHeight(),"You have opened the \"logical negate\" path! Please select a puzzle.");
			return s;
		}
		return this;
	}
}