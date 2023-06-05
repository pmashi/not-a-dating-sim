package scene;

import java.awt.Graphics;

import game.Game;
import game.GameState;

public class GameScene {
	protected Game game; 
	
	public GameScene(Game g) { 
		game = g; 
	}
	
	public Game getGame() { 
		return game; 
	}
	
	public void render(Graphics g) {}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void setDefault() {
		// TODO Auto-generated method stub
		
	}
}
