/*This is a source piece that has an associated color. It is used to build sets.*/

package base.state.puzzles.pieces;

public class NullPiece extends FPiece {
	
	private int color;
	
	public NullPiece() {
		super (0,0,false,0);
	}
	
	@Override
	public void draw() {
	}
	
	@Override
	public int getOut() {
		return 0;
	}
}