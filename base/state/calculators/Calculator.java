package base.state.calculators;

import base.*;
import base.state.State;
import java.awt.Graphics;

public abstract class Calculator extends State {
	
	public Calculator () {
		super(1200,650);
	}
	
	public abstract void pressUp();
	public abstract void pressDown();
	public abstract void pressLeft();
	public abstract void pressRight();
	public abstract boolean pressEnter();
	public abstract void pressA();
	public abstract void pressS();
	public abstract void pressD();
	public abstract void pressW();

}