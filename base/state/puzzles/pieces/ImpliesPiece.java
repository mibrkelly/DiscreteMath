/*This is an implies piece which just functions as a picture. We need a more sophisticated way to keep track of which state implies which to get the logic right.*/

package base.state.puzzles.pieces;

public class ImpliesPiece extends FPiece{
	
	public ImpliesPiece (int x, int y) {
		super (x,y,true,2);
	}
	
	@Override
	public int getOut() {
		return 1;
	}
	
	@Override
	public void draw() {
		int x = getX();
		int y = getY();
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				if (10 < j && j < 20) {
					pix[x+i][y+j] = (i+j)*20;
				}
				if (j-3 < i-15 && j+3 > i-15) {
					pix[x+i][y+j] = (i+j)*20;
				}
				if (j-3 < -i+45 && j+3 > -i+45) {
					pix[x+i][y+j] = (i+j)*20;
				}
			}
		}
	}
}