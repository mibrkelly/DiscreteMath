/*This is the abstract superclass of all of the function peices*/

package base.state.puzzles.pieces;

import base.PixelDrawer;

public abstract class FPiece extends Pieces {	
	public FPiece (int x, int y, boolean isChangable, int num) {
		super(x,y,isChangable,num);
	}
}