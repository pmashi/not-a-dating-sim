package scene;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entity.BossEntity;
import entity.Player;
import game.Game;
import game.GamePanel;
import helpers.DataLoader;

public class BossFightScene extends GameScene implements SceneMethods {
	private BufferedImage background; 
	private BossEntity you;  
	
	public BossFightScene(Game g) {
		super(g);
		importBackground(); 
		you = new BossEntity(game, 300); 
		game.getPlayer().setActive(true);
		game.getPlayer().setShowHotbar(true);
		game.getPlayer().setShowHpBar(true);
		game.getPlayer().setShowLocator(true);

	}
	
	public void render(Graphics g) { 
		g.drawImage(background, -2250, -1250, null);
		you.draw(g);
	}
	
	public void update() { 
		you.update(); 
		if(you.getHp() < 0) { 
			game.getPlayer().setActive(false); 
		}
		else if(game.getPlayer().getHp() < 0) { 
			game.getPlayer().setActive(false); 
		}
	}
	
	
	public void setDefault() { 
		Player p = game.getPlayer();
		p.setActive(true);
		p.setShowHotbar(true);
		p.setShowLocator(true);
		p.setPlayerLocation((GamePanel.screenWidth - 72) / 2, GamePanel.screenHeight - 200);;

	}
	
	
	public BossEntity getBoss() {
		return you; 
	}
	
	public void importBackground() { 
		background = DataLoader.getImage("arena.png");
	}
	@Override
	public void mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		
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
