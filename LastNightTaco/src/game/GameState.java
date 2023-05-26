package game;

public enum GameState {
	MENU, PLAYING, EDIT, DEATH, SCENE_SELECT; 
	
	public static GameState STATE = MENU; 
	
	public static void setState(GameState s) { 
		STATE = s; 
	}
}
