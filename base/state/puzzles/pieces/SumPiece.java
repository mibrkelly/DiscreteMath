/*This is the basic addition unit. It takes in two inputs and will output the sum.*/

package base.state.puzzles.pieces;

public class SumPiece extends FPiece{
	
	public SumPiece (int x, int y) {
		super (x,y,true,2);
	}
	
	@Override
	public int getOut() {
		return inputs[0] + inputs[1];
	}
	
	@Override
	public void draw() {
		int x = getX();
		int y = getY();
		for (int i = 0; i < 15; i++) {
			pix[x+i][y] = 0xaa8800;
			pix[x+i][y+1] = 0xaa8800;
			pix[x+i][y+2] = 0xaa8800;
			
			pix[x+i][y+27] = 0xaa8800;
			pix[x+i][y+28] = 0xaa8800;
			pix[x+i][y+29] = 0xaa8800;
			
			pix[x+i][y+i] = 0xaa8800;
			pix[x+i][y+i+1] = 0xaa8800;
			
			pix[x+i][y+29-i] = 0xaa8800;
			pix[x+i][y+30-i] = 0xaa8800;
		}
		for (int i = 15; i < 30; i++) {
			pix[x+i][y] = 0xaa8800;
			pix[x+i][y+1] = 0xaa8800;
			pix[x+i][y+2] = 0xaa8800;
			
			pix[x+i][y+27] = 0xaa8800;
			pix[x+i][y+28] = 0xaa8800;
			pix[x+i][y+29] = 0xaa8800;
		}
	}
}