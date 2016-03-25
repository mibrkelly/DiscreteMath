/*
This class includes the main method. Game runs the loop to update the status of the game and draw to the screen. It also handles the listening for the mouse and keyboard input.
*/

package base;
import javax.swing.JFrame;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.Graphics;
import java.awt.Color;

import base.state.*;
import base.state.expPages.*;
import base.state.menu.*;
import base.state.calculators.Calculator;
import base.PixelDrawer;

public class GameBase extends Canvas implements Runnable, PixelDrawer {
	private static final long serialVersionUID = 1L;
	
	public static int width = 1200;
	public static int height = 650;
	public static String title = "Game";
	private boolean running = false;
	private boolean keyIn = true;
	private boolean mouseIn = true;
	private int updates;
	
	private Thread thread;
	private JFrame frame;
	
	private Keyboard key;
	private Mouse mouse;
	private State currState;
	
	private BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	 
	public GameBase() {
		Dimension size = new Dimension(width,height);
		setPreferredSize(size);
		
		currState = new Menu(width, height);
		((Menu)currState).initialize();
		frame = new JFrame();
		
		key = new Keyboard();
		addKeyListener(key);
		
		mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		updates = 0;
		
		while(running) {
			long now = System.nanoTime();
			delta += (now-lastTime)/ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer  > 1000) {
				timer += 1000;
				frame.setTitle(title + "   |   " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
			
			try {
			      Thread.sleep(2);  // sleep a bit
			}
			catch(InterruptedException ex){}
		}
		stop();
	}
	
	public void update() {
		key.update();
		if (!key.up && !key.down && !key.left && !key.right && !key.enter) {
			keyIn = true;
		}
		if (key.up && keyIn) {
			currState.pressUp();
			keyIn = false;
		}
		if (key.down && keyIn) {
			currState.pressDown();
			keyIn = false;
		}
		if (key.left && keyIn) {
			currState.pressLeft();
			keyIn = false;
		}
		if (key.right && keyIn) {
			currState.pressRight();
			keyIn = false;
		}
		if (key.a && currState instanceof Calculator) {
			((Calculator)currState).pressA();
		}
		if (key.s && currState instanceof Calculator) {
			((Calculator)currState).pressS();
		}
		if (key.d && currState instanceof Calculator) {
			((Calculator)currState).pressD();
		}
		if (key.w && currState instanceof Calculator) {
			((Calculator)currState).pressW();
		}
		/*
		if (key.enter && keyIn && currState instanceof Calculator) {
			if (((Calculator)currState).pressEnter()) {
				currState = currState.whichState(0,0); //The 0,0 is irrelevant in the Keyboard input
			}
			keyIn = false;
		}
		*/
		if (key.enter && keyIn) {
			if (currState.pressEnter()) {
				currState = currState.whichState(0,0); //The 0,0 is irrelevant in the Keyboard input
			}
			keyIn = false;
		}
		
		if (mouse.clicked) {
			if (currState.clickedAt(mouse.clickX, mouse.clickY)) {
				currState = currState.whichState(mouse.clickX, mouse.clickY);
			}
			mouse.clicked = false;
		}
		if (mouse.pressing) {
			currState.pressedAt(mouse.pressX, mouse.pressY);
		}
		if (mouse.dragging) {
			currState.draggedTo(mouse.dragX, mouse.dragY);
		}
		if (mouse.released) {
			currState.released();
			mouse.released = false;
		}
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		currState.clear(0xa4aeeb);
		currState.render(updates);
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = pix[i % width][(i / width)];
		}
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.BLACK);
		currState.write(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		GameBase game = new GameBase();
		game.frame.setResizable(false);
		game.frame.setTitle(GameBase.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
}