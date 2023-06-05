package scene;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entity.BossEntity;
import entity.Entity;
import game.Game;
import helpers.DataLoader;

public class DeathScene extends GameScene implements SceneMethods {
	private BufferedImage background; 
	private Entity god; 
	
	private String[][] dialogue = 
		{ 
		{"You", ""},
		{},
		
		};
	
	public DeathScene(Game g) { 
		super(g);
	}



	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(background, 0, 0, null); 
	}

	public void update() {
		
	}
	
	public void setDefault() { 
		
	}
	
	public void importBackground() { 
		background = DataLoader.getImage("haven.webp");
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
