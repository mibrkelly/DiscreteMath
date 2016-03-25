/*This is the boolean source piece which is either on or off*/

package base.state.puzzles.pieces;

public class NumberSource extends IPiece {
	
	private int val;
	
	public NumberSource(int x, int y, int num) {
		super (x,y,false,0);
		val = num;
	}
	
	public NumberSource (int x, int y, boolean changable, int startsOn, int num) {
		super(x,y,changable,startsOn);
		val = num;
	}
	
	@Override
	public void draw() {
		for(int i = 0; i < 30; i++) {
			for(int j = 0; j < 30; j++) {
				if((i-15)*(i-15)+(j-15)*(j-15) < 15*15)
					pix[getX()+i][getY()+j] = 0x8844cc;
			}
		}
	}
	
	@Override
	public int getOut() {
		return val;
	}
	
	public void clicked() {
		
	}
}