/*Change this so there are 4 puzzles, =, < or >= 5, mod 2, mod 3.*/

package base.state.puzzles;

import base.state.*;
import base.state.puzzles.pieces.*;
import base.state.expPages.RelationEqualExp;
import base.state.menu.PuzMenu;
import java.awt.Graphics;
import java.awt.Color;

public class EquivalencePuz extends State {
	
	protected Pieces[] pieces;
	private int level, stored;
	protected Pieces moving;
	protected boolean solved;
		
	public EquivalencePuz(int w, int h) {
		super(w,h);
		
		pieces = new Pieces[6];
		
		pieces[0] = new NumberSource(680,100,1);
		pieces[1] = new NumberSource(760,100,2);
		pieces[2] = new NumberSource(840,100,3);
		
		pieces[3] = new PairPiece(100,150);
		pieces[4] = new PairPiece(100,200);
		pieces[5] = new PairPiece(100,250);
		
		level = 1;
		stored = 0;
	}
	
	public EquivalencePuz(int w, int h, int lev) {
		super(w,h);
		
		level = lev;
		
		if (level == 2) {
			pieces = new Pieces[12];
		
			pieces[0] = new NumberSource(680,100,0);
			pieces[1] = new NumberSource(760,100,2);
			pieces[2] = new NumberSource(840,100,5);
			pieces[3] = new NumberSource(920,100,8);
		
			pieces[4] = new PairPiece(100,100);
			pieces[5] = new PairPiece(100,150);
			pieces[6] = new PairPiece(100,200);
			pieces[7] = new PairPiece(100,250);
			pieces[8] = new PairPiece(100,300);
			pieces[9] = new PairPiece(100,350);
			pieces[10] = new PairPiece(100,400);
			pieces[11] = new PairPiece(100,450);
		}
		
		if (level == 3) {
			pieces = new Pieces[18];
		
			pieces[0] = new NumberSource(680,100,0);
			pieces[1] = new NumberSource(760,100,2);
			pieces[2] = new NumberSource(840,100,3);
			pieces[3] = new NumberSource(920,100,7);
			pieces[4] = new NumberSource(680,150,8);
		
			pieces[5] = new PairPiece(100,100);
			pieces[6] = new PairPiece(100,150);
			pieces[7] = new PairPiece(100,200);
			pieces[8] = new PairPiece(100,250);
			pieces[9] = new PairPiece(100,300);
			pieces[10] = new PairPiece(100,350);
			pieces[11] = new PairPiece(100,400);
			pieces[12] = new PairPiece(100,450);
			pieces[13] = new PairPiece(100,500);
			pieces[14] = new PairPiece(100,550);
			pieces[15] = new PairPiece(200,100);
			pieces[16] = new PairPiece(200,150);
			pieces[17] = new PairPiece(200,200);
		}
		
		if (level == 4) {
			pieces = new Pieces[20];
		
			pieces[0] = new NumberSource(680,100,0);
			pieces[1] = new NumberSource(760,100,2);
			pieces[2] = new NumberSource(840,100,6);
			pieces[3] = new NumberSource(920,100,7);
			pieces[4] = new NumberSource(680,150,8);
			pieces[5] = new NumberSource(760,150,9);
		
			pieces[6] = new PairPiece(100,100);
			pieces[7] = new PairPiece(100,150);
			pieces[8] = new PairPiece(100,200);
			pieces[9] = new PairPiece(100,250);
			pieces[10] = new PairPiece(100,300);
			pieces[11] = new PairPiece(100,350);
			pieces[12] = new PairPiece(100,400);
			pieces[13] = new PairPiece(100,450);
			pieces[14] = new PairPiece(100,500);
			pieces[15] = new PairPiece(100,550);
			pieces[16] = new PairPiece(200,100);
			pieces[17] = new PairPiece(200,150);
			pieces[18] = new PairPiece(200,200);
			pieces[19] = new PairPiece(200,250);
		}
		
		stored = 0;
	}
	
	@Override
	public State whichState(int x, int y) {
		if (1050 < x && x < 1150 && 450 < y && y < 480 && solved) {
			level++;
			if (level < 5) {
				State s= new EquivalencePuz(getWidth(),getHeight(),level);
				return s;
			}
			State s= new PuzMenu(getWidth(),getHeight(),"You have solved the \"equivalence relation\" puzzle! Please continue!");
			return s;
		}
		if (1050 < x && x < 1150 && 530 < y && y < 560) {
			State s = new RelationEqualExp(getWidth(), getHeight());
			return s;
		}
		if (1050 < x && x < 1150 && 490 < y && y < 520) {
			State s = new EquivalencePuz(getWidth(), getHeight());
			return s;
		}
		return this;
	}
	
	public void runCheck() {
		boolean goOn = false;
		if (level == 1) {
			for (int i = 3; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 1 && ((PairPiece)pieces[i]).getRight() == 1) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 3; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 2 && ((PairPiece)pieces[i]).getRight() == 2) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 3; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 3 && ((PairPiece)pieces[i]).getRight() == 3) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		}
		
		if (level == 2) {
			for (int i = 4; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 0 && ((PairPiece)pieces[i]).getRight() == 0) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 4; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 0 && ((PairPiece)pieces[i]).getRight() == 2) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 4; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 2 && ((PairPiece)pieces[i]).getRight() == 0) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 4; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 2 && ((PairPiece)pieces[i]).getRight() == 2) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			for (int i = 4; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 5 && ((PairPiece)pieces[i]).getRight() == 5) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 4; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 5 && ((PairPiece)pieces[i]).getRight() == 8) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 4; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 8 && ((PairPiece)pieces[i]).getRight() == 5) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 4; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 8 && ((PairPiece)pieces[i]).getRight() == 8) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		}
		
		if (level == 3) {
			for (int i = 5; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 0 && ((PairPiece)pieces[i]).getRight() == 0) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 5; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 2 && ((PairPiece)pieces[i]).getRight() == 2) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
		
			goOn = false;
			for (int i = 5; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 3 && ((PairPiece)pieces[i]).getRight() == 3) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 5; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 7 && ((PairPiece)pieces[i]).getRight() == 7) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 5; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 8 && ((PairPiece)pieces[i]).getRight() == 8) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 5; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 0 && ((PairPiece)pieces[i]).getRight() == 2) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 5; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 2 && ((PairPiece)pieces[i]).getRight() == 0) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		
			goOn = false;
			for (int i = 5; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 0 && ((PairPiece)pieces[i]).getRight() == 8) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 5; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 8 && ((PairPiece)pieces[i]).getRight() == 0) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 5; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 2 && ((PairPiece)pieces[i]).getRight() == 8) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 5; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 8 && ((PairPiece)pieces[i]).getRight() == 2) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 5; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 3 && ((PairPiece)pieces[i]).getRight() == 7) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 5; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 7 && ((PairPiece)pieces[i]).getRight() == 3) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
		}
		
		if (level == 4) {
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 0 && ((PairPiece)pieces[i]).getRight() == 0) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 2 && ((PairPiece)pieces[i]).getRight() == 2) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 6 && ((PairPiece)pieces[i]).getRight() == 6) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 7 && ((PairPiece)pieces[i]).getRight() == 7) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 8 && ((PairPiece)pieces[i]).getRight() == 8) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 9 && ((PairPiece)pieces[i]).getRight() == 9) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 0 && ((PairPiece)pieces[i]).getRight() == 6) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 6 && ((PairPiece)pieces[i]).getRight() == 0) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 0 && ((PairPiece)pieces[i]).getRight() == 9) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 9 && ((PairPiece)pieces[i]).getRight() == 0) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 6 && ((PairPiece)pieces[i]).getRight() == 9) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 9 && ((PairPiece)pieces[i]).getRight() == 6) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 2 && ((PairPiece)pieces[i]).getRight() == 8) {
					goOn = true;
				}
			}
			if (!goOn)
				return;
			
			goOn = false;
			for (int i = 6; i < pieces.length; i++) {
				if (((PairPiece)pieces[i]).getLeft() == 8 && ((PairPiece)pieces[i]).getRight() == 2) {
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
		if (level == 1) {
			g.drawString("Equal relation: Two elements are equal only if they are the same. You are on level 1",120,620);
		}
		else if (level == 2) {
			g.drawString("Equal relation: Two elements are equal if they are both less than 5 or not. You are on level 2",120,620);
		}
		else if (level == 3){
			g.drawString("Equal relation: Two elements are equal if they are both odd or both even. You are on level 3",120,620);
		}
		else if (level == 4){
			g.drawString("Equal relation: Two elements are equal if they have the same remainder when divided by 3. You are on level 4",120,620);
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
				open(17);
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