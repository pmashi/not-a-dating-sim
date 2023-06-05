package ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.GamePanel;
import helpers.DataLoader;
import scene.Menu;

public class DialogueBox {
	private String speaker, text, shownText; 
	
	private boolean visible;
	private BufferedImage box; 
	private int x; 
	private int y;
	
	private int convo; 
	private String[][] convos; 
	
	public DialogueBox() { 
		box = DataLoader.getImage("dialogue.png");
		x = (GamePanel.screenWidth - box.getWidth()) / 2; 
		y  = GamePanel.screenHeight - 250;
		convo = 0; 
	}
	
	public void draw(Graphics g) { 
		if(visible) {
			g.drawImage(box, x, y, null);
			g.setFont(Menu.thaleah);
			g.drawString(shownText, x + 50, y + 50);
		}
	}
	
	private int tick = 0; 
	
	public void update() {
		if(tick % 5 == 0) {
			updateShownText(); 
		}
	}
	
	public void updateText() {
		text = convos[convo][0] + "[" + convo + "]: " + convos[convo][1];
		shownText= convos[convo][0] + "[" + convo + "]: ";
	}
	
	public void updateShownText() { 
		if(!shownText.equals(text)) {
			int i = shownText.length();

			if(i != text.length()) {
				shownText += text.substring(i, i + 1);
			}
			
		}
	}
	
	public void quickUpdate() { 
		if(!shownText.equals(text)) { 
			shownText = text; 
		} else {
			if(convo + 1 < convos.length) {
				convo++;
				updateText();
			}
		}
	}
	
	public void setConvos(String[][] convos) {
		this.convos = convos;
		updateText(); 
	}

	
	public void setVisibility(boolean v) { 
		visible = v; 
	}
	
	public boolean getVisible() { 
		return visible;
	}
	
	public Rectangle getBounds() { 
		return new Rectangle(x, y, box.getWidth(), box.getHeight());
	}
	
	public int getConvoNum() {
		return convo; 
	}
}
