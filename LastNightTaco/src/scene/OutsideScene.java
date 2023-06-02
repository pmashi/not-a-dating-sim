package scene;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Game;
import helpers.DataLoader;
import helpers.Utilities;
import objects.Vehicle;

public class OutsideScene extends GameScene implements SceneMethods {
	public static int sceneNum = 1; 
	
	private Vehicle truck; 
	private Vehicle car;
	
	
	
	public OutsideScene(Game g) { 
		super(g);
		initClasses();
		importImages(); 
	}
	
	public void render() { 
		
	}
	
	public void update() { 
		
	}
	
	private void initClasses() { 
		truck = new Vehicle(); 
		car = new Vehicle(); 
	}
	
	private void importImages() { 
		truck.setSprite(Utilities.getRotatedImage(DataLoader.getImage("truckkun.png"), 90)); 
		car.setSprite(Utilities.getRotatedImage(DataLoader.getImage("car.png"), 90));
	}
	
	private void setTruckLocation() { 
		truck.setLocation(100, 100);
	}
	
	private void setCarLocation() { 
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
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
