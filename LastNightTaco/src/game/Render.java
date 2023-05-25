package game;

public class Render {
	
	Game game; 
	public Render(Game g) { 
		game = g; 
	}
	
	public void render() { 
		switch(GameState.STATE) { 
		case MENU: 
		
			break; 
		case PLAYING: 
		
			break; 
		case LOADING: 
			
			break; 
		case SETTINGS: 
			
			break; 
		default: 
			break; 
		}
	}
	
}
