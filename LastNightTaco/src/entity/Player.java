package entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import game.Game;
import inputs.MyKeyListener;
import objects.Item;

public class Player extends Entity {
	private Game game; 
	private MyKeyListener keyInput;
	protected Item[] inventory = new Item[5];
	private boolean active; 
	

	 
	
	
	public Player(Game g, MyKeyListener key) { 
		game = g; 
		keyInput = key;
	}
	
	public void update() { 
		
	}
	
	public void draw(Graphics g) { 
		super.draw(g);
	}
	
	public boolean getActive() { 
		return active; 
	}
	
	public void setActive(boolean b) { 
		active = b; 
	}
}
