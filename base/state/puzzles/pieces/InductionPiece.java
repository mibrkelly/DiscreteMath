/*This piece is used for the explanation of induction*/

package base.state.puzzles.pieces;

public class InductionPiece extends FPiece{
	
	int color;
	
	public InductionPiece (int x, int y, int isBad, int c) {
		super(x,y,false,1);
		inputs[0] = isBad;
		color = c;
	}
	
	@Override
	public int getOut() {
		return inputs[0];
	}
	
	@Override
	public void draw() {
		int x = getX();
		int y = getY();
		if (inputs[0] == 0) {
			for (int i = 0; i < 30; i++) {
				for (int j = 15; j < 30; j++) {
					if ((i-15)*(i-15)+(j-30)*(j-30) < 225)
						pix[x+i][y+j] = color;
				}
			}
		}
		else {
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 30; j++) {
					if (i*i+(j-15)*(j-15) < 225)
						pix[x+i][y+j] = color;
				}
			}
		}
	}
}