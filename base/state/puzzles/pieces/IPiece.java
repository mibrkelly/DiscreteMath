/*This is the abstract superclass of all of the input peices*/

package base.state.puzzles.pieces;

import base.PixelDrawer;

public abstract class IPiece extends Pieces {
		
	public IPiece (int x, int y, boolean isChangable, int output) {
		super(x,y,isChangable,1);
		inputs[0] = output;
	}
	
	public int getOut() {
		return inputs[0];
	}
	
	public abstract void clicked();
}