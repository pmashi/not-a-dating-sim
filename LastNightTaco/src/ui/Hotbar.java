package ui;

import java.util.ArrayList;

import entity.Player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.GamePanel;
import helpers.DataLoader;
import objects.Item;

public class Hotbar {
	private Player player; 
	private BufferedImage slotIcon; 
	private Item[] hotbarItems = new Item[2];
	private ArrayList<Item> abilityList = new ArrayList<>(); 
	private int equipped;
	
	private int itemBarLength; 
	private int barGap = 40; 

	public Hotbar(Player player) {
		this.player = player; 
		importSlotIcon(); 
		itemBarLength = slotIcon.getWidth();
		System.out.println(itemBarLength);
	}
	
	public void draw(Graphics g) { 
//		int leftBound = GamePanel.screenWidth / 2 - (hotbarItems.length * itemBarLength / 2) * (hotbarItems.length / 2);
//		int leftBound = (GamePanel.screenWidth - hotbarItems.length * (itemBarLength - barGap) - barGap) / 2;
		int leftBound = GamePanel.screenWidth / 2 - (hotbarItems.length / 2) * itemBarLength - ((hotbarItems.length - 1) / 2) * barGap;
		if(hotbarItems.length % 2 == 1) {
			leftBound -= itemBarLength/2;
		} else leftBound -= barGap / 2; 
		
		for(int i = 0; i < hotbarItems.length; i ++) { 
			g.drawImage(slotIcon, leftBound + i * (itemBarLength + barGap), GamePanel.screenHeight - 100, null);
			//g.drawRect(leftBound + i * (itemBarLength + barGap), GamePanel.screenHeight - 100, itemBarLength, itemBarLength); 
		}
		
//		g.drawImage(slotIcon, GamePanel.screenWidth / 2 - itemBarLength/2, GamePanel.screenHeight - 150, null);
	}
	
	public void update() { 
		
	}

	public void updateEquipped() { 
		
	}
	
	private void importSlotIcon() { 
		slotIcon = DataLoader.getImage("hotbaricon.png");
	}
	
	public Item getItem(int i) { 
		return hotbarItems[i]; 
	}
}
