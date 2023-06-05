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
	
	protected String name; 
	protected int hp, block, mana;
	protected int worldX, worldY, baseSpeed, speedBoost, speed; 
	protected String direction; 
	
	public Entity() {}
	
	public Entity(String name) { 
		this.name = name;
	}
	
	public void draw(Graphics g) { 
		
	}
	
	public void attack(Entity e) {
		if(equipped.getHitArea().intersects(e.getHitBox())) {
			System.out.println("HIT!");
			e.getHit(this); 
		}
	}
	
	public void getHit(Entity offender) { 
		hp -= offender.getEquipped().getDamage(); 
	}
	
	
	public BufferedImage[][] getSprites() {
		return sprites;
	}

	public Item getEquipped() {
		return equipped;
	}

	public Rectangle getHitBox() { 
		return hitbox;	
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

	public int getSpeed() { 
		return speed; 
	}
	
	public int getWorldX() {
		return worldX;
	}

	public void setWorldX(int x) { 
		worldX = x; 
	}
	public int getWorldY() {
		return worldY;
	}
	
	public void setWorldY(int y) { 
		worldY = y; 
	}

	public String getDirection() {
		return direction;
	}
	
	public void setDirection(String s) { 
		direction = s; 
	}
	public void setEquipped(Item i) { 
		equipped = i; 
	}
}
