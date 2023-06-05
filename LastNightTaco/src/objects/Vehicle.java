package objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Vehicle {
	private BufferedImage sprite; 
	private int speed; 
	private int x, y; 
	
	public Vehicle() { 
		
	}
	
	public void draw(Graphics g) { 
		g.drawImage(sprite, x, y, null); 
	}
	
	public void draw(Graphics g, int w, int h) { 
		g.drawImage(sprite, x, y, w, h, null); 
	}
	
	public void move(int x, int y) { 
		x -= speed; 
	}
	
	public void setSprite(BufferedImage img) {
		sprite = img; 
	}
	
	public BufferedImage getSprite() { 
		return sprite; 
	}
	
	public void setLocation(int x, int y) { 
		this.x = x; 
		this.y = y; 
	}
	
	public int getX() { 
		return x;
	}
	
	public int getY() { 
		return y; 
	}
}
