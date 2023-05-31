package scene;

import java.awt.image.BufferedImage;

import game.Game;
import helpers.DataLoader;
import helpers.Utilities;
import objects.Vehicle;

public class OutsideScene extends Playing {
	public static int sceneNum = 1; 
	
	private Vehicle truck; 
	private Vehicle car;
	
	
	
	public OutsideScene(Game g) { 
		super(g);
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
}
