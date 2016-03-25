package base.state.menu;

import base.state.calculators.*;
import base.state.State;
import java.awt.Graphics;
import java.awt.Color;

public class CalculatorMenu extends Calculator {
	
	private int ctrlX;
	private int ctrlY;
	
	@Override
	public boolean clickedAt(int x, int y) {
		return false;
	}
	
	@Override
	public void pressedAt(int x, int y) {
	}
	
	@Override
	public void draggedTo(int x, int y) {
	}
	
	@Override
	public void released() {
	}
	
	@Override
	public State whichState(int x, int y) {
		if (ctrlX == 0 && ctrlY == 0 && finEdge[9]) {
			State s = new ModCalc();
			return s;
		}
		if (ctrlX == 0 && ctrlY == 1) {
			State s = new SetTheoryCalc();
			return s;
		}
		if (ctrlX == 1 && ctrlY == 0) {
			State s = new LogicCalc();
			return s;
		}
		if (ctrlX == 1 && ctrlY == 1) {
			State s = new Menu(1200,650);
			return s;
		}
		return this;
	}

	@Override
	public void pressUp() {
		ctrlY--;
		ctrlY = (ctrlY%2+2)%2;
	}
	
	public void pressDown() {
		ctrlY++;
		ctrlY = (ctrlY%2+2)%2;
	}
	
	public void pressLeft() {
		ctrlX--;
		ctrlX = (ctrlX%2+2)%2;
	}
	
	public void pressRight() {
		ctrlX++;
		ctrlX = (ctrlX%2+2)%2;
	}
	
	public boolean pressEnter() {
		return true;
	}
	
	public void pressA() {
		
	}
	
	public void pressS() {
		
	}
	
	public void pressD() {
		
	}
	
	public void pressW() {
		
	}
	
	@Override
	public void render(int keepTime) {
		clear(0x990000);
	}
	
	public void write(Graphics g) {
		g.setColor(Color.ORANGE);
		g.drawString("Welcome!", 200, 100);
		g.drawString("Choose your scenario:", 200, 120);
		if (finEdge[9]) {
			g.drawString("Modular Arithmetic", 200, 140);
		}
		g.drawString("Set Theory", 200, 160);
		g.drawString("Logic", 450, 140);
		g.drawString("Return", 450, 160);
		g.setColor(Color.BLACK);
		g.drawRect(195+250*ctrlX, 128+20*ctrlY, 200, 15);
	}
}