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
	
	private int tick = 0;
	
	public void update() { 
		checkForMultipleKeys();
		if(active) {
			if(upPress) { 
				super.y -= speed; 
			}
			if(downPress) { 
				super.y += speed;
			}
			if(leftPress) { 
				super.x -= speed;
			}
			if(rightPress) { 
				super.x += speed; 
			}
		}
		tick++;
		if(tick % 120 == 0) {
			System.out.println(speed);
		}
	}
	
	public void checkForMultipleKeys() { 
		int newSpeed = (int) Math.floor(super.baseSpeed * Math.sin(45));
		if((upPress && (leftPress || rightPress)) || (downPress && (leftPress || rightPress))) { 
			this.speed = newSpeed;
		} else { 
			speed = baseSpeed; 
		}

	}
	
	public void draw(Graphics g) { 
		super.draw(g);
	}
	
	public void setDefault() { 
		active = true; 
		super.hp = 100; 
		super.x = 100; 
		super.y = 100; 
		baseSpeed = 3;
		super.speed = 3;
		
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
