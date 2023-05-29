package game;

public enum GameState {
	MENU, SCENE_SELECT, PLAYING, DEATH; 
	
	public static GameState state = MENU; 
	
	public static void setState(GameState s) { 
		state = s; 
	}
}
