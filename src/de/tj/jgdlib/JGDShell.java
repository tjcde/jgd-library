package de.tj.jgdlib;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class JGDShell {
	
	public abstract void drawShell(Graphics2D g, Rectangle windowSize);
	public abstract Rectangle dragArea();

}
