package com.project.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


	

public class Player extends GameObject {
	Random r = new Random();
	private int width;
	private int height;
	private Handler handler;
	
	
	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.width = this.height = 32;	
		this.handler = handler;
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x,  0,  Game.WIDTH - 37);
		y = Game.clamp(y,  0,  Game.HEIGHT - 60);
		
		collision();
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.WHITE, this.width, this.height, 0.04f, this.handler));
	}
	
	private void collision() {
		for (GameObject object : this.handler.objects) {
			if (object.getId() == ID.BasicEnemy || object.getId() == ID.FastEnemy || object.getId() == ID.SmartEnemy) {
				if(getBounds().intersects(object.getBounds())) {
					HUD.HEALTH -= 2;
				}
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((int) x, (int) y, this.width, this.height);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, this.width, this.height);
	}
	
	
	
}
