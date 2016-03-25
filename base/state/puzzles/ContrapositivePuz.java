/*The first puzzle. The player must build a logical and from only or and not gates.*/

package base.state.puzzles;

import base.state.*;
import base.state.puzzles.pieces.*;
import base.state.expPages.DirectProofExp;
import base.state.menu.PuzMenu;
import java.awt.Graphics;
import java.awt.Color;

public class ContrapositivePuz extends State {
	
	protected FPiece[] pieces;
	private int[] inBox;
	private int level;
	private int red, blue, white, yellow, brown, pink, lightblue, green;
	protected Pieces moving;
	protected boolean solved;
		
	public ContrapositivePuz(int w, int h) {
		super(w,h);
		
		pieces = new FPiece[26];
		inBox = new int[10];
		for (int i = 0; i < 10; i++) {
			inBox[i] = 0;
		}
		
		pieces[0] = new ProofPiece(130,100,0xff0000);
		pieces[1] = new ProofPiece(170,100,0x0000ff);
		pieces[2] = new NullPiece();
		pieces[3] = new NullPiece();
		pieces[4] = new NullPiece();
		pieces[5] = new NullPiece();
		pieces[6] = new NullPiece();
		pieces[7] = new NullPiece();
		pieces[8] = new NullPiece();
		pieces[9] = new NullPiece();
		
		pieces[10] = new ProofPiece(680,100,false,0xff0000);
		pieces[11] = new ProofPiece(760,100,false,0x0000ff);
		pieces[12] = new ProofPiece(840,100,false,0xffffff);
		
		pieces[13] = new ProofPiece(680,140,false,0x0000ff);
		pieces[14] = new ProofPiece(760,140,false,0xffffff);
		pieces[15] = new ProofPiece(840,140,false,0xffff00);
		
		pieces[16] = new ProofPiece(680,180,false,0xffffff);
		pieces[17] = new ProofPiece(760,180,false,0xffff00);
		pieces[18] = new ProofPiece(840,180,false,0x654321);
		
		pieces[19] = new ProofPiece(680,220,false,0x654321);
		pieces[20] = new ProofPiece(760,220,false,0xffff00);
		pieces[21] = new ProofPiece(840,220,false,0xff00ff);
		
		pieces[22] = new ProofPiece(680,260,false,0x0000ff);
		pieces[23] = new ProofPiece(760,260,false,0x654321);
		pieces[24] = new ProofPiece(840,260,false,0xff00ff);
		pieces[25] = new ProofPiece(920,260,false,0x00ff00);
		
		red = 0;
		blue = 0;
		white = 0;
		yellow = 0;
		brown = 0;
		pink = 0;
		lightblue = 0;
		green = 0;
		
		level = 1;
	}
	
	public ContrapositivePuz(int w, int h, int lev) {
		super(w,h);
		level = lev;
		
		inBox = new int[10];
		for (int i = 0; i < 10; i++) {
			inBox[i] = 0;
		}
		
		if (level == 2) {
			pieces = new FPiece[28];
			
			pieces[0] = new ProofPiece(130,100,0xff0000);
			pieces[1] = new NullPiece();
			pieces[2] = new NullPiece();
			pieces[3] = new NullPiece();
			pieces[4] = new NullPiece();
			pieces[5] = new NullPiece();
			pieces[6] = new NullPiece();
			pieces[7] = new NullPiece();
			pieces[8] = new NullPiece();
			pieces[9] = new NullPiece();
		
			pieces[10] = new ProofPiece(680,100,false,0xff0000);
			pieces[11] = new ProofPiece(760,100,false,0x0000ff);
			pieces[12] = new ProofPiece(840,100,false,0x00ffff);
		
			pieces[13] = new ProofPiece(680,140,false,0xff0000);
			pieces[14] = new ProofPiece(760,140,false,0x00ffff);
			pieces[15] = new ProofPiece(840,140,false,0xffffff);
		
			pieces[16] = new ProofPiece(680,180,false,0xff0000);
			pieces[17] = new ProofPiece(760,180,false,0x0000ff);
			pieces[18] = new ProofPiece(840,180,false,0xff00ff);
		
			pieces[19] = new ProofPiece(680,220,false,0xffffff);
			pieces[20] = new ProofPiece(760,220,false,0xffff00);
		
			pieces[21] = new ProofPiece(680,260,false,0xffff00);
			pieces[22] = new ProofPiece(760,260,false,0x00ff00);
			
			pieces[23] = new ProofPiece(680,300,false,0xff00ff);
			pieces[24] = new ProofPiece(760,300,false,0x00ffff);
			pieces[25] = new ProofPiece(840,300,false,0x654321);
			
			pieces[26] = new ProofPiece(680,340,false,0x654321);
			pieces[27] = new ProofPiece(760,340,false,0x00ff00);
		}
		
		if (level == 3) {
			pieces = new FPiece[26];
			
			pieces[0] = new ProofPiece(130,100,0xff0000);
			pieces[1] = new NullPiece();
			pieces[2] = new NullPiece();
			pieces[3] = new NullPiece();
			pieces[4] = new NullPiece();
			pieces[5] = new NullPiece();
			pieces[6] = new NullPiece();
			pieces[7] = new NullPiece();
			pieces[8] = new NullPiece();
			pieces[9] = new NullPiece();
		
			pieces[10] = new ProofPiece(680,100,false,0xff0000);
			pieces[11] = new ProofPiece(760,100,false,0x0000ff);
			
			pieces[12] = new ProofPiece(680,140,false,0xff0000);
			pieces[13] = new ProofPiece(760,140,false,0x0000ff);
			pieces[14] = new ProofPiece(840,140,false,0x00ffff);
			
			pieces[15] = new ProofPiece(680,180,false,0x00ffff);
			pieces[16] = new ProofPiece(760,180,false,0x0000ff);
			pieces[17] = new ProofPiece(840,180,false,0xffffff);
			
			pieces[18] = new ProofPiece(680,220,false,0x0000ff);
			pieces[19] = new ProofPiece(760,220,false,0x0000ff);
			pieces[20] = new ProofPiece(840,220,false,0xffff00);
			
			pieces[21] = new ProofPiece(680,260,false,0xffffff);
			pieces[22] = new ProofPiece(760,260,false,0xff0000);
			
			pieces[23] = new ProofPiece(680,300,false,0x0000ff);
			pieces[24] = new ProofPiece(760,300,false,0xffff00);
			pieces[25] = new ProofPiece(840,300,false,0x00ff00);
		}
		
		if (level == 4) {
			pieces = new FPiece[34];
			
			pieces[0] = new ProofPiece(130,100,0xff0000);
			pieces[1] = new NullPiece();
			pieces[2] = new NullPiece();
			pieces[3] = new NullPiece();
			pieces[4] = new NullPiece();
			pieces[5] = new NullPiece();
			pieces[6] = new NullPiece();
			pieces[7] = new NullPiece();
			pieces[8] = new NullPiece();
			pieces[9] = new NullPiece();
		
			pieces[10] = new ProofPiece(680,100,false,0xff0000);
			pieces[11] = new ProofPiece(760,100,false,0x0000ff);
			pieces[12] = new ProofPiece(840,100,false,0x00ffff);
			
			pieces[13] = new ProofPiece(680,140,false,0x0000ff);
			pieces[14] = new ProofPiece(760,140,false,0x0000ff);
			
			pieces[15] = new ProofPiece(680,180,false,0x0000ff);
			pieces[16] = new ProofPiece(760,180,false,0x0000ff);
			pieces[17] = new ProofPiece(840,180,false,0xffffff);
			
			pieces[18] = new ProofPiece(680,220,false,0x0000ff);
			pieces[19] = new ProofPiece(760,220,false,0x0000ff);
			pieces[20] = new ProofPiece(840,220,false,0x0000ff);
			pieces[21] = new ProofPiece(920,220,false,0xffff00);
			
			pieces[22] = new ProofPiece(680,260,false,0xffffff);
			pieces[23] = new ProofPiece(760,260,false,0x00ffff);
			pieces[24] = new ProofPiece(840,260,false,0x00ff00);
			
			pieces[25] = new ProofPiece(680,300,false,0xffff00);
			pieces[26] = new ProofPiece(760,300,false,0xffffff);
			pieces[27] = new ProofPiece(840,300,false,0xff00ff);
			
			pieces[28] = new ProofPiece(680,340,false,0xffff00);
			pieces[29] = new ProofPiece(760,340,false,0xff0000);
			pieces[30] = new ProofPiece(840,340,false,0x654321);
			
			pieces[31] = new ProofPiece(680,380,false,0x654321);
			pieces[32] = new ProofPiece(760,380,false,0xff00ff);
			pieces[33] = new ProofPiece(840,380,false,0xffffff);
		}
		
		red = 0;
		blue = 0;
		white = 0;
		yellow = 0;
		brown = 0;
		pink = 0;
		lightblue = 0;
		green = 0;
	}
	
	@Override
	public State whichState(int x, int y) {
		if (1050 < x && x < 1150 && 450 < y && y < 480 && solved) {
			level++;
			if (level < 5) {
				State s= new DirectProofPuz(getWidth(),getHeight(),level);
				return s;
			}
			State s= new PuzMenu(getWidth(),getHeight(),"You have solved the \"direct proof\" puzzle! Please continue!");
			return s;
		}
		if (1050 < x && x < 1150 && 530 < y && y < 560) {
			State s = new DirectProofExp(getWidth(), getHeight());
			return s;
		}
		if (1050 < x && x < 1150 && 490 < y && y < 520) {
			State s = new DirectProofPuz(getWidth(), getHeight());
			return s;
		}
		return this;
	}
	
	public void runCheck() {
		for (int i = 0; i < 10; i++) {
			if (pieces[i].getOut() == 0x00ff00) {
				solved = true;
			}
		}
	}
	
	@Override
	public void render(int keepTime) {
		Square(50,50,950,550,0x000000);
		Square(1050,50,100,550,0xabebbe);
		Square(1050,530,100,30,0x123456);
		Square(1050,490,100,30,0x123456);		
		Square(1050,450,100,30,0x123456);
		Square(1050,210,100,30,0x123456);
		Square(50,600,950,30,0xfffffff);
		Square(660,50,10,550,0xffffff);
		Square(100,100,100,100,0xaaaaaa);
		
		for (int i = 0; i < pieces.length; i++) {
			pieces[i].draw();
		}
	}
	
	@Override
	public void write(Graphics g) {
		g.setColor(Color.ORANGE);
		g.drawString("RETURN", 1070,550);
		g.drawString("RESTART", 1070,510);
		g.drawString("SUBMIT", 1070, 470);
		g.drawString("DEDUCE!",1070,230);
		
		g.setColor(Color.WHITE);
		if (level == 1) {
			g.drawString("+", 730,120);
			g.drawString("->", 810,120);
			g.drawString("+", 730,160);
			g.drawString("->", 810,160);
			g.drawString("+", 730,200);
			g.drawString("->", 810,200);
			g.drawString("+", 730,240);
			g.drawString("->", 810,240);
			g.drawString("+", 730,280);
			g.drawString("+", 810,280);
			g.drawString("->", 890,280);
		}
		if (level == 2) {
			g.drawString("->", 730,120);
			g.drawString("+", 810,120);
			g.drawString("+", 730,160);
			g.drawString("->", 810,160);
			g.drawString("+", 730,200);
			g.drawString("->", 810,200);
			g.drawString("->", 730,240);
			g.drawString("->", 730,280);
			g.drawString("+", 730,320);
			g.drawString("->", 810,320);
			g.drawString("->", 730,360);
		}
		if (level == 3) {
			g.drawString("->", 730,120);
			g.drawString("+", 730,160);
			g.drawString("->", 810,160);
			g.drawString("+", 730,200);
			g.drawString("->", 810,200);
			g.drawString("+", 730,240);
			g.drawString("->", 810,240);
			g.drawString("->", 730,280);
			g.drawString("+", 730,320);
			g.drawString("->", 810,320);
		}
		if (level == 4) {
			g.drawString("->", 730,120);
			g.drawString("+", 810,120);
			g.drawString("->", 730,160);
			g.drawString("+", 730,200);
			g.drawString("->", 810,200);
			g.drawString("+", 730,240);
			g.drawString("+", 810,240);
			g.drawString("->", 890,240);
			g.drawString("+", 730,280);
			g.drawString("->", 810,280);
			g.drawString("+", 730,320);
			g.drawString("->", 810,320);
			g.drawString("+", 730,360);
			g.drawString("->", 810,360);
			g.drawString("+", 730,400);
			g.drawString("->", 810,400);
		}
		
		g.setColor(Color.RED);
		g.drawString("Your goal is to create a green circle. You are on level " + Integer.toString(level),120,620);
	}
	
	@Override
	public void draggedTo(int x, int y) {
		if (moving != null) {
			if (x > 50 && x < 630 && y > 50 && y < 570) {
				moving.setX(x);
				moving.setY(y);
			}
		}
	}
	
	@Override
	public boolean clickedAt(int x, int y) {
		if ((1050 < x && x < 1150 && 530 < y && y < 560) || (1050 < x && x < 1150 && 490 < y && y < 520)) {
			return true;
		}
		if (1050 < x && x < 1150 && 450 < y && y < 480) {
			runCheck();
			if (solved) {
				open(12);
				return true;
			}
		}
		
		
		
		
		
		if (1050 < x && x < 1150 && y > 210 && y < 240) {   //This is where the deductions happen
			for (int i = 0; i < 10; i++) {
				if (pieces[i].getX() > 100 && pieces[i].getX() < 200 && pieces[i].getY() > 100 && pieces[i].getY() < 200) {
					if (pieces[i].getOut() == 0xff0000) {
						red++;
					}
					if (pieces[i].getOut() == 0x0000ff) {
						blue++;
					}
					if (pieces[i].getOut() == 0xffffff) {
						white++;
					}
					if (pieces[i].getOut() == 0xffff00) {
						yellow++;
					}
					if (pieces[i].getOut() == 0x654321) {
						brown++;
					}
					if (pieces[i].getOut() == 0xff00ff) {
						pink++;
					}
					if (pieces[i].getOut() == 0x00ffff) {
						lightblue++;
					}
					if (pieces[i].getOut() == 0x00ff00) {
						green++;
					}
				}
			}
			
			if (level == 1) {
				if (red == 1 && blue == 1 && white == 0 && yellow == 0 && brown == 0 && pink == 0 && lightblue == 0 && green == 0) {
					//Make white
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0xffffff);
							i = 10;
						}
					}
				}
				if (red == 0 && blue == 1 && white == 1 && yellow == 0 && brown == 0 && pink == 0 && lightblue == 0 && green == 0) {
					//Make yellow
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0xffff00);
							i = 10;
						}
					}
				}
				if (red == 0 && blue == 0 && white == 1 && yellow == 1 && brown == 0 && pink == 0 && lightblue == 0 && green == 0) {
					//Make brown
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0x654321);
							i = 10;
						}
					}
				}
				if (red == 0 && blue == 0 && white == 0 && yellow == 1 && brown == 1 && pink == 0 && lightblue == 0 && green == 0) {
					//Make pink
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0xff00ff);
							i = 10;
						}
					}
				}
				if (red == 0 && blue == 1 && white == 0 && yellow == 0 && brown == 1 && pink == 1 && lightblue == 0 && green == 0) {
					//Make green
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0x00ff00);
							i = 10;
						}
					}
				}
			}
			
			if (level == 2) {
				if (red == 1 && blue == 0 && white == 0 && yellow == 0 && brown == 0 && pink == 0 && lightblue == 0 && green == 0) {
					//Make blue and light blue
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0x0000ff);
							i = 10;
						}
					}
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0x00ffff);
							i = 10;
						}
					}
				}
				if (red == 1 && blue == 0 && white == 0 && yellow == 0 && brown == 0 && pink == 0 && lightblue == 1 && green == 0) {
					//Make white
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0xffffff);
							i = 10;
						}
					}
				}
				if (red == 1 && blue == 1 && white == 0 && yellow == 0 && brown == 0 && pink == 0 && lightblue == 0 && green == 0) {
					//Make pink
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0xff00ff);
							i = 10;
						}
					}
				}
				if (red == 0 && blue == 0 && white == 1 && yellow == 0 && brown == 0 && pink == 0 && lightblue == 0 && green == 0) {
					//Make yellow
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0xffff00);
							i = 10;
						}
					}
				}
				if (red == 0 && blue == 0 && white == 0 && yellow == 1 && brown == 0 && pink == 0 && lightblue == 0 && green == 0) {
					//Make green
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0x00ff00);
							i = 10;
						}
					}
				}
				if (red == 0 && blue == 0 && white == 0 && yellow == 0 && brown == 0 && pink == 1 && lightblue == 1 && green == 0) {
					//Make brown
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0x654321);
							i = 10;
						}
					}
				}
				if (red == 0 && blue == 0 && white == 0 && yellow == 0 && brown == 1 && pink == 0 && lightblue == 0 && green == 0) {
					//Make green
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0x00ff00);
							i = 10;
						}
					}
				}
			}
			
			if (level == 3) {
				if (red == 1 && blue == 0 && white == 0 && yellow == 0 && brown == 0 && pink == 0 && lightblue == 0 && green == 0) {
					//Make blue
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0x0000ff);
							i = 10;
						}
					}
				}
				if (red == 1 && blue == 1 && white == 0 && yellow == 0 && brown == 0 && pink == 0 && lightblue == 0 && green == 0) {
					//Make light blue
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0x00ffff);
							i = 10;
						}
					}
				}
				if (red == 0 && blue == 1 && white == 0 && yellow == 0 && brown == 0 && pink == 0 && lightblue == 1 && green == 0) {
					//Make white
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0xffffff);
							i = 10;
						}
					}
				}
				if (red == 0 && blue == 2 && white == 0 && yellow == 0 && brown == 0 && pink == 0 && lightblue == 0 && green == 0) {
					//Make yellow
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0xffff00);
							i = 10;
						}
					}
				}
				if (red == 0 && blue == 1 && white == 0 && yellow == 1 && brown == 0 && pink == 0 && lightblue == 0 && green == 0) {
					//Make green
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0x00ff00);
							i = 10;
						}
					}
				}
				if (red == 0 && blue == 0 && white == 1 && yellow == 0 && brown == 0 && pink == 0 && lightblue == 0 && green == 0) {
					//Make red
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0xff0000);
							i = 10;
						}
					}
				}
			}
			
			if (level == 4) {
				if (red == 1 && blue == 0 && white == 0 && yellow == 0 && brown == 0 && pink == 0 && lightblue == 0 && green == 0) {
					//Make blue and light blue
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0x0000ff);
							i = 10;
						}
					}
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0x00ffff);
							i = 10;
						}
					}
				}
				if (red == 0 && blue == 1 && white == 0 && yellow == 0 && brown == 0 && pink == 0 && lightblue == 0 && green == 0) {
					//Make blue
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0x0000ff);
							i = 10;
						}
					}
				}
				if (red == 0 && blue == 2 && white == 0 && yellow == 0 && brown == 0 && pink == 0 && lightblue == 0 && green == 0) {
					//Make while
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0xffffff);
							i = 10;
						}
					}
				}
				if (red == 0 && blue == 3 && white == 0 && yellow == 0 && brown == 0 && pink == 0 && lightblue == 0 && green == 0) {
					//Make yellow
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0xffff00);
							i = 10;
						}
					}
				}
				if (red == 0 && blue == 0 && white == 1 && yellow == 0 && brown == 0 && pink == 0 && lightblue == 1 && green == 0) {
					//Make green
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0x00ff00);
							i = 10;
						}
					}
				}
				if (red == 0 && blue == 0 && white == 1 && yellow == 1 && brown == 0 && pink == 0 && lightblue == 0 && green == 0) {
					//Make pink
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0xff00ff);
							i = 10;
						}
					}
				}
				if (red == 1 && blue == 0 && white == 0 && yellow == 1 && brown == 0 && pink == 0 && lightblue == 0 && green == 0) {
					//Make brown
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0x654321);
							i = 10;
						}
					}
				}
				if (red == 0 && blue == 0 && white == 0 && yellow == 0 && brown == 1 && pink == 1 && lightblue == 0 && green == 0) {
					//Make white
					for (int i = 0; i < 10; i++) {
						if (pieces[i] instanceof NullPiece) {
							pieces[i] = new ProofPiece(150,150,0xffffff);
							i = 10;
						}
					}
				}
			}
			
			red = 0;
			blue = 0;
			white = 0;
			yellow = 0;
			brown = 0;
			pink = 0;
			lightblue = 0;
			green = 0;
		}
		return false;
	}
	
	
	
	
	
	@Override
	public void pressedAt(int x, int y) {
		for (int i = 0; i < pieces.length; i++) {
			if (pieces[i].getX() < x && pieces[i].getX()+30 > x && pieces[i].getY() < y && pieces[i].getY()+30 > y) {
				if (pieces[i] instanceof FPiece && pieces[i].getChangable()) {
					moving = pieces[i];
					break;
				}
			}
		}
	}
	
	@Override
	public void released() {
		moving = null;
	}
}