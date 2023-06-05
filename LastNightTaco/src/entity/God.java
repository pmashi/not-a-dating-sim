package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.GamePanel;
import helpers.DataLoader;

public class God extends Entity {
	
	private BufferedImage sprite; 
	
	public God() { 
		worldX = GamePanel.screenWidth / 2 - 175; 
		worldY = -50; 
		importSprite();
	}
	
	public void draw(Graphics g) { 
		g.drawImage(sprite, worldX, worldY, null);
	}
	
	public void importSprite() { 
		BufferedImage sprite = DataLoader.getImage("hesus.png");
		this.sprite = sprite; 
	}
	
	public int findDistanceFromTarget(Entity e) { 
		return (int) Math.sqrt(Math.pow(worldX - e.getWorldX(), 2) + Math.pow(worldY - e.getWorldY(), 2)); 
	}
}
