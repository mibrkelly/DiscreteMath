/*This is the basic logical not unit*/

package base.state.puzzles.pieces;

public class NotPiece extends FPiece{
	
	public NotPiece (int x, int y) {
		super(x,y,true,1);
	}
	
	public NotPiece (int x, int y, boolean changable) {
		super(x,y,changable,1);
	}
	
	@Override
	public int getOut () {
		return 1-inputs[0];
	}
	
	@Override
	public void draw() {
		int x = getX();
		int y = getY();
		for(int i = 0; i < 30; i++) {
			for(int j = 0; j < 30; j++) {
				pix[x+i][y+j] = 0xe6e227;
			}
		}
	}
}