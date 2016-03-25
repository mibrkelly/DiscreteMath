/*This exposition page tells the players the goals for this level 2 puzzle, building an xor gate from not and or gates.*/

package base.state.expPages;

import base.state.*;
import base.state.menu.PuzMenu;
import base.state.puzzles.LogicIffPuz;
import java.awt.Graphics;
import java.awt.Color;

import base.state.puzzles.pieces.Pieces;
import base.state.puzzles.pieces.SourcePiece;
import base.state.puzzles.pieces.SinkPiece;
import base.state.puzzles.pieces.IffPiece;

public class LogicIffExp extends State {
	private Pieces[] pieces;
	
	public LogicIffExp(int w, int h) {
		super(w,h);
		pieces = new Pieces[17];
		
		pieces[0] = new IffPiece(150,150);
		pieces[1] = new SourcePiece(600,300,false,0);
		pieces[2] = new SourcePiece(600,350,false,0);
		pieces[3] = new SourcePiece(600,400,false,1);
		pieces[4] = new SourcePiece(600,450,false,0);
		pieces[5] = new SourcePiece(800,300,false,0);
		pieces[6] = new SourcePiece(800,350,false,1);
		pieces[7] = new SourcePiece(800,400,false,1);
		pieces[8] = new SourcePiece(800,450,false,1);
		pieces[9] = new IffPiece(660,325);
		pieces[10] = new IffPiece(660,425);
		pieces[11] = new IffPiece(860,325);
		pieces[12] = new IffPiece(860,425);
		pieces[13] = new SinkPiece(720,325);
		pieces[14] = new SinkPiece(720,425);
		pieces[15] = new SinkPiece(920,325);
		pieces[16] = new SinkPiece(920,425);
	}
	
	@Override
	public void render(int keepTime) {
		Square(100,50,1000,500,0xb38f60);
		Square(130,510,100,30,0x123456);
		Square(980,510,100,30,0x123456);
		
		drawLn(pieces[9].getX()+15,pieces[9].getY()+15,pieces[1].getX()+15,pieces[1].getY()+15,0x636773);
		drawLn(pieces[9].getX()+15,pieces[9].getY()+15,pieces[2].getX()+15,pieces[2].getY()+15,0x636773);
		drawLnOn(keepTime,pieces[13].getX()+15,pieces[13].getY()+15,pieces[9].getX()+15,pieces[9].getY()+15,0x636773,0xf7f30a);
		
		drawLn(pieces[10].getX()+15,pieces[10].getY()+15,pieces[4].getX()+15,pieces[4].getY()+15,0x636773);
		drawLnOn(keepTime,pieces[10].getX()+15,pieces[10].getY()+15,pieces[3].getX()+15,pieces[3].getY()+15,0xffffff,0xf7f30a);
		drawLn(pieces[14].getX()+15,pieces[14].getY()+15,pieces[10].getX()+15,pieces[10].getY()+15,0xffffff);
		
		drawLnOn(keepTime,pieces[11].getX()+15,pieces[11].getY()+15,pieces[6].getX()+15,pieces[6].getY()+15,0xffffff,0xf7f30a);
		drawLn(pieces[11].getX()+15,pieces[11].getY()+15,pieces[5].getX()+15,pieces[5].getY()+15,0x636773);
		drawLn(pieces[15].getX()+15,pieces[15].getY()+15,pieces[11].getX()+15,pieces[11].getY()+15,0xffffff);
		
		drawLnOn(keepTime,pieces[12].getX()+15,pieces[12].getY()+15,pieces[7].getX()+15,pieces[7].getY()+15,0xffffff,0xf7f30a);
		drawLnOn(keepTime,pieces[12].getX()+15,pieces[12].getY()+15,pieces[8].getX()+15,pieces[8].getY()+15,0xffffff,0xf7f30a);
		drawLnOn(keepTime,pieces[16].getX()+15,pieces[16].getY()+15,pieces[12].getX()+15,pieces[12].getY()+15,0xffffff,0xf7f30a);
		
		for (int i = 0; i < pieces.length; i++) {
			pieces[i].draw();
		}
	}
	
	@Override
	public void write(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("In this puzzle you will build an IFF gate.", 150,100);
		g.drawString("An IFF gate will let send a charge out if the input charges are the same.", 150,120);
		g.drawString("The IFF gate looks as follows:", 150,140);
		g.drawString("To the right you see how the IFF gate functions.", 150,200);
		g.drawString("Good luck!", 150,340);
		
		g.setColor(Color.RED);
		g.drawString("Information:", 150,240);
		g.drawString("IFF stands for \"if and only if\".", 150,260);
		g.drawString("To say \"A if and only if B\" is to combine two statements:", 150,280);
		g.drawString("\"If A then B\" and \"If B then A\"", 150,300);
		g.drawString("That is, we combine the AND and the IF gates to get IFF!", 150,320);
		
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
			State s = new LogicIffPuz(getWidth(), getHeight());
			return s;
		}
		return this;
	}
}