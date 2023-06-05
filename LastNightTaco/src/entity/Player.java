package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.Game;
import game.GamePanel;
import helpers.*;
import inputs.MyKeyListener;
import objects.Item;
import scene.Playing;
import ui.Hotbar;
import ui.ValueBar;

public class Player extends Entity {
	
	
//	Entity variables

//	private BufferedImage[][] sprites; 
//	protected Item equipped; 
	
//	protected Rectangle hitBox; 
	
//	protected int hp, block, mana;
//	protected int x, y, xSpeed, ySpeed; 
//	protected String direction; 
	private Game game; 
	private MyKeyListener key;
	private ValueBar hpBar = new ValueBar("HP", 100, Color.RED, Color.GREEN);
	private Hotbar hotbar; 
	private Item[] inventory = new Item[2];
	private int equipID = 0;
	private BufferedImage locator; 
	
	private boolean upPress, downPress, leftPress, rightPress;
	private boolean active, lockDirection, moving, isAttacking, isRun, isBlock; 
	
	private boolean showLocator, showHotbar, showValueBars; 
	private int screenX, screenY; 
	private double scale; 
	
	
	
	public Player(Game g, MyKeyListener key) { 
		locator = DataLoader.getImage("locator.png");
		game = g; 
		this.key = key;
		hotbar = new Hotbar(this);
		spriteRow = 0; 
		spriteCol = 3; 
		importSprites("player.png");
		hitbox = new Rectangle(0, 0, 0, 0);

//		screenX = GamePanel.screenWidth / 2 - (int) (1.5 * sprites[0][0].getWidth() / 2);
//		screenY = GamePanel.screenHeight / 2 - (int) (1.5 * sprites[0][0].getHeight() / 2); 
		
		inventory[0] = new Item("sword", 10);
		inventory[0].importSprites(); 
		equipped = inventory[0];
		setDefault(); 

	}
	
	public void setDefault() { 
		active = true; 
		super.hp = 100; 
		super.worldX = (GamePanel.screenWidth - sprites[spriteRow][spriteCol].getWidth()) / 2; 
		super.worldY = screenY; 
		super.baseSpeed = 3;
		super.speed = 3;
		direction = "down"; 
	}
	
	private int tick = 0;
	
	public void draw(Graphics g) { 
		
		BufferedImage sprite = sprites[spriteRow][spriteCol];
		if(Playing.getScene() == 0) { 
			scale = 2.5; 
		} else {
			scale = 1.5; 
		}
		if(game.getPlay().getCameraLock()) {
			if(showLocator) 
				g.drawImage(locator, screenX, screenY + (int)(48 * scale), (int)(32 * scale), 10, null);
				//g.drawOval(screenX, screenY + (int)(48 * scale), (int)(32 * scale), 10);
			g.drawImage(sprite, screenX, screenY, (int) (sprite.getWidth() * scale), (int) (sprite.getHeight() * scale), null);
		} else { 
			if(showLocator)
				g.drawImage(locator, worldX, worldY + (int)(48 * scale), (int)(32 * scale), 10, null);
				//g.drawOval(worldX, worldY + (int)(48 * scale), (int)(32 * scale), 10);
			g.drawImage(sprite, worldX, worldY, (int) (sprite.getWidth() * scale), (int) (sprite.getHeight() * scale), null);
		}
		
//		if((equipID == 0 || equipID == 1)) { 
//			if(inventory[equipID].getType().equals("sword")) { 
//				drawItem(g); 
//			}
//		}
		if(Playing.getScene() == 3) {
			drawItem(g);
		}
		drawHitbox(g); 
		
		g.drawRect(equipped.getHitArea().x, equipped.getHitArea().y, equipped.getHitArea().width, equipped.getHitArea().height); 
	}
	
	public void update() {
		if(active) {
			hotbar.update(); 
			updateSpeed(); 
			updateSprite(); 
			updateHitbox(); 
			updateItemSprite(); 
			
			if(upPress) { 
				moving = true;
				direction = lockDirection ? direction : "up";
				if(!(worldY - speed < 0))
					super.worldY -= speed; 
			}
			if(downPress) { 
				moving = true; 
				direction = lockDirection ? direction : "down";
				if(!(worldY + speed > GamePanel.screenHeight - 2 * sprites[spriteRow][spriteCol].getHeight()))
					super.worldY += speed;
			}
			if(leftPress) { 
				moving = true; 
				direction = lockDirection ? direction : "left";
				if(!(worldX - speed < 0))
					super.worldX -= speed;
			}
			if(rightPress) { 
				moving = true; 
				direction = lockDirection ? direction : "right";
				if(!(worldX + speed > GamePanel.screenWidth - 2 * sprites[spriteRow][spriteCol].getWidth()))
					super.worldX += speed; 
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
		
		
		updateTick(); 
		
		if(tick % 120 == 0) {
			//System.out.println(speed + "\n" + checkForMultipleKeys());
		}
	}
	
	private int attackAniTick, attackCdTick, blockCdTick, parryTimerTick; 

	public void updateTick() { 
		tick++; 
		attackAniTick--; 
		attackCdTick--; 
		blockCdTick--; 
		parryTimerTick++; 
	}
	
	public void updateHitArea() { 
		BufferedImage sprite = sprites[spriteRow][spriteCol];
		switch(direction) { 
		case "up":
			inventory[0].setHitArea(worldX + 10, worldY - sprite.getHeight()/2, (int) (scale * sprite.getWidth()) / 2, 50);
			break; 
		case "down": 
			inventory[0].setHitArea(worldX + 10, worldY + sprite.getHeight() + 10, (int) (scale * sprite.getWidth()) / 2, 50);
			break; 
		case "right": 
			inventory[0].setHitArea(worldX + sprite.getWidth() + 10, worldY + 10, 40, 40);
			break; 
		case "left": 
			inventory[0].setHitArea(worldX - 20, worldY + 10, 40, 40);
			break; 	
		}
	}
	
	
	
	
	
	public boolean parried() { 
		return parryTimerTick >= 6 && parryTimerTick <= 12; 
	}
	
	public void update(int i) { 
		updateSprite(); 
		if(i == 1) {
			moving = true;
			direction = "up";
		}

		if(tick % sprites[spriteRow].length == 0) { 
			spriteCol++; 
			if(spriteCol > 5) { 
				spriteCol %= 6; 
			}
		}
	}
	
	public void drawItem(Graphics g) { 
		
		BufferedImage[][] sprites = inventory[equipID].getSprites();
		int r = equipped.getSpriteRow(); 
		int c = equipped.getSpriteCol(); 
		BufferedImage sprite = sprites[r][c]; 
		g.drawImage(sprite, worldX + xOffset, worldY + yOffset, sprite.getWidth() * 3, sprite.getHeight() * 3, null); 
	}
	
	private int xOffset = 0, yOffset = 0 ; 
	
	public void updateItemSprite() { 
		if(equipID != -1) { 
			if(inventory[equipID].getType().equals("sword")) { 
				xOffset = yOffset = 0; 
				switch(direction) { 
				case "up":
					inventory[equipID].setSpriteRow(0);
					yOffset = -10; 
					break;
				case "down": 
					inventory[equipID].setSpriteRow(1);
					yOffset = 40;
					break;
				case "right": 
					inventory[equipID].setSpriteRow(2);
					xOffset = 20; 
					break; 
				case "left":
					inventory[equipID].setSpriteRow(3);
					xOffset = -20; 
					break; 
					
				}
				if(attackAniTick > 0) { 
					inventory[equipID].setSpriteCol(1);
				}
				else if(isBlock) { 
					yOffset = 20; 
					inventory[equipID].setSpriteCol(2);
				} else inventory[equipID].setSpriteCol(0);
			}
		}
	}
	
	public void updateHitbox() { 
		BufferedImage sprite = sprites[spriteRow][spriteCol];
		hitbox = new Rectangle(worldX , worldY + 10, (int)(sprite.getWidth() * scale), (int)(sprite.getHeight() * scale - 10));

	}
	
	public void drawHitbox(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
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
//				System.out.println(i + " " + k);
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

	public void setPlayerLocation(int x, int y) { 
		this.setWorldX(x);
		this.setWorldY(y);
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

	public boolean isShowLocator() { 
		return showLocator;
	}
	
	public void setShowLocator(boolean b) { 
		showLocator = b; 
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
	
	public int getEquipId() { 
		return equipID; 
	}
	
	public void setShowHotbar(boolean b) {
		showHotbar = b; 
	}
	
	public boolean showHotbar() { 
		return showHotbar;
	}
	
	public void setEquipped(int i) {
		if(equipped == hotbar.getItem(i)) { 
			super.setEquipped(null);
			equipID = -1; 
		} else { 
			equipped = hotbar.getItem(i);
			equipID = i; 
		}
	}
	
	public boolean isAttacking() {
		return isAttacking;
	}

	public void setAttacking(boolean isAttacking) {
		this.isAttacking = isAttacking;
	}

	public int getAttackAniTick() {
		return attackAniTick;
	}

	public void setAttackAniTick(int attackAniTick) {
		this.attackAniTick = attackAniTick;
	}

	public int getAttackCdTick() {
		return attackCdTick;
	}

	public void setAttackCdTick(int attackCdTick) {
		this.attackCdTick = attackCdTick;
	}

	public int getBlockCdTick() {
		return blockCdTick;
	}

	public void setBlockCdTick(int blockCdTick) {
		this.blockCdTick = blockCdTick;
	}

	public int getParryTimerTick() {
		return parryTimerTick;
	}

	public void setParryTimerTick(int parryTimerTick) {
		this.parryTimerTick = parryTimerTick;
	}
	
	public boolean isLockDirection() {
		return lockDirection;
	}

	public void setLockDirection(boolean lockDirection) {
		this.lockDirection = lockDirection;
	}
}
