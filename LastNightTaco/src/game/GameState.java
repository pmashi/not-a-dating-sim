package game;

public enum GameState {
	MENU, LOADING, PLAYING, PAUSED, SETTINGS, EDIT; 
	
	public static GameState STATE = MENU; 
	
	public static void setState(GameState s) { 
		STATE = s; 
	}
}
