package com.project.main;

import java.awt.Color;

public class SmartEnemy extends BasicEnemy {
	private GameObject player;
	
	public SmartEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, Color.GREEN, 0, 0, id, handler);
		
		for (GameObject obj : handler.objects) {
			if (obj.getId() == ID.Player) {
				player = obj;
			}
		}
	}
	
	@Override
	public void tick() {
		
		float diffX = x - player.getX() - 8;
		float diffY = y - player.getY() - 8;
		float distance = (float) Math.sqrt(Math.pow(x - player.getX(), 2) + Math.pow(y - player.getY(), 2));
		
		velX =  ((-2.0f / distance) * diffX);
		velY =  ((-2.0f / distance) * diffY);
		
		super.tick();
	}


}
