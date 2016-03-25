/*The first puzzle. The player must build a logical and from only or and not gates.*/

package base.state.puzzles;

import base.state.*;
import base.state.puzzles.pieces.*;
import base.state.expPages.ImpliesExp;
import base.state.menu.PuzMenu;
import java.awt.Graphics;
import java.awt.Color;

public class ImpliesPuz extends Puzzle {
	
	public ImpliesPuz(int w, int h) {
		super(w,h,9);
		
		pieces[0] = new SourcePiece(100,300);
		pieces[1] = new SourcePiece(100,550);
		pieces[2] = new OrPiece(130,100);
		pieces[3] = new OrPiece(170,100);
		pieces[4] = new OrPiece(210,100);
		pieces[5] = new NotPiece(250,100);
		pieces[6] = new NotPiece(290,100);
		pieces[7] = new NotPiece(330,100);
		pieces[8] = new SinkPiece(950,425);
		
		whichOpen = 7;
	}
	
	@Override
	public State whichState(int x, int y) {
		if (1050 < x && x < 1150 && 450 < y && y < 480 && solved) {
			State s = new PuzMenu(getWidth(),getHeight(),"You have solved the \"implies\" puzzle! Please continue!");
			return s;
		}
		if (1050 < x && x < 1150 && 450 < y && y < 480 && !solved) {
			State s = new PuzMenu(getWidth(),getHeight(),"Sorry, but your solution was incorrect. Please choose a puzzle.");
			return s;
		}
		if (1050 < x && x < 1150 && 450 < y && y < 480) {
			State s = new PuzMenu(getWidth(),getHeight());
			return s;
		}
		if (1050 < x && x < 1150 && 530 < y && y < 560) {
			State s = new ImpliesExp(getWidth(), getHeight());
			return s;
		}
		if (1050 < x && x < 1150 && 490 < y && y < 520) {
			State s = new ImpliesPuz(getWidth(), getHeight());
			return s;
		}
		return this;
	}
	
	@Override
	public void runCheck() {
		int b1 = pieces[0].getOut();
		int b2 = pieces[1].getOut();
		
		pieces[0].inputs[0] = 0;
		pieces[1].inputs[0] = 0;
		update();
		if (pieces[8].getOut() == 1) {
			pieces[0].inputs[0] = 1;
			pieces[1].inputs[0] = 0;
			update();
			if (pieces[8].getOut() == 0) {
				pieces[0].inputs[0] = 0;
				pieces[1].inputs[0] = 1;
				update();
				if (pieces[8].getOut() == 1) {
					pieces[0].inputs[0] = 1;
					pieces[1].inputs[0] = 1;
					update();
					if (pieces[8].getOut() == 1) {
						solved = true;
					}
				}
			}
		}
		
		pieces[0].inputs[0] = b1;
		pieces[1].inputs[0] = b2;
		update();
		
		checkingMode = false;
	}
	
	@Override
	public void render(int keepTime) {
		Square(50,50,950,550,0x000000);
		Square(1050,50,100,550,0xabebbe);
		Square(1050,530,100,30,0x123456);
		Square(1050,490,100,30,0x123456);		
		Square(1050,450,100,30,0x123456);
		Square(900,600,100,30,0xfffffff);
		Square(960,50,10,550,0xffffff);
		if (selectedMode) {
			Square(80,600,150,30,0x123456);
		}
		
		drawLn(115,400,115,480,0x00b000);
		drawLn(115,480,95,460,0x00b000);
		drawLn(115,480,135,460,0x00b000);
		
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces.length; j++) {
				if (edges[i][j] == 0) {
					drawLn(pieces[j].getX()+15,pieces[j].getY()+15,pieces[i].getX()+15,pieces[i].getY()+15,0x636773);
				}
				else if (edges[i][j] > 0) {
					drawLnOn(keepTime,pieces[j].getX()+15,pieces[j].getY()+15,pieces[i].getX()+15,pieces[i].getY()+15,0xffffff,0xf7f30a);
				}
			}
		}
		
		for (int i = 0; i < pieces.length; i++) {
			pieces[i].draw();
		}
	}
	
	@Override
	public void write (Graphics g) {
		super.write(g);
		g.setColor(Color.GREEN);
		g.drawString("A",110,320);
		g.drawString("B",110,570);
		g.setColor(Color.RED);
		g.drawString("-->",950,445);
		if (pieces[8].getOut() == 1) {
			g.drawString("ON",900,620);
		}
		else {
			g.drawString("OFF",905,620);
		}
	}
}