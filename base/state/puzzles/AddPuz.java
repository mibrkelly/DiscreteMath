/*The first puzzle. The player must build a logical and from only or and not gates.*/

package base.state.puzzles;

import base.state.*;
import base.state.puzzles.pieces.*;
import base.state.expPages.LogicAddPg3Exp;
import base.state.menu.PuzMenu;
import java.awt.Graphics;
import java.awt.Color;

public class AddPuz extends Puzzle {
	public AddPuz(int w, int h) {
		super(w,h,10);
		
		pieces[0] = new NumberSource(100,250, true, 0, 1);
		pieces[1] = new NumberSource(100,350, true, 0, 1);
		pieces[2] = new NumberSource(100,450, true, 0, 2);
		pieces[3] = new XorPiece(130,100);
		pieces[4] = new AndPiece(250,100);
		pieces[5] = new XorPiece(290,100);
		pieces[6] = new AndPiece(330,100);
		pieces[7] = new SinkPiece(950,325);
		pieces[8] = new SinkPiece(950,425);
		pieces[9] = new SinkPiece(950,525);
		
		whichOpen = 8;
	}
	
	@Override
	public State whichState(int x, int y) {
		if (1050 < x && x < 1150 && 450 < y && y < 480 && solved) {
			State s = new PuzMenu(getWidth(),getHeight(),"You have solved the \"logical addition\" puzzle! Please continue!");
			return s;
		}
		if (1050 < x && x < 1150 && 450 < y && y < 480 && !solved) {
			State s = new PuzMenu(getWidth(),getHeight(),"Sorry, but your solution was incorrect. Please choose a puzzle.");
			return s;
		}
		if (1050 < x && x < 1150 && 530 < y && y < 560) {
			State s = new LogicAddPg3Exp(getWidth(), getHeight());
			return s;
		}
		if (1050 < x && x < 1150 && 490 < y && y < 520) {
			State s = new AddPuz(getWidth(), getHeight());
			return s;
		}
		return this;
	}
	
	@Override
	public void runCheck() {
		int b1 = pieces[0].inputs[0];
		int b2 = pieces[1].inputs[0];
		int b3 = pieces[2].inputs[0];
		int num = 0;
		
		pieces[0].inputs[0] = 0;
		pieces[1].inputs[0] = 0;
		pieces[2].inputs[0] = 0;
		update();
		if (pieces[7].getOut() != 0) {
			num++;
		}
		if (pieces[8].getOut() != 0) {
			num+=2;
		}
		if (pieces[9].getOut() != 0) {
			num+=4;
		}
		if (num == 0) {
			pieces[0].inputs[0] = 1;
			pieces[1].inputs[0] = 0;
			pieces[2].inputs[0] = 0;
			update();
			if (pieces[7].getOut() != 0) {
				num++;
			}
			if (pieces[8].getOut() != 0) {
				num+=2;
			}
			if (pieces[9].getOut() != 0) {
				num+=4;
			}
			if (num == 1) {
				pieces[0].inputs[0] = 0;
				pieces[1].inputs[0] = 1;
				pieces[2].inputs[0] = 0;
				update();
				if (pieces[7].getOut() != 0) {
					num++;
				}
				if (pieces[8].getOut() != 0) {
					num+=2;
				}
				if (pieces[9].getOut() != 0) {
					num+=4;
				}
				if (num == 2) {
					pieces[0].inputs[0] = 0;
					pieces[1].inputs[0] = 0;
					pieces[2].inputs[0] = 1;
					update();
					if (pieces[7].getOut() != 0) {
						num++;
					}
					if (pieces[8].getOut() != 0) {
						num+=2;
					}
					if (pieces[9].getOut() != 0) {
						num+=4;
					}
					if (num == 4) {
						pieces[0].inputs[0] = 1;
						pieces[1].inputs[0] = 1;
						pieces[2].inputs[0] = 0;
						update();
						if (pieces[7].getOut() != 0) {
							num++;
						}
						if (pieces[8].getOut() != 0) {
							num+=2;
						}
						if (pieces[9].getOut() != 0) {
							num+=4;
						}
						if (num == 6) {
							pieces[0].inputs[0] = 1;
							pieces[1].inputs[0] = 0;
							pieces[2].inputs[0] = 1;
							update();
							if (pieces[7].getOut() != 0) {
								num++;
							}
							if (pieces[8].getOut() != 0) {
								num+=2;
							}
							if (pieces[9].getOut() != 0) {
								num+=4;
							}
							if (num == 9) {
								pieces[0].inputs[0] = 0;
								pieces[1].inputs[0] = 1;
								pieces[2].inputs[0] = 1;
								update();
								if (pieces[7].getOut() != 0) {
									num++;
								}
								if (pieces[8].getOut() != 0) {
									num+=2;
								}
								if (pieces[9].getOut() != 0) {
									num+=4;
								}
								if (num == 12) {
									pieces[0].inputs[0] = 1;
									pieces[1].inputs[0] = 1;
									pieces[2].inputs[0] = 1;
									update();
									if (pieces[7].getOut() != 0) {
										num++;
									}
									if (pieces[8].getOut() != 0) {
										num+=2;
									}
									if (pieces[9].getOut() != 0) {
										num+=4;
									}
									if (num == 16) {
										solved = true;
									}
								}
							}
						}
					}
				}
			}
		}
		
		pieces[0].inputs[0] = b1;
		pieces[1].inputs[0] = b2;
		pieces[2].inputs[0] = b3;
		update();
		
		checkingMode = false;
	}
	
	@Override
	public void write (Graphics g) {
		super.write(g);
		g.setColor(Color.GREEN);
		g.drawString("1",110,270);
		g.drawString("1",110,370);
		g.drawString("2",110,470);
		g.setColor(Color.RED);
		g.drawString("1",960,345);
		g.drawString("2",960,445);
		g.drawString("4",960,545);
		int num = 0;
		if (pieces[7].getOut() != 0) {
			num++;
		}
		if (pieces[8].getOut() != 0) {
			num+=2;
		}
		if (pieces[9].getOut() != 0) {
			num+=4;
		}
		String sum = Integer.toString(num);
		g.drawString(sum,900,620);

	}
}