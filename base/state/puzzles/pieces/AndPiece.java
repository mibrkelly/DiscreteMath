/*This is the basic logical and unit*/

package base.state.puzzles.pieces;

public class AndPiece extends FPiece{
	
	public AndPiece (int x, int y) {
		super (x,y,true,2);
	}
	
	@Override
	public int getOut() {
		if (inputs[0] == 0 || inputs[1] == 0) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	@Override
	public void draw() {
		int size = 10;
		for(int i = 0; i < size; i++) {
			for (int j = 0; j < size-i; j++) {
				int x1 = getX();
				int y1 = getY()+30;
				int x2 = getX()+15;
				int y2 = getY();
				int x3 = getX()+30;
				int y3 = getY()+30;
				pix[(int)((double)((x2-x1)*i+(x3-x1)*j)/(double)size)+x1][(int)((double)((y2-y1)*i+(y3-y1)*j)/(double)size)+y1] = 0x99063c;
				pix[(int)((double)((x2-x1)*i+(x3-x1)*j)/(double)size)+x1][(int)((double)((y2-y1)*i+(y3-y1)*j)/(double)size)+y1+1] = 0x99063c;
				pix[(int)((double)((x2-x1)*i+(x3-x1)*j)/(double)size)+x1+1][(int)((double)((y2-y1)*i+(y3-y1)*j)/(double)size)+y1] = 0x99063c;
				pix[(int)((double)((x2-x1)*i+(x3-x1)*j)/(double)size)+x1+1][(int)((double)((y2-y1)*i+(y3-y1)*j)/(double)size)+y1+1] = 0x99063c;
				
				pix[(int)((double)((x2-x1)*i+(x3-x1)*j)/(double)size)+x1+1][(int)((double)((y2-y1)*i+(y3-y1)*j)/(double)size)+y1-1] = 0x99063c;
				pix[(int)((double)((x2-x1)*i+(x3-x1)*j)/(double)size)+x1-1][(int)((double)((y2-y1)*i+(y3-y1)*j)/(double)size)+y1-1] = 0x99063c;
				pix[(int)((double)((x2-x1)*i+(x3-x1)*j)/(double)size)+x1-1][(int)((double)((y2-y1)*i+(y3-y1)*j)/(double)size)+y1] = 0x99063c;
				pix[(int)((double)((x2-x1)*i+(x3-x1)*j)/(double)size)+x1][(int)((double)((y2-y1)*i+(y3-y1)*j)/(double)size)+y1-1] = 0x99063c;
				pix[(int)((double)((x2-x1)*i+(x3-x1)*j)/(double)size)+x1-1][(int)((double)((y2-y1)*i+(y3-y1)*j)/(double)size)+y1+1] = 0x99063c;
			}
		}
	}
}