package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import objects.Item;

public class Entity {
	
	private BufferedImage[][] sprite; 
	private Item[] inventory = new Item[5];
	private Item equpped; 
	private int hp, block, mana;
	private int xPos, yPos; 
	private int direction; 
	
	public void draw(Graphics g) { 
		g.setColor(Color.BLACK);
		g.drawRect(xPos, yPos, 32, 32);
	}
	
}
