package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.Game;
import objects.Item;

public class Entity {
	private BufferedImage[][] sprite; 
	protected Item equipped; 
	protected Rectangle hitbox; 
	protected int hp, block, mana;
	protected int x, y, speed; 
	protected String direction; 
	
	public void draw(Graphics g) { 
		g.setColor(Color.BLACK);
		g.drawRect(x, y, 32, 32);
	}

	public void importSprites() { 
		
	}
	
	public void move(int speed, int angle) { 
		
	}
	
	
	public BufferedImage[][] getSprite() {
		return sprite;
	}

	public Item getEquipped() {
		return equipped;
	}

	public int getHp() {
		return hp;
	}

	public int getBlock() {
		return block;
	}

	public int getMana() {
		return mana;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getDirection() {
		return direction;
	}
	
	

	
}
