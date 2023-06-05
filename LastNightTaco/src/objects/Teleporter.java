package objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import entity.Player;

public class Teleporter {
	public Rectangle bounds; 
	public int destination; 
	public int x, y; 
	
	public Teleporter() { 
		
	}
	
	public void draw(Graphics g) { 
		
	}
	
	public boolean isNear(Player p) { 
		if(Math.sqrt(Math.pow((x - p.getWorldX()), 2) + Math.pow(y - p.getWorldY(), 2)) < 25) { 
			return true; 
		}
			
		return false; 
	}
}
