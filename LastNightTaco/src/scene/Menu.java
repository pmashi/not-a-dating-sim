package scene;

import static game.GameState.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import game.Game;
import game.GamePanel; 
import game.GameState;
import helpers.DataLoader;
import ui.Buttons;

public class Menu extends GameScene implements SceneMethods {
	private BufferedImage background; 
	private Buttons play, sceneSelect, settings, exit; 
	public static final Font thaleahMassive = new Font("ThaleahFat", Font.PLAIN, 96);
	public static final Font thaleah = new Font("ThaleahFat", Font.PLAIN, 24);
	public static final Font thaleahSmall = new Font("ThaleahFat", Font.PLAIN, 14);
	public static final Font thaleahMedium = new Font("ThaleahFat", Font.PLAIN, 18);
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

	
	public Menu(Game g) {
		super(g);
		importFont(); 
		background = DataLoader.getImage("background.png");
		initButtons(); 
	}
	
	public void initButtons() { 
		int width = 96 * 3;
		int height = 32 * 3;
		int x = GamePanel.screenWidth / 2 - width / 2;
		int y = 300;
		int yOffset = 100;

		play = new Buttons("Play", x, y, width, height);
		sceneSelect = new Buttons("Scene Select", x, y + yOffset, width, height);
		settings = new Buttons("Settings", x, y + 2 * yOffset, width, height); 
		exit = new Buttons("Exit", x, y + 3 * yOffset, width, height);
	}

	public void render(Graphics g) {
		game.getGamePanel().setBackground(Color.WHITE);
		g.drawImage(background, 0, 0, GamePanel.screenWidth, GamePanel.screenHeight, null);
		drawLogo(g);
		drawButtons(g); 
		
	}
	
	public void drawButtons(Graphics g) { 
		play.draw(g);
		sceneSelect.draw(g);
		settings.draw(g);
		exit.draw(g);
	}

	public void drawLogo(Graphics g) { 
		g.setFont(Menu.thaleah);
		g.drawString("Not a Dating simulator", 0, 0);
	}
	
	public void importFont() 
	{ 
		try 
		{
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./res/ThaleahFat.ttf")));
		} 
		catch (FontFormatException | IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		if(play.getBounds().contains(x, y)) 
		{
			setState(PLAYING);
		} 
		else if(sceneSelect.getBounds().contains(x, y)) { 
			setState(SCENE_SELECT);
		}
		else if (settings.getBounds().contains(x,y)) {

		}
		else if (exit.getBounds().contains(x, y)) {
			System.exit(0);
		}
	}

	@Override
	public void mouseMoved(int x, int y) {
		// TODO Auto-generated method stub
		play.setMouseOver(false);
		sceneSelect.setMouseOver(false);
		settings.setMouseOver(false);
		exit.setMouseOver(false);
		
		if(play.getBounds().contains(x, y)) {
			play.setMouseOver(true);
		}
		else if(sceneSelect.getBounds().contains(x, y)) { 
			sceneSelect.setMouseOver(true);
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
		else if(sceneSelect.getBounds().contains(x, y)) { 
			sceneSelect.setMousePressed(true);
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
		sceneSelect.resetBooleans();
		settings.resetBooleans();
		exit.resetBooleans();
	}

	@Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
