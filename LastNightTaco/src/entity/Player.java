package entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.Game;
import helpers.*;
import inputs.MyKeyListener;
import objects.Item;
import ui.Hotbar;

public class Player extends Entity {
	private Game game; 
	private MyKeyListener key;
	private Hotbar hotbar; 
	protected Item[] inventory = new Item[5];
	
	
//	Entity variables

//	private BufferedImage[][] sprite; 
//	protected Item equipped; 
	
//	protected Rectangle hitBox; 
	
//	protected int hp, block, mana;
//	protected int x, y, xSpeed, ySpeed; 
//	protected String direction; 
	
	private boolean upPress, downPress, leftPress, rightPress;
	private boolean active, moving, isRun, isBlock; 
	

	 
	
	
	public Player(Game g, MyKeyListener key) { 
		game = g; 
		this.key = key;
		hotbar = new Hotbar(this);
		spriteRow = 0; 
		spriteCol = 3; 
		importSprites("player.png");
		setDefault(); 
	}
	
	private int tick = 0;
	
	public void draw(Graphics g) { 
		super.draw(g);
		
	}
	
	public void update() {
		hotbar.update(); 
		updateSpeed(); 
		updateSprite(); 
		if(active) {
			if(upPress) { 
				moving = true;
				direction = "up";
				super.y -= speed; 
			}
			if(downPress) { 
				moving = true; 
				direction = "down";
				super.y += speed;
			}
			if(leftPress) { 
				moving = true; 
				direction = "left";
				super.x -= speed;
			}
			if(rightPress) { 
				moving = true; 
				direction = "right";
				super.x += speed; 
			}
			if(!(upPress || downPress || leftPress || rightPress)) { 
				moving = false; 
			}
			if(tick % sprites[spriteRow].length == 0) { 
				spriteCol++; 
				if(spriteCol > 5) { 
					spriteCol %= 6; 
				}
			}
		} 
		
		
		tick++;
		if(tick % 120 == 0) {
			//System.out.println(speed + "\n" + checkForMultipleKeys());
		}
	}
	
	public void setDefault() { 
		active = true; 
		super.hp = 100; 
		super.x = 100; 
		super.y = 100; 
		super.baseSpeed = 3;
		super.speed = 3;
		direction = "down"; 
	}
	
	public boolean checkForMultipleKeys() { 
		return (upPress && (leftPress || rightPress)) || (downPress && (leftPress || rightPress));
	}
	
	public void updateSpeed() { 
		if(checkForMultipleKeys()) { //diagonal movement
			speed = (int) Math.floor(super.baseSpeed * Math.sin(45));
		} 
		else { 
			speed = baseSpeed; 
		}
		
		if(isBlock) { 
			speed /= 2; 
		}
		if(isRun) { 
			speed = Utilities.round(speed * 1.5);  
		}
	}
	
	public void importSprites(String fileName) { 
		BufferedImage spritesheet = DataLoader.getImage(fileName);
		sprites = new BufferedImage[9][6];
		for(int i = 0; i < sprites.length; i++) {
			for(int k = 0; k < sprites[i].length; k++) { 
				System.out.println(i + " " + k);
				sprites[i][k] = spritesheet.getSubimage(k * 32, i * 64 + (64-50), 32, 50);
			}
		}
	}
	
	public void updateSprite() { 
		int row = 1; 
		if(moving) { 
			row += 4; 
		}
		if(!checkForMultipleKeys()) {
			if(direction.equals("right") && !leftPress) { 
				spriteRow = row; 
			}
			else if(direction.equals("up") ) { 
				spriteRow = row + 1;
			}
			else if(direction.equals("left")) { 
				spriteRow = row + 2; 
			}
			else if(direction.equals("down") && !upPress) { 
				spriteRow = row + 3; 
			}
		}
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

	public boolean isRunning() { 
		return isRun; 
	}
	
	public void setRun(boolean isRun) { 
		this.isRun = isRun;
	}
	public boolean getActive() { 
		return active; 
	}
	
	public void setActive(boolean b) { 
		active = b; 
	}
	
	public void setEquipped(int i) {
		if(equipped == hotbar.getItem(i)) { 
			super.setEquipped(null);
		} else { 
			equipped = hotbar.getItem(i);
		}
	}
	
}
