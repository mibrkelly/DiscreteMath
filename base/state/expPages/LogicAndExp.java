/*This exposition page tells the players the goals for the first puzzle and the means to solve the puzzle.
The puzzle is to build a logical and gate from only or and not gates.*/

package base.state.expPages;

import base.state.*;
import base.state.menu.PuzMenu;
import base.state.puzzles.LogicAndPuz;
import java.awt.Graphics;
import java.awt.Color;

import base.state.puzzles.pieces.Pieces;
import base.state.puzzles.pieces.NotPiece;
import base.state.puzzles.pieces.SourcePiece;
import base.state.puzzles.pieces.SinkPiece;
import base.state.puzzles.pieces.AndPiece;

public class LogicAndExp extends State {
	private Pieces[] pieces;
	
	public LogicAndExp(int w, int h) {
		super(w,h);
		pieces = new Pieces[17];
		
		pieces[0] = new AndPiece(150,150);
		pieces[1] = new SourcePiece(650,200,false,0);
		pieces[2] = new SourcePiece(650,250,false,0);
		pieces[3] = new SourcePiece(650,300,false,1);
		pieces[4] = new SourcePiece(650,350,false,0);
		pieces[5] = new SourcePiece(850,200,false,0);
		pieces[6] = new SourcePiece(850,250,false,1);
		pieces[7] = new SourcePiece(850,300,false,1);
		pieces[8] = new SourcePiece(850,350,false,1);
		pieces[9] = new AndPiece(710,225);
		pieces[10] = new AndPiece(710,325);
		pieces[11] = new AndPiece(910,225);
		pieces[12] = new AndPiece(910,325);
		pieces[13] = new SinkPiece(770,225);
		pieces[14] = new SinkPiece(770,325);
		pieces[15] = new SinkPiece(970,225);
		pieces[16] = new SinkPiece(970,325);
	}
	
	@Override
	public void render(int keepTime) {
		Square(100,50,1000,500,0xb38f60);
		Square(130,510,100,30,0x123456);
		Square(980,510,100,30,0x123456);
		
		drawLn(pieces[9].getX()+15,pieces[9].getY()+15,pieces[1].getX()+15,pieces[1].getY()+15,0x636773);
		drawLn(pieces[9].getX()+15,pieces[9].getY()+15,pieces[2].getX()+15,pieces[2].getY()+15,0x636773);
		drawLn(pieces[13].getX()+15,pieces[13].getY()+15,pieces[9].getX()+15,pieces[9].getY()+15,0x636773);
		
		drawLn(pieces[10].getX()+15,pieces[10].getY()+15,pieces[4].getX()+15,pieces[4].getY()+15,0x636773);
		drawLnOn(keepTime,pieces[10].getX()+15,pieces[10].getY()+15,pieces[3].getX()+15,pieces[3].getY()+15,0xffffff,0xf7f30a);
		drawLn(pieces[14].getX()+15,pieces[14].getY()+15,pieces[10].getX()+15,pieces[10].getY()+15,0x636773);
		
		drawLnOn(keepTime,pieces[11].getX()+15,pieces[11].getY()+15,pieces[6].getX()+15,pieces[6].getY()+15,0xffffff,0xf7f30a);
		drawLn(pieces[11].getX()+15,pieces[11].getY()+15,pieces[5].getX()+15,pieces[5].getY()+15,0x636773);
		drawLn(pieces[15].getX()+15,pieces[15].getY()+15,pieces[11].getX()+15,pieces[11].getY()+15,0x636773);
		
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
		g.drawString("This is the \"logical and\" puzzle!", 150,100);
		g.drawString("In the introduction you saw SOURCE gates, SINK gates, NOT gates and OR gates.", 150,120);
		g.drawString("Your task is to use these to build the AND gate:", 150,140);
		g.drawString("In the puzzle you can turn on and off the sources by clicking on them.", 150,200);
		g.drawString("You can drag and drop all of the gates except the SOURCE/SINK gates.", 150,220);
		g.drawString("If you want to link one gate to other gates, first click on the gate", 150,240);
		g.drawString("you want to link and then click on the gates you want it to link to.", 150,260);
		g.drawString("To the right you see the funtion of the AND gate.", 150,280);
		g.drawString("Using the OR and NOT gates, build a system that functions the same way.", 150,300);
		g.drawString("Good luck!", 150,320);
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
			State s = new LogicAndPuz(getWidth(), getHeight());
			return s;
		}
		return this;
	}
}