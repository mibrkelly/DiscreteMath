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

public class RelationsExp extends State {
	
	private Pieces[] pieces;
	
	public RelationsExp(int w, int h) {
		super(w,h);
		finEdge[11] = true;
		pieces = new Pieces[27];
		pieces[0] = new SourcePiece(150,150,false,0);
		pieces[1] = new SourcePiece(250,150,false,1);
		pieces[2] = new SourcePiece(150,430,false,0);
		pieces[3] = new SourcePiece(330,430,false,1);
		pieces[4] = new SourcePiece(600,300,false,0);
		pieces[5] = new SourcePiece(600,350,false,0);
		pieces[6] = new SourcePiece(600,400,false,1);
		pieces[7] = new SourcePiece(600,450,false,0);
		pieces[8] = new SourcePiece(800,300,false,0);
		pieces[9] = new SourcePiece(800,350,false,1);
		pieces[10] = new SourcePiece(800,400,false,1);
		pieces[11] = new SourcePiece(800,450,false,1);
		pieces[12] = new OrPiece(600,210);
		pieces[13] = new OrPiece(660,325);
		pieces[14] = new OrPiece(660,425);
		pieces[15] = new OrPiece(860,325);
		pieces[16] = new OrPiece(860,425);
		pieces[17] = new NotPiece(150,350);
		pieces[18] = new NotPiece(210,430);
		pieces[19] = new NotPiece(390,430);
		pieces[20] = new SinkPiece(150,260);
		pieces[21] = new SinkPiece(270,430);
		pieces[22] = new SinkPiece(450,430);
		pieces[23] = new SinkPiece(720,325);
		pieces[24] = new SinkPiece(720,425);
		pieces[25] = new SinkPiece(920,325);
		pieces[26] = new SinkPiece(920,425);
	}
	
	@Override
	public void render(int keepTime) {
		Square(100,50,1000,500,0xb38f60);
		Square(130,510,100,30,0x123456);
		
		drawLn(pieces[0].getX()+90,pieces[0].getY()+15,pieces[0].getX()+15,pieces[0].getY()+15,0x636773);
		drawLnOn(keepTime,pieces[1].getX()+90,pieces[1].getY()+15,pieces[1].getX()+15,pieces[1].getY()+15,0xffffff,0xf7f30a);
		drawLn(pieces[18].getX()+15,pieces[18].getY()+15,pieces[2].getX()+15,pieces[2].getY()+15,0x636773);
		drawLnOn(keepTime,pieces[21].getX()+15,pieces[21].getY()+15,pieces[18].getX()+15,pieces[18].getY()+15,0xffffff,0xf7f30a);
		drawLnOn(keepTime,pieces[19].getX()+15,pieces[19].getY()+15,pieces[3].getX()+15,pieces[3].getY()+15,0xffffff,0xf7f30a);
		drawLn(pieces[22].getX()+15,pieces[22].getY()+15,pieces[19].getX()+15,pieces[19].getY()+15,0x636773);
		
		drawLn(pieces[13].getX()+15,pieces[13].getY()+15,pieces[4].getX()+15,pieces[4].getY()+15,0x636773);
		drawLn(pieces[13].getX()+15,pieces[13].getY()+15,pieces[5].getX()+15,pieces[5].getY()+15,0x636773);
		drawLn(pieces[23].getX()+15,pieces[23].getY()+15,pieces[13].getX()+15,pieces[13].getY()+15,0x636773);
		
		drawLn(pieces[14].getX()+15,pieces[14].getY()+15,pieces[7].getX()+15,pieces[7].getY()+15,0x636773);
		drawLnOn(keepTime,pieces[14].getX()+15,pieces[14].getY()+15,pieces[6].getX()+15,pieces[6].getY()+15,0xffffff,0xf7f30a);
		drawLnOn(keepTime,pieces[24].getX()+15,pieces[24].getY()+15,pieces[14].getX()+15,pieces[14].getY()+15,0xffffff,0xf7f30a);
		
		drawLnOn(keepTime,pieces[15].getX()+15,pieces[15].getY()+15,pieces[9].getX()+15,pieces[9].getY()+15,0xffffff,0xf7f30a);
		drawLn(pieces[15].getX()+15,pieces[15].getY()+15,pieces[8].getX()+15,pieces[8].getY()+15,0x636773);
		drawLnOn(keepTime,pieces[25].getX()+15,pieces[25].getY()+15,pieces[15].getX()+15,pieces[15].getY()+15,0xffffff,0xf7f30a);
		
		drawLnOn(keepTime,pieces[16].getX()+15,pieces[16].getY()+15,pieces[10].getX()+15,pieces[10].getY()+15,0xffffff,0xf7f30a);
		drawLnOn(keepTime,pieces[16].getX()+15,pieces[16].getY()+15,pieces[11].getX()+15,pieces[11].getY()+15,0xffffff,0xf7f30a);
		drawLnOn(keepTime,pieces[26].getX()+15,pieces[26].getY()+15,pieces[16].getX()+15,pieces[16].getY()+15,0xffffff,0xf7f30a);
		
		for (int i = 0; i < pieces.length; i++) {
			pieces[i].draw();
		}
	}
	
	@Override
	public void write(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("Welcome to the game!", 150,100);
		g.drawString("You are going to learn a lot. The puzzles start simple but quickly get more elaborate.", 150,120);
		g.drawString("This is a source gate:", 150,140);
		g.drawString("The red source is off and the yellow source is on.", 150,200);
		g.drawString("If a source is on then energy will flow through.", 150,220);
		g.drawString("This is a sink:", 150,250);
		g.drawString("The sink is always the last gate. It reads the output.", 150,310);
		g.drawString("This is a not gate:", 150,340);
		g.drawString("The not gate gives the opposite of whatever it gets.", 150,400);
		g.drawString("Here are examples with the not gate:", 150,420);
		g.drawString("This is an or gate:", 600,200);
		g.drawString("An or gate will take two inputs and send out a charge", 600,260);
		g.drawString("if one input or the other is on, or both, as you see below:", 600,280);
		
		
		//g.drawString("The OR gate combines to links into one.", 150,200);
		//g.drawString("The following is a NOT gate:", 150,220);
		//g.drawString("The NOT gate will send out the opposite signal of whatever is coming in.", 150,260);
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
			State s = new PuzMenu(getWidth(), getHeight());
			return s;
		}
		return this;
	}
}