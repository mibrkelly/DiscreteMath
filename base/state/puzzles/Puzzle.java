/*The first puzzle. The player must build a logical and from only or and not gates.*/

package base.state.puzzles;

import base.state.*;
import base.state.puzzles.pieces.*;
import java.awt.Graphics;
import java.awt.Color;

public abstract class Puzzle extends State {
	
	protected Pieces[] pieces;
	protected Pieces moving;
	protected int[][] edges;
	protected boolean selectedMode;
	protected boolean checkingMode;
	protected int selected;
	protected int numInputs;
	protected boolean solved;
	
	public int whichOpen;
	
	public Puzzle(int w, int h, int numPieces) {
		super(w,h);
		pieces = new Pieces[numPieces];
		edges = new int[numPieces][numPieces];
		
		for (int i = 0; i < numPieces; i++) {
			for (int j = 0; j < numPieces; j++) {
				edges[i][j] = -1;
			}
		}
		
		moving = null;
		
		selectedMode = false;
		selected = -1;
		checkingMode = false;
		solved = false;
	}
	
	public abstract State whichState(int x, int y);
	public abstract void runCheck();
	public void open() {
		super.open(whichOpen);
	}
	
	@Override
	public boolean clickedAt(int x, int y) {
		if ((1050 < x && x < 1150 && 530 < y && y < 560) || (1050 < x && x < 1150 && 490 < y && y < 520)) {
			return true;
		}
		if (1050 < x && x < 1150 && 450 < y && y < 480) {
			checkingMode = true;
			runCheck();
			if (solved) {
				open();
			}
			return true;
		}
		if (selectedMode) {
			for (int i = 0; i < pieces.length; i++) {
				if (pieces[i].getX() < x && pieces[i].getX()+30 > x && pieces[i].getY() < y && pieces[i].getY()+30 > y && edges[i][selected] == -1) {
					//if (i == selected || loopCheck(i)) {
					if (loopCheck(i)) {
						for (int j = 0; j < pieces.length; j++) {
							edges[j][selected] = -1;
						}
						selectedMode = false;
						return false;
					}
					edges[i][selected] = pieces[i].getOut();
					numInputs--;
					pieces[selected].inputs[numInputs] = pieces[i].getOut();
					if (numInputs <= 0) {
						selectedMode = false;
						update();
						return false;
					}
				}
			}
		}
		if (!selectedMode && !checkingMode) {
			for (int i = 0; i < pieces.length; i++) {
				if (pieces[i].getX() < x && pieces[i].getX()+30 > x && pieces[i].getY() < y && pieces[i].getY()+30 > y && pieces[i].getChangable()) {
					if (pieces[i] instanceof IPiece) {
						((IPiece)pieces[i]).clicked();
						update();
					}
					else {
						selected = i;
						numInputs = pieces[selected].getNumInputs();
						for (int j = 0; j < pieces.length; j++) {
							edges[j][selected] = -1;
						}
						selectedMode = true;
					}
				}
			}
		}
		return false;
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
	public void write(Graphics g) {
		g.setColor(Color.ORANGE);
		g.drawString("RETURN", 1070,550);
		g.drawString("RESTART", 1070,510);
		g.drawString("SUBMIT", 1070, 470);
		if (selectedMode) {
			g.drawString("SELECTED MODE", 100,620);
		}
	}
	
	@Override
	public void pressedAt(int x, int y) {
		if (!selectedMode && !checkingMode) {
			for (int i = 0; i < pieces.length; i++) {
				if (pieces[i].getX() < x && pieces[i].getX()+30 > x && pieces[i].getY() < y && pieces[i].getY()+30 > y) {
					if (pieces[i] instanceof FPiece && pieces[i].getChangable()) {
						moving = pieces[i];
						break;
					}
				}
			}
		}
	}
		
	@Override
	public void draggedTo(int x, int y) {
		if (moving != null) {
			if (canMove(x,y)) {
				moving.setX(x);
				moving.setY(y);
			}
		}
	}
	
	@Override
	public void released() {
		moving = null;
	}
	
	public void update() {
		boolean[] added = new boolean[pieces.length];
		for (int i = 0; i < pieces.length; i++) {
			added[i] = false;
		}
		int countAdded = 0;
		int lastCount = -1;
		while (countAdded != lastCount) {
			lastCount = countAdded;
			for (int i = 0; i < pieces.length; i++) {
				if (!added[i]) {
					boolean addNow = true;
					for (int j = 0; j < pieces.length; j++) {
						if (!added[j] && edges[j][i] > -1) {
							addNow = false;
						}
					}
					if (addNow) {
						added[i] = true;
						countAdded++;
						int j = 0;
						numInputs = pieces[i].getNumInputs();
						while (numInputs > 0 && j < pieces.length) {
							if (edges[j][i] > -1) {
								numInputs--;
								pieces[i].inputs[numInputs] = pieces[j].getOut();
								edges[j][i] = pieces[j].getOut();
							}
							j++;
						}
					}
				}
			}
		}
	}
	
	private boolean loopCheck (int i) { //Returns true if there is a loop
		if (i == selected) {
			return true;
		}
		boolean isALoop = false;
		for (int j = 0; j < pieces.length; j++) {
			if (edges[j][i] != -1) {
				isALoop = isALoop || loopCheck(j);
			}
		}
		return isALoop;
	}
}