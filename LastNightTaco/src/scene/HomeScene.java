package scene;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Game;
import game.GamePanel;
import helpers.DataLoader;
import objects.Tile;

public class HomeScene extends GameScene implements SceneMethods {

	private BufferedImage background; 
	private Tile[] outOfBounds; 
	
	public HomeScene(Game g) {
		super(g);
		importBackground(); 
	}
	

	
	public void importSprites() { 
		
	}

	public void importBackground() { 
		background = DataLoader.getImage("homescene.png");
	}
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(background, (GamePanel.screenWidth - background.getWidth()) / 2, (GamePanel.screenHeight - background.getHeight()) / 2, null); 
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
