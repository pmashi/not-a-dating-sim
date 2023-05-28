package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Game;
import objects.Item;

public class Entity {
	private BufferedImage[][] sprite; 
	protected Item equpped; 
	protected int hp, block, mana;
	protected int x, y; 
	protected int direction; 
	
	public void draw(Graphics g) { 
		g.setColor(Color.BLACK);
		g.drawRect(x, y, 32, 32);
	}
	
}
