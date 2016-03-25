package base.state.calculators;

import base.state.State;
import base.state.menu.CalculatorMenu;
import java.awt.Graphics;
import java.awt.Color;

public class ModCalc extends Calculator {
	
	private int ctrlX, ctrlY, spin, modBy, horNums, verNums, calcIn, calcOut;
	
	public ModCalc() {
		ctrlX = 0;
		ctrlY = 0;
		spin = 372;
		modBy = 3;
		horNums = 0;//numbers on line
		verNums = 0;
		calcIn = 0;
		calcOut = 0;
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
		ctrlY = ((ctrlY%6)+6)%6; //moves box locater
	}
	
	public void pressDown() {
		ctrlY++;                   //moves box locater
		ctrlY = ((ctrlY%6)+6)%6;
	}
	
	
	public void pressLeft() {
		ctrlX--;                    //moves box locater
		ctrlX = (ctrlX%3+3)%3;
	}
	
	public void pressRight() {
		ctrlX++;                 //moves box locater
		ctrlX = (ctrlX%3+3)%3;
	}
	public boolean pressEnter() {
		if (ctrlX == 0 && ctrlY == 0 && calcIn < 999 && calcIn > -999) { //adds 1
			calcIn = calcIn*10+1;
		}
		if (ctrlX == 1 && ctrlY == 0 && calcIn < 999 && calcIn > -999) {//adds 2
			calcIn = calcIn*10+2;
		}
		if (ctrlX == 2 && ctrlY == 0 && calcIn < 999 && calcIn > -999) { //adds 3
			calcIn = calcIn*10+3;
		}
		if (ctrlX == 0 && ctrlY == 1 && calcIn < 999 && calcIn > -999) { //adds 4
			calcIn = calcIn*10+4;
		}
		if (ctrlX == 1 && ctrlY == 1 && calcIn < 999 && calcIn > -999) { //adds 5
			calcIn = calcIn*10+5;
		}
		if (ctrlX == 2 && ctrlY == 1 && calcIn < 999 && calcIn > -999) { //adds 6
			calcIn = calcIn*10+6;
		}
		if (ctrlX == 0 && ctrlY == 2 && calcIn < 999 && calcIn > -999) { //adds 7
			calcIn = calcIn*10+7;
		}
		if (ctrlX == 1 && ctrlY == 2 && calcIn < 999 && calcIn > -999) { //adds 8
			calcIn = calcIn*10+8;
		}
		if (ctrlX == 2 && ctrlY == 2 && calcIn < 999 && calcIn > -999) { //adds 9
			calcIn = calcIn*10+9;
		}
		if (ctrlX == 0 && ctrlY == 3 && calcIn < 999 && calcIn > -999) { //adds 0
			calcIn = calcIn*10;
		}
		if (ctrlX == 1 && ctrlY == 3 && calcIn < 999 && calcIn > -999) { //+
			calcOut = calcIn + calcOut;
			calcIn = 0;
			spin = 372;
		}
		if (ctrlX == 2 && ctrlY == 3 && calcIn < 999 && calcIn > -999) { //-
			calcOut = calcOut-calcIn;
			calcIn = 0;
			spin = 372;
		}
		if (ctrlX == 0 && ctrlY == 4 && calcIn < 999 && calcIn > -999) { //*
			calcOut = calcOut*calcIn;
			calcIn = 0;
			spin = 372;
		}
		if (ctrlX == 1 && ctrlY == 4) { //=
			calcOut = calcIn;
			calcIn = 0;
			spin = 372;
		}
		if (ctrlX == 2 && ctrlY == 4 && calcIn > 0 && calcIn < 21) { //mod button
			modBy = calcIn;
			calcIn = 0;
			spin = 372;
		}
		if (ctrlX == 0 && ctrlY == 5) {  //clear
			calcIn = 0;
			calcOut = 0;
		}
		horNums = calcOut; //are these for the answer after using calc?
		verNums = calcOut;
		if (ctrlX == 2 && ctrlY == 5) {  //back
			return true;
		}
		return false;
	}
	
	public void pressA() {
		spin = ((spin-1)%(modBy*930)+(modBy*930))%(modBy*930);
		if (spin%93 == 92) {
			horNums++;
			calcOut++;
		}
	}
	
	public void pressS() {
		if (modBy > 1) {
			modBy--;
			spin = 372;
			horNums = verNums;
		}
	}
	
	public void pressD() {
		spin = ((spin+1)%(modBy*930)+(modBy*930))%(modBy*930);
		if (spin%93 == 0) {
			horNums--;
			calcOut--;
		}
	}
	
	public void pressW() {
		if (modBy < 20) {
			modBy++;
			spin = 372;
			horNums = verNums;
		}
	}
	
	public void render(int keepTime) {
		clear(0x990099);
		
		Square(10,10,880,530,0x000000);
		drawAnnulus(450,215,180,900,0xffffff);
		for (int i = 0; i < modBy; i++) {
			drawCell(450+(int)(180*Math.sin(2*i*Math.PI/modBy+2*Math.PI*(spin-460)/(93*modBy))),(int)(215+180*Math.cos(2*i*Math.PI/modBy+2*Math.PI*(spin-460)/(modBy*93))),20,0x000000);
			drawAnnulus((int)(450+180*Math.sin(2*i*Math.PI/modBy+2*Math.PI*(spin-460)/(93*modBy))),(int)(215+180*Math.cos(2*i*Math.PI/modBy+2*Math.PI*(spin-460)/(modBy*93))),20,100,0xffffff);
		}
		Square(10,650-220,1200-320,3,0xffffff);
		for (int i = 0; i < 10; i++) {
			drawBdCell(-10+((spin+93*i)%930+930)%930,430,20,0x000000);
			drawBdAnnulus(-10+((spin+93*i)%930+930)%930,430,20,100,0xffffff);
		}
	}
	
	public void write(Graphics g) {
		g.setColor(Color.WHITE);
		int n = modBy;
		for (int i = -5; i < 5; i++) {
			if (450+93*i+((spin+93*i)%93+93)%93 > 10 && 450+93*i+((spin+93*i)%93+93)%93 < 890) {
				g.drawString(String.valueOf(horNums+i),450+93*i+((spin+93*i)%93+93)%93,430);
			}
		}
		for (int i = 0; i < n; i++) {
			g.drawString(String.valueOf((verNums+i+n-1)%n), 450+(int)(180*Math.sin(2*i*Math.PI/n+2*Math.PI*(spin-460)/(93*n))), (int)(215+180*Math.cos(2*i*Math.PI/n+2*Math.PI*(spin-460)/(n*93))));
		}
		g.setColor(Color.YELLOW);
		g.drawRect(940+60*ctrlX, 60+25*ctrlY, 50, 20);
		g.setColor(Color.BLACK);
			g.drawString("1", 945, 75);
			g.drawString("4", 945, 100);
			g.drawString("7", 945, 125);
			g.drawString("0", 945, 150);
			g.drawString("*", 945, 175);
			g.drawString("CLEAR", 945, 200);
			g.drawString("2", 1005, 75);
			g.drawString("5", 1005, 100);
			g.drawString("8", 1005, 125);
			g.drawString("+", 1005, 150);
			g.drawString("=", 1005, 175);
			g.drawString("3", 1065, 75);
			g.drawString("6", 1065, 100);
			g.drawString("9", 1065, 125);
			g.drawString("-", 1065, 150);
			g.drawString("MOD", 1065, 175);
			g.drawString("BACK", 1065, 200);

		g.setColor(Color.DARK_GRAY);
		g.drawString(String.valueOf(calcIn), 1065, 225);
		g.drawString(String.valueOf(calcOut), 1065, 250);
		g.drawString(String.valueOf(calcOut%modBy), 1065, 275);
		String s = "mod " + modBy;
		g.drawString(s, 1115,275);
		g.setColor(Color.RED);
		g.drawRect(1060, 210, 50, 20);
		g.drawRect(1060, 235, 50, 20);
		g.setColor(Color.CYAN);
		g.drawRect(1060, 260, 50, 20);
	}
	
	private void drawBdCell (int x, int y, int radius, int color) {
		for(int i = -radius; i < radius; i++) {
			for(int j = -radius; j < radius; j++) {
				if(i*i+j*j < radius*radius && x+i > 10 && x+i < 890)
					pix[x+i][y+j] = color;
			}
		}
	}
	
	private void drawBdAnnulus (int x, int y, int radius, int thick, int color) {
		for(int i = -radius; i < radius; i++) {
			for(int j = -radius; j < radius; j++) {
				if (radius*radius-thick < i*i+j*j && i*i+j*j < radius*radius && x+i > 10 && x+i < 890)
					pix[x+i][y+j] = color;
			}
		}
	}
	
	private void drawCell (int x, int y, int radius, int color) {
		for(int i = -radius; i < radius; i++) {
			for(int j = -radius; j < radius; j++) {
				if(i*i+j*j < radius*radius)
					pix[x+i][y+j] = color;
			}
		}
	}
}