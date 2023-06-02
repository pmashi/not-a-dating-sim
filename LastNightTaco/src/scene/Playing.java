package scene;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import entity.Player;
import game.Game;
import game.GameState;
import ui.DialogueBox;
import ui.Hotbar;

public class Playing extends GameScene implements SceneMethods {
	private Player player; 
	private DialogueBox dialogueBox; 
	private Hotbar hotbar; 
	private int scene; 
	private ArrayList<GameScene> gameScenes = new ArrayList<>(); 
	private HomeScene homeScene; 
	private OutsideScene outsideScene; 
	private DeathScene deathScene; 
	
	private boolean cameraLock; 
	private boolean pause; 
	
	public Playing(Game g) {
		super(g);
		player = game.getPlayer();
		dialogueBox = new DialogueBox();
		hotbar = new Hotbar(player);
		initScenes();

	}
	
	public void render(Graphics g) { 
		g.drawString("Scene: " + scene, 0, 0);
		gameScenes.get(1).render(g);
		player.draw(g); 
		if(player.getActive()) {
			hotbar.draw(g); 
		}
		if(dialogueBox.getVisible()) { 
			dialogueBox.draw(g);
		}
	}
	
	public void update() { 
		if(!pause) { 
			player.update(); 
		}
		
	}
	
	private void initScenes() { 
		homeScene = new HomeScene(game);
		outsideScene = new OutsideScene(game); 
		deathScene = new DeathScene(game); 
		
		gameScenes.add(homeScene);
		gameScenes.add(outsideScene);
		gameScenes.add(deathScene);
	}

	public void setScene(int s) { 
		scene = s; 
	}
	
	public void setCameraLock(boolean b) { 
		cameraLock = b; 
	}
	
	public boolean getCameraLock() { 
		return cameraLock; 
	}
	
	public void setPause(boolean b) { 
		pause = b; 
	}
	
	public boolean getPause() { 
		return pause; 
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
		
		if(key == KeyEvent.VK_J) { 
			player.setActive(!player.getActive());
		}
		
		if(key == KeyEvent.VK_L) { 
			setCameraLock(!cameraLock);
		}
		
		if(key == KeyEvent.VK_1) { 
			player.setEquipped(0); 
		}
		
		if(key == KeyEvent.VK_2) { 
			player.setEquipped(1);
		}
		
		if(key == KeyEvent.VK_Z) { 
			dialogueBox.setVisibility(!dialogueBox.getVisible());
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
		System.out.println(x + " " + y);
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
