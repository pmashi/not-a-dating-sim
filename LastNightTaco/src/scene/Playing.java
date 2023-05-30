package scene;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import entity.Player;
import game.Game;
import game.GameState;
import ui.Hotbar;

public class Playing extends GameScene implements SceneMethods {
	private Player player; 
	private Hotbar hotbar; 
	private int scene; 
	private GameScene[] gameScenes; 
	private boolean pause; 
	
	public Playing(Game g) {
		super(g);
		player = game.getPlayer();
		hotbar = new Hotbar(player);
	}
	
	public void render(Graphics g) { 
		player.draw(g); 
		hotbar.draw(g); 
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
		
		if(key == KeyEvent.VK_F) { 
			player.setBlock(true);
		}
		
		if(key == KeyEvent.VK_SHIFT) { 
			player.setRun(true);
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
		
		if(key == KeyEvent.VK_F) { 
			player.setBlock(false);
		}
		
		if(key == KeyEvent.VK_SHIFT) { 
			player.setRun(false);
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
