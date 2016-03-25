/*This is a source piece that has an associated color. It is used to build sets.*/

package base.state.puzzles.pieces;

public class ProofPiece extends FPiece {
	
	private int color;
	
	public ProofPiece(int x, int y, int c) {
		super (x,y,true,0);
		color = c;
	}
	
	public ProofPiece(int x, int y, boolean b, int c) {
		super (x,y,b,0);
		color = c;
	}
	
	@Override
	public void draw() {
		for(int i = 0; i < 30; i++) {
			for(int j = 0; j < 30; j++) {
				if((i-15)*(i-15)+(j-15)*(j-15) < 15*15)
					pix[getX()+i][getY()+j] = color;
			}
		}
	}
	
	@Override
	public int getOut() {
		return color;
	}
}