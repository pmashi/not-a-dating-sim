package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import inputs.MyKeyListener;
import objects.Item;

public class Player extends Entity {
	private MyKeyListener keyInput;
	private boolean active; 

	 
	
	
	public Player(MyKeyListener k) { 
		keyInput = k; 
	}
	
	public void draw(Graphics2D g) { 
		
	}
	
	public boolean getActive() { 
		return active; 
	}
	
	public void setActive(boolean b) { 
		active = b; 
	}
}
