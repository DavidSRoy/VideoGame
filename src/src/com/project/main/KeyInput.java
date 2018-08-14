package com.project.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	public Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for (GameObject obj : this.handler.objects) {
			if (obj.getId() == ID.Player) {
				//key events for Player 1
				
				if (key == KeyEvent.VK_UP) { obj.setVelY(-5);}
				if (key == KeyEvent.VK_DOWN) { obj.setVelY(5);}
				if (key == KeyEvent.VK_LEFT) { obj.setVelX(-5);}
				if (key == KeyEvent.VK_RIGHT) { obj.setVelX(5);}
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (GameObject obj : this.handler.objects) {
			if (obj.getId() == ID.Player) {
				//key events for Player 1
				
				if (key == KeyEvent.VK_UP) { obj.setVelY(0);}
				if (key == KeyEvent.VK_DOWN) { obj.setVelY(0);}
				if (key == KeyEvent.VK_LEFT) { obj.setVelX(0);}
				if (key == KeyEvent.VK_RIGHT) { obj.setVelX(0);}
				
				if (key == KeyEvent.VK_ESCAPE) { System.exit(1);}
			
			}
		}
		
	}
}
