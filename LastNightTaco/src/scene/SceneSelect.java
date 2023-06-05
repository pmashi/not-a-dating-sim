package scene;

import static game.GameState.*;
import game.GameState;
import java.awt.Graphics;

import game.Game;
import scene.Playing;
import scene.Menu;
import ui.Buttons;

public class SceneSelect extends GameScene implements SceneMethods {
	
	private Buttons back, homeScene, outsideScene, deathScene, bossFightScene; 
	private Buttons[] scenes; 
	private Buttons[] reset; 
	
	public SceneSelect(Game g) {
		super(g);
		initButtons(); 
	}

	public void initButtons() { 
		int width = 200; 
		int height = 50; 
		int x = 100;
		int y = 100;
		int offSet = 100; 
		
		back = new Buttons("Back", 10, 10, 50, 50); 
		homeScene = new Buttons("0. Home", x, y + 0 *offSet, width, height); 
		outsideScene = new Buttons("1. Outside", x, y + 1 * offSet, width, height); 
		deathScene = new Buttons("2. Death Scene", x, y + 2 * offSet, width, height); 
		bossFightScene = new Buttons("3. Boss Fight", x, y + 3 * offSet, width, height); 
		
		scenes = new Buttons[]{homeScene, outsideScene, deathScene, bossFightScene}; 
		reset = new Buttons[scenes.length];
		for(int i = 0; i < reset.length; i++) { 
			reset[i] = new Buttons("Reset", x + width + 100, scenes[i].getY(), width, height);
		}
	}
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		drawButtons(g); 
	}

	public void drawButtons(Graphics g) { 
		g.setFont(Menu.thaleah);
		back.draw(g); 
		for(Buttons b : scenes) { 
			b.draw(g);
		}
		for(Buttons b : reset) { 
			b.draw(g);
		}
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
		for(int i = 0; i < reset.length; i++) { 
			if(reset[i].getBounds().contains(x, y)) { 
				game.getPlay().setDefault(i);
			}
		}
	}
	
	@Override
	public void mouseMoved(int x, int y) {
		// TODO Auto-generated method stub
		back.setMouseOver(false);
		homeScene.setMouseOver(false);
		outsideScene.setMouseOver(false);
		deathScene.setMouseOver(false);
		for(int i = 0; i < reset.length; i++) { 
			if(reset[i].getBounds().contains(x, y)) { 
				reset[i].setMouseOver(false);
			}
		}
		
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
		for(int i = 0; i < reset.length; i++) { 
			if(reset[i].getBounds().contains(x, y)) { 
				reset[i].setMouseOver(true);
			}
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
		for(int i = 0; i < reset.length; i++) { 
			if(reset[i].getBounds().contains(x, y)) { 
				reset[i].setMousePressed(true);
			}
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
		for(int i = 0; i < reset.length; i++) { 
			if(reset[i].getBounds().contains(x, y)) { 
				reset[i].resetBooleans();
			}
		}
	}

	@Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
