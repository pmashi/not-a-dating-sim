package entity;

import java.awt.image.BufferedImage;

import objects.Item;

public class Entity {
	public enum ID { 
		PLAYER, NPC, ALLY, ENEMY; 
		
		private ID() { 
			
		}
		
		public void setID(ID id) { 
			
		}
	}
	
	private BufferedImage Sprite; 
	private Item[] inventory = new Item[5];
	private Item equpped; 
	private int hp, block, mana;
	private String direction; 
	
	
}
