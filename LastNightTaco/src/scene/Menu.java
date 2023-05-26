package scene;

import static game.GameState.*;

import java.awt.Graphics;

import game.Game;
import game.GamePanel; 
import game.GameState;
import ui.Buttons;

public class Menu extends GameScene implements SceneMethods {

	private Buttons play, settings, exit; 
	
	public Menu(Game g) {
		super(g);
		initButtons(); 
	}
	
	public void initButtons() { 
		int width = 300;
		int height = width / 5;
		int x = GamePanel.screenWidth / 2 - width / 2;
		int y = 300;
		int yOffset = 90;

		play = new Buttons("Play", x, y, width, height);
		settings = new Buttons("Settings", x, y + yOffset, width, height); 
		exit = new Buttons("Exit", x, y + 2 * yOffset, width, height);
	}

	public void drawButtons(Graphics g) { 
		play.draw(g);
		settings.draw(g);
		exit.draw(g);
	}
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		drawButtons(g); 
	}

	public void update() { 
		
	}
	@Override
	public void mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		if(play.getBounds().contains(x, y)) 
		{
			setState(PLAYING);
		} 
		else if (settings.getBounds().contains(x,y))
		{

		}
		else if (exit.getBounds().contains(x, y))
		{
			System.exit(0);
		}
	}

	@Override
	public void mouseMoved(int x, int y) {
		// TODO Auto-generated method stub
		play.setMouseOver(false);
		exit.setMouseOver(false);
		if(play.getBounds().contains(x, y)) {
			play.setMouseOver(true);
		}
		else if(settings.getBounds().contains(x, y)) { 
			settings.setMouseOver(true);
		}
		else if(exit.getBounds().contains(x, y)) { 
			exit.setMouseOver(true);
		}
	}

	@Override
	public void mousePressed(int x, int y) {
		// TODO Auto-generated method stub
		if (play.getBounds().contains(x, y)) {
			play.setMousePressed(true);
		} 
		else if(settings.getBounds().contains(x, y)) { 
			settings.setMousePressed(true);
		}
		else if (exit.getBounds().contains(x, y)) {
			exit.setMousePressed(true); 
		}
	}

	@Override
	public void mouseReleased(int x, int y) {
		// TODO Auto-generated method stub
		play.resetBooleans();
		exit.resetBooleans();
	}

	@Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
