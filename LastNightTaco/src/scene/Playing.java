package scene;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import entity.Player;
import game.Game;
import game.GameState;

public class Playing extends GameScene implements SceneMethods {
	private Player player; 
	private int scene; 
	private GameScene[] gameScenes; 
	private boolean pause; 
	
	public Playing(Game g) {
		super(g);
		player = game.getPlayer();
	}
	
	public void render(Graphics g) { 
		player.draw(g); 
	}
	
	public void update() { 
		if(!pause) { 
			player.update(); 
		}
	}

	public void keyPressed(KeyEvent e) { 
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_W) { 
			player.setUpPress(true);
		}
		
		if(key == KeyEvent.VK_S) { 
			player.setDownPress(true);
		}
		
		if(key == KeyEvent.VK_A) { 
			player.setLeftPress(true);
		}
		
		if(key == KeyEvent.VK_D) { 
			player.setRightPress(true);
		}

	}
	
	public void keyReleased(KeyEvent e) { 
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_W) { 
			player.setUpPress(false);
		}
		
		if(key == KeyEvent.VK_S) { 
			player.setDownPress(false);
		}
		
		if(key == KeyEvent.VK_A) { 
			player.setLeftPress(false);
		}
		
		if(key == KeyEvent.VK_D) { 
			player.setRightPress(false);
		}
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
