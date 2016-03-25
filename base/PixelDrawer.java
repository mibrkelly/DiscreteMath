//This interface is used to store the graphics

package base;

public interface PixelDrawer {
	public final int WIDTH = 1200;
	public final int HEIGHT = 650;
	public static int[][] pix = new int[WIDTH][HEIGHT];
	
	public final int PUZMINX = 50;
	public final int PUZMAXX = 970;
	public final int PUZMINY = 50;
	public final int PUZMAXY = 570;
}