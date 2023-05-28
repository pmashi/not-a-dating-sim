package scene;

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
}
