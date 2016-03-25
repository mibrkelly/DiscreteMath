package base.state.puzzles;

import base.state.State;
import base.state.menu.PuzMenu;
import base.state.expPages.LogicDeMorgansExp;
import base.state.calculators.Calculator;
import java.awt.Graphics;
import java.awt.Color;

public class LogicDeMorganPuz extends Calculator {
	
	private int ctrlX, ctrlY, logic, store, opps, storeOpps, redbox, level;
	private String currStatement, storeStatement;
	
	public LogicDeMorganPuz() {
		
		currStatement = "";
		logic = 0; //Product of primes to denote truth values of current statement
		opps = 0; //Number of operations in the statement
		storeStatement = "";
		store = 0;
		storeOpps = 0;
		redbox = 0;
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
			finEdge[23] = true;
			State s = new PuzMenu(getWidth(), getHeight(),"You have solved the \"De Morgan's logic\" puzzle! Please continue!");
			return s;
		}
		State s = new LogicDeMorgansExp(getWidth(), getHeight());
		return s;
	}

	public void pressUp() {
		ctrlY--;
		ctrlY = (ctrlY%4+4)%4;
	}
	
	public void pressDown() {
		ctrlY++;
		ctrlY = (ctrlY%4+4)%4;
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
		if (ctrlX == 0 && ctrlY == 0 && opps < 6) { //p
			if (redbox == 0 || opps == 0) {
				currStatement = "p";
				logic = 2*3;
				opps = 1;
			}		
			else if (redbox == 1) {
				if (opps == 1) {
					currStatement = currStatement + "^p";
				}
				else {
					currStatement = "(" + currStatement + ")^p";
				}
				if (logic%5 == 0) {
					logic = logic/5;
				}
				if (logic%7 == 0) {
					logic = logic/7;
				}
				opps++;
				storeOpps++;
			}
			else if (redbox == 2) {
				if (opps == 1) {
					currStatement = currStatement + "vp";
				}
				else {
					currStatement = "(" + currStatement + ")vp";
				}
				if (logic%2 != 0) {
					logic=logic*2;
				}
				if (logic%3 != 0) {
					logic=logic*3;
					opps++;
				}
			}
			redbox = 0;
		}
		if (ctrlX == 1 && ctrlY == 0 && opps < 6) { //q
			if (redbox == 0 || opps == 0) {
				currStatement = "q";
				logic = 2*5;
				opps = 1;
			}
			else if (redbox == 1) {
				if (opps == 1) {
					currStatement = currStatement + "^q";
				}
				else {
					currStatement = "(" + currStatement + ")^q";
				}
				if (logic%3 == 0) {
					logic=logic/3;
				}
				if (logic%7 == 0) {
					logic=logic/7;
				}
				opps++;
			}
			else if (redbox == 2) {
				if (opps == 1) {
					currStatement = currStatement + "vq";
				}
				else {
					currStatement = "(" + currStatement + ")vq";
				}
				if (logic%2 != 0) {
					logic=logic*2;
				}
				if (logic%5 != 0) {
					logic=logic*5;
				}
				opps++;
			}
			redbox = 0;
		}
		if (ctrlX == 2 && ctrlY == 0) {
			if (level == 4 && logic == 2) {
				level++;
				return true;
			}
			else if (level == 3 && logic == 2*3*5) {
				level++;
			}
			else if (level == 2 && logic == 2*3*5) {
				level++;
			}
			else if (level == 1 && logic == 2) {
				level++;
			}
		}
		if (ctrlX == 0 && ctrlY == 1 && (level == 3 || level == 4)) { //and
			redbox = 1;
		}
		if (ctrlX == 1 && ctrlY == 1 && (level == 1 || level == 2)) { //or
			redbox = 2;
		}
		if (ctrlX == 2 && ctrlY == 1 && opps < 6) { //not
			if (opps == 1) {
				currStatement = "-" + currStatement;
				opps = 2;
			}
			else if (opps > 1) {
				currStatement = "-(" + currStatement + ")";
				opps++;
			}
			if (opps != 0) {
				if (logic%2 == 0) {
					logic=logic/2;
				}
				else {
					logic=logic*2;
				}
				if (logic%3 == 0) {
					logic=logic/3;
				}
				else {
					logic=logic*3;
				}
				if (logic%5 == 0) {
					logic=logic/5;
				}
				else {
					logic=logic*5;
				}
				if (logic%7 == 0) {
					logic=logic/7;
				}
				else {
					logic=logic*7;
				}
			}
		}
		if (ctrlX == 0 && ctrlY == 2 && opps < 7) { //store
			storeStatement = currStatement;
			store = logic;
			storeOpps = opps;
			logic = 0;
			opps = 0;
			currStatement = "";
		}
		if (ctrlX == 1 && ctrlY == 2) { //get
			if (redbox == 0 || opps == 0 || storeOpps == 0) {
				currStatement = storeStatement;
				logic = store;
				opps = storeOpps;
			}
			else if (redbox == 1) {
				if (opps == 1 && storeOpps == 1) {
					currStatement = currStatement + "^" + storeStatement;
				}
				else if (opps > 1 && storeOpps == 1){
					currStatement = "(" + currStatement + ")^" + storeStatement;
				}
				else if (opps == 1 && storeOpps > 1){
					currStatement = currStatement + "^(" + storeStatement + ")";
				}
				else {
					currStatement = "(" + currStatement + ")^(" + storeStatement + ")";
				}
				if (logic%2 == 0 && store%2 != 0) {
					logic=logic/2;
				}
				if (logic%3 == 0 && store%3 != 0) {
					logic=logic/3;
				}
				if (logic%5 == 0 && store%5 != 0) {
					logic=logic/5;
				}
				if (logic%7 == 0 && store%7 != 0) {
					logic=logic/7;
				}
				opps += storeOpps;
			}
			else if (redbox == 2) {
				if (opps == 1 && storeOpps == 1) {
					currStatement = currStatement + "v" + storeStatement;
				}
				else if (opps > 1 && storeOpps == 1){
					currStatement = "(" + currStatement + ")v" + storeStatement;
				}
				else if (opps == 1 && storeOpps > 1){
					currStatement = currStatement + "v(" + storeStatement + ")";
				}
				else {
					currStatement = "(" + currStatement + ")v(" + storeStatement + ")";
				}
				if (logic%2 != 0 && store%2 == 0) {
					logic=logic*2;
				}
				if (logic%3 != 0 && store%3 == 0) {
					logic=logic*3;
				}
				if (logic%5 != 0 && store%5 == 0) {
					logic=logic*5;
				}
				if (logic%7 != 0 && store%7 == 0) {
					logic=logic*7;
				}
				opps += storeOpps;
			}
			
			store = 0;
			storeOpps = 0;
			redbox = 0;
		}
		if (ctrlX == 2 && ctrlY == 2) { //clear
			logic = 0;
			opps = 0;
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
		clear(0x000099);
	}
	public void write(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawString("p            q", 50, 100);
		g.drawString("-            -", 50, 125);
		g.drawString("T            T", 50, 150);
		g.drawString("T            F", 50, 175);
		g.drawString("F            T", 50, 200);
		g.drawString("F            F", 50, 225);
		if (opps > 0) {
			g.drawString(currStatement, 250, 100);
			g.drawString("--------------", 250, 125);
			if (logic%2 == 0) {
				g.drawString("T", 250, 150);
			}
			else {
				g.drawString("F", 250, 150);
			}
			if (logic%3 == 0) {
				g.drawString("T", 250, 175);
			}
			else {
				g.drawString("F", 250, 175);
			}
			if (logic%5 == 0) {
				g.drawString("T", 250, 200);
			}
			else {
				g.drawString("F", 250, 200);
			}
			if (logic%7 == 0) {
				g.drawString("T", 250, 225);
			}
			else {
				g.drawString("F", 250, 225);
			}
		}
		if (storeOpps > 0) {
			g.setColor(Color.GREEN);
			g.drawString(storeStatement, 675, 100);
			g.drawString("--------------", 675, 125);
			if (store%2 == 0) {
				g.drawString("T", 675, 150);
			}
			else {
				g.drawString("F", 675, 150);
			}
			if (store%3 == 0) {
				g.drawString("T", 675, 175);
			}
			else {
				g.drawString("F", 675, 175);
			}
			if (store%5 == 0) {
				g.drawString("T", 675, 200);
			}
			else {
				g.drawString("F", 675, 200);
			}
			if (store%7 == 0) {
				g.drawString("T", 675, 225);
			}
			else {
				g.drawString("F", 675, 225);
			}
		}
		if (redbox == 1) {
			g.setColor(Color.RED);
			g.drawRect(940, 85, 50, 20);
		}
		else if (redbox == 2) {
			g.setColor(Color.RED);
			g.drawRect(1000, 85, 50, 20);
		}
		else if (redbox == 3) {
			g.setColor(Color.RED);
			g.drawRect(940, 110, 50, 20);
		}
		else if (redbox == 4) {
			g.setColor(Color.RED);
			g.drawRect(1000, 110, 50, 20);
		}
		else if (redbox == 5) {
			g.setColor(Color.RED);
			g.drawRect(1060, 110, 50, 20);
		}
		g.setColor(Color.YELLOW);
		g.drawRect(940+60*ctrlX, 60+25*ctrlY, 50, 20);
		g.setColor(Color.BLACK);
		g.drawString("p", 945, 75);
		g.drawString("q", 1005, 75);
		g.drawString("SOLVE", 1065, 75);
		if (level == 3 || level == 4) {
			g.drawString("AND", 945, 100);
		}
		if (level == 1 || level == 2) {
			g.drawString("OR", 1005, 100);
		}
		g.drawString("NOT", 1065, 100);
		g.drawString("Store", 945, 125);
		g.drawString("Get", 1005, 125);
		g.drawString("Clear", 1065, 125);
		g.drawString("BACK", 1065, 150);
		
		g.setColor(Color.WHITE);
		if (level == 1) {
			g.drawString("Your first puzzle is to find an equivalent statement to the following:",200,400);
			g.drawString("p^q",200,420);
		}
		if (level == 2) {
			g.drawString("Congratulations! Your next puzzle is to find an equivalent statement to the following:",200,400);
			g.drawString("-(-p^-q)",200,420);
		}
		if (level == 3) {
			g.drawString("Congratulations! Your next first puzzle is to find an equivalent statement to the following:",200,400);
			g.drawString("pvq",200,420);
		}
		if (level == 4) {
			g.drawString("Congratulations! Your final puzzle is to find an equivalent statement to the following:",200,400);
			g.drawString("-(-pv-q)",200,420);
		}		
	}
}