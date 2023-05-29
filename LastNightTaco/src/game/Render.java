package game;

import java.awt.Graphics;

public class Render {
	
	Game game; 
	public Render(Game g) { 
		game = g; 
	}
	
	public void render(Graphics g) { 
		switch(GameState.state) { 
		case MENU: 
			game.getMenu().render(g);
			break; 
		case PLAYING: 
			game.getPlay().render(g);
			break; 
		case SCENE_SELECT: 
			game.getSceneSelect().render(g);
			break; 
		case DEATH: 
			game.getDeath().render(g);
		default: 
			break; 
		}
	}
	
}
