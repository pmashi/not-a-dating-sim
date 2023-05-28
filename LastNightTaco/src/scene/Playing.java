package scene;

import java.awt.Graphics;

import entity.Player;
import game.Game;
import game.GameState;

public class Playing extends GameScene implements SceneMethods {
	private Player player; 
	private int scene; 
	private GameScene[] gameScenes; 
	
	public Playing(Game g) {
		super(g);
		player = game.getPlayer();
	}
	
	public void render(Graphics g) { 
		player.draw(g); 
	}
	
	public void update() { 
		
	}

	@Override
	public void mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub
		
	}	
}
