package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.Game;
import helpers.DataLoader;
import objects.Item;

public class Entity {
	protected BufferedImage[][] sprites; 
	protected int spriteRow;
	protected int spriteCol; 
	
	protected Item equipped; 
	
	protected Rectangle hitbox; 
	
	protected int hp, block, mana;
	protected int worldX, worldY, baseSpeed, speedBoost, speed; 
	protected String direction; 
	
	public void draw(Graphics g) { 
		
	}

	
	

	
	
	
	public BufferedImage[][] getSprites() {
		return sprites;
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

	public int getWorldX() {
		return worldX;
	}

	public int getY() {
		return worldY;
	}

	public String getDirection() {
		return direction;
	}
	
	public void setEquipped(Item i) { 
		equipped = i; 
	}
}
