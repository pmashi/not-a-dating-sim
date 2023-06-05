package objects;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import helpers.DataLoader;

public class Item {
	private BufferedImage[][] sprites; 
	private int spriteRow, spriteCol;
	private String type; 
	private int damage; 
	private Rectangle hitArea; 
	
	public Item(String type, int dmg) { 
		this.type = type; 
		damage = dmg; 
		spriteRow = 0; 
		spriteCol = 0; 
		hitArea = new Rectangle(0, 0, 0, 0);
	}
	
	public void importSprites() { 
		if(type.equals("sword")) { 
			BufferedImage spreadsheet = DataLoader.getImage("sword.png");
			sprites = new BufferedImage[4][3];
			sprites[0][0] = spreadsheet.getSubimage(0, 0, 16, 16);
			sprites[0][1] = spreadsheet.getSubimage(16, 0, 16, 20);
			sprites[0][2] = spreadsheet.getSubimage(0, 16, 16, 16);

			
			sprites[1][0] = spreadsheet.getSubimage(0, 16, 16, 16);
			sprites[1][1] = spreadsheet.getSubimage(32, 0, 16, 20);
			sprites[1][2] = spreadsheet.getSubimage(0, 0, 16, 16);

			sprites[2][0] = spreadsheet.getSubimage(0, 16, 16, 16);
			sprites[2][1] = spreadsheet.getSubimage(0, 32, 20, 16);
			sprites[2][2] = spreadsheet.getSubimage(16, 0, 16, 20);

			sprites[3][0] = spreadsheet.getSubimage(0, 0, 16, 16);
			sprites[3][1] = spreadsheet.getSubimage(0, 48, 20, 16);
			sprites[3][2] = spreadsheet.getSubimage(16, 0, 16, 20);

		}
	}
	
	public BufferedImage[][] getSprites() {
		return sprites; 
	}
	
	public void setSpriteRow(int i) {
		spriteRow = i; 
	}
	
	public void setSpriteCol(int i) {
		spriteCol = i; 
	}
	
	public int getSpriteRow() { 
		return spriteRow; 
	}
	
	public int getSpriteCol() { 
		return spriteCol; 
	}
	
	public String getType() { 
		return type; 
	}
	
	public int getDamage() { 
		return damage; 
	}
	
	public void setHitArea(int x, int y, int w, int h) { 
		hitArea = new Rectangle(x, y, w, h); 
	}
	
	public Rectangle getHitArea() { 
		return hitArea; 
	}
} 
