package base.state.puzzles;

import base.state.State;
import base.state.expPages.SetDeMorgansExp;
import base.state.calculators.Calculator;
import base.state.menu.PuzMenu;

import java.awt.Graphics;
import java.awt.Color;

public class SetDeMorganPuz extends Calculator {

	private int ctrlX;
	private int ctrlY;
	private int logicX;
	private int logicY;
	private int store;
	private int level;
	
	public SetDeMorganPuz() {
		ctrlX = 0;
		ctrlY = 0;
		logicX = 1;
		logicY = 1;
		store = 1;
		level = 1;
	}
	
	public boolean clickedAt(int x, int y) {
		return false;
	}
	
	public void pressedAt(int x, int y) {
	}
	
	public void draggedTo(int x, int y) {
	}
	
	public void released() {
	}
	
	public State whichState(int x, int y) {
		if (level == 5) {
			finEdge[26] = true;
			State s = new PuzMenu(getWidth(),getHeight(),"You have solved the \"set De Morgan's\" puzzle! Please continue!");
			return s;
		}
		State s = new SetDeMorgansExp(getWidth(),getHeight());
		return s;
	}
	
	

	public void pressUp() {
		ctrlY--;
		ctrlY = ((ctrlY%4)+4)%4;
	}
	
	public void pressDown() {
		ctrlY++;
		ctrlY = ((ctrlY%4)+4)%4;
	}
	
	public void pressLeft() {
		ctrlX--;
		ctrlX = (ctrlX%3+3)%3;
	}
	
	public void pressRight() {
		ctrlX++;
		ctrlX = (ctrlX%3+3)%3;
	}
	
	public boolean pressEnter() {
		if (ctrlX == 0 && ctrlY == 0 && logicY == 1) {
			logicX = 2*3;
		}
		else if (ctrlX == 0 && ctrlY == 0 && logicY == 3 && (level == 2 || level == 3)) {
			int holder = logicX;
			logicX = 1;
			if (holder % 2 == 0) {
				logicX *= 2;
			}
			if (holder % 3 == 0) {
				logicX *= 3;
			}
			logicY = 1;
		}
		else if (ctrlX == 0 && ctrlY == 0 && logicY == 3 && (level == 1 || level == 4)) {
			if (logicX % 2 != 0) {
				logicX *= 2;
			}
			if (logicX % 3 != 0) {
				logicX *= 3;
			}
			logicY = 1;
		}
		else if (ctrlX == 0 && ctrlY == 1 && logicY == 1) {
			logicX = 3*5;
		}
		else if (ctrlX == 0 && ctrlY == 1 && logicY == 3 && (level == 2 || level == 3)) {
			int holder = logicX;
			logicX = 1;
			if (holder % 3 == 0) {
				logicX *= 3;
			}
			if (holder % 5 == 0) {
				logicX *= 5;
			}
			logicY = 1;
		}
		else if (ctrlX == 0 && ctrlY == 1 && logicY == 3 && (level == 1 || level == 4)) {
			if (logicX % 3 != 0) {
				logicX *= 3;
			}
			if (logicX % 5 != 0) {
				logicX *= 5;
			}
			logicY = 1;
		}
		else if (ctrlX == 1 && ctrlY == 0) { //Intersect
			if (logicY != 3) {
				logicY = 3;
			}
			else {
				logicY = 1;
			}
		}
		else if (ctrlX == 1 && ctrlY == 1) { //NOT
			if (logicX % 2 == 0) {
				logicX = logicX/2;
			}
			else {
				logicX *= 2;
			}
			if (logicX % 3 == 0) {
				logicX = logicX/3;
			}
			else {
				logicX *= 3;
			}
			if (logicX % 5 == 0) {
				logicX = logicX/5;
			}
			else {
				logicX *= 5;
			}
			if (logicX % 7 == 0) {
				logicX = logicX/7;
			}
			else {
				logicX *= 7;
			}
		}
		else if (ctrlX == 1 && ctrlY == 2) {
			if (level == 4 && logicX == 2*5*7) {
				level++;
				return true;
			}
			else if (level == 3 && logicX == 7) {
				level++;
			}
			else if (level == 2 && logicX == 2*5*7) {
				level++;
			}
			else if (level == 1 && logicX == 7) {
				level++;
			}
		}
		else if (ctrlX == 0 && ctrlY == 2 && (logicY == 1 || level == 1 || level == 4)) {
			logicX = 2*3*5*7;
			logicY = 1;
		}
		else if (ctrlX == 0 && ctrlY == 2 && logicY == 3 && (level == 2 || level == 3)) {
			logicY = 1;
		}
		else if (ctrlX == 2 && ctrlY == 0) {
			store = logicX;
			logicX = 1;
		}
		else if (ctrlX == 2 && ctrlY == 2) {
			int n = logicX;
			logicX = store;
			store = n;
		}
		else if (ctrlX == 2 && ctrlY == 1 && logicY == 1) {
			logicX = store;
		}
		else if (ctrlX == 2 && ctrlY == 1 && logicY == 3 && (level == 2 || level == 3)) {
			int holder = logicX;
			logicX = 1;
			if(holder %2 == 0 && store % 2 == 0) {
				logicX *= 2;
			}
			if(holder %3 == 0 && store % 3 == 0) {
				logicX *= 3;
			}
			if(holder %5 == 0 && store % 5 == 0) {
				logicX *= 5;
			}
			if(holder %7 == 0 && store % 7 == 0) {
				logicX *= 7;
			}
			logicY = 1;
		}
		else if (ctrlX == 2 && ctrlY == 1 && logicY == 3 && (level == 1 || level == 4)) {
			if(logicX %2 != 0 && store % 2 == 0) {
				logicX *= 2;
			}
			if(logicX %3 != 0 && store % 3 == 0) {
				logicX *= 3;
			}
			if(logicX %5 != 0 && store % 5 == 0) {
				logicX *= 5;
			}
			if(logicX %7 != 0 && store % 7 == 0) {
				logicX *= 7;
			}
			logicY = 1;
		}
		else if (ctrlX == 2 && ctrlY == 3) {
			return true;
		}
		return false;
	}
	
	public void pressA() {
		
	}
	
	public void pressS() {
		
	}
	
	public void pressD() {
		
	}
	
	public void pressW() {
		
	}
	
	public void render(int keepTime) {
		clear(0x009999);
		
		if (logicX%7 == 0) { //Not A,B or C
			Square(10,125,400,325,0x777777);
		}
		else {
			Square(10,125,400,325,0x000000);
		}
		drawCirc(35,150,100,0x000000);
		drawCirc(160,150,100,0x000000);
		drawAnnulus(135,250,100, 250, 0xff33aa);
		drawAnnulus(260,250,100,250, 0xff33aa);
		
		if (logicX%2 == 0) { //A not B
			for(int i = 35; i < 360; i++) {
				for(int j = 150; j < 425; j++) {
					if ((i-135)*(i-135)+(j-250)*(j-250) < 100*100 && (i-260)*(i-260)+(j-250)*(j-250) > 100*100 && (i-200)*(i-200)+(j-325)*(j-325) > 100*100)
						pix[i][j] = 0x777777;
				}
			}
			for(int i = 35; i < 360; i++) {
				for(int j = 150; j < 425; j++) {
					if ((i-135)*(i-135)+(j-250)*(j-250) < 100*100 && (i-260)*(i-260)+(j-250)*(j-250) > 100*100 && (i-200)*(i-200)+(j-325)*(j-325) < 100*100)
						pix[i][j] = 0x777777;
				}
			}
		}
		if (logicX%3 == 0) { //A and B
			for(int i = 35; i < 360; i++) {
				for(int j = 150; j < 425; j++) {
					if ((i-135)*(i-135)+(j-250)*(j-250) < 100*100 && (i-260)*(i-260)+(j-250)*(j-250) < 100*100 && (i-200)*(i-200)+(j-325)*(j-325) < 100*100)
						pix[i][j] = 0x777777;
				}
			}
			for(int i = 35; i < 360; i++) {
				for(int j = 150; j < 425; j++) {
					if ((i-135)*(i-135)+(j-250)*(j-250) < 100*100 && (i-260)*(i-260)+(j-250)*(j-250) < 100*100 && (i-200)*(i-200)+(j-325)*(j-325) > 100*100)
						pix[i][j] = 0x777777;
				}
			}
		}
		if (logicX%5 == 0) { //B not A
			for(int i = 35; i < 360; i++) {
				for(int j = 150; j < 425; j++) {
					if ((i-135)*(i-135)+(j-250)*(j-250) > 100*100 && (i-260)*(i-260)+(j-250)*(j-250) < 100*100 && (i-200)*(i-200)+(j-325)*(j-325) > 100*100)
						pix[i][j] = 0x777777;
				}
			}
			for(int i = 35; i < 360; i++) {
				for(int j = 150; j < 425; j++) {
					if ((i-135)*(i-135)+(j-250)*(j-250) > 100*100 && (i-260)*(i-260)+(j-250)*(j-250) < 100*100 && (i-200)*(i-200)+(j-325)*(j-325) < 100*100)
						pix[i][j] = 0x777777;
				}
			}
		}
		if (logicX%7 == 0) { //Niether A nor B
			for(int i = 35; i < 360; i++) {
				for(int j = 150; j < 425; j++) {
					if ((i-135)*(i-135)+(j-250)*(j-250) > 100*100 && (i-260)*(i-260)+(j-250)*(j-250) > 100*100 && (i-200)*(i-200)+(j-325)*(j-325) < 100*100)
						pix[i][j] = 0x777777;
				}
			}
		}
		
		if (store%7 == 0) {
			Square(50,30,80,65,0x777777);
		}
		else {
			Square(50,30,80,65,0x000000);
		}
		drawCirc(60,35,20,0x000000);
		drawCirc(80,35,20,0x000000);
		drawAnnulus(80,55,20, 60, 0xff33aa);
		drawAnnulus(100,55,20, 60, 0xff33aa);
		
		if (store%2 == 0) {
			for(int i = 50; i < 130; i++) {
				for(int j = 30; j < 95; j++) {
					if ((i-80)*(i-80)+(j-55)*(j-55) < 20*20 && (i-100)*(i-100)+(j-55)*(j-55) > 20*20 && (i-90)*(i-90)+(j-70)*(j-70) < 20*20)
						pix[i][j] = 0x777777;
				}
			}
			for(int i = 50; i < 130; i++) {
				for(int j = 30; j < 95; j++) {
					if ((i-80)*(i-80)+(j-55)*(j-55) < 20*20 && (i-100)*(i-100)+(j-55)*(j-55) > 20*20 && (i-90)*(i-90)+(j-70)*(j-70) > 20*20)
						pix[i][j] = 0x777777;
				}
			}
			
		}
		if (store%3 == 0) {
			for(int i = 50; i < 130; i++) {
				for(int j = 30; j < 95; j++) {
					if ((i-80)*(i-80)+(j-55)*(j-55) < 20*20 && (i-100)*(i-100)+(j-55)*(j-55) < 20*20 && (i-90)*(i-90)+(j-70)*(j-70) > 20*20)
						pix[i][j] = 0x777777;
				}
			}
			for(int i = 50; i < 130; i++) {
				for(int j = 30; j < 95; j++) {
					if ((i-80)*(i-80)+(j-55)*(j-55) < 20*20 && (i-100)*(i-100)+(j-55)*(j-55) < 20*20 && (i-90)*(i-90)+(j-70)*(j-70) < 20*20)
						pix[i][j] = 0x777777;
				}
			}
		}
		if (store%5 == 0) {
			for(int i = 50; i < 130; i++) {
				for(int j = 30; j < 95; j++) {
					if ((i-80)*(i-80)+(j-55)*(j-55) > 20*20 && (i-100)*(i-100)+(j-55)*(j-55) < 20*20 && (i-90)*(i-90)+(j-70)*(j-70) > 20*20)
						pix[i][j] = 0x777777;
				}
			}
			for(int i = 50; i < 130; i++) {
				for(int j = 30; j < 95; j++) {
					if ((i-80)*(i-80)+(j-55)*(j-55) > 20*20 && (i-100)*(i-100)+(j-55)*(j-55) < 20*20 && (i-90)*(i-90)+(j-70)*(j-70) < 20*20)
						pix[i][j] = 0x777777;
				}
			}
		}
	}
	
	public void write(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawString("A", 115, 170);
		g.drawString("B", 280, 170);
		g.drawString("Universe", 20, 140);
		g.setColor(Color.BLACK);
		g.drawString("A", 945, 75);
		g.drawString("B", 945, 100);
		g.drawString("U-All", 945, 125);
		if (level == 2 || level == 3) {
			g.drawString("AND", 1005, 75);
		}
		if (level == 1 || level == 4) {
			g.drawString("OR", 1005, 75);
		}
		g.drawString("NOT", 1005, 100);
		g.drawString("SOLVE", 1005, 125);
		g.drawString("Store", 1065, 75);
		g.drawString("Get", 1065, 100);
		g.drawString("Swap", 1065, 125);
		g.drawString("BACK", 1065, 150);
		
		g.setColor(Color.WHITE);
		if (level == 1) {
			g.drawString("LEVEL 1:", 15, 470);
			g.drawString("Your goal is to create the set that contains everything outside of A and B.", 15, 490);
		}
		if (level == 2) {
			g.drawString("LEVEL 1 Complete!:", 15, 470);
			g.drawString("LEVEL 2:", 15, 490);
			g.drawString("Your goal is to create the set that contains everything not in common to A and B.", 15, 510);
		}
		if (level == 3) {
			g.drawString("LEVEL 1 Complete!:", 15, 470);
			g.drawString("LEVEL 2 Complete!:", 15, 490);
			g.drawString("LEVEL 3:", 15, 510);
			g.drawString("Your goal is to create the set that contains everything outside of A and B.", 15, 530);
		}
		if (level == 4) {
			g.drawString("LEVEL 1 Complete!:", 15, 470);
			g.drawString("LEVEL 2 Complete!:", 15, 490);
			g.drawString("LEVEL 3 Complete!:", 15, 510);
			g.drawString("LEVEL 4:", 15, 530);
			g.drawString("Your goal is to create the set that contains everything not in common to A and B.", 15, 550);
		}
		
		g.setColor(Color.YELLOW);
		g.drawRect(940+60*ctrlX, 60+25*ctrlY, 50, 20);
		if (logicY == 3) {
			g.setColor(Color.RED);
			g.drawRect(1000, 60, 50, 20);
		}
	}
}