package scene;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.*;

import entity.Player;
import game.Game;
import game.GamePanel;
import helpers.DataLoader;
import helpers.Utilities;
import managers.TileManager;
import objects.Tile;
import objects.Vehicle;

public class OutsideScene extends GameScene implements SceneMethods {
	public static final int sceneNum = 1; 
	
	private AudioInputStream audioInputStream;
	private Clip peacefulMusic; 
	private Playing play; 
	private TileManager tileManager; 
	

	
	private int[][] map = 
		{
		{0, 0, 5, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 1, 0, 0, 0, 0},
		{0, 1, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0},
		{0, 1, 0, 0, 6, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 5, 0, 0, 0, 3, 6, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0},
		}; 
	private Vehicle truck; 
	private Vehicle car;
	
	
	public OutsideScene(Game g) { 
		super(g);
		play = game.getPlay(); 
		tileManager = game.getTileManager(); 
		tileManager.createTiles2(); 
		initClasses();
//		importSounds(); 
		importImages(); 
		setDefault(); 
	}
	
	public void render(Graphics g) { 
		drawMap(g);
		car.draw(g, (int)(car.getSprite().getWidth() * 0.75), (int) (car.getSprite().getHeight()*0.75));
		truck.draw(g, (int)(truck.getSprite().getWidth() * 2.5), (int)(truck.getSprite().getHeight() * 2.5));
	}
	
	private int sceneTick = 0; 
	
	public void update() { 
		sceneTick++;
//		try {
//			peacefulMusic.open(audioInputStream);
//		} catch (LineUnavailableException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		peacefulMusic.start();
		if(sceneTick % 60 == 0)
			System.out.println(sceneTick);
		truck.setLocation(truck.getX() - 20, truck.getY());
		if(sceneTick == 240) 
			game.getPlayer().setUpPress(true); 
		if(sceneTick > 240 && sceneTick < 340) 
			game.getPlayer().setPlayerLocation(game.getPlayer().getWorldX(), game.getPlayer().getWorldY() - 5);
		if(sceneTick == 340) {
			
		}
		if(sceneTick > 340 && sceneTick < 500) 
			game.getPlayer().setPlayerLocation(game.getPlayer().getWorldX() - 40, game.getPlayer().getWorldY() - 2);
		if(sceneTick == 540) {
			game.getPlayer().setUpPress(false); 
			Playing.setScene(2);
		}
	}
	
	public void setDefault() { 
		setTruckLocation(); 
		setCarLocation(); 
		sceneTick = 0; 
		game.getPlayer().setPlayerLocation(GamePanel.screenWidth/2 - 40, GamePanel.screenHeight - 100);
		game.getPlayer().setDirection("up");
	}
	
	
	
	private void initClasses() { 
		truck = new Vehicle(); 
		car = new Vehicle(); 
	}
	
	private void importSounds() { 
		try {
			File file = new File("Calm-and-Peaceful.wav");
			audioInputStream = AudioSystem.getAudioInputStream(file);
			peacefulMusic = AudioSystem.getClip();

		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private void importImages() { 
		truck.setSprite(DataLoader.getImage("truckkun.png")); 
		car.setSprite(DataLoader.getImage("car.png"));
	}
	
	private void setTruckLocation() { 
		truck.setLocation(GamePanel.screenWidth + 20 * 60 * 5, 250);
	}
	
	private void setCarLocation() { 
		car.setLocation((GamePanel.screenWidth - car.getSprite().getWidth()) / 2, 125);
	}

	public void drawMap(Graphics g) {
		ArrayList<Tile> tiles = TileManager.getScene2Tiles(); 
		for(int c = 0; c < map[0].length; c++) { 
			for(int r = 0; r < map.length; r++) { 
				
				BufferedImage tile = tiles.get(map[r][c]).getSprite(); 
				
				int width = 64; 
				int height = 64; 
				if(map[r][c] == 7) { 
					width = 128; 
					height = 64;
				}
				g.drawImage(tile, c * tile.getWidth() - width + 64, r * tile.getHeight(), width, 64, null);
			}
		}
		BufferedImage road = DataLoader.getImage("road.png");
		for(int i = 0; i < 5; i++) { 
			g.drawImage(road, i * road.getWidth(), 100, null);
		}
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
