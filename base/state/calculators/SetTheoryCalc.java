package base.state.calculators;

import base.state.State;
import base.state.menu.CalculatorMenu;
import java.awt.Graphics;
import java.awt.Color;

public class SetTheoryCalc extends Calculator {

	private int ctrlX;
	private int ctrlY;
	private int logicX;
	private int logicY;
	private int store;
	
	public SetTheoryCalc() {
		ctrlX = 0;
		ctrlY = 0;
		logicX = 1;
		logicY = 1;
		store = 1;
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
		State s = new CalculatorMenu();
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
			logicX = 3*5*17*19;
		}
		else if (ctrlX == 0 && ctrlY == 0 && logicY == 2) {
			if (logicX % 3 != 0) {
				logicX *= 3;
			}
			if (logicX % 5 != 0) {
				logicX *= 5;
			}
			if (logicX % 17 != 0) {
				logicX *= 17;
			}
			if (logicX % 19 != 0) {
				logicX *= 19;
			}
			logicY = 1;
		}
		else if (ctrlX == 0 && ctrlY == 0 && logicY == 3) {
			int holder = logicX;
			logicX = 1;
			if (holder % 3 == 0) {
				logicX *= 3;
			}
			if (holder % 5 == 0) {
				logicX *= 5;
			}
			if (holder % 17 == 0) {
				logicX *= 17;
			}
			if (holder % 19 == 0) {
				logicX *= 19;
			}
			logicY = 1;
		}
		else if (ctrlX == 0 && ctrlY == 0 && logicY == 5) {
			if (logicX % 3 == 0) {
				logicX = logicX/3;
			}
			if (logicX % 5 == 0) {
				logicX = logicX/5;
			}
			if (logicX % 17 == 0) {
				logicX = logicX/17;
			}
			if (logicX % 19 == 0) {
				logicX = logicX/19;
			}
			logicY = 1;
		}
		else if (ctrlX == 0 && ctrlY == 1 && logicY == 1) {
			logicX = 3*7*13*19;
		}
		else if (ctrlX == 0 && ctrlY == 1 && logicY == 2) {
			if (logicX % 3 != 0) {
				logicX *= 3;
			}
			if (logicX % 7 != 0) {
				logicX *= 7;
			}
			if (logicX % 13 != 0) {
				logicX *= 13;
			}
			if (logicX % 19 != 0) {
				logicX *= 19;
			}
			logicY = 1;
		}
		else if (ctrlX == 0 && ctrlY == 1 && logicY == 3) {
			int holder = logicX;
			logicX = 1;
			if (holder % 3 == 0) {
				logicX *= 3;
			}
			if (holder % 7 == 0) {
				logicX *= 7;
			}
			if (holder % 13 == 0) {
				logicX *= 13;
			}
			if (holder % 19 == 0) {
				logicX *= 19;
			}
			logicY = 1;
		}
		else if (ctrlX == 0 && ctrlY == 1 && logicY == 5) {
			if (logicX % 3 == 0) {
				logicX = logicX/3;
			}
			if (logicX % 7 == 0) {
				logicX = logicX/7;
			}
			if (logicX % 13 == 0) {
				logicX = logicX/13;
			}
			if (logicX % 19 == 0) {
				logicX = logicX/19;
			}
			logicY = 1;
		}
		else if (ctrlX == 0 && ctrlY == 2 && logicY == 1) {
			logicX = 3*11*13*17;
		}
		else if (ctrlX == 0 && ctrlY == 2 && logicY == 2) {
			if (logicX % 3 != 0) {
				logicX *= 3;
			}
			if (logicX % 11 != 0) {
				logicX *= 11;
			}
			if (logicX % 13 != 0) {
				logicX *= 13;
			}
			if (logicX % 17 != 0) {
				logicX *= 17;
			}
			logicY = 1;
		}
		else if (ctrlX == 0 && ctrlY == 2 && logicY == 3) {
			int holder = logicX;
			logicX = 1;
			if (holder % 3 == 0) {
				logicX *= 3;
			}
			if (holder % 11 == 0) {
				logicX *= 11;
			}
			if (holder % 13 == 0) {
				logicX *= 13;
			}
			if (holder % 17 == 0) {
				logicX *= 17;
			}
			logicY = 1;
		}
		else if (ctrlX == 0 && ctrlY == 2 && logicY == 5) {
			if (logicX % 3 == 0) {
				logicX = logicX/3;
			}
			if (logicX % 11 == 0) {
				logicX = logicX/11;
			}
			if (logicX % 13 == 0) {
				logicX = logicX/13;
			}
			if (logicX % 17 == 0) {
				logicX = logicX/17;
			}
			logicY = 1;
		}
		else if (ctrlX == 1 && ctrlY == 0 && finEdge[13]) { //Union
			if (logicY != 2) {
				logicY = 2;
			}
			else {
				logicY = 1;
			}
		}
		else if (ctrlX == 1 && ctrlY == 1 && finEdge[4]) { //Intersect
			if (logicY != 3) {
				logicY = 3;
			}
			else {
				logicY = 1;
			}
		}
		else if (ctrlX == 1 && ctrlY == 2) { //Set Difference
			if (logicY != 5) {
				logicY = 5;
			}
			else {
				logicY = 1;
			}
		}
		else if (ctrlX == 1 && ctrlY == 3 && finEdge[3]) { //NOT
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
			if (logicX % 11 == 0) {
				logicX = logicX/11;
			}
			else {
				logicX *= 11;
			}
			if (logicX % 13 == 0) {
				logicX = logicX/13;
			}
			else {
				logicX *= 13;
			}
			if (logicX % 17 == 0) {
				logicX = logicX/17;
			}
			else {
				logicX *= 17;
			}
			if (logicX % 19 == 0) {
				logicX = logicX/19;
			}
			else {
				logicX *= 19;
			}
		}
		else if (ctrlX == 0 && ctrlY == 3 && logicY == 1) {
			logicX = 2*3*5*7*11*13*17*19;
		}
		else if (ctrlX == 0 && ctrlY == 3 && logicY == 2) {
			logicX = 2*3*5*7*11*13*17*19;
			logicY = 1;
		}
		else if (ctrlX == 0 && ctrlY == 3 && logicY == 3) {
			logicY = 1;
		}
		else if (ctrlX == 0 && ctrlY == 3 && logicY == 5) {
			logicX = 1;
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
		else if (ctrlX == 2 && ctrlY == 1 && logicY == 2) {
			if(logicX %2 != 0 && logicX % 2 == 0) {
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
			if(logicX %11 != 0 && store % 11 == 0) {
				logicX *= 11;
			}
			if(logicX %13 != 0 && store % 13 == 0) {
				logicX *= 13;
			}
			if(logicX %17 != 0 && store % 17 == 0) {
				logicX *= 17;
			}
			if(logicX %19 != 0 && store % 19 == 0) {
				logicX *= 19;
			}
			logicY = 1;
		}
		else if (ctrlX == 2 && ctrlY == 1 && logicY == 3) {
			if(logicX %2 == 0 && store % 2 != 0) {
				logicX = logicX/2;
			}
			if(logicX %3 == 0 && store % 3 != 0) {
				logicX = logicX/3;
			}
			if(logicX %5 == 0 && store % 5 != 0) {
				logicX = logicX/5;
			}
			if(logicX %7 == 0 && store % 7 != 0) {
				logicX = logicX/7;
			}
			if(logicX %11 == 0 && store % 11 != 0) {
				logicX = logicX/11;
			}
			if(logicX %13 == 0 && store % 13 != 0) {
				logicX = logicX/13;
			}
			if(logicX %17 == 0 && store % 17 != 0) {
				logicX = logicX/17;
			}
			if(logicX %19 == 0 && store % 19 != 0) {
				logicX = logicX/19;
			}
			logicY = 1;
		}
		else if (ctrlX == 2 && ctrlY == 1 && logicY == 5) {
			if(logicX %2 == 0 && store % 2 == 0) {
				logicX = logicX/2;
			}
			if(logicX %3 == 0 && store % 3 == 0) {
				logicX = logicX/3;
			}
			if(logicX %5 == 0 && store % 5 == 0) {
				logicX = logicX/5;
			}
			if(logicX %7 == 0 && store % 7 == 0) {
				logicX = logicX/7;
			}
			if(logicX %11 == 0 && store % 11 == 0) {
				logicX = logicX/11;
			}
			if(logicX %13 == 0 && store % 13 == 0) {
				logicX = logicX/13;
			}
			if(logicX %17 == 0 && store % 17 == 0) {
				logicX = logicX/17;
			}
			if(logicX %19 == 0 && store % 19 == 0) {
				logicX = logicX/19;
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
		Square(420,150,460,50,0x66ff66);
		Square(420,220,460,50,0x66ff66);
		if (logicX%2 == 0) { //Not A,B or C
			Square(10,125,400,325,0x777777);
			drawCirc(820,235,10,0xff1111);
		}
		else {
			Square(10,125,400,325,0x000000);
		}
		drawCirc(35,150,100,0x000000);
		drawCirc(160,150,100,0x000000);
		drawCirc(100,225,100,0x000000);
		drawAnnulus(135,250,100, 250, 0xff33aa);
		drawAnnulus(260,250,100,250, 0xff33aa);
		drawAnnulus(200,325,100,250, 0xff33aa);
		
		Square(430,155,40,40,0x3300aa);
		Square(500,165,20,20,0x3300aa);
		Square(550,155,40,40,0xff1111);
		Square(620,165,20,20,0xff1111);
		drawCirc(660,155,20,0x3300aa);
		drawCirc(720,165,10,0x3300aa);
		drawCirc(760,155,20,0xff1111);
		drawCirc(820,165,10,0xff1111);
		
		if (logicX%3 == 0) { //A,B,C
			for(int i = 35; i < 360; i++) {
				for(int j = 150; j < 425; j++) {
					if ((i-135)*(i-135)+(j-250)*(j-250) < 100*100 && (i-260)*(i-260)+(j-250)*(j-250) < 100*100 && (i-200)*(i-200)+(j-325)*(j-325) < 100*100)
						pix[i][j] = 0x777777;
				}
			}
			Square(430,225,40,40,0x3300aa);
		}
		if (logicX%5 == 0) { //A, not B or C
			for(int i = 35; i < 360; i++) {
				for(int j = 150; j < 425; j++) {
					if ((i-135)*(i-135)+(j-250)*(j-250) < 100*100 && (i-260)*(i-260)+(j-250)*(j-250) > 100*100 && (i-200)*(i-200)+(j-325)*(j-325) > 100*100)
						pix[i][j] = 0x777777;
				}
			}
			Square(620,235,20,20,0xff1111);
		}
		if (logicX%7 == 0) { //B, not A or C
			for(int i = 35; i < 360; i++) {
				for(int j = 150; j < 425; j++) {
					if ((i-135)*(i-135)+(j-250)*(j-250) > 100*100 && (i-260)*(i-260)+(j-250)*(j-250) < 100*100 && (i-200)*(i-200)+(j-325)*(j-325) > 100*100)
						pix[i][j] = 0x777777;
				}
			}
			drawCirc(720,235,10,0x3300aa);
		}
		if (logicX%11 == 0) { //C, not B or A
			for(int i = 35; i < 360; i++) {
				for(int j = 150; j < 425; j++) {
					if ((i-135)*(i-135)+(j-250)*(j-250) > 100*100 && (i-260)*(i-260)+(j-250)*(j-250) > 100*100 && (i-200)*(i-200)+(j-325)*(j-325) < 100*100)
						pix[i][j] = 0x777777;
				}
			}
			drawCirc(760,225,20,0xff1111);
		}
		if (logicX%13 == 0) { //B,C, not A
			for(int i = 35; i < 360; i++) {
				for(int j = 150; j < 425; j++) {
					if ((i-135)*(i-135)+(j-250)*(j-250) > 100*100 && (i-260)*(i-260)+(j-250)*(j-250) < 100*100 && (i-200)*(i-200)+(j-325)*(j-325) < 100*100)
						pix[i][j] = 0x777777;
				}
			}
			drawCirc(660,225,20,0x3300aa);
		}
		if (logicX%17 == 0) { //A,C, not B
			for(int i = 35; i < 360; i++) {
				for(int j = 150; j < 425; j++) {
					if ((i-135)*(i-135)+(j-250)*(j-250) < 100*100 && (i-260)*(i-260)+(j-250)*(j-250) > 100*100 && (i-200)*(i-200)+(j-325)*(j-325) < 100*100)
						pix[i][j] = 0x777777;
				}
			}
			Square(550,225,40,40,0xff1111);
		}
		if (logicX%19 == 0) { //A,B, not C
			for(int i = 35; i < 360; i++) {
				for(int j = 150; j < 425; j++) {
					if ((i-135)*(i-135)+(j-250)*(j-250) < 100*100 && (i-260)*(i-260)+(j-250)*(j-250) < 100*100 && (i-200)*(i-200)+(j-325)*(j-325) > 100*100)
						pix[i][j] = 0x777777;
				}
			}
			Square(500,235,20,20,0x3300aa);
		}
		
		Square(420,30,210,25,0x66ff66);
		if (store%2 == 0) {
			Square(50,30,80,65,0x777777);
			drawCirc(600,37,5,0xff1111);
		}
		else {
			Square(50,30,80,65,0x000000);
		}
		drawCirc(60,35,20,0x000000);
		drawCirc(80,35,20,0x000000);
		drawCirc(70,50,20,0x000000);
		drawAnnulus(80,55,20, 60, 0xff33aa);
		drawAnnulus(100,55,20, 60, 0xff33aa);
		drawAnnulus(90,70,20, 60, 0xff33aa);
		
		if (store%3 == 0) {
			for(int i = 50; i < 130; i++) {
				for(int j = 30; j < 95; j++) {
					if ((i-80)*(i-80)+(j-55)*(j-55) < 20*20 && (i-100)*(i-100)+(j-55)*(j-55) < 20*20 && (i-90)*(i-90)+(j-70)*(j-70) < 20*20)
						pix[i][j] = 0x777777;
				}
				Square(430,32,20,20,0x3300aa);
			}
		}
		if (store%5 == 0) {
			for(int i = 50; i < 130; i++) {
				for(int j = 30; j < 95; j++) {
					if ((i-80)*(i-80)+(j-55)*(j-55) < 20*20 && (i-100)*(i-100)+(j-55)*(j-55) > 20*20 && (i-90)*(i-90)+(j-70)*(j-70) > 20*20)
						pix[i][j] = 0x777777;
				}
			}
			Square(510,38,10,10,0xff1111);
		}
		if (store%7 == 0) {
			for(int i = 50; i < 130; i++) {
				for(int j = 30; j < 95; j++) {
					if ((i-80)*(i-80)+(j-55)*(j-55) > 20*20 && (i-100)*(i-100)+(j-55)*(j-55) < 20*20 && (i-90)*(i-90)+(j-70)*(j-70) > 20*20)
						pix[i][j] = 0x777777;
				}
			}
			drawCirc(555,37,5,0x3300aa);
		}
		if (store%11 == 0) {
			for(int i = 50; i < 130; i++) {
				for(int j = 30; j < 95; j++) {
					if ((i-80)*(i-80)+(j-55)*(j-55) > 20*20 && (i-100)*(i-100)+(j-55)*(j-55) > 20*20 && (i-90)*(i-90)+(j-70)*(j-70) < 20*20)
						pix[i][j] = 0x777777;
				}
			}
			drawCirc(573,32,10,0xff1111);
		}
		if (store%13 == 0) {
			for(int i = 50; i < 130; i++) {
				for(int j = 30; j < 95; j++) {
					if ((i-80)*(i-80)+(j-55)*(j-55) > 20*20 && (i-100)*(i-100)+(j-55)*(j-55) < 20*20 && (i-90)*(i-90)+(j-70)*(j-70) < 20*20)
						pix[i][j] = 0x777777;
				}
			}
			drawCirc(528,32,10,0x3300aa);
		}
		if (store%17 == 0) {
			for(int i = 50; i < 130; i++) {
				for(int j = 30; j < 95; j++) {
					if ((i-80)*(i-80)+(j-55)*(j-55) < 20*20 && (i-100)*(i-100)+(j-55)*(j-55) > 20*20 && (i-90)*(i-90)+(j-70)*(j-70) < 20*20)
						pix[i][j] = 0x777777;
				}
			}
			Square(480,32,20,20,0xff1111);
		}
		if (store%19 == 0) {
			for(int i = 50; i < 130; i++) {
				for(int j = 30; j < 95; j++) {
					if ((i-80)*(i-80)+(j-55)*(j-55) < 20*20 && (i-100)*(i-100)+(j-55)*(j-55) < 20*20 && (i-90)*(i-90)+(j-70)*(j-70) > 20*20)
						pix[i][j] = 0x777777;
				}
			}
			Square(460,38,10,10,0x3300aa);
		}
	}
	
	public void write(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawString("A", 115, 170);
		g.drawString("B", 280, 170);
		g.drawString("C", 190, 420);
		g.drawString("Universe", 20, 140);
		g.setColor(Color.BLACK);
		g.drawString("Universe:", 430, 144);
		g.drawString("Your Set:", 430, 214);
		g.drawString("A-Box", 945, 75);
		g.drawString("B-Blue", 945, 100);
		g.drawString("C-Big", 945, 125);
		g.drawString("U-All", 945, 150);
		if (finEdge[13]) {
			g.drawString("OR", 1005, 75);
		}
		if (finEdge[4]) {
			g.drawString("AND", 1005, 100);
		}
		g.drawString("-", 1005, 125);
		if (finEdge[3]) {
			g.drawString("NOT", 1005, 150);
		}
		g.drawString("Store", 1065, 75);
		g.drawString("Get", 1065, 100);
		g.drawString("Swap", 1065, 125);
		g.drawString("BACK", 1065, 150);

		g.setColor(Color.YELLOW);
		g.drawRect(940+60*ctrlX, 60+25*ctrlY, 50, 20);
		if (logicY == 2) {
			g.setColor(Color.RED);
			g.drawRect(1000, 60, 50, 20);
		}
		else if (logicY == 3) {
			g.setColor(Color.RED);
			g.drawRect(1000, 85, 50, 20);
		}
		else if (logicY == 5) {
			g.setColor(Color.RED);
			g.drawRect(1000, 110, 50, 20);
		}
	}
}