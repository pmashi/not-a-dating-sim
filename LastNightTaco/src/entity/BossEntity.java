package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import objects.Item;

public class BossEntity extends Entity {
	
//	protected BufferedImage[][] sprites; 
//	protected int spriteRow;
//	protected int spriteCol; 
//	protected Item equipped; 
//	protected Rectangle hitbox; 
//	protected int hp, block, mana;
//	protected int x, y, baseSpeed, speedBoost, speed; 
//	protected String direction; 
	
	private int xSpeed, ySpeed; 

	private boolean isHostile; 
	private Entity target; 
	
	
	public BossEntity() { 
		
	}
	
	public void draw() { 
		
	}
	
	public void update() { 
		
	}
	
	public void setDefault(int hp, int x, int y, int speed, String direction) { 
		this.hp = hp; 
		this.worldX = x; 
		this.worldY = y; 
		baseSpeed = speed; 
		this.speed = speed; 
		this.direction = direction; 
	}
	
	
	public int findTargetXDistance() { 
		return Math.abs(target.getWorldX() - this.worldX);
		
	}
	
	public int findTargetYDistance() { 
		return Math.abs(target.getY() - this.worldY); 
	}
	
	public int findTargetAngle() { 
		return (int) Math.atan(findTargetYDistance() / findTargetXDistance()); 
	}
}

