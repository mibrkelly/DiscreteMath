/*The first puzzle. The player must build a logical and from only or and not gates.*/

package base.state.puzzles;

import base.state.*;
import base.state.puzzles.pieces.*;
import base.state.expPages.LogicAndExp;
import base.state.menu.PuzMenu;
import java.awt.Graphics;
import java.awt.Color;

public class FirstSetPuz extends Puzzle {
	
	public FirstSetPuz(int w, int h) {
		super(w,h,10);
		
		pieces[0] = new SetSource(100,300,0x66ed44);
		pieces[1] = new SetSource(100,400,0x0f7ef5);
		pieces[2] = new SetSource(100,500,0xe20ff5);
		pieces[3] = new OrPiece(130,100);
		pieces[4] = new OrPiece(170,100);
		pieces[5] = new OrPiece(210,100);
		pieces[6] = new NotPiece(250,100);
		pieces[7] = new NotPiece(290,100);
		pieces[9] = new NotPiece(330,100);
		pieces[8] = new SinkPiece(950,425);
	}
	
	@Override
	public State whichState(int x, int y) {
		if (1050 < x && x < 1150 && 450 < y && y < 480) {
			State s = new PuzMenu(getWidth(),getHeight());
			return s;
		}
		if (1050 < x && x < 1150 && 530 < y && y < 560) {
			State s = new LogicAndExp(getWidth(), getHeight());
			return s;
		}
		if (1050 < x && x < 1150 && 490 < y && y < 520) {
			State s = new LogicAndPuz(getWidth(), getHeight());
			return s;
		}
		return this;
	}
	
	@Override
	public void runCheck() {
		int b1 = pieces[0].inputs[0];
		int b2 = pieces[1].inputs[0];
		
		pieces[0].inputs[0] = 0;
		pieces[1].inputs[0] = 0;
		update();
		if (pieces[8].getOut() == 0) {
			pieces[0].inputs[0] = 1;
			pieces[1].inputs[0] = 0;
			update();
			if (pieces[8].getOut() == 0) {
				pieces[0].inputs[0] = 0;
				pieces[1].inputs[0] = 1;
				update();
				if (pieces[8].getOut() == 0) {
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
	public void write (Graphics g) {
		super.write(g);
		g.setColor(Color.RED);
		g.drawString("AND",950,445);
		if (pieces[8].inputs[0] == 1) {
			g.drawString("ON",900,620);
		}
		else {
			g.drawString("OFF",905,620);
		}
	}
}