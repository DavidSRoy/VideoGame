package com.project.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



public class BasicEnemy extends GameObject {
	
	private Handler handler;
	private int width;
	private int height;
	private Color color;
	

	public BasicEnemy(int x, int y, ID id, Handler handler) {
		this(x, y, Color.RED, 5, 5, id, handler);
	}
	
	public BasicEnemy(int x, int y, Color color, int velX, int velY, ID id, Handler handler) {
		super(x, y, id);
		this.width = this.height = 16;
		this.handler = handler;
		
		this.color = color;
		
		this.velX = velX;
		this.velY = velY;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if (y <= 0 || y >= Game.HEIGHT - 16) {
			velY *= -1;
		}
		
		if (x <= 0 || x >= Game.WIDTH - 16) {
			velX *= -1;
		}
		
		handler.addObject(new Trail(x, y, ID.Trail, this.color, 16, 16, 0.02f, this.handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(this.color);
		g.fillRect(x, y, this.width, this.height);
		
		/*
		 * See collision bounds
		 * Graphics2d g2d = (Graphics2D) g;
		 * g.setColor(Color.RED);
		 * g2d.draw(getBounds());
		 */
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, this.width, this.height);
	}
}
