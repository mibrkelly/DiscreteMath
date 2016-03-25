/*This is the abstract superclass of all of the output peices*/

package base.state.puzzles.pieces;

import base.PixelDrawer;

public abstract class OPiece extends Pieces {
	public int input;
	
	public OPiece (int x, int y, boolean isChangable, int s) {
		super(x,y,isChangable,1);
	}
}