package entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.Game;
import inputs.MyKeyListener;
import objects.Item;

public class Player extends Entity {
	private Game game; 
	private MyKeyListener key;
	protected Item[] inventory = new Item[5];
	
//	Entity variables

//	private BufferedImage[][] sprite; 
//	protected Item equipped; 
//	protected Rectangle hitBox; 
//	protected int hp, block, mana;
//	protected int x, y, xSpeed, ySpeed; 
//	protected String direction; 
	
	private boolean active, upPress, downPress, leftPress, rightPress, isBlock; 
	

	 
	
	
	public Player(Game g, MyKeyListener key) { 
		game = g; 
		this.key = key;
		
		setDefault(); 
	}
	
	public void update() { 
		if(upPress) { 
			super.y -= super.speed; 
		}
		if(downPress) { 
			super.y += super.speed;
		}
		if(leftPress) { 
			super.x -= super.speed;
		}
		if(rightPress) { 
			super.x += super.speed; 
		}
	}
	
	public void draw(Graphics g) { 
		super.draw(g);
	}
	
	public void setDefault() { 
		super.hp = 100; 
		super.x = 100; 
		super.y = 100; 
		super.speed = 4;
		
	}



	public boolean isUpPress() {
		return upPress;
	}

	public void setUpPress(boolean upPress) {
		this.upPress = upPress;
	}

	public boolean isDownPress() {
		return downPress;
	}

	public void setDownPress(boolean downPress) {
		this.downPress = downPress;
	}

	public boolean isLeftPress() {
		return leftPress;
	}

	public void setLeftPress(boolean leftPress) {
		this.leftPress = leftPress;
	}

	public boolean isRightPress() {
		return rightPress;
	}

	public void setRightPress(boolean rightPress) {
		this.rightPress = rightPress;
	}

	public boolean isBlock() {
		return isBlock;
	}

	public void setBlock(boolean isBlock) {
		this.isBlock = isBlock;
	}

	public boolean getActive() { 
		return active; 
	}
	
	public void setActive(boolean b) { 
		active = b; 
	}
	
}
