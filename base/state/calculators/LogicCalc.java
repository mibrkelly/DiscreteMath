package base.state.calculators;

import base.state.State;
import base.state.menu.CalculatorMenu;
import java.awt.Graphics;
import java.awt.Color;

public class LogicCalc extends Calculator {
	
	private int ctrlX, ctrlY, logic, store, opps, storeOpps, redbox;
	private String currStatement, storeStatement;
	
	public LogicCalc() {
		
		currStatement = "";
		logic = 0; //Product of primes to denote truth values of current statement
		opps = 0; //Number of operations in the statement
		storeStatement = "";
		store = 0;
		storeOpps = 0;
		redbox = 0;
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
		ctrlY = (ctrlY%5+5)%5;
	}
	
	public void pressDown() {
		ctrlY++;
		ctrlY = (ctrlY%5+5)%5;
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
				logic = 2*3*5*7;
				opps = 1;
			}
			else if (redbox == 1) {
				if (opps == 1) {
					currStatement = currStatement + "^p";
				}
				else {
					currStatement = "(" + currStatement + ")^p";
				}
				if (logic%11 == 0) {
					logic = logic/11;
				}
				if (logic%13 == 0) {
					logic = logic/13;
				}
				if (logic%17 == 0) {
					logic = logic/17;
				}
				if (logic%19 == 0) {
					logic = logic/19;
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
				}
				if (logic%5 != 0) {
					logic=logic*5;
				}
				if (logic%7 != 0) {
					logic=logic*7;
				}
				opps++;
			}
			else if (redbox == 3) {
				if (opps == 1) {
					currStatement = currStatement + "+p";
				}
				else {
					currStatement = "(" + currStatement + ")+p";
				}
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
				opps++;
			}
			else if (redbox == 4) {
				if (opps == 1) {
					currStatement = currStatement + "->p";
				}
				else {
					currStatement = "(" + currStatement + ")->p";
				}
				if (logic%2 != 0) {
					logic=logic*2;
				}
				if (logic%3 != 0) {
					logic=logic*3;
				}
				if (logic%5 != 0) {
					logic=logic*5;
				}
				if (logic%7 != 0) {
					logic=logic*7;
				}
				if (logic%11 != 0) {
					logic=logic*11;
				}
				else {
					logic=logic/11;
				}
				if (logic%13 != 0) {
					logic=logic*13;
				}
				else {
					logic=logic/13;
				}
				if (logic%17 != 0) {
					logic=logic*17;
				}
				else {
					logic=logic/17;
				}
				if (logic%19 != 0) {
					logic=logic*19;
				}
				else {
					logic=logic/19;
				}
				opps++;
			}
			else if (redbox == 5) {
				if (opps == 1) {
					currStatement = currStatement + "<->p";
				}
				else {
					currStatement = "(" + currStatement + ")<->p";
				}
				if (logic%11 != 0) {
					logic=logic*11;
				}
				else {
					logic=logic/11;
				}
				if (logic%13 != 0) {
					logic=logic*13;
				}
				else {
					logic=logic/13;
				}
				if (logic%17 != 0) {
					logic=logic*17;
				}
				else {
					logic=logic/17;
				}
				if (logic%19 != 0) {
					logic=logic*19;
				}
				else {
					logic=logic/19;
				}
				opps++;
			}
			redbox = 0;
		}
		if (ctrlX == 1 && ctrlY == 0 && opps < 6) { //q
			if (redbox == 0 || opps == 0) {
				currStatement = "q";
				logic = 2*3*11*13;
				opps = 1;
			}
			else if (redbox == 1) {
				if (opps == 1) {
					currStatement = currStatement + "^q";
				}
				else {
					currStatement = "(" + currStatement + ")^q";
				}
				if (logic%5 == 0) {
					logic=logic/5;
				}
				if (logic%7 == 0) {
					logic=logic/7;
				}
				if (logic%17 == 0) {
					logic=logic/17;
				}
				if (logic%19 == 0) {
					logic=logic/19;
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
				if (logic%3 != 0) {
					logic=logic*3;
				}
				if (logic%11 != 0) {
					logic=logic*11;
				}
				if (logic%13 != 0) {
					logic=logic*13;
				}
				opps++;
			}
			else if (redbox == 3) {
				if (opps == 1) {
					currStatement = currStatement + "+q";
				}
				else {
					currStatement = "(" + currStatement + ")+q";
				}
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
				if (logic%11 == 0) {
					logic=logic/11;
				}
				else {
					logic=logic*11;
				}
				if (logic%13 == 0) {
					logic=logic/13;
				}
				else {
					logic=logic*13;
				}
				opps++;
			}
			else if (redbox == 4) {
				if (opps == 1) {
					currStatement = currStatement + "->q";
				}
				else {
					currStatement = "(" + currStatement + ")->q";
				}
				if (logic%2 != 0) {
					logic=logic*2;
				}
				if (logic%3 != 0) {
					logic=logic*3;
				}
				if (logic%11 != 0) {
					logic=logic*11;
				}
				if (logic%13 != 0) {
					logic=logic*13;
				}
				if (logic%5 != 0) {
					logic=logic*5;
				}
				else {
					logic=logic/5;
				}
				if (logic%7 != 0) {
					logic=logic*7;
				}
				else {
					logic=logic/7;
				}
				if (logic%17 != 0) {
					logic=logic*17;
				}
				else {
					logic=logic/17;
				}
				if (logic%19 != 0) {
					logic=logic*19;
				}
				else {
					logic=logic/19;
				}
				opps++;
			}
			else if (redbox == 5) {
				if (opps == 1) {
					currStatement = currStatement + "<->q";
				}
				else {
					currStatement = "(" + currStatement + ")<->q";
				}
				if (logic%5 != 0) {
					logic=logic*5;
				}
				else {
					logic=logic/5;
				}
				if (logic%7 != 0) {
					logic=logic*7;
				}
				else {
					logic=logic/7;
				}
				if (logic%17 != 0) {
					logic=logic*17;
				}
				else {
					logic=logic/17;
				}
				if (logic%19 != 0) {
					logic=logic*19;
				}
				else {
					logic=logic/19;
				}
				opps++;
			}
			redbox = 0;
		}
		if (ctrlX == 2 && ctrlY == 0 && opps < 6) { //r
			if (redbox == 0 || opps == 0) {
				currStatement = "r";
				logic = 2*5*11*17;
				opps = 1;
			}
			else if (redbox == 1) {
				if (opps == 1) {
					currStatement = currStatement + "^r";
				}
				else {
					currStatement = "(" + currStatement + ")^r";
				}
				if (logic%3 == 0) {
					logic=logic/3;
				}
				if (logic%7 == 0) {
					logic=logic/7;
				}
				if (logic%13 == 0) {
					logic=logic/13;
				}
				if (logic%19 == 0) {
					logic=logic/19;
				}
				opps++;
			}
			else if (redbox == 2) {
				if (opps == 1) {
					currStatement = currStatement + "vr";
				}
				else {
					currStatement = "(" + currStatement + ")vr";
				}
				if (logic%2 != 0) {
					logic=logic*2;
				}
				if (logic%5 != 0) {
					logic=logic*5;
				}
				if (logic%11 != 0) {
					logic=logic*11;
				}
				if (logic%17 != 0) {
					logic=logic*17;
				}
				opps++;
			}
			else if (redbox == 3) {
				if (opps == 1) {
					currStatement = currStatement + "+r";
				}
				else {
					currStatement = "(" + currStatement + ")+r";
				}
				if (logic%2 == 0) {
					logic=logic/2;
				}
				else {
					logic=logic*2;
				}
				if (logic%5 == 0) {
					logic=logic/5;
				}
				else {
					logic=logic*5;
				}
				if (logic%11 == 0) {
					logic=logic/11;
				}
				else {
					logic=logic*11;
				}
				if (logic%17 == 0) {
					logic=logic/17;
				}
				else {
					logic=logic*17;
				}
				opps++;
			}
			else if (redbox == 4) {
				if (opps == 1) {
					currStatement = currStatement + "->r";
				}
				else {
					currStatement = "(" + currStatement + ")->r";
				}
				if (logic%2 != 0) {
					logic=logic*2;
				}
				if (logic%5 != 0) {
					logic=logic*5;
				}
				if (logic%11 != 0) {
					logic=logic*11;
				}
				if (logic%17 != 0) {
					logic=logic*17;
				}
				if (logic%3 != 0) {
					logic=logic*3;
				}
				else {
					logic=logic/3;
				}
				if (logic%7 != 0) {
					logic=logic*7;
				}
				else {
					logic=logic/7;
				}
				if (logic%13 != 0) {
					logic=logic*13;
				}
				else {
					logic=logic/13;
				}
				if (logic%19 != 0) {
					logic=logic*19;
				}
				else {
					logic=logic/19;
				}
				opps++;
			}
			else if (redbox == 5) {
				if (opps == 1) {
					currStatement = currStatement + "<->r";
				}
				else {
					currStatement = "(" + currStatement + ")<->r";
				}
				if (logic%3 != 0) {
					logic=logic*3;
				}
				else {
					logic=logic/3;
				}
				if (logic%7 != 0) {
					logic=logic*7;
				}
				else {
					logic=logic/7;
				}
				if (logic%13 != 0) {
					logic=logic*13;
				}
				else {
					logic=logic/13;
				}
				if (logic%19 != 0) {
					logic=logic*19;
				}
				else {
					logic=logic/19;
				}
				opps++;
			}
			redbox = 0;
		}
		if (ctrlX == 0 && ctrlY == 1 && finEdge[5]) { //and
			redbox = 1;
		}
		if (ctrlX == 1 && ctrlY == 1 && finEdge[2]) { //or
			redbox = 2;
		}
		if (ctrlX == 2 && ctrlY == 1 && opps < 6 && finEdge[1]) { //not
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
				if (logic%11 == 0) {
					logic=logic/11;
				}
				else {
					logic=logic*11;
				}
				if (logic%13 == 0) {
					logic=logic/13;
				}
				else {
					logic=logic*13;
				}
				if (logic%17 == 0) {
					logic=logic/17;
				}
				else {
					logic=logic*17;
				}
				if (logic%19 == 0) {
					logic=logic/19;
				}
				else {
					logic=logic*19;
				}
			}
		}
		if (ctrlX == 0 && ctrlY == 2) { //xor
			redbox = 3;
		}
		if (ctrlX == 1 && ctrlY == 2) { //imply
			redbox = 4;
		}
		if (ctrlX == 2 && ctrlY == 2 && finEdge[15]) { //iff
			redbox = 5;
		}
		if (ctrlX == 0 && ctrlY == 3 && opps < 7) { //store
			storeStatement = currStatement;
			store = logic;
			storeOpps = opps;
			logic = 0;
			opps = 0;
			currStatement = "";
		}
		if (ctrlX == 1 && ctrlY == 3) { //get
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
				if (logic%11 == 0 && store%11 != 0) {
					logic=logic/11;
				}
				if (logic%13 == 0 && store%13 != 0) {
					logic=logic/13;
				}
				if (logic%17 == 0 && store%17 != 0) {
					logic=logic/17;
				}
				if (logic%19 == 0 && store%19 != 0) {
					logic=logic/19;
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
				if (logic%11 != 0 && store%11 == 0) {
					logic=logic*11;
				}
				if (logic%13 != 0 && store%13 == 0) {
					logic=logic*13;
				}
				if (logic%17 != 0 && store%17 == 0) {
					logic=logic*17;
				}
				if (logic%19 != 0 && store%19 == 0) {
					logic=logic*19;
				}
				opps += storeOpps;
			}
			else if (redbox == 3) {
				if (opps == 1 && storeOpps == 1) {
					currStatement = currStatement + "+" + storeStatement;
				}
				else if (opps > 1 && storeOpps == 1){
					currStatement = "(" + currStatement + ")+" + storeStatement;
				}
				else if (opps == 1 && storeOpps > 1){
					currStatement = currStatement + "+(" + storeStatement + ")";
				}
				else {
					currStatement = "(" + currStatement + ")+(" + storeStatement + ")";
				}
				if (logic%2 == 0 && store%2 == 0) {
					logic=logic/2;
				}
				else if (logic%2 != 0 && store%2 == 0) {
					logic=logic*2;
				}
				if (logic%3 == 0 && store%3 == 0) {
					logic=logic/3;
				}
				else if (logic%3 != 0 && store%3 == 0) {
					logic=logic*3;
				}
				if (logic%5 == 0 && store%5 == 0) {
					logic=logic/5;
				}
				else if (logic%5 != 0 && store%5 == 0) {
					logic=logic*5;
				}
				if (logic%7 == 0 && store%7 == 0) {
					logic=logic/7;
				}
				else if (logic%7 != 0 && store%7 == 0) {
					logic=logic*7;
				}
				if (logic%11 == 0 && store%11 == 0) {
					logic=logic/11;
				}
				else if (logic%11 != 0 && store%11 == 0) {
					logic=logic*11;
				}
				if (logic%13 == 0 && store%13 == 0) {
					logic=logic/13;
				}
				else if (logic%13 != 0 && store%13 == 0) {
					logic=logic*13;
				}
				if (logic%17 == 0 && store%17 == 0) {
					logic=logic/17;
				}
				else if (logic%17 != 0 && store%17 == 0) {
					logic=logic*17;
				}
				if (logic%19 == 0 && store%19 == 0) {
					logic=logic/19;
				}
				else if (logic%19 != 0 && store%19 == 0) {
					logic=logic*19;
				}
				opps += storeOpps;
			}
			else if (redbox == 4) {
				if (opps == 1 && storeOpps == 1) {
					currStatement = currStatement + "->" + storeStatement;
				}
				else if (opps > 1 && storeOpps == 1){
					currStatement = "(" + currStatement + ")->" + storeStatement;
				}
				else if (opps == 1 && storeOpps > 1){
					currStatement = currStatement + "->(" + storeStatement + ")";
				}
				else {
					currStatement = "(" + currStatement + ")->(" + storeStatement + ")";
				}
				if (logic%2 != 0) {
					logic=logic*2;
				}
				else if (store%2 != 0) {
					logic=logic/2;
				}
				if (logic%3 != 0) {
					logic=logic*3;
				}
				else if (store%3 != 0) {
					logic=logic/3;
				}
				if (logic%5 != 0) {
					logic=logic*5;
				}
				else if (store%5 != 0) {
					logic=logic/5;
				}
				if (logic%7 != 0) {
					logic=logic*7;
				}
				else if (store%7 != 0) {
					logic=logic/7;
				}
				if (logic%11 != 0) {
					logic=logic*11;
				}
				else if (store%11 != 0) {
					logic=logic/11;
				}
				if (logic%13 != 0) {
					logic=logic*13;
				}
				else if (store%13 != 0) {
					logic=logic/13;
				}
				if (logic%17 != 0) {
					logic=logic*17;
				}
				else if (store%17 != 0) {
					logic=logic/17;
				}
				if (logic%19 != 0) {
					logic=logic*19;
				}
				else if (store%19 != 0) {
					logic=logic/19;
				}
				opps += storeOpps;
			}
			else if (redbox == 5) {
				if (opps == 1 && storeOpps == 1) {
					currStatement = currStatement + "<->" + storeStatement;
				}
				else if (opps > 1 && storeOpps == 1){
					currStatement = "(" + currStatement + ")<->" + storeStatement;
				}
				else if (opps == 1 && storeOpps > 1){
					currStatement = currStatement + "<->(" + storeStatement + ")";
				}
				else {
					currStatement = "(" + currStatement + ")<->(" + storeStatement + ")";
				}
				if (logic%2 == 0 && store%2 != 0) {
					logic=logic/2;
				}
				else if (logic%2 != 0 && store%2 != 0) {
					logic=logic*2;
				}
				if (logic%3 == 0 && store%3 != 0) {
					logic=logic/3;
				}
				else if (logic%3 != 0 && store%3 != 0) {
					logic=logic*3;
				}
				if (logic%5 == 0 && store%5 != 0) {
					logic=logic/5;
				}
				else if (logic%5 != 0 && store%5 != 0) {
					logic=logic*5;
				}
				if (logic%7 == 0 && store%7 != 0) {
					logic=logic/7;
				}
				else if (logic%7 != 0 && store%7 != 0) {
					logic=logic*7;
				}
				if (logic%11 == 0 && store%11 != 0) {
					logic=logic/11;
				}
				else if (logic%11 != 0 && store%11 != 0) {
					logic=logic*11;
				}
				if (logic%13 == 0 && store%13 != 0) {
					logic=logic/13;
				}
				else if (logic%13 != 0 && store%13 != 0) {
					logic=logic*13;
				}
				if (logic%17 == 0 && store%17 != 0) {
					logic=logic/17;
				}
				else if (logic%17 != 0 && store%17 != 0) {
					logic=logic*17;
				}
				if (logic%19 == 0 && store%19 != 0) {
					logic=logic/19;
				}
				else if (logic%19 != 0 && store%19 != 0) {
					logic=logic*19;
				}
				opps++;
			}
			store = 0;
			storeOpps = 0;
			redbox = 0;
		}
		if (ctrlX == 2 && ctrlY == 3) { //clear
			logic = 0;
			opps = 0;
		}
		else if (ctrlX == 2 && ctrlY == 4) {
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
		g.drawString("p            q            r", 50, 100);
		g.drawString("-            -            -", 50, 125);
		g.drawString("T            T            T", 50, 150);
		g.drawString("T            T            F", 50, 175);
		g.drawString("T            F            T", 50, 200);
		g.drawString("T            F            F", 50, 225);
		g.drawString("F            T            T", 50, 250);
		g.drawString("F            T            F", 50, 275);
		g.drawString("F            F            T", 50, 300);
		g.drawString("F            F            F", 50, 325);
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
			if (logic%11 == 0) {
				g.drawString("T", 250, 250);
			}
			else {
				g.drawString("F", 250, 250);
			}
			if (logic%13 == 0) {
				g.drawString("T", 250, 275);
			}
			else {
				g.drawString("F", 250, 275);
			}
			if (logic%17 == 0) {
				g.drawString("T", 250, 300);
			}
			else {
				g.drawString("F", 250, 300);
			}
			if (logic%19 == 0) {
				g.drawString("T", 250, 325);
			}
			else {
				g.drawString("F", 250, 325);
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
			if (store%11 == 0) {
				g.drawString("T", 675, 250);
			}
			else {
				g.drawString("F", 675, 250);
			}
			if (store%13 == 0) {
				g.drawString("T", 675, 275);
			}
			else {
				g.drawString("F", 675, 275);
			}
			if (store%17 == 0) {
				g.drawString("T", 675, 300);
			}
			else {
				g.drawString("F", 675, 300);
			}
			if (store%19 == 0) {
				g.drawString("T", 675, 325);
			}
			else {
				g.drawString("F", 675, 325);
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
		g.drawString("r", 1065, 75);
		if (finEdge[5]) {
			g.drawString("AND", 945, 100);
		}
		if (finEdge[2]) {
			g.drawString("OR", 1005, 100);
		}
		if (finEdge[1]) {
			g.drawString("NOT", 1065, 100);
		}
		g.drawString("XOR", 945, 125);
		g.drawString("IMPLY", 1005, 125);
		if (finEdge[15]) {
			g.drawString("IFF", 1065, 125);
		}
		g.drawString("Store", 945, 150);
		g.drawString("Get", 1005, 150);
		g.drawString("Clear", 1065, 150);
		g.drawString("BACK", 1065, 175);
	}
}