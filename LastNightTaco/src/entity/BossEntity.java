package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.Game;
import game.GamePanel;
import helpers.DataLoader;
import objects.Item;
import ui.Hotbar;

public class BossEntity extends Entity {
	
//	protected BufferedImage[][] sprites; 
//	protected int spriteRow;
//	protected int spriteCol; 
//	protected Item equipped; 
//	protected Rectangle hitbox; 
//	protected int hp, block, mana;
//	protected int x, y, baseSpeed, speedBoost, speed; 
//	protected String direction; 
	private Game game; 
	private double scale = 1.5; 
	private int xSpeed, ySpeed; 
	private String vertiDir, HoriDir; 
	
	private boolean isHostile; 
	private boolean moving = false;
	private boolean stop = false; 
	private boolean isAttacking, strafe;  
	private Entity target; 
	private String phase; 
	
	public BossEntity(Game g, int hp) { 
		game = g; 
		importSprites("player.png");
		spriteRow = 4; 
		spriteCol = 0; 
		
		equipped = new Item("sword", 10);
		equipped.importSprites();
		hitbox = new Rectangle(0, 0, 0, 0);

		setDefault(hp);


	}
	
	public void draw(Graphics g) { 
		BufferedImage sprite = sprites[spriteRow][spriteCol];
		g.drawImage(sprite, worldX, worldY, (int) (sprite.getWidth() * scale), (int) (sprite.getHeight() * scale), null);
		drawItem(g);
		drawHitbox(g);
		
	}
	
	public void update() { 
		updateHitbox(); 

		if(isHostile) { 
			
			if(tick % 30 == 0) { 
				updateToTarget();
				updateSpeed(); 
				updateSprite(); 
				updateItemSprite(); 
			}
			move(); 
			
			if(findDistanceFromTarget() < 20) { 
				if(attackCdTick == 0) {
					attack(target); 
					updateHitArea();
					setAttacking(true);
					setAttackAniTick(30); 
					attackCdTick = 60; 
					strafe = true; 
					strafeTick = 120;
				}
			}
		} else { 
			turnHostile(); 
		}
		
		if(tick % sprites[spriteRow].length == 0) { 
			spriteCol++; 
			if(spriteCol > 5) { 
				spriteCol %= 6; 
			}
		}
		updateTick();
	}
	
	private int tick = 0;
	private int attackAniTick, attackCdTick, strafeTick, stunTick; 
	private void updateTick() { 
		tick++; 
		if(attackAniTick > 0) 
			attackAniTick--;
		if(attackCdTick > 0)
			attackCdTick--; 
		if(strafeTick > 0) { 
			strafeTick--; 
		}
		if(strafeTick == 0) {
			strafe = false; 
		}
	}
	
	private void setStrafe(boolean b) {
		strafe = b;
	}

	private void setAttackCd(int i) {
		attackCdTick = 60; 
	}

	private void setAttackAniTick(int i) {
		// TODO Auto-generated method stub
		
	}

	private void setAttacking(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void setDefault(int hp) { 
		this.hp = hp; 
		this.worldX = (GamePanel.screenWidth - sprites[spriteRow][spriteCol].getWidth())/ 2; 
		this.worldY = 200;   
		baseSpeed = 4; 
		this.speed = 4; 
		direction = "down"; 
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
		
		if(direction.equals("right")) { 
			spriteRow = row; 
		}
		else if(direction.equals("up") ) { 
			spriteRow = row + 1;
		}
		else if(direction.equals("left")) { 
			spriteRow = row + 2; 
		}
		else if(direction.equals("down")) { 
			spriteRow = row + 3; 
		}
		
		if(moving) { 
			spriteRow += 4; 
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
	
	public void updateHitArea() { 
		BufferedImage sprite = sprites[spriteRow][spriteCol];
		switch(direction) { 
		case "up":
			equipped.setHitArea(worldX + 10, worldY - sprite.getHeight()/2, (int) (scale * sprite.getWidth()) / 2, 50);
			break; 
		case "down": 
			equipped.setHitArea(worldX + 10, worldY + sprite.getHeight() + 10, (int) (scale * sprite.getWidth()) / 2, 50);
			break; 
		case "right": 
			equipped.setHitArea(worldX + sprite.getWidth() + 10, worldY + 10, 40, 40);
			break; 
		case "left": 
			equipped.setHitArea(worldX - 20, worldY + 10, 40, 40);
			break; 	
		}
	}
	
	public void drawItem(Graphics g) { 
		
		BufferedImage[][] sprites = equipped.getSprites();
		int r = equipped.getSpriteRow(); 
		int c = equipped.getSpriteCol(); 
		BufferedImage sprite = sprites[r][c]; 
		g.drawImage(sprite, worldX + xOffset, worldY + yOffset, sprite.getWidth() * 3, sprite.getHeight() * 3, null); 
	}

	private int xOffset = 0, yOffset = 0 ; 

	public void updateItemSprite() { 
		if(equipped.getType().equals("sword")) { 
			xOffset = yOffset = 0; 
			switch(direction) { 
			case "up":
				equipped.setSpriteRow(0);
				yOffset = -10; 
				break;
			case "down": 
				equipped.setSpriteRow(1);
				yOffset = 40;
				break;
			case "right": 
				equipped.setSpriteRow(2);
				xOffset = 20; 
				break; 
			case "left":
				equipped.setSpriteRow(3);
				xOffset = -20; 
				break; 
				
			}
			if(attackAniTick > 0) { 
				equipped.setSpriteCol(1);
			} else equipped.setSpriteCol(0);
		}
	}

	public void turnHostile() { 
		if(findDistanceFromTarget(game.getPlayer()) < 300) { 
			isHostile = true; 	
			moving = true; 
			target = game.getPlayer(); 
		}
	}
	
	public void updateToTarget() { 
		int dx = target.getWorldX() - worldX; 
		int dy = target.getWorldY() - worldY; 
		
		if(Math.abs(dx) > Math.abs(dy)) {
			if(dx > 0) { 
				direction = "right";
			} else direction = "left";
		} 
		else {
			if(dy > 0) { 
				direction = "down";
			} else direction = "up"; 
		}

	}
	
	public void updateSpeed() { 
		int dx = target.getWorldX() - worldX; 
		int dy = target.getWorldY() - worldY; 
		float angle = (float)Math.atan2(dy, dx); 
	
		xSpeed = (int)(Math.cos(angle) * speed); 
		ySpeed = (int)(Math.sin(angle) * speed); 
		
		if(direction.equals("down") && (worldY + speed > target.getWorldY())) {
			ySpeed = 0;
		} 
		if(stop) { 
			speed = 0; 
		}
	}

	public void move() { 
		if(strafe) {
			worldX -= xSpeed; 
			worldY -= ySpeed; 
		} else {
			worldX += xSpeed; 
			worldY += ySpeed; 
		}

	}
	
	public void teleport() { 
		worldX = (int) (Math.random() * (GamePanel.screenWidth - 640) + 320); 
		worldY = (int) (Math.random() * (GamePanel.screenHeight - 160) + 80);
	}
	
	public int findDistanceFromTarget() { 
		return (int) Math.sqrt(Math.pow(worldX - target.getWorldX(), 2) - Math.pow(worldY, target.getWorldY())); 
	}
	
	public int findDistanceFromTarget(Entity e) { 
		return (int) Math.sqrt(Math.pow(worldX - e.getWorldX(), 2) + Math.pow(worldY - e.getWorldY(), 2)); 
	}
	
}

