package scene;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Game;
import game.GamePanel;
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
		reset(); 
	}
	
	public void render(Graphics g) { 
		car.draw(g);
		truck.draw(g);
	}
	
	private int tick = 0; 
	
	public void update() { 
		
	}
	
	public void reset() { 
		setTruckLocation(); 
		setCarLocation(); 
	}
	
	private void initClasses() { 
		truck = new Vehicle(); 
		car = new Vehicle(); 
	}
	
	private void importImages() { 
		truck.setSprite(DataLoader.getImage("truckkun.png")); 
		car.setSprite(DataLoader.getImage("car.png"));
	}
	
	private void setTruckLocation() { 
		truck.setLocation(500, 500);
	}
	
	private void setCarLocation() { 
		car.setLocation((GamePanel.screenWidth - car.getSprite().getWidth()) / 2, 200);
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
