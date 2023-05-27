package objects;

import java.awt.image.BufferedImage;

public class Tile {
	private BufferedImage sprite; 
	private int tileType; 
	private int id; 

	public Tile(BufferedImage sprite, int id, int tileType) {
		this.sprite = sprite; 
		this.tileType = tileType; 
		this.id = id; 
	}

	public BufferedImage getSprite() {
		return sprite;
	}

	public int getTileType() {
		return tileType;
	}

	public int getId() {
		return id;
	}
	
}
