/*
This class represents the game menus.
*/


package base.state.menu;

import base.state.*;
import java.awt.Graphics;
import base.state.expPages.*;

import base.state.puzzles.*;

import java.awt.image.DataBufferByte;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;


public class PuzMenu extends State {
	
	private int[][] icons;
	private String feedback;
	
	public PuzMenu(int w, int h) {
		super(w,h);
		
		feedback = "Welcome to the puzzle menu! Please select a puzzle.";
		
		icons = new int[210][210];		
		try	{
			BufferedImage screenImage = ImageIO.read(PuzMenu.class.getResource("PuzIcons.png"));
			icons = convertTo2DUsingGetRGB(screenImage);
		}
			catch (IOException e) {
		}
	}
	
	public PuzMenu(int w, int h, String s) {
		super(w,h);
		
		feedback = s;
		
		icons = new int[210][210];		
		try	{
			BufferedImage screenImage = ImageIO.read(PuzMenu.class.getResource("PuzIcons.png"));
			icons = convertTo2DUsingGetRGB(screenImage);
		}
			catch (IOException e) {
		}
	}
	
	private static int[][] convertTo2DUsingGetRGB(BufferedImage image) {
      int width = image.getWidth();
      int height = image.getHeight();
      int[][] result = new int[width][height];

      for (int row = 0; row < height; row++) {
         for (int col = 0; col < width; col++) {
            result[col][row] = image.getRGB(col, row);
         }
      }

      return result;
   }
		
	@Override
	public void render (int keepTime) {
		

		//forall = 0 -- New Environment 1
		drawIcon(4,0,300,600, finEdge[0]);
		
		//Logical Negation = 1 -- Finished
		drawIcon(5,0,20,500, finEdge[1]);
		
		//OR = 2 -- Finished
		drawIcon(3,0,20,400, finEdge[2]);
		
		//Set Compliment = 3 -- Finished
		drawIcon(6,0,20,300, finEdge[3]);
		
		//Intersection = 4 -- Finished
		drawIcon(0,0,20,200, finEdge[4]);
		
		if (finEdge[1] && finEdge[2]) { //AND = 5 -- Finished
			drawLn(315,465,50,415,0xffffff);
			drawLn(315,465,50,515,0xffffff);
			drawIcon(2,0,300,450, finEdge[5]);
		}
		if (finEdge[0]) { //thereexists = 6 -- New Environment 1 -- Perhaps similar to pair pieces: Create a set the set must satisfy a list of rules? Sets should look different than pairs
			drawLn(415,565,330,615,0xffffff);
			drawIcon(3,1,400,550, finEdge[6]);
		}
		if (finEdge[1] && finEdge[2]) { //Implies = 7 -- Finished
			drawLn(315,365,50,415,0xffffff);
			drawLn(315,365,50,515,0xffffff);
			drawIcon(0,1,300,350, finEdge[7]);
		}
		if (finEdge[5]) { //Logic Addition = 8 -- Finished
			drawLn(300,465,115,115,0xffffff);
			drawIcon(5,5,100,100, finEdge[8]);
		}
		if (finEdge[8] && finEdge[3] && finEdge[4]) { //Numbers = 9 -- Finished
			drawLn(115,35,115,100,0xffffff);
			drawLn(115,35,35,35,0xffffff);
			drawLn(35,200,35,35,0xffffff);
			drawLn(115,35,70,80,0xffffff);
			drawLn(35,300,70,265,0xffffff);
			drawLn(70,80,70,265,0xffffff);
			drawIcon(5,2,100,20, finEdge[9]);
		}
		if (finEdge[9]) { //Set Cross = 10 -- Finished except Exp Page
			drawLn(200,35,130,35,0xffffff);
			drawIcon(6,5,200,20, finEdge[10]);
		}
		if (finEdge[10] && finEdge[14]) { //Relations = 11 -- Maybe just an Exp Page?
			drawLn(400,35,230,35,0xffffff);
			drawLn(400,35,375,60,0xffffff);
			drawLn(375,60,375,340,0xffffff);
			drawLn(400,365,375,340,0xffffff);
			drawIcon(6,2,400,20, finEdge[11]);
		}
		if (finEdge[6] && finEdge[7]) { //Direct Proof = 12 -- Finished
			drawLn(415,465,415,550,0xffffff);
			drawLn(415,465,330,365,0xffffff);
			drawIcon(2,1,400,450, finEdge[12]);
		}
		if (finEdge[3] && finEdge[4]) { //Union = 13 -- Finished
			drawLn(415,265,50,315,0xffffff);
			drawLn(415,265,50,215,0xffffff);
			drawIcon(1,0,400,250, finEdge[13]);
		}
		if (finEdge[13] && finEdge[7] && finEdge[0]) { //Subset = 14 -- New Environment 1
			drawLn(415,365,415,280,0xffffff);
			drawLn(415,365,330,365,0xffffff);
			drawLn(415,365,315,600,0xffffff);
			drawIcon(4,1,400,350, finEdge[14]);
		}
		if (finEdge[5] && finEdge[7]) { //Iff = 15 -- Finished
			drawLn(315,350,315,85,0xffffff);
			drawLn(315,85,500,85,0xffffff);
			drawLn(315,450,350,415,0xffffff);
			drawLn(350,415,350,150,0xffffff);
			drawLn(515,85,350,150,0xffffff);
			drawIcon(1,1,500,70, finEdge[15]);
		}
		if (finEdge[15]) { //Logical Equivalence = 16 -- Finished
			drawLn(530,85,600,85,0xffffff);
			drawIcon(5,1,600,70, finEdge[16]);
		}
		if (finEdge[16] && finEdge[11]) { //Relation Equivalence = 17 -- Finished except expPage
			drawLn(700,35,630,85,0xffffff);
			drawLn(700,35,430,35,0xffffff);
			drawIcon(6,1,700,20, finEdge[17]);
		}
		if (finEdge[17]) { //Set/Relation Partition = 18 -- Proof Environment where you drag peices into various regions, should mimic equivalence relation
			drawLn(800,35,730,35,0xffffff);
			drawIcon(4,2,800,20, finEdge[18]);
		}
		if (finEdge[18]) { //Modulo n = 19 -- New Environment 3 or Circuits Environment?? Or calculator??
			drawLn(830,35,900,35,0xffffff);
			drawIcon(0,2,900,20, finEdge[19]);
		}
		if (finEdge[14] && finEdge[11]) { //Relation Order = 20 -- Finished except expPage
			drawLn(430,365,515,565,0xffffff);
			drawLn(415,50,415,200,0xffffff);
			drawLn(415,200,515,330,0xffffff);
			drawLn(515,550,515,330,0xffffff);
			drawIcon(5,3,500,550, finEdge[20]);
		}
		if (finEdge[12]) { //Counterexample = 21 -- Proof Environment
			drawLn(415,480,470,615,0xffffff);
			drawLn(470,615,600,615,0xffffff);
			drawIcon(6,3,600,600, finEdge[21]);
		}
		if (finEdge[5]) { //Logic Distribution = 22 -- Finished
			drawLn(315,480,350,515,0xffffff);
			drawLn(600,515,350,515,0xffffff);
			drawIcon(1,5,600,500, finEdge[22]);
		}
		if (finEdge[5]) { //Logic De Morgan's = 23 -- Finished
			drawLn(530,515,555,490,0xffffff);
			drawLn(555,490,690,490,0xffffff);
			drawLn(715,515,690,490,0xffffff);
			drawIcon(5,4,700,500, finEdge[23]);
		}
		if (finEdge[21] && finEdge[22] && finEdge[23]) { //Contradiction = 24 -- Proof Environment
			drawLn(630,615,815,615,0xffffff);
			drawLn(615,530,815,615,0xffffff);
			drawLn(715,530,815,615,0xffffff);
			drawIcon(1,4,800,600, finEdge[24]);
		}
		if (finEdge[13]) { //Set Distribution = 25 -- ?? New Enironment 1 or Set Calculator?
			drawLn(415,280,550,380,0xffffff);
			drawLn(550,380,800,380,0xffffff);
			drawLn(800,515,800,380,0xffffff);
			drawLn(800,515,900,515,0xffffff);
			drawIcon(6,4,900,500, finEdge[25]);
		}
		if (finEdge[13]) { //Set De Morgan's = 26 -- Finished
			drawLn(800,490,950,490,0xffffff);
			drawLn(950,490,1015,515,0xffffff);
			drawIcon(0,5,1000,500, finEdge[26]);
		}
		if (finEdge[24] && finEdge[25] && finEdge[26]) { //Contrapositive = 27 -- Proof Environment
			drawLn(830,615,1015,615,0xffffff);
			drawLn(915,530,1015,615,0xffffff);
			drawLn(1015,530,1015,615,0xffffff);
			drawIcon(4,5,1000,600, finEdge[27]);
		}
		if (finEdge[20] && finEdge[27]) { //Induction = 28 -- ??
			drawLn(530,565,1115,565,0xffffff);
			drawLn(1030,615,1115,565,0xffffff);
			drawIcon(2,5,1100,550, finEdge[28]);
		}
		if (finEdge[11]) { //Functions = 29 -- Finished except expPage
			drawLn(415,50,515,265,0xffffff);
			drawIcon(3,3,500,250, finEdge[29]);
		}
		if (finEdge[3] && finEdge[4] && finEdge[14]) { //Power Set = 30 -- New Environment 1??
			drawLn(300,405,650,405,0xffffff);
			drawLn(300,425,650,425,0xffffff);
			drawLn(300,405,50,215,0xffffff);
			drawLn(300,425,50,315,0xffffff);
			drawIcon(3,2,650,400, finEdge[30]);
		}
		if (finEdge[29]) { //Graphs = 31 -- New Environment 2?? New Environment 1??
			drawLn(530,265,615,185,0xffffff);
			drawIcon(4,4,600,170, finEdge[31]);
		}
		if (finEdge[29]) { //Surjective = 32 -- Finished
			drawLn(530,265,615,265,0xffffff);
			drawIcon(2,3,600,250, finEdge[32]);
		}
		if (finEdge[29]) { //Injective = 33 -- Finished
			drawLn(530,265,615,345,0xffffff);
			drawIcon(1,3,600,330, finEdge[33]);
		}
		if (finEdge[31]) { //Coloring = 34 -- ??
			drawLn(700,185,630,185,0xffffff);
			drawIcon(2,2,700,170, finEdge[34]);
		}
		if (finEdge[32] && finEdge[33] && finEdge[34]) { //Preimage = 35 -- Circuits Environment??
			drawLn(630,265,815,265,0xffffff);
			drawLn(630,345,815,265,0xffffff);
			drawLn(730,185,815,265,0xffffff);
			drawIcon(4,3,800,250, finEdge[35]);
		}
		if (finEdge[35]) { //Bijection = 36 -- Finished
			drawLn(830,265,915,265,0xffffff);
			drawIcon(0,3,900,250, finEdge[36]);
		}
		if (finEdge[12] && finEdge[5]) { //Tautology Contradiction = 37 -- Logic Calculator?
			drawLn(430,455,700,455,0xffffff);
			
			drawLn(330,465,390,495,0xffffff);
			drawLn(390,495,470,495,0xffffff);
			drawLn(470,495,470,475,0xffffff);
			drawLn(470,475,700,475,0xffffff);
			drawIcon(2,4,700,450, finEdge[37]);
		}
		if (finEdge[37]) { //Paradox = 38 -- ??
			drawLn(730,465,915,465,0xffffff);
			drawIcon(3,4,900,450, finEdge[38]);
		}
		if (finEdge[38] && finEdge[36] && finEdge[30]) { //Cardinality = 39 -- ??
			drawLn(680,415,1015,345,0xffffff);
			drawLn(930,265,1015,345,0xffffff);
			drawLn(930,465,1015,345,0xffffff);
			drawIcon(3,5,1000,330, finEdge[39]);
		}
		
		Square(1100,20,50,30,0xFFFF00);
	}
	
	@Override
	public boolean clickedAt(int x, int y) {
		return true;
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
		if (x > 300 && x < 330 && y > 600 && y < 630) { //forall = 0
			State s = new ForallExp(getWidth(),getHeight());
			return s;
		}
		if (x > 20 && x < 50 && y > 500 && y < 530) { //Logical Negation = 1
			State s = new LogicNegateExp(getWidth(),getHeight());
			return s;
		}
		if (x > 20 && x < 50 && y > 400 && y < 430) { //OR = 2
			State s = new LogicOrExp(getWidth(),getHeight());
			return s;
		}
		if (x > 20 && x < 50 && y > 300 && y < 330) { //Set Compliment = 3
			State s = new SetComplimentExp(getWidth(),getHeight());
			return s;
		}
		if (x > 20 && x < 50 && y > 200 && y < 230) { //Intersection = 4
			State s = new Intersection(getWidth(),getHeight());
			return s;
		}
		if (x > 300 && x < 330 && y > 450 && y < 480 && finEdge[1] && finEdge[2]) { //AND = 5
			State s = new LogicAndExp(getWidth(),getHeight());
			return s;
		}
		if (x > 400 && x < 430 && y > 550 && y < 580 && finEdge[0]) { //thereexists = 6
			State s = new ThereExistsExp(getWidth(),getHeight());
			return s;
		}
		if (x > 300 && x < 330 && y > 350 && y < 380 && finEdge[1] && finEdge[2]) { //Implies = 7
			State s = new ImpliesExp(getWidth(),getHeight());
			return s;
		}
		if (x > 100 && x < 130 && y > 100 && y < 130 && finEdge[5]) { //Logic Addition = 8
			State s = new LogicAddExp(getWidth(),getHeight());
			return s;
		}
		if (x > 100 && x < 130 && y > 20 && y < 50 && finEdge[8] && finEdge[3] && finEdge[4]) { //Numbers = 9
			State s = new NumbersExp(getWidth(),getHeight());
			return s;
		}
		if (x > 200 && x < 230 && y > 20 && y < 50 && finEdge[9]) { //Set Cross = 10
			State s = new SetCrossExp(getWidth(),getHeight());
			return s;
		}
		if (x > 400 && x < 430 && y > 20 && y < 50 && finEdge[10] && finEdge[14]) { //Relations = 11
			State s = new RelationsExp(getWidth(),getHeight());
			return s;
		}
		if (x > 400 && x < 430 && y > 450 && y < 480 && finEdge[6] && finEdge[7]) { //Direct Proof = 12
			State s = new DirectProofExp(getWidth(),getHeight());
			return s;
		}
		if (x > 400 && x < 430 && y > 250 && y < 280 && finEdge[3] && finEdge[4]) { //Union = 13
			State s = new UnionExp(getWidth(),getHeight());
			return s;
		}
		if (x > 400 && x < 430 && y > 350 && y < 380 && finEdge[13] && finEdge[7] && finEdge[0]) { //Subset = 14
			State s = new SubsetExp(getWidth(),getHeight());
			return s;
		}
		if (x > 500 && x < 530 && y > 70 && y < 100 && finEdge[5] && finEdge[7]) { //Iff = 15
			State s = new LogicIffExp(getWidth(),getHeight());
			return s;
		}
		if (x > 600 && x < 630 && y > 70 && y < 100 && finEdge[15]) { //Logical Equivalence = 16
			State s = new LogicEqualExp(getWidth(),getHeight());
			return s;
		}
		if (x > 700 && x < 730 && y > 20 && y < 50 && finEdge[16] && finEdge[11]) { //Relation Equivalence = 17
			State s = new RelationEqualExp(getWidth(),getHeight());
			return s;
		}
		if (x > 800 && x < 830 && y > 20 && y < 50 && finEdge[17]) { //Relation Partition = 18
			State s = new PartitionExp(getWidth(),getHeight());
			return s;
		}
		if (x > 900 && x < 930 && y > 20 && y < 50 && finEdge[18]) { //Modulo n = 19
			State s = new ModuloExp(getWidth(),getHeight());
			return s;
		}
		if (x > 500 && x < 530 && y > 550 && y < 580 && finEdge[14] && finEdge[11]) { //Relation Order = 20
			State s = new OrderExp(getWidth(),getHeight());
			return s;
		}
		if (x > 600 && x < 630 && y > 600 && y < 630 && finEdge[12]) { //Counterexample = 21
			State s = new CounterExampleExp(getWidth(),getHeight());
			return s;
		}
		if (x > 600 && x < 630 && y > 500 && y < 530 && finEdge[5]) { //Logic Distribution = 22
			State s = new LogicDistExp(getWidth(),getHeight());
			return s;
		}
		if (x > 700 && x < 730 && y > 500 && y < 530 && finEdge[5]) { //Logic De Morgan's = 23
			State s = new LogicDeMorgansExp(getWidth(),getHeight());
			return s;
		}
		if (x > 800 && x < 830 && y > 600 && y < 630 && finEdge[21] && finEdge[22] && finEdge[23]) { //Contradiction = 24
			State s = new ContradictionExp(getWidth(),getHeight());
			return s;
		}
		if (x > 900 && x < 930 && y > 500 && y < 530 && finEdge[13]) { //Set Distribution = 25
			State s = new SetDistExp(getWidth(),getHeight());
			return s;
		}
		if (x > 1000 && x < 1030 && y > 500 && y < 530 && finEdge[13]) { //Set De Morgan's = 26
			State s = new SetDeMorgansExp(getWidth(),getHeight());
			return s;
		}
		if (x > 1000 && x < 1030 && y > 600 && y < 630 && finEdge[24] && finEdge[25] && finEdge[26]) { //Contrapositive = 27
			State s = new ContrapositiveExp(getWidth(),getHeight());
			return s;
		}
		if (x > 1100 && x < 1130 && y > 550 && y < 580 && finEdge[20] && finEdge[27]) { //Induction = 28
			State s = new InductionExp(getWidth(),getHeight());
			return s;
		}
		if (x > 500 && x < 530 && y > 250 && y < 280 && finEdge[11]) { //Functions = 29
			State s = new FunctionExp(getWidth(),getHeight());
			return s;
		}
		if (x > 650 && x < 680 && y > 400 && y < 430 && finEdge[3] && finEdge[4] && finEdge[14]) { //Power Set = 30
			State s = new PowerSetExp(getWidth(),getHeight());
			return s;
		}
		if (x > 600 && x < 630 && y > 165 && y < 195 && finEdge[29]) { //Graphs = 31
			State s = new GraphExp(getWidth(),getHeight());
			return s;
		}
		if (x > 600 && x < 630 && y > 250 && y < 280 && finEdge[29]) { //Surjective = 32
			State s = new SurjectiveExp(getWidth(),getHeight());
			return s;
		}
		if (x > 600 && x < 630 && y > 330 && y < 360 && finEdge[29]) { //Injective = 33
			State s = new InjectiveExp(getWidth(),getHeight());
			return s;
		}
		if (x > 700 && x < 730 && y > 170 && y < 200 && finEdge[31]) { //Coloring = 34
			State s = new ColoringExp(getWidth(),getHeight());
			return s;
		}
		if (x > 800 && x < 830 && y > 250 && y < 280 && finEdge[32] && finEdge[33] && finEdge[34]) { //Preimage = 35
			State s = new PreimageExp(getWidth(),getHeight());
			return s;
		}
		if (x > 900 && x < 930 && y > 250 && y < 280 && finEdge[35]) { //Bijection = 36
			State s = new BijectionExp(getWidth(),getHeight());
			return s;
		}
		if (x > 700 && x < 730 && y > 455 && y < 485 && finEdge[12] && finEdge[5]) { //Tautology Contradiction = 37
			State s = new TCExp(getWidth(),getHeight());
			return s;
		}
		if (x > 900 && x < 930 && y > 450 && y < 480 && finEdge[37]) { //Paradox = 38
			State s = new ParadoxExp(getWidth(),getHeight());
			return s;
		}
		if (x > 1000 && x < 1030 && y > 330 && y < 360 && finEdge[38] && finEdge[36] && finEdge[30]) { //Cardinality = 39
			State s = new CardinalityExp(getWidth(),getHeight());
			return s;
		}
		if (x > 1100 && x < 1150 && y > 20 && y < 50) {
			State s = new Menu(getWidth(),getHeight());
			return s;
		}
		return this;
	}
	
	@Override
	public void write(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.drawString("BACK", 1110, 40);
		g.setColor(Color.BLACK);
		g.drawString(feedback, 15,15);
	}
	
	private void drawIcon (int xIcon, int yIcon, int xDraw, int yDraw, boolean completed) {
		if (completed) {
			drawCirc(xDraw-5,yDraw-5,20,0x00BB10);
		}
		else {
			drawCirc(xDraw-5,yDraw-5,20,0x444444);
		}
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				if (icons[30*xIcon+i][30*yIcon+j] != -1)
					pix[xDraw+i][yDraw+j] = icons[30*xIcon+i][30*yIcon+j];
			}
		}
	}
}