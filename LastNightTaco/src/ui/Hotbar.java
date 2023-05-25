package ui;

import java.util.ArrayList; 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.GamePanel; 
import objects.Item;

public class Hotbar {

	ArrayList<Item> inventory = new ArrayList<>(); 
	public static int itemBarLength = 30; 

	public void render(Graphics g) { 
		int leftBound = 0 + GamePanel.screenWidth - (inventory.size() / 2) * itemBarLength;
		for(int i = leftBound; i < leftBound + itemBarLength * (inventory.size() + 30); i += itemBarLength + 30) { 
			g.drawRect(leftBound, 100, itemBarLength, itemBarLength); 
		}
	}

	public void addItem(Item i) { 
		inventory.add(i);
	}

	public void swap(int item1, int item2) { 
		
	}
}
