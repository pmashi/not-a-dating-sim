package scene;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import entity.Player;
import game.Game;
import game.GameState.*;
import static game.GameState.*; 
import ui.Buttons;
import ui.DialogueBox;
import ui.Hotbar;

public class Playing extends GameScene implements SceneMethods, MouseListener {
	private Player player; 
	private Buttons back; 
	private DialogueBox dialogueBox; 
	private Hotbar hotbar; 
	
	public static int scene = 1; 
	private ArrayList<GameScene> gameScenes = new ArrayList<>(); 
	private HomeScene homeScene; 
	private OutsideScene outsideScene; 
	private DeathScene deathScene; 
	private BossFightScene bossFightScene; 
	
	private boolean cameraLock, showHotbar; 
	private boolean pause, backMenu; 

	
	public Playing(Game g) {
		super(g);
		back = new Buttons("Back", 10, 10, 50, 50);
		player = game.getPlayer();
		dialogueBox = new DialogueBox();
		hotbar = new Hotbar(player);
		initScenes();

	}
	
	public void render(Graphics g) { 
		if(scene == 0 || scene == 3) { 
			//game.getGamePanel().setBackground(Color.BLACK);
		} 
		else if(scene == 2) { 
			game.getGamePanel().setBackground(Color.WHITE);
		}
		else { 
			game.getGamePanel().setBackground(Color.WHITE);
		}
		gameScenes.get(scene).render(g);
		
		back.draw(g);
		g.drawString("Scene: " + scene, 0, 0);
		
		player.draw(g); 
		if(player.showHotbar()) {
//			hotbar.draw(g); 
		}
		if(dialogueBox.getVisible()) { 
			dialogueBox.draw(g);
		}
	}
	private int tick = 0; 
	public void update() { 
		if(!pause) { 
//			tick++; 
//			if(tick % 10 == 0) 
//				System.out.println(tick); 
			player.update(); 
			gameScenes.get(scene).update(); 
		}
		
		if(scene == 1) { 
			if(player.getActive()) { 
				player.setActive(false);
			}
			player.update(); 
		} 
		else if(scene == 2) { 
			
		}
		else {
			player.setActive(true); 
		}
		
		
	}
	
	private void initScenes() { 
		homeScene = new HomeScene(game);
		outsideScene = new OutsideScene(game); 
		deathScene = new DeathScene(game); 
		bossFightScene = new BossFightScene(game);
		
		gameScenes.add(homeScene);
		gameScenes.add(outsideScene);
		gameScenes.add(deathScene);
		gameScenes.add(bossFightScene);
	}
	
	public void setDefault(int scene) { 
		gameScenes.get(scene).setDefault(); 
	}

	public static void setScene(int s) {
		scene = s; 
	}
	
	public static int getScene() { 
		return scene; 
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
	
	
	public void mouseClicked(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		if(scene == 3) {
			if(e.getButton() == MouseEvent.BUTTON1) { 
//				System.out.println("YES" + player.isAttacking());
				player.attack(bossFightScene.getBoss()); 
				player.updateHitArea();
				player.setAttacking(true);
				player.setAttackAniTick(30); 
				player.setAttackCdTick(45);
			}
			
			if(e.getButton() == MouseEvent.BUTTON3) { 
				player.setBlock(true);
				player.setParryTimerTick(tick);
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3) { 
			player.setBlock(false);
			player.setBlockCdTick(60);
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
		
		if(key == KeyEvent.VK_Z) { 
			player.setBlock(true);
		}
		
		if(key == KeyEvent.VK_SHIFT) { 
			player.setRun(true);
		}
		
		if(key == KeyEvent.VK_C) { 
			player.setLockDirection(!player.isLockDirection());
		}
//		if(key == KeyEvent.VK_J) { 
//			player.setActive(!player.getActive());
//		}
//		
//		if(key == KeyEvent.VK_L) { 
//			setCameraLock(!cameraLock);
//		}
		
		if(key == KeyEvent.VK_1) { 
			player.setEquipped(0); 
		}
		
		if(key == KeyEvent.VK_2) { 
			player.setEquipped(1);
		}
		
//		if(key == KeyEvent.VK_Z) { 
//			dialogueBox.setVisibility(!dialogueBox.getVisible());
//		}
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
		if(back.getBounds().contains(x, y)) {
			setState(MENU);
		} 
//		else {  
//			if(pause) { 
//				pause = !pause; 
//			}
//		}
//		System.out.println(x + " " + y + "\nWorld (X, Y)");
	}

	@Override
	public void mouseMoved(int x, int y) {
		// TODO Auto-generated method stub
		back.setMouseOver(false);
		if(back.getBounds().contains(x, y)) {
			back.setMouseOver(true);
		}
	}

	@Override
	public void mousePressed(int x, int y) {
		// TODO Auto-generated method stub
		if(back.getBounds().contains(x, y)) {
			back.setMousePressed(true);
		}
	}

	@Override
	public void mouseReleased(int x, int y) {
		// TODO Auto-generated method stub
		back.resetBooleans();
 
	}

	@Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
