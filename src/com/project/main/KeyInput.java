package com.project.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	public Handler handler;
	private boolean[] = keyDown = new boolean[4];
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		keyDown[0] = false; // UP
		keyDown[1] = false; // DOWN
		keyDown[2] = false; // LEFT
		keyDown[3] = false; // RIGHT
	}
	
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for (GameObject obj : this.handler.objects) {
			if (obj.getId() == ID.Player) {
				//key events for Player 1
				
				if (key == KeyEvent.VK_UP) { obj.setVelY(-5); keyDown[0]= true;}
				if (key == KeyEvent.VK_DOWN) { obj.setVelY(5); keyDown[1]= true;}
				if (key == KeyEvent.VK_LEFT) { obj.setVelX(-5); keyDown[2]= true;}
				if (key == KeyEvent.VK_RIGHT) { obj.setVelX(5); keyDown[3]= true;}
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (GameObject obj : this.handler.objects) {
			if (obj.getId() == ID.Player) {
				//key events for Player 1
				
				if (key == KeyEvent.VK_UP) { keyDown[0]= false;}
				if (key == KeyEvent.VK_DOWN) { keyDown[1]= false;}
				if (key == KeyEvent.VK_LEFT) { keyDown[2]= false;}
				if (key == KeyEvent.VK_RIGHT) { keyDown[3]= false;}
				
				if (!keyDown[0] && !keyDown[1]) {
					obj.setVelY(0);
				}
				
				if (!keyDown[2] && !keyDown[3]) {
					obj.setVelX(0);
				}
				
				if (key == KeyEvent.VK_ESCAPE) { System.exit(1);}
			
			}
		}
		
	}
}
