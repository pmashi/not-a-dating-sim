package helpers;

import entity.Entity;
import game.Game;

public class CollisionChecker {
	private Game game; 
	 
	public CollisionChecker(Game g) {
		game = g; 
	}
	
	public void checkArea(Entity e) { 
		
	}
	public void checkTile(Entity entity) { 
		int entityLeftWorldX = entity.getWorldX() + entity.getHitBox().x; 
		int entityRightWorldX = entity.getWorldX() + entity.getHitBox().x + entity.getHitBox().width; 
		int entityTopWorldY = entity.getWorldY() + entity.getHitBox().y;
		int entityBottomWorldY = entity.getWorldY() + entity.getHitBox().y + entity.getHitBox().height;

		int entityLeftCol = entityLeftWorldX/Game.unit; 
		int entityRightCol = entityRightWorldX/Game.unit; 
		int entityTopRow = entityTopWorldY/Game.unit; 
		int entityBottomRow = entityBottomWorldY/Game.unit; 
		
		int tileNum1, tileNum2; 
		
		switch(entity.getDirection()) { 
		case "up":
			entityTopRow = (entityTopWorldY - entity.getSpeed()) / Game.unit; 
			
			break;
		case "down":
			break; 
		case "right": 
			break;
		case "left":
			break; 
		}
	}
}
