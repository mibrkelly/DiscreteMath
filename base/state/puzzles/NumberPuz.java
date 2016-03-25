/*The first puzzle. The player must build a logical and from only or and not gates.*/

package base.state.puzzles;

import base.state.*;
import base.state.puzzles.pieces.*;
import base.state.expPages.NumbersExp;
import base.state.menu.PuzMenu;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class NumberPuz extends Puzzle {
	
	private int ans;
	private int trials;
	
	public NumberPuz(int w, int h) {
		super(w,h,10);
		
		pieces[0] = new SourcePiece(600,125);
		pieces[1] = new SourcePiece(600,225);
		pieces[2] = new SourcePiece(600,325);
		pieces[3] = new SourcePiece(600,425);
		pieces[4] = new SourcePiece(600,525);
		pieces[5] = new SinkPiece(950,125,false);
		pieces[6] = new SinkPiece(950,225,false);
		pieces[7] = new SinkPiece(950,325,false);
		pieces[8] = new SinkPiece(950,425,false);
		pieces[9] = new SinkPiece(950,525,false);
		
		edges[0][5] = 0;
		edges[1][6] = 0;
		edges[2][7] = 0;
		edges[3][8] = 0;
		edges[4][9] = 0;
		
		Random rand = new Random();
		ans = rand.nextInt(32);
		
		trials = 5;
		
		whichOpen = 9;
	}
	
	public NumberPuz(int w, int h, int x) {
		super(w,h,10);
		
		pieces[0] = new SourcePiece(600,125);
		pieces[1] = new SourcePiece(600,225);
		pieces[2] = new SourcePiece(600,325);
		pieces[3] = new SourcePiece(600,425);
		pieces[4] = new SourcePiece(600,525);
		pieces[5] = new SinkPiece(950,125,false);
		pieces[6] = new SinkPiece(950,225,false);
		pieces[7] = new SinkPiece(950,325,false);
		pieces[8] = new SinkPiece(950,425,false);
		pieces[9] = new SinkPiece(950,525,false);
		
		edges[0][5] = 0;
		edges[1][6] = 0;
		edges[2][7] = 0;
		edges[3][8] = 0;
		edges[4][9] = 0;
		
		Random rand = new Random();
		ans = rand.nextInt(32);
		
		trials = x;
		
		whichOpen = 9;
	}
	
	@Override
	public State whichState(int x, int y) {
		if (1050 < x && x < 1150 && 450 < y && y < 480 && solved && trials == 1) {
			State s = new PuzMenu(getWidth(),getHeight(),"You have solved the \"numbers\" puzzle! Please continue!");
			return s;
		}
		if (1050 < x && x < 1150 && 450 < y && y < 480 && solved && trials != 1) {
			State s = new NumberPuz(getWidth(),getHeight(),trials-1);
			return s;
		}
		if (1050 < x && x < 1150 && 450 < y && y < 480 && !solved) {
			State s = new PuzMenu(getWidth(),getHeight(),"Sorry, but your solution was incorrect. Please choose a puzzle.");
			return s;
		}
		if (1050 < x && x < 1150 && 530 < y && y < 560) {
			State s = new NumbersExp(getWidth(), getHeight());
			return s;
		}
		if (1050 < x && x < 1150 && 490 < y && y < 520) {
			State s = new NumberPuz(getWidth(), getHeight());
			return s;
		}
		return this;
	}
	
	@Override
	public void runCheck() {
		int num = 0;
		if (pieces[5].getOut() != 0) {
			num++;
		}
		if (pieces[6].getOut() != 0) {
			num+=2;
		}
		if (pieces[7].getOut() != 0) {
			num+=4;
		}
		if (pieces[8].getOut() != 0) {
			num+=8;
		}
		if (pieces[9].getOut() != 0) {
			num+=16;
		}
		if (num == ans) {
			solved = true;
		}
	}
	
	@Override
	public void write (Graphics g) {
		super.write(g);
		
		String times = Integer.toString(trials);
		g.setColor(Color.WHITE);
		g.drawString("Numbers to get right: " + times,110,100);
		g.drawString("This is the next value to find:",110,120);
		g.drawString("Base 10:",110,140);
		g.drawString(String.valueOf(ans),110,160);
		g.drawString("Your answer base 2:",110,200);
		String d1, d2, d3, d4, d5, binary;
		if (pieces[0].getOut() == 0) {
			d1 = "0";
		}
		else {
			d1 = "1";
		}
		if (pieces[1].getOut() == 0) {
			d2 = "0";
		}
		else {
			d2 = "1";
		}
		if (pieces[2].getOut() == 0) {
			d3 = "0";
		}
		else {
			d3 = "1";
		}
		if (pieces[3].getOut() == 0) {
			d4 = "0";
		}
		else {
			d4 = "1";
		}
		if (pieces[4].getOut() == 0) {
			d5 = "0";
		}
		else {
			d5 = "1";
		}
		binary = d5 + d4 + d3 + d2 + d1;
		g.drawString(binary,110,220);
		
		g.setColor(Color.GREEN);
		g.drawString("1",610,145);
		g.drawString("2",610,245);
		g.drawString("4",610,345);
		g.drawString("8",610,445);
		g.drawString("16",610,545);
		g.setColor(Color.RED);
		g.drawString("1",960,145);
		g.drawString("2",960,245);
		g.drawString("4",960,345);
		g.drawString("8",960,445);
		g.drawString("16",960,545);
		int num = 0;
		if (pieces[5].getOut() != 0) {
			num++;
		}
		if (pieces[6].getOut() != 0) {
			num+=2;
		}
		if (pieces[7].getOut() != 0) {
			num+=4;
		}
		if (pieces[8].getOut() != 0) {
			num+=8;
		}
		if (pieces[9].getOut() != 0) {
			num+=16;
		}
		String sum = Integer.toString(num);
		g.drawString(sum,900,620);

	}
}