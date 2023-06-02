package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.GamePanel;
import helpers.DataLoader;

public class DialogueBox {
	private String speaker, text, shownText; 
	
	private boolean visible;
	private BufferedImage box; 
	private int x; 
	private int y = GamePanel.screenHeight - 250;
	
	public DialogueBox() { 
		box = DataLoader.getImage("dialogue.png");
		x = (GamePanel.screenWidth - box.getWidth()) / 2; 
	}
	
	public void draw(Graphics g) { 
		if(visible) {
			g.drawImage(box, x, y, null);
		}
	}
	
	private int tick; 
	
	public void update() {
		
	}
	
	public void setDialogue(String[] dialogueDetails) {
		if(dialogueDetails.length == 2) {
			speaker = dialogueDetails[0];
			text = dialogueDetails[1];
		}
	}
	
	public void setText(String str) { 
		text = str; 
	}
	
	public String getText() {
		return text; 
	}
	
	public void setVisibility(boolean v) { 
		visible = v; 
	}
	
	public boolean getVisible() { 
		return visible;
	}
}
