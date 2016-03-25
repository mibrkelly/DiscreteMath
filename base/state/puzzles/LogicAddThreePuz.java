/*The first puzzle. The player must build a logical and from only or and not gates.*/

package base.state.puzzles;

import base.state.*;
import base.state.puzzles.pieces.*;
import base.state.expPages.LogicAddPg2Exp;
import base.state.expPages.LogicAddPg3Exp;
import base.state.menu.PuzMenu;
import java.awt.Graphics;
import java.awt.Color;

public class LogicAddThreePuz extends Puzzle {
		
	public LogicAddThreePuz(int w, int h) {
		super(w,h,12);
		
		pieces[0] = new SourcePiece(100,300);
		pieces[1] = new SourcePiece(100,425);
		pieces[2] = new SourcePiece(100,550);
		
		pieces[3] = new AndPiece(130,100);
		pieces[4] = new AndPiece(170,100);
		pieces[5] = new AndPiece(210,100);
		pieces[6] = new OrPiece(250,100);
		pieces[7] = new OrPiece(290,100);
		pieces[8] = new XorPiece(330,100);
		pieces[9] = new XorPiece(370,100);
		pieces[10] = new SinkPiece(950,225);
		pieces[11] = new SinkPiece(950,325);
	}
	
	@Override
	public State whichState(int x, int y) {
		if (1050 < x && x < 1150 && 450 < y && y < 480 && solved) {
			State s= new LogicAddPg3Exp(getWidth(),getHeight());
			return s;
		}
		if (1050 < x && x < 1150 && 450 < y && y < 480 && !solved) {
			State s = new PuzMenu(getWidth(),getHeight(),"Sorry, but your solution was incorrect. Please choose a puzzle.");
			return s;
		}
		if (1050 < x && x < 1150 && 530 < y && y < 560) {
			State s = new LogicAddPg2Exp(getWidth(), getHeight());
			return s;
		}
		if (1050 < x && x < 1150 && 490 < y && y < 520) {
			State s = new LogicAddThreePuz(getWidth(), getHeight());
			return s;
		}
		return this;
	}
	
	@Override
	public void runCheck() {
		int out = 0;
		
		pieces[0].inputs[0] = 0;
		pieces[1].inputs[0] = 0;
		pieces[2].inputs[0] = 0;
		update();
		if (pieces[11].inputs[0] == 1) {
			out+=2;
		}
		if (pieces[10].inputs[0] == 1) {
			out++;
		}
		if (out == 0) {
			pieces[0].inputs[0] = 1;
			pieces[1].inputs[0] = 0;
			pieces[2].inputs[0] = 0;
			update();
			if (pieces[11].inputs[0] == 1) {
				out+=2;
			}
			if (pieces[10].inputs[0] == 1) {
				out++;
			}
			if (out == 1) {
				pieces[0].inputs[0] = 0;
				pieces[1].inputs[0] = 1;
				pieces[2].inputs[0] = 0;
				update();
				if (pieces[11].inputs[0] == 1) {
					out+=2;
				}
				if (pieces[10].inputs[0] == 1) {
					out++;
				}
				if (out == 2) {
					pieces[0].inputs[0] = 0;
					pieces[1].inputs[0] = 0;
					pieces[2].inputs[0] = 1;
					update();
					if (pieces[11].inputs[0] == 1) {
						out+=2;
					}
					if (pieces[10].inputs[0] == 1) {
						out++;
					}
					if (out == 3) {
						pieces[0].inputs[0] = 1;
						pieces[1].inputs[0] = 1;
						pieces[2].inputs[0] = 0;
						update();
						if (pieces[11].inputs[0] == 1) {
							out+=2;
						}
						if (pieces[10].inputs[0] == 1) {
							out++;
						}
						if (out == 5) {
							pieces[0].inputs[0] = 1;
							pieces[1].inputs[0] = 0;
							pieces[2].inputs[0] = 1;
							update();
							if (pieces[11].inputs[0] == 1) {
								out+=2;
							}
							if (pieces[10].inputs[0] == 1) {
								out++;
							}
							if (out == 7) {
								pieces[0].inputs[0] = 0;
								pieces[1].inputs[0] = 1;
								pieces[2].inputs[0] = 1;
								update();
								if (pieces[11].inputs[0] == 1) {
									out+=2;
								}
								if (pieces[10].inputs[0] == 1) {
									out++;
								}
								if (out == 9) {
									pieces[0].inputs[0] = 1;
									pieces[1].inputs[0] = 1;
									pieces[2].inputs[0] = 1;
									update();
									if (pieces[11].inputs[0] == 1) {
										out+=2;
									}
									if (pieces[10].inputs[0] == 1) {
										out++;
									}
									if (out == 12) {
										solved = true;
									}
								}
							}
						}
					}
				}
			}
		}		
		checkingMode = false;
	}
	
	@Override
	public void write (Graphics g) {
		super.write(g);
		int out = 0;
		g.setColor(Color.RED);
		g.drawString("+1",950,245);
		g.drawString("+2",950,345);
		if (pieces[10].inputs[0] == 1) {
			out++;
		}
		if (pieces[11].inputs[0] == 1) {
			out+=2;
		}
		g.drawString(Integer.toString(out),905,620);
	}
}