/*This is a source piece that has an associated color. It is used to build sets.*/

package base.state.puzzles.pieces;

public class SetSource extends IPiece {
	
	private int color;
	
	public SetSource(int x, int y, int c) {
		super (x,y,false,1);
		color = c;
	}
	
	@Override
	public void draw() {
		if (inputs[0] == 1) {
			for(int i = 0; i < 30; i++) {
				for(int j = 0; j < 30; j++) {
					if((i-15)*(i-15)+(j-15)*(j-15) < 15*15)
						pix[getX()+i][getY()+j] = color;
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