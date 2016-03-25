/*
This class is the main menu when you open the game.
*/


package base.state.menu;

import base.state.*;
import base.state.expPages.IntroPage;
import java.awt.Graphics;
import java.awt.Color;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Menu extends State {
	
	public Menu(int w, int h) {
		super(w,h);
		
		finEdge = new boolean[40];
		
		File f = new File("PlayerProgress.txt");
		if (!f.exists()) {
	        try {
	            FileWriter fileWriter = new FileWriter(f);

	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
				for (int i = 0; i < finEdge.length; i++) {
					bufferedWriter.write("0");
				}
				
	            bufferedWriter.close();
	        }
	        catch(IOException ex) {
	            System.out.println("Error writing to file '"+ f + "'");
	        }
		}
	}
		
	@Override
	public void render (int keepTime) {
		Square(400,150,400,350,0x000000);
		Square(550,200,100,30,0xffffff);
		Square(550,300,100,30,0xffffff);
		Square(550,400,100,30,0xffffff);
	}
	
	@Override
	public boolean clickedAt(int x, int y) {
		if (550 < x && x < 650 && 200 < y && y < 230) {
	        File f = new File("PlayerProgress.txt");
	        try {
	            FileWriter fileWriter = new FileWriter(f);

	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	
				for (int i = 0; i < finEdge.length; i++) {
					bufferedWriter.write("0");
				}
			
	            bufferedWriter.close();
	        }
	        catch(IOException ex) {
	            System.out.println("Error writing to file '"+ f + "'");
	        }
			return true;
		}
		if (550 < x && x < 650 && 300 < y && y < 330) {
			return true;
		}
		if (550 < x && x < 650 && 400 < y && y < 430) {
	        File f = new File("PlayerProgress.txt");
			try {
	            FileReader fileReader = new FileReader(f);

	            BufferedReader bufferedReader = new BufferedReader(fileReader);
				String finEdgeInfo = bufferedReader.readLine();
				for (int i = 0; i < finEdge.length; i++) {
					if (finEdgeInfo.charAt(i) == '1') {
						finEdge[i] = true;
					}
				}
				

	            bufferedReader.close();
	        }
	        catch(IOException ex) {
	            System.out.println("Error reading file '"+ f + "'");
	        }
			return true;
		}
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
		if (550 < x && x < 650 && 200 < y && y < 230) {
			if (!(finEdge[0] || finEdge[1] || finEdge[2] || finEdge[3] || finEdge[4])) {
				State s = new IntroPage(getWidth(), getHeight());
				return s;
			}
			State s = new PuzMenu(getWidth(), getHeight());
			return s;
		}
		if (550 < x && x < 650 && 300 < y && y < 330) {
			State s = new CalculatorMenu();
			return s;
		}
		if (550 < x && x < 650 && 400 < y && y < 430) {
			State s = new PuzMenu(width, height);
			return s;
		}
		return this;
	}
	
	@Override
	public void write(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("New",560,220);
		g.drawString("Calculators",560,320);
		g.drawString("Load",560,420);
	}
	
	public void initialize() {
		for (int i = 0; i < finEdge.length; i++) {
			finEdge[i] = false;
		}
	}
}