/*This is the basic logical if and only if gate*/

package base.state.puzzles.pieces;

public class IffPiece extends FPiece{
	
	public IffPiece (int x, int y) {
		super (x,y,true,2);
	}
	
	public IffPiece (int x, int y, boolean changable) {
		super(x,y,changable,2);
	}
	
	@Override
	public int getOut() {
		if (inputs[0] == inputs[1]) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	@Override
	public void draw() {
		int x = getX();
		int y = getY();
		for(int i = 0; i < 30; i++) {
			for(int j = 0; j < 30; j++) {
				pix[getX()+i][getY()+6] = 0xa530ba;
				pix[getX()+i][getY()+7] = 0xa530ba;
				pix[getX()+i][getY()+8] = 0xa530ba;
				pix[getX()+i][getY()+9] = 0xa530ba;
				pix[getX()+i][getY()+10] = 0xa530ba;
				pix[getX()+i][getY()+20] = 0xa530ba;
				pix[getX()+i][getY()+21] = 0xa530ba;
				pix[getX()+i][getY()+22] = 0xa530ba;
				pix[getX()+i][getY()+23] = 0xa530ba;
				pix[getX()+i][getY()+24] = 0xa530ba;
				pix[getX()+12][getY()+j] = 0xa530ba;
				pix[getX()+13][getY()+j] = 0xa530ba;
				pix[getX()+14][getY()+j] = 0xa530ba;
				pix[getX()+15][getY()+j] = 0xa530ba;
				pix[getX()+16][getY()+j] = 0xa530ba;
				pix[getX()+17][getY()+j] = 0xa530ba;
				pix[getX()+18][getY()+j] = 0xa530ba;
			}
		}
	}
}