/*This page explains the concept of induction.*/

/*It may be worthwhile to animate this page where if a link turns on then it's line moves to go straight (or if broken in the wrong direction)*/

package base.state.expPages;

import base.state.*;
import base.state.menu.PuzMenu;
import base.state.puzzles.LogicAndPuz;
import java.awt.Graphics;
import java.awt.Color;

import base.state.puzzles.pieces.Pieces;
import base.state.puzzles.pieces.SourcePiece;
import base.state.puzzles.pieces.InductionPiece;

public class InductionExp extends State {
	private Pieces[] pieces;
	
	public InductionExp(int w, int h) {
		super(w,h);
		pieces = new Pieces[28];
		
		pieces[0] = new SourcePiece(150,150,false,1);
		pieces[1] = new SourcePiece(150,210,false,1);
		pieces[2] = new SourcePiece(150,270,false,1);
		pieces[3] = new SourcePiece(150,330,false,0);
		pieces[4] = new InductionPiece(250,150,1,0xf7f30a);
		pieces[5] = new InductionPiece(350,150,1,0xf7f30a);
		pieces[6] = new InductionPiece(450,150,1,0xf7f30a);
		pieces[7] = new InductionPiece(550,150,1,0xf7f30a);
		pieces[8] = new InductionPiece(650,150,1,0xf7f30a);
		pieces[9] = new InductionPiece(750,150,1,0xf7f30a);
		pieces[10] = new InductionPiece(250,210,1,0xf7f30a);
		pieces[11] = new InductionPiece(350,210,1,0xf7f30a);
		pieces[12] = new InductionPiece(450,210,1,0xf7f30a);
		pieces[13] = new InductionPiece(550,210,0,0xf7f30a);
		pieces[14] = new InductionPiece(650,210,1,0x222333);
		pieces[15] = new InductionPiece(750,210,0,0x222333);
		pieces[16] = new InductionPiece(250,270,0,0xf7f30a);
		pieces[17] = new InductionPiece(350,270,1,0x222333);
		pieces[18] = new InductionPiece(450,270,1,0x222333);
		pieces[19] = new InductionPiece(550,270,1,0x222333);
		pieces[20] = new InductionPiece(650,270,1,0x222333);
		pieces[21] = new InductionPiece(750,270,1,0x222333);
		pieces[22] = new InductionPiece(250,330,1,0x222333);
		pieces[23] = new InductionPiece(350,330,1,0x222333);
		pieces[24] = new InductionPiece(450,330,1,0x222333);
		pieces[25] = new InductionPiece(550,330,1,0x222333);
		pieces[26] = new InductionPiece(650,330,1,0x222333);
		pieces[27] = new InductionPiece(750,330,1,0x222333);
	}
	
	@Override
	public void render(int keepTime) {
		Square(100,50,1000,500,0xb38f60);
		Square(130,510,100,30,0x123456);
		Square(980,510,100,30,0x123456);
		
		drawLnOn(keepTime, 260,165,160,165);
		drawLnOn(keepTime, 360,165,260,165);
		drawLnOn(keepTime, 460,165,360,165);
		drawLnOn(keepTime, 560,165,460,165);
		drawLnOn(keepTime, 660,165,560,165);
		drawLnOn(keepTime, 760,165,660,165);
		drawLnOn(keepTime, 860,165,760,165);
		
		drawLnOn(keepTime, 260,225,160,225);
		drawLnOn(keepTime, 360,225,260,225);
		drawLnOn(keepTime, 460,225,360,225);
		drawLnOn(keepTime, 560,235,460,225);
		drawLnOn(keepTime, 590,210,560,235);
		drawLn(760,235,660,225);
		drawLn(790,210,760,235);
		
		drawLnOn(keepTime, 260,295,160,285);
		drawLnOn(keepTime, 290,270,260,295);
		drawLn(460,285,360,285);
		drawLn(560,285,460,285);
		drawLn(660,285,560,285);
		drawLn(760,285,660,285);
		drawLn(860,285,760,285);
		
		drawLn(260,345,160,345);
		drawLn(360,345,260,345);
		drawLn(460,345,360,345);
		drawLn(560,345,460,345);
		drawLn(660,345,560,345);
		drawLn(760,345,660,345);
		drawLn(860,345,760,345);
		
		for (int i = 0; i < pieces.length; i++) {
			pieces[i].draw();
		}
	}
	
	@Override
	public void write(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("Sometimes we wish to prove a sequence of statements, 1,2,3...", 150,100);
		g.drawString("It would take forever to prove every statement so instead we build a machine:", 150,120);
		g.drawString("We must check that in the maching there are no broken links. If there are broken links, well, you see what happens:", 150,140);
		g.drawString("Sometimes all the links work but one. Even if just one link doesn't work, this can cause serious problems:", 150,200);
		g.drawString("Finally, if all the links work but the source is off, it doesn't work at all!", 150,260);
		g.drawString("Our goal is to build a machine in which we check that the source is on and every link is straight.", 150,320);
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
	
	public void drawLn (int x0, int y0, int x1, int y1) {
		double t = 0;
		for (int i = 0; i < 1500; i++) {
			t = (double)i/1500;
			double x = (double)x0*(1-t)+(double)x1*t;
			double y = (double)y0*(1-t)+(double)y1*t;
			if (x < 1100 & x > 100 && y < 600 && y > 50) {
				pix[(int)x][(int)y] = 0xffffff;
				pix[(int)x+1][(int)y] = 0xffffff;
				pix[(int)x-1][(int)y] = 0xffffff;
				pix[(int)x][(int)y+1] = 0xffffff;
				pix[(int)x][(int)y-1] = 0xffffff;
			}
		}
	}
	
	public void drawLnOn (int timer, int x0, int y0, int x1, int y1) {
		double t = 0;
		for (int i = 0; i < 1500; i++) {
			t = (double)i/1500;
			double x = (double)x0*(1-t)+(double)x1*t;
			double y = (double)y0*(1-t)+(double)y1*t;
			if (x < 1100 & x > 100 && y < 600 && y > 50) {
				pix[(int)x][(int)y] = 0xffffff;
				pix[(int)x+1][(int)y] = 0xffffff;
				pix[(int)x-1][(int)y] = 0xffffff;
				pix[(int)x][(int)y+1] = 0xffffff;
				pix[(int)x][(int)y-1] = 0xffffff;
			}
			if ((i+4*timer)%120 == 0) {
				for(int j = -5; j < 5; j++) {
					for(int k = -5; k < 5; k++) {
						if(j*j+k*k < 5*5)
							pix[(int)x+j][(int)y+k] = 0xf7f30a;
					}
				}
			}
		}
	}
}