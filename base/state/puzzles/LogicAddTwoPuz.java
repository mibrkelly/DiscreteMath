/*The first puzzle. The player must build a logical and from only or and not gates.*/

package base.state.puzzles;

import base.state.*;
import base.state.puzzles.pieces.*;
import base.state.expPages.LogicAddExp;
import base.state.expPages.LogicAddPg2Exp;
import base.state.menu.PuzMenu;
import java.awt.Graphics;
import java.awt.Color;

public class LogicAddTwoPuz extends Puzzle {
		
	public LogicAddTwoPuz(int w, int h) {
		super(w,h,6);
		
		pieces[0] = new SourcePiece(100,300);
		pieces[1] = new SourcePiece(100,425);
		
		pieces[2] = new XorPiece(130,100);
		pieces[3] = new AndPiece(210,100);
		pieces[4] = new SinkPiece(950,225);
		pieces[5] = new SinkPiece(950,325);
	}
	
	@Override
	public State whichState(int x, int y) {
		if (1050 < x && x < 1150 && 450 < y && y < 480 && solved) {
			State s= new LogicAddPg2Exp(getWidth(),getHeight());
			return s;
		}
		if (1050 < x && x < 1150 && 450 < y && y < 480 && !solved) {
			State s = new PuzMenu(getWidth(),getHeight(),"Sorry, but your solution was incorrect. Please choose a puzzle.");
			return s;
		}
		if (1050 < x && x < 1150 && 530 < y && y < 560) {
			State s = new LogicAddExp(getWidth(), getHeight());
			return s;
		}
		if (1050 < x && x < 1150 && 490 < y && y < 520) {
			State s = new LogicAddTwoPuz(getWidth(), getHeight());
			return s;
		}
		return this;
	}
	
	@Override
	public void runCheck() {
		int out = 0;	
		int b1 = pieces[0].inputs[0];
		int b2 = pieces[1].inputs[0];
		
		pieces[0].inputs[0] = 0;
		pieces[1].inputs[0] = 0;
		update();
		if (pieces[5].inputs[0] == 1) {
			out+=2;
		}
		if (pieces[4].inputs[0] == 1) {
			out++;
		}
		if (out == 0) {
			pieces[0].inputs[0] = 1;
			pieces[1].inputs[0] = 0;
			update();
			if (pieces[5].inputs[0] == 1) {
				out+=2;
			}
			if (pieces[4].inputs[0] == 1) {
				out++;
			}
			if (out == 1) {
				pieces[0].inputs[0] = 0;
				pieces[1].inputs[0] = 1;
				update();
				if (pieces[5].inputs[0] == 1) {
					out+=2;
				}
				if (pieces[4].inputs[0] == 1) {
					out++;
				}
				if (out == 2) {
					pieces[0].inputs[0] = 1;
					pieces[1].inputs[0] = 1;
					update();
					if (pieces[5].inputs[0] == 1) {
						out+=2;
					}
					if (pieces[4].inputs[0] == 1) {
						out++;
					}
					if (out == 4) {
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
		int out = 0;
		g.setColor(Color.RED);
		g.drawString("+1",955,245);
		g.drawString("+2",955,345);
		if (pieces[4].inputs[0] == 1) {
			out++;
		}
		if (pieces[5].inputs[0] == 1) {
			out+=2;
		}
		g.drawString(Integer.toString(out),905,620);
	}
}