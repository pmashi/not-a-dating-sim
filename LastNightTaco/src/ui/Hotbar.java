package ui;

import java.util.ArrayList;

import entity.Player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.GamePanel; 
import objects.Item;

public class Hotbar {
	private Player player; 
	private Item[] hotbarItems = new Item[4];
	private ArrayList<Item> abilityList = new ArrayList<>(); 
	private int equipped;
	
	private int itemBarLength = 50; 
	private int barGap = 40; 

	public Hotbar(Player player) {
		this.player = player; 
	}
	
	public void draw(Graphics g) { 
		int leftBound = (0 + GamePanel.screenWidth) / 2 - (itemBarLength + barGap / hotbarItems.length);
		for(int i = 0; i < hotbarItems.length; i ++) { 
			g.drawRect(leftBound + i * (itemBarLength + barGap), GamePanel.screenHeight - 100, itemBarLength, itemBarLength); 
		}
	}
	
	public void drawHotbar() { 
		
	}
	
	public void update() { 
		
	}
	
	public void updateHotBar() { 
		
	}
	
	public void addItem(Item i) { 
		
	}

	public void swap(int item1, int item2) { 
		
	}
}
