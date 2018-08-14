package com.project.main;

import java.awt.Graphics;

public interface Displayable {
	
	/**
	 * Logic, such as movement of the Displayable object,
	 * game scoring logic, etc.
	 */
	public void tick();
	
	
	/**
	 * Code for graphics (drawing shapes, images, etc)
	 * @param g
	 */
	public void render(Graphics g);
}
