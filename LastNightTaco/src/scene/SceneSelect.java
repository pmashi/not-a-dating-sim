package scene;

import static game.GameState.*;
import game.GameState;
import java.awt.Graphics;

import game.Game;
import scene.Playing;
import ui.Buttons;

public class SceneSelect extends GameScene implements SceneMethods {
	
	private Buttons back, homeScene, outsideScene, deathScene, bossFightScene; 
	
	
	public SceneSelect(Game g) {
		super(g);
		initButtons(); 
	}

	public void initButtons() { 
		int width = 300; 
		int height = 100; 
		int x = 100;
		int y = 100;
		int offSet = 150; 
		
		back = new Buttons("Back", 10, 10, 50, 50); 
		homeScene = new Buttons("Home", x, y + 0 *offSet, width, height); 
		outsideScene = new Buttons("Outside", x, y + 1 * offSet, width, height); 
		deathScene = new Buttons("Death Scene", x, y + 2 * offSet, width, height); 
		bossFightScene = new Buttons("Boss Fight", x, y + 3 * offSet, width, height); 
	}
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		drawButtons(g); 
	}

	public void drawButtons(Graphics g) { 
		back.draw(g); 
		homeScene.draw(g);
		outsideScene.draw(g);
		deathScene.draw(g);
		bossFightScene.draw(g);
	}

	
	@Override
	public void mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		if(back.getBounds().contains(x, y)) 
		{
			setState(MENU);
		} 
		else if(homeScene.getBounds().contains(x, y)) { 
			game.getPlay().setScene(0);
			setState(PLAYING);
		}
		else if (outsideScene.getBounds().contains(x,y)) {
			game.getPlay().setScene(1);
			setState(PLAYING);
		}
		else if (deathScene.getBounds().contains(x, y)) {
			game.getPlay().setScene(2);
			setState(PLAYING);
		}
		else if(bossFightScene.getBounds().contains(x, y)) {
			game.getPlay().setScene(3);
			setState(PLAYING);
		}
	}
	
	@Override
	public void mouseMoved(int x, int y) {
		// TODO Auto-generated method stub
		back.setMouseOver(false);
		homeScene.setMouseOver(false);
		outsideScene.setMouseOver(false);
		deathScene.setMouseOver(false);
		if(back.getBounds().contains(x, y)) {
			back.setMouseOver(true);
		}
		else if(homeScene.getBounds().contains(x, y)) { 
			homeScene.setMouseOver(true);
		}
		else if(outsideScene.getBounds().contains(x, y)) { 
			outsideScene.setMouseOver(true);
		}
		else if(deathScene.getBounds().contains(x, y)) { 
			deathScene.setMouseOver(true);
		}
		else if(bossFightScene.getBounds().contains(x, y)) { 
			bossFightScene.setMouseOver(true);
		}
	}

	@Override
	public void mousePressed(int x, int y) {
		// TODO Auto-generated method stub

		if(back.getBounds().contains(x, y)) {
			back.setMousePressed(true);
		}
		else if(homeScene.getBounds().contains(x, y)) { 
			homeScene.setMousePressed(true);
		}
		else if(outsideScene.getBounds().contains(x, y)) { 
			outsideScene.setMousePressed(true);
		}
		else if(deathScene.getBounds().contains(x, y)) { 
			deathScene.setMousePressed(true);
		}
		else if(bossFightScene.getBounds().contains(x, y)) { 
			bossFightScene.setMousePressed(true);
		}
	}
//	back, homeScene, outsideScene, deathScene, bossFightScene; 

	@Override
	public void mouseReleased(int x, int y) {
		// TODO Auto-generated method stub
		back.resetBooleans();
		homeScene.resetBooleans();
		outsideScene.resetBooleans();
		deathScene.resetBooleans();
		bossFightScene.resetBooleans();
	}

	@Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
