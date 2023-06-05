package objects;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Tile {
	private BufferedImage sprite; 
	private int id; 
	private boolean collision; 

	private Rectangle hitbox;
	
	public Tile(BufferedImage sprite, int id, boolean collision) {
		this.sprite = sprite; 
		this.id = id; 
		this.collision = collision; 
	}
	
	public Tile(int x, int y, int w, int h) {
		hitbox = new Rectangle(x, y, w, h);
	}

	public BufferedImage getSprite() {
		return sprite;
	}

	public int getId() {
		return id;
	}
	
	public boolean getCollision() { 
		return collision; 
	}
}
