package game;

public enum GameState {
	MENU, SCENE_SELECT, PLAYING, DEATH; 
	
	public static GameState STATE = MENU; 
	
	public static void setState(GameState s) { 
		STATE = s; 
	}
}
