/*This is the basic logical xor gate*/

package base.state.puzzles.pieces;

public class XorPiece extends FPiece {
	
	public XorPiece (int x, int y) {
		super (x,y,true,2);
	}
	
	public XorPiece (int x, int y, boolean changable) {
		super(x,y,changable,2);
	}
	
	@Override
	public int getOut() {
		if ((inputs[0] == 0 && inputs[1] == 0) || (inputs[0] != 0 && inputs[1] != 0)) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	@Override
	public void draw() {
		int x = getX();
		int y = getY();
		for(int i = 0; i < 30; i++) {
			for(int j = 0; j < 30; j++) {
				if(((j < i+7) && (j > i-7)) || ((j < -i+37) && (j > -i+23)))
					pix[getX()+i][getY()+j] = 0xa530ba;
			}
		}
	}
}