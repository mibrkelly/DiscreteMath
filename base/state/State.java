/*This is the interface for the various game states. The states include menus, puzzles and exposition pages.*/

package base.state;

import java.awt.Graphics;
import java.awt.Color;
import base.PixelDrawer;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public abstract class State implements PixelDrawer {
	protected int width;
	protected int height;
	protected int playerX;
	protected int playerY;
	protected static boolean[] finEdge;
	
	public State (int w, int h) {
		width = w;
		height = h;
		playerX = 0;
		playerY = 0;
	}
	
	public abstract void render(int keepTime);
	public abstract void write(Graphics g);
	public abstract boolean clickedAt(int x, int y);
	public abstract void pressedAt(int x, int y);
	public abstract void draggedTo(int x, int y);
	public abstract void released();
	public abstract State whichState(int x, int y);
	
	public void open(int edge) {
		finEdge[edge] = true;
        File f = new File("PlayerProgress.txt");
		try {
            FileReader fileReader = new FileReader(f);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
			String finEdgeInfo = bufferedReader.readLine();
            bufferedReader.close();
	        try {
	            FileWriter fileWriter = new FileWriter(f);

	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
				for (int i = 0; i < finEdge.length; i++) {
					if (i != edge)
						bufferedWriter.write(finEdgeInfo.charAt(i));
					else
						bufferedWriter.write("1");
				}
				
	            bufferedWriter.close();
	        }
	        catch(IOException ex) {
	            System.out.println("Error writing to file '"+ f + "'");
	        }
        }
        catch(IOException ex) {
            System.out.println("Error reading file '"+ f + "'");
        }
	}
	
	public void clear(int color) {
		Square(0,0,width,height,color);
	}
	
	public int getWidth () {
		return width;
	}
	
	public int getHeight () {
		return height;
	}
	
	public int getPlayerX() {
		return playerX;
	}
	public int getPlayerY() {
		return playerY;
	}
	public void setPlayerX(int x) {
		playerX = x;
	}
	public void setPlayerY(int y) {
		playerY = y;
	}
	
	public void pressUp() {
		playerY--;
	}
	public void pressDown() {
		playerY++;
	}
	public void pressRight() {
		playerX++;
	}
	public void pressLeft() {
		playerX--;
	}
	public boolean pressEnter() {
		return false;
	}
	
	public boolean canMove (int x, int y) {
		if (x >= PUZMINX && x <= PUZMAXX && y >= PUZMINY && y <= PUZMAXY) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean canDraw (int x, int y) {
		if (x > 0 && x <= WIDTH && y >= 0 && y < HEIGHT) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void Square (int x, int y, int w, int h, int color) {
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				if(x+i >= 0 && x+i <= 1200 && y+j >= 0 && y+j <= 650)
					pix[x+i][y+j] = color;
			}
		}
	}
	
	public void drawLn (int x0, int y0, int x1, int y1, int color) {
		double t = 0;
		for (int i = 0; i < 1500; i++) {
			t = (double)i/1500;
			double x = (double)x0*(1-t)+(double)x1*t;
			double y = (double)y0*(1-t)+(double)y1*t;
			//if (x < 1100 & x > 100 && y < 600 && y > 50) {
				pix[(int)x][(int)y] = color;
				pix[(int)x+1][(int)y] = color;
				pix[(int)x-1][(int)y] = color;
				pix[(int)x][(int)y+1] = color;
				pix[(int)x][(int)y-1] = color;
			//}
		}
	}
	
	public void drawLnOn (int timer, int x0, int y0, int x1, int y1, int color, int color2) {
		double t = 0;
		for (int i = 0; i < 1500; i++) {
			t = (double)i/1500;
			double x = (double)x0*(1-t)+(double)x1*t;
			double y = (double)y0*(1-t)+(double)y1*t;
			if (x < 1100 & x > 100 && y < 600 && y > 50) {
				pix[(int)x][(int)y] = color;
				pix[(int)x+1][(int)y] = color;
				pix[(int)x-1][(int)y] = color;
				pix[(int)x][(int)y+1] = color;
				pix[(int)x][(int)y-1] = color;
			}
			if ((i+4*timer)%120 == 0) {
				for(int j = -5; j < 5; j++) {
					for(int k = -5; k < 5; k++) {
						if(j*j+k*k < 5*5)
							pix[(int)x+j][(int)y+k] = color2;
					}
				}
			}
		}
	}
	
	public void drawCirc (int x, int y, int radius, int color) {
		for(int i = 0; i < 2*radius; i++) {
			for(int j = 0; j < 2*radius; j++) {
				if((i-radius)*(i-radius)+(j-radius)*(j-radius) < radius*radius)
					pix[x+i][y+j] = color;
			}
		}
	}
	
	public void drawAnnulus (int x, int y, int radius, int thick, int color) {
		for(int i = -radius; i < radius; i++) {
			for(int j = -radius; j < radius; j++) {
				if (radius*radius-thick < i*i+j*j && i*i+j*j < radius*radius)
					pix[x+i][y+j] = color;
			}
		}
	}
}