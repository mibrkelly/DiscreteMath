/*This is the boolean source piece which is either on or off*/

package base.state.puzzles.pieces;

public class SourcePiece extends IPiece {
	
	public SourcePiece(int x, int y) {
		super (x,y,true,0);
	}
	
	public SourcePiece (int x, int y, boolean changable, int startsOn) {
		super(x,y,changable,startsOn);
	}
	
	@Override
	public void draw() {
		if (inputs[0] == 1) {
			for(int i = 0; i < 30; i++) {
				for(int j = 0; j < 30; j++) {
					if((i-15)*(i-15)+(j-15)*(j-15) < 15*15)
						pix[getX()+i][getY()+j] = 0xf7f30a;
				}
			}
		}
		else {
			for(int i = 0; i < 30; i++) {
				for(int j = 0; j < 30; j++) {
					if((i-15)*(i-15)+(j-15)*(j-15) < 15*15)
						pix[getX()+i][getY()+j] = 0xad071d;
				}
			}
		}
	}
	
	@Override
	public void clicked() {
		inputs[0] = 1-inputs[0];
	}
}