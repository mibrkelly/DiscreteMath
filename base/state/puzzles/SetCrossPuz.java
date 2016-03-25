/*The first puzzle. The player must build a logical and from only or and not gates.*/

package base.state.puzzles;

import base.state.*;
import base.state.puzzles.pieces.*;
import base.state.expPages.SetCrossExp;
import base.state.menu.PuzMenu;
import java.awt.Graphics;
import java.awt.Color;

public class SetCrossPuz extends State {
	
	protected Pieces[] pieces;
	private int level, stored;
	protected Pieces moving;
	protected boolean solved;
		
	public SetCrossPuz(int w, int h) {
		super(w,h);
		
		pieces = new Pieces[15];
		
		pieces[0] = new NumberSource(680,100,2);
		pieces[1] = new NumberSource(760,100,5);
		pieces[2] = new NumberSource(840,100,4);
		
		pieces[3] = new NumberSource(680,380,0);
		pieces[4] = new NumberSource(760,380,1);
		pieces[5] = new NumberSource(840,380,3);
		
		pieces[6] = new PairPiece(100,100);
		pieces[7] = new PairPiece(100,150);
		pieces[8] = new PairPiece(100,200);
		pieces[9] = new PairPiece(100,250);
		pieces[10] = new PairPiece(100,300);
		pieces[11] = new PairPiece(100,350);
		pieces[12] = new PairPiece(100,400);
		pieces[13] = new PairPiece(100,450);
		pieces[14] = new PairPiece(100,500);
		
		level = 1;
		stored = 0;
	}
	
	public SetCrossPuz(int w, int h, int lev) {
		super(w,h);
		
		level = lev;
		
		if (level == 2) {
			pieces = new Pieces[6];
		
			pieces[0] = new NumberSource(680,100,0);
			pieces[1] = new NumberSource(760,100,2);
		
			pieces[2] = new PairPiece(100,100);
			pieces[3] = new PairPiece(100,150);
			pieces[4] = new PairPiece(100,200);
			pieces[5] = new PairPiece(100,250);
		
			stored = 0;
		}
		
		if (level == 3) {
			pieces = new Pieces[14];
		
			pieces[0] = new NumberSource(680,100,1);
			pieces[1] = new NumberSource(760,100,4);
			
			pieces[2] = new NumberSource(680,380,2);
			pieces[3] = new NumberSource(760,380,3);
			pieces[4] = new NumberSource(840,380,1);
			pieces[5] = new NumberSource(920,380,5);
		
			pieces[6] = new PairPiece(100,100);
			pieces[7] = new PairPiece(100,150);
			pieces[8] = new PairPiece(100,200);
			pieces[9] = new PairPiece(100,250);
			pieces[10] = new PairPiece(100,300);
			pieces[11] = new PairPiece(100,350);
			pieces[12] = new PairPiece(100,400);
			pieces[13] = new PairPiece(100,450);
		
			stored = 0;
		}
	}
	
	@Override
	public State whichState(int x, int y) {
		if (1050 < x && x < 1150 && 450 < y && y < 480 && solved) {
			level++;
			if (level < 4) {
				State s= new SetCrossPuz(getWidth(),getHeight(),level);
				return s;
			}
			State s= new PuzMenu(getWidth(),getHeight(),"You have solved the \"cross product\" puzzle! Please continue!");
			return s;
		}
		if (1050 < x && x < 1150 && 530 < y && y < 560) {
			State s = new SetCrossExp(getWidth(), getHeight());
			return s;
		}
		if (1050 < x && x < 1150 && 490 < y && y < 520) {
			State s = new SetCrossPuz(getWidth(), getHeight());
			return s;
		}
		return this;
	}
	
	public void runCheck() {
		boolean goOn = false;
		if (level == 1) {
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 2 && ((PairPiece)pieces[i]).getRight() == 0) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 2 && ((PairPiece)pieces[i]).getRight() == 1) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 2 && ((PairPiece)pieces[i]).getRight() == 3) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
		
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 5 && ((PairPiece)pieces[i]).getRight() == 0) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 5 && ((PairPiece)pieces[i]).getRight() == 1) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 5 && ((PairPiece)pieces[i]).getRight() == 3) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 4 && ((PairPiece)pieces[i]).getRight() == 0) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 4 && ((PairPiece)pieces[i]).getRight() == 1) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 4 && ((PairPiece)pieces[i]).getRight() == 3) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		}
		
		if (level == 2) {
			for (int i = 2; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 0 && ((PairPiece)pieces[i]).getRight() == 0) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 2; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 0 && ((PairPiece)pieces[i]).getRight() == 2) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 2; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 2 && ((PairPiece)pieces[i]).getRight() == 0) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 2; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 2 && ((PairPiece)pieces[i]).getRight() == 2) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		}
		
		if (level == 3) {
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 2 && ((PairPiece)pieces[i]).getRight() == 1) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 3 && ((PairPiece)pieces[i]).getRight() == 1) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
		
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 1 && ((PairPiece)pieces[i]).getRight() == 1) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 5 && ((PairPiece)pieces[i]).getRight() == 1) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 2 && ((PairPiece)pieces[i]).getRight() == 4) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 3 && ((PairPiece)pieces[i]).getRight() == 4) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 1 && ((PairPiece)pieces[i]).getRight() == 4) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 5 && ((PairPiece)pieces[i]).getRight() == 4) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		}
		solved = true;
	}
	
	@Override
	public void render(int keepTime) {
		Square(50,50,950,550,0x000000);
		Square(1050,50,100,550,0xabebbe);
		Square(1050,530,100,30,0x123456);
		Square(1050,490,100,30,0x123456);		
		Square(1050,450,100,30,0x123456);
		Square(50,600,950,30,0xfffffff);
		Square(660,50,10,550,0xffffff);
		if (level != 2){
			Square(660,320,340,10,0xffffff);
		}
		
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
		
		for (int i = 0; i < pieces.length; i++) {
			if (pieces[i] instanceof PairPiece) {
				if (((PairPiece)pieces[i]).getLeft() != -1) {
					g.drawString(Integer.toString(((PairPiece)pieces[i]).getLeft()),pieces[i].getX()+10,pieces[i].getY()+20);
				}
				if (((PairPiece)pieces[i]).getRight() != -1) {
					g.drawString(Integer.toString(((PairPiece)pieces[i]).getRight()),pieces[i].getX()+40,pieces[i].getY()+20);
				}
			}
			else {
				g.drawString(Integer.toString(pieces[i].getOut()),pieces[i].getX()+10,pieces[i].getY()+20);
			}
		}
		
		g.setColor(Color.RED);
		g.drawString("Set A",800,70);
		if (level == 1) {
			g.drawString("Set B",800,350);
			g.drawString("Your goal is to create the set AxB. You are on level 1",120,620);
		}
		else if (level == 2) {
			g.drawString("Your goal is to create the set AxA. You are on level 2",120,620);
		}
		else {
			g.drawString("Set B",800,350);
			g.drawString("Your goal is to create the set BxA. You are on level 3",120,620);
		}
		g.drawString("You are creating " + Integer.toString(stored) +"'s",70,70);
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
				open(10);
				return true;
			}
		}
		for (int i = 0; i < pieces.length; i++) {
			if (pieces[i].getX() < x && pieces[i].getX()+30 > x && pieces[i].getY() < y && pieces[i].getY()+30 > y) {
				if (pieces[i] instanceof NumberSource) {
					stored = pieces[i].getOut();
				}
				if (pieces[i] instanceof PairPiece) {
					((PairPiece)pieces[i]).setLeft(stored);
				}
			}
			if (pieces[i].getX()+30 < x && pieces[i].getX()+60 > x && pieces[i].getY() < y && pieces[i].getY()+30 > y) {
				if (pieces[i] instanceof PairPiece) {
					((PairPiece)pieces[i]).setRight(stored);
				}
			}
		}
		return false;
	}
	
	@Override
	public void pressedAt(int x, int y) {
	}
	
	@Override
	public void released() {
		moving = null;
	}
}