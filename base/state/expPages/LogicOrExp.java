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

public class LogicOrExp extends State {
	
	private Pieces[] pieces;
	
	public LogicOrExp(int w, int h) {
		super(w,h);
		
		open(2);
		
		pieces = new Pieces[20];
		pieces[0] = new SourcePiece(150,150,false,0);
		pieces[1] = new SourcePiece(250,150,false,1);
		pieces[2] = new SourcePiece(600,300,false,0);
		pieces[3] = new SourcePiece(600,350,false,0);
		pieces[4] = new SourcePiece(600,400,false,1);
		pieces[5] = new SourcePiece(600,450,false,0);
		pieces[6] = new SourcePiece(800,300,false,0);
		pieces[7] = new SourcePiece(800,350,false,1);
		pieces[8] = new SourcePiece(800,400,false,1);
		pieces[9] = new SourcePiece(800,450,false,1);
		pieces[10] = new OrPiece(600,210);
		pieces[11] = new OrPiece(660,325);
		pieces[12] = new OrPiece(660,425);
		pieces[13] = new OrPiece(860,325);
		pieces[14] = new OrPiece(860,425);
		pieces[15] = new SinkPiece(150,260);
		pieces[16] = new SinkPiece(720,325);
		pieces[17] = new SinkPiece(720,425);
		pieces[18] = new SinkPiece(920,325);
		pieces[19] = new SinkPiece(920,425);
	}
	
	@Override
	public void render(int keepTime) {
		Square(100,50,1000,500,0xb38f60);
		Square(130,510,100,30,0x123456);
		
		drawLn(pieces[0].getX()+90,pieces[0].getY()+15,pieces[0].getX()+15,pieces[0].getY()+15,0x636773);
		drawLnOn(keepTime,pieces[1].getX()+90,pieces[1].getY()+15,pieces[1].getX()+15,pieces[1].getY()+15,0xffffff,0xf7f30a);
		
		drawLn(pieces[11].getX()+15,pieces[11].getY()+15,pieces[2].getX()+15,pieces[2].getY()+15,0x636773);
		drawLn(pieces[11].getX()+15,pieces[11].getY()+15,pieces[3].getX()+15,pieces[3].getY()+15,0x636773);
		drawLn(pieces[16].getX()+15,pieces[16].getY()+15,pieces[11].getX()+15,pieces[11].getY()+15,0x636773);
		
		drawLn(pieces[12].getX()+15,pieces[12].getY()+15,pieces[5].getX()+15,pieces[5].getY()+15,0x636773);
		drawLnOn(keepTime,pieces[12].getX()+15,pieces[12].getY()+15,pieces[4].getX()+15,pieces[4].getY()+15,0xffffff,0xf7f30a);
		drawLnOn(keepTime,pieces[17].getX()+15,pieces[17].getY()+15,pieces[12].getX()+15,pieces[12].getY()+15,0xffffff,0xf7f30a);
		
		drawLnOn(keepTime,pieces[13].getX()+15,pieces[13].getY()+15,pieces[7].getX()+15,pieces[7].getY()+15,0xffffff,0xf7f30a);
		drawLn(pieces[13].getX()+15,pieces[13].getY()+15,pieces[6].getX()+15,pieces[6].getY()+15,0x636773);
		drawLnOn(keepTime,pieces[18].getX()+15,pieces[18].getY()+15,pieces[13].getX()+15,pieces[13].getY()+15,0xffffff,0xf7f30a);
		
		drawLnOn(keepTime,pieces[14].getX()+15,pieces[14].getY()+15,pieces[8].getX()+15,pieces[8].getY()+15,0xffffff,0xf7f30a);
		drawLnOn(keepTime,pieces[14].getX()+15,pieces[14].getY()+15,pieces[9].getX()+15,pieces[9].getY()+15,0xffffff,0xf7f30a);
		drawLnOn(keepTime,pieces[19].getX()+15,pieces[19].getY()+15,pieces[14].getX()+15,pieces[14].getY()+15,0xffffff,0xf7f30a);
		
		for (int i = 0; i < pieces.length; i++) {
			pieces[i].draw();
		}
	}
	
	@Override
	public void write(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("Welcome to the \"inclusive or\" page. Part of your adventure is to solve several logical puzzles!", 150,100);
		g.drawString("You will first need to know about a SOURCE gate, which is a source of energy.", 150,120);
		g.drawString("This is a SOURCE gate:", 150,140);
		g.drawString("The red SOURCE is off and the yellow SOURCE is on.", 150,200);
		g.drawString("If a SOURCE is on then energy will flow through.", 150,220);
		g.drawString("This is a SINK:", 150,250);
		g.drawString("The SINK is always the last gate. It is the output.", 150,310);
		
		g.drawString("This is an OR gate:", 600,200);
		g.drawString("An OR gate will take two inputs and send out a charge", 600,260);
		g.drawString("if one input or the other is on, or both, as you see below:", 600,280);
		
		g.setColor(Color.RED);
		g.drawString("Important instructions!", 150,340);
		g.drawString("In a puzzle you can click and drag an OR gate around the screen.", 150,380);
		g.drawString("A single click will select the OR gate.", 150,400);
		g.drawString("You can then click on 2 other input gates.", 150,420);
		g.drawString("If you click on an OR gate a second time it will be deselected.", 150,440);
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
			State s = new PuzMenu(getWidth(), getHeight(),"You have opened the \"inclusive or\" path! Please select a puzzle.");
			return s;
		}
		return this;
	}
}