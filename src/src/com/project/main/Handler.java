package com.project.main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Handler {
	
	List<GameObject> objects = new ArrayList<GameObject>();
	
	public void tick() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject obj = this.objects.get(i);
			obj.tick();
		}
	}
	
	public void render(Graphics g) {
		for (GameObject obj : objects) {
			obj.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		this.objects.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.objects.remove(object);
	}
}
