package base.state.puzzles.pieces;

import base.PixelDrawer;

public class PairPiece extends Pieces { /*The pair peice is not an FPiece because it is not a drag and drop peice*/
	
	public PairPiece (int x, int y) {
		super(x,y,true,2);
		
		inputs[0] = -1;
		inputs[1] = -1;
	}
	
	public int getOut() {
		return 0;
	}
	
	public int getLeft() {
		return inputs[0];
	}
	
	public int getRight() {
		return inputs[1];
	}
	
	public void setLeft(int x) {
		inputs[0] = x;
	}
	
	public void setRight(int x) {
		inputs[1] = x;
	}
	
	public void draw() {
		for(int i = 0; i < 60; i++) {
			for(int j = 0; j < 3; j++) {
				pix[getX()+i][getY()+j] = 0xa530ba;
			}
		}
		for(int i = 0; i < 60; i++) {
			for(int j = 27; j < 30; j++) {
				pix[getX()+i][getY()+j] = 0xa530ba;
			}
		}
		for(int j = 3; j < 27; j++) {
			pix[getX()][getY()+j] = 0xa530ba;
			pix[getX()+1][getY()+j] = 0xa530ba;
			pix[getX()+2][getY()+j] = 0xa530ba;
			pix[getX()+29][getY()+j] = 0xa530ba;
			pix[getX()+30][getY()+j] = 0xa530ba;
			pix[getX()+31][getY()+j] = 0xa530ba;
			pix[getX()+58][getY()+j] = 0xa530ba;
			pix[getX()+59][getY()+j] = 0xa530ba;
			pix[getX()+60][getY()+j] = 0xa530ba;
		}
	}
}