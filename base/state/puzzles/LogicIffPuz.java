/*The first puzzle. The player must build a logical iff from and, or and not gates.*/

package base.state.puzzles;

import base.state.*;
import base.state.puzzles.pieces.*;
import base.state.expPages.LogicIffExp;
import base.state.menu.PuzMenu;
import java.awt.Graphics;
import java.awt.Color;

public class LogicIffPuz extends Puzzle {
	
	public LogicIffPuz(int w, int h) {
		super(w,h,9);
		
		pieces[0] = new SourcePiece(100,300);
		pieces[1] = new SourcePiece(100,550);
		pieces[2] = new OrPiece(130,100);
		pieces[3] = new OrPiece(170,100);
		pieces[4] = new NotPiece(210,100);
		pieces[5] = new NotPiece(250,100);
		pieces[6] = new AndPiece(290,100);
		pieces[7] = new AndPiece(330,100);
		pieces[8] = new SinkPiece(950,425);
		
		whichOpen = 15;
	}
	
	@Override
	public State whichState(int x, int y) {
		if (1050 < x && x < 1150 && 450 < y && y < 480 && solved) {
			State s = new PuzMenu(getWidth(),getHeight(),"You have solved the \"if and only if\" puzzle! Please continue!");
			return s;
		}
		if (1050 < x && x < 1150 && 450 < y && y < 480 && !solved) {
			State s = new PuzMenu(getWidth(),getHeight(),"Sorry, but your solution was incorrect. Please choose a puzzle.");
			return s;
		}
		if (1050 < x && x < 1150 && 530 < y && y < 560) {
			State s = new LogicIffExp(getWidth(), getHeight());
			return s;
		}
		if (1050 < x && x < 1150 && 490 < y && y < 520) {
			State s = new LogicIffPuz(getWidth(), getHeight());
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
		if (pieces[8].getOut() == 1) {
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
		g.drawString("IFF",955,445);
		if (pieces[8].inputs[0] == 1) {
			g.drawString("ON",900,620);
		}
		else {
			g.drawString("OFF",905,620);
		}
	}
}