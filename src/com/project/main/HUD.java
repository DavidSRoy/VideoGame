package com.project.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD implements Displayable {
	
	public static int HEALTH = 100;
	
	private int score = 0;
	private int level = 1;
	private boolean isGameOver = false;
	
	public void tick() {
		
		HEALTH = Game.clamp(HEALTH, 0, 100);
		
		if (HEALTH <= 0) {
			isGameOver = true;
		} else {
			score++;
		}
		
		

	}
	
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(15,  15, 200, 32);
		
		//transition
		if (HEALTH > 66) {
			g.setColor(Color.GREEN);
		} else if (HEALTH > 33) {
			g.setColor(Color.YELLOW);
		} else if (HEALTH <= 33) {
			g.setColor(Color.RED);
		}
		
		g.fillRect(15,  15, HEALTH * 2, 32);
		g.setColor(Color.WHITE);
		g.drawRect(15,  15, 200, 32);
		
		
		g.drawString("Score : " + score, 15, 64);
		g.drawString("Level : " + level, 15,  80);
		
		if (isGameOver) {
			gameOver(g);
		}
		
	}
	
	private void gameOver(Graphics g) {
		g.setFont(new Font("SansSerif", Font.PLAIN, 50));
		g.drawString("GAME OVER!", 5, Game.HEIGHT / 2);
		
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public int getLevel() {
		return this.level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}
