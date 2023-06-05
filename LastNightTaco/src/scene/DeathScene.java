package scene;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entity.BossEntity;
import entity.Entity;
import entity.God;
import entity.Player;
import game.Game;
import game.GamePanel;
import helpers.DataLoader;
import ui.DialogueBox;

public class DeathScene extends GameScene implements SceneMethods {
	private BufferedImage background; 
	private God god; 
	private DialogueBox dialogueBox; 
	
	private String[][] dialogue = 
		{ 
		{"You", "OMG Are you God! It's like I'm in heaven."},
		{"???", "Yes, that's because you are in heaven."},
		{"You", "Omg Jesus, but why am I in heaven?"},
		{"???", "I am not Jesus, I am Hesus, the second cousin of Jesus!"},
		{"You", "He sus? Anyways, why am I in heaven?"},
		{"Hesus", "You got hit by a truck because you didn't look at both sides of \nthe road before crossing."},
		{"You", "So what do I do now?"},
		{"Hesus", "If you win against yourself from an alternate universe, I'll give \nyou another chance in life. However, those that are sent to Jesus are usually better than the ones sent to me, which is you"},
		{"You", "Does that mean I'll die?"},
		{"Hesus", "You're already dead idiot. You're just going to die again, unless \nyou win against your \nalternate self."},
		{"You", "But how am I going to win?"},
		{"Hesus", "I don't know. You know yourself the best. Good Luck"}
		};
	
	public DeathScene(Game g) { 
		super(g);
		dialogueBox = new DialogueBox(); 
		dialogueBox.setConvos(dialogue);
		importBackground();
		importGod(); 
	}

	public void importGod() { 
		god = new God(); 
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(background, -250, -1000, null); 
		god.draw(g); 
		dialogueBox.draw(g);
	}
	
	private int tick = 0;
	public void update() {
		if(tick == 0) {
			setDefault();
			tick++; 
		}
		if(tick == 1) {
			if(god.findDistanceFromTarget(game.getPlayer()) < 400) {
				game.getPlayer().setActive(false);
				tick++;
			}
		}
		if(tick == 2) {
			dialogueBox.setVisibility(true);
			tick++;
		}
		if(tick >= 3) {
			dialogueBox.update(); 
			tick++;
		}
		if(dialogueBox.getConvoNum() > dialogue.length) {
			Playing.setScene(3);
		}
	}
	
	public void setDefault() { 
		Player p = game.getPlayer(); 
		p.setPlayerLocation((GamePanel.screenWidth - p.getSprites()[0][0].getWidth()) / 2, GamePanel.screenHeight - 200);
		game.getPlayer().setActive(true);

	}
	
	public void importBackground() { 
		background = DataLoader.getImage("heaven.png");
	}
	
	@Override
	public void mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		if(dialogueBox.getBounds().contains(x, y)) { 
			dialogueBox.quickUpdate(); 
		}
	}


	@Override
	public void mouseMoved(int x, int y) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(int x, int y) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(int x, int y) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
