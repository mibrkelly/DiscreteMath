/*The first puzzle. The player must build a logical and from only or and not gates.*/

package base.state.puzzles;

import base.state.*;
import base.state.puzzles.pieces.*;
import base.state.expPages.InjectiveExp;
import base.state.menu.PuzMenu;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class InjectivePuz extends Puzzle {
	
	private int level;
	private int ctrlY, numSinks, numSources;
	
	public InjectivePuz(int w, int h) {
		super(w,h,10);
		
		numSources = 2;
		numSinks = 3;
		
		for (int i = 0; i < numSources; i++) {
			pieces[i] = new SinkPiece(600,125+i*(400/numSources),0x00ffaa);
		}
		for (int i = 0; i < numSinks; i++) {
			pieces[i+numSources] = new SetSource(950,125+i*(400/numSinks),0x00ffaa);
		}
		for (int i = numSinks+numSources; i < 10; i++) {
			pieces[i] = new NullPiece();
		}
		
		ctrlY = 0;
		level = 1;
		
		whichOpen = 33;
	}
	
	public InjectivePuz(int w, int h, int lev) {
		super(w,h,10);
		
		level = lev;
		numSources = 0;
		numSinks = 3;
		
 		if (level == 2) {
			numSources = 5;
 		}
		if (level == 3) {
			numSources = 3;
		}
		if (level == 4) {
			numSources = 1;
		}
		for (int i = 0; i < numSources; i++) {
			pieces[i] = new SinkPiece(600,125+i*(400/numSources),0x00ffaa);
		}
		for (int i = 0; i < numSinks; i++) {
			pieces[i+numSources] = new SetSource(950,125+i*(400/numSinks),0x00ffaa);
		}
		for (int i = numSources+numSinks; i < 10; i++) {
			pieces[i] = new NullPiece();
		}
		
		ctrlY = 0;
		whichOpen = 33;
	}
	
	public void pressUp() {
		ctrlY--;
		ctrlY = (ctrlY%2+2)%2;
	}
	
	public void pressDown() {
		ctrlY++;
		ctrlY = (ctrlY%2+2)%2;
	}
	
	public boolean pressEnter() {
		if (ctrlY == 0 && numSinks > 1) {
			numSinks--;
		}
		if (ctrlY == 1 && numSinks < 5) {
			numSinks++;
		}
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				edges[i][j] = -1;
			}
		}
		for (int i = 0; i < numSources; i++) {
			pieces[i] = new SinkPiece(600,125+i*(400/numSources),0x00ffaa);
		}
		for (int i = 0; i < numSinks; i++) {
			pieces[i+numSources] = new SetSource(950,125+i*(400/numSinks),0x00ffaa);
		}
		for (int i = numSinks+numSources; i < 10; i++) {
			pieces[i] = new NullPiece();
		}
		
		return false;
	}
	
	@Override
	public State whichState(int x, int y) {
		if (1050 < x && x < 1150 && 450 < y && y < 480 && solved && level == 5) {
			State s = new PuzMenu(getWidth(),getHeight(),"You have solved the \"injective functions\" puzzle! Please continue!");
			return s;
		}
		if (1050 < x && x < 1150 && 450 < y && y < 480 && solved && level != 5) {
			State s = new InjectivePuz(getWidth(),getHeight(),level);
			return s;
		}
		if (1050 < x && x < 1150 && 450 < y && y < 480 && !solved) {
			State s = new PuzMenu(getWidth(),getHeight(),"Sorry, but your solution was incorrect. Please choose a puzzle.");
			return s;
		}
		if (1050 < x && x < 1150 && 530 < y && y < 560) {
			State s = new InjectiveExp(getWidth(), getHeight());
			return s;
		}
		if (1050 < x && x < 1150 && 490 < y && y < 520) {
			State s = new InjectivePuz(getWidth(), getHeight());
			return s;
		}
		return this;
	}
	
	@Override
	public void runCheck() {
		int[] domain = new int[numSources];
		int[] range = new int[numSinks];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < numSources; j++) {
					domain[j] += edges[i][j];
				}
			for (int j = 0; j < numSinks; j++) {
					range[j] += edges[j+numSources][i];
			}
		}
		
		boolean surj = true;
		for (int i = 0; i < numSources; i++) {
			if (domain[i] != -8) {
				surj = false;
			}
		}
		for (int i = 0; i < numSinks; i++) {
			if (range[i] != -10 && range[i] != -8) {
				surj = false;
			}
		}
		if (surj) {
			level++;
			solved = true;;
		}
	}
	
	@Override
	public void render(int keepTime) {
		Square(50,50,950,550,0x000000);
		Square(1050,50,100,550,0xabebbe);
		Square(1050,530,100,30,0x123456);
		Square(1050,490,100,30,0x123456);		
		Square(1050,450,100,30,0x123456);
		Square(900,600,100,30,0xfffffff);
		if (selectedMode) {
			Square(80,600,150,30,0x123456);
		}
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces.length; j++) {
				if (edges[i][j] > 0) {
					drawLnOn(-keepTime,pieces[j].getX()+15,pieces[j].getY()+15,pieces[i].getX()+15,pieces[i].getY()+15,0xffffff,0x00ffaa);
				}
			}
		}
		
		for (int i = 0; i < pieces.length; i++) {
			pieces[i].draw();
		}
	}
	
	@Override
	public void write (Graphics g) {
		super.write(g);
		
		g.setColor(Color.WHITE);
		g.setColor(Color.WHITE);
		g.drawString("Your goal is to create an injective function.",110,120);
		
		g.drawString("Your may click elements of the domain and",110,160);
		g.drawString("map them to elements of the range.",110,180);
		
		g.drawString("An injective function is a function which",110,220);
		g.drawString("maps each element of the domain to a different element.",110,240);
		
		g.setColor(Color.BLUE);
		g.drawString("Sinks-", 1070, 75);
		g.drawString("Sinks+", 1070, 100);
		g.drawRect(1050, 60+25*ctrlY, 100, 20);
		
		g.setColor(Color.GREEN);
		g.drawString("Domain",600, 100);
		
		g.setColor(Color.RED);
		g.drawString("Range",950, 100);
	}
}