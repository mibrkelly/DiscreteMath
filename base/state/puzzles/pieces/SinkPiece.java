/*This is the boolean output unit*/

package base.state.puzzles.pieces;

public class SinkPiece extends OPiece {	
	private int color;
	
	public SinkPiece(int x, int y) {
		super (x,y,true,1);
		color = 0x222222;
	}
	
	public SinkPiece (int x, int y, boolean changable) {
		super(x,y,changable,1);
		color = 0x222222;
	}
	
	public SinkPiece (int x, int y, int col) {
		super(x,y,true,1);
		color = col;
	}
	
	@Override
	public int getOut() {
		return inputs[0];
	}
	
	@Override
	public void draw() {
		for(int i = 0; i < 30; i++) {
			for(int j = 0; j < 30; j++) {
				if ((i-15)*(i-15)+(j-15)*(j-15) < 15*15)
					pix[getX()+i][getY()+j] = color;
			}
		}
	}
}