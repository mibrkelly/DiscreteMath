/*This is the basic logical or unit*/

package base.state.puzzles.pieces;

public class OrPiece extends FPiece{
	
	public OrPiece (int x, int y) {
		super (x,y,true,2);
	}
	
	public OrPiece (int x, int y, boolean changable) {
		super(x,y,changable,2);
	}
	
	@Override
	public int getOut() {
		if (inputs[0] == 0 && inputs[1] == 0) {
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
				if((i-15)*(i-15)+(j-15)*(j-15) < 15*15 && (i-15)*(i-15)+(j-15)*(j-15) > 10*10)
					pix[getX()+i][getY()+j] = 0x0e0ec2;
			}
		}
	}
}