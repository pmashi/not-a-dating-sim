package managers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import game.Game;
import helpers.DataLoader;
import objects.Tile;

public class TileManager {
	private Game game; 
	private static ArrayList<Tile> scene1 = new ArrayList<>(); 
	private static ArrayList<Tile> scene2 = new ArrayList<>(); 
	
	public TileManager(Game g) { 
		game = g; 
		createTiles2(); 
	}
	
	public void setScene1Collision() { 
		
	}
	
	public void createTiles2() { 
		int id = 0; 
		boolean f = false; 
		scene2.add(new Tile(getSprite2(0, 0), id++, f));
		scene2.add(new Tile(getSprite2(0, 1), id++, f));
		scene2.add(new Tile(getSprite2(0, 2), id++, f));
		scene2.add(new Tile(getSprite2(0, 3), id++, f));
		scene2.add(new Tile(getSprite2(0, 4), id++, f));
		scene2.add(new Tile(getSprite2(0, 5), id++, f));
		scene2.add(new Tile(getSprite2(0, 6), id++, f));
		scene2.add(new Tile(getSprite2(0, 7), id++, f));
		scene2.add(new Tile(getSprite2(0, 8), id++, f));
		scene2.add(new Tile(getSprite2(0, 9), id++, f));
		scene2.add(new Tile(getSprite2(1, 0), id++, f));
		scene2.add(new Tile(getSprite2(1, 1), id++, f));
		scene2.add(new Tile(getSprite2(1, 2), id++, f));
		scene2.add(new Tile(DataLoader.getImage("road.png"), id++, f));
	}
	
	
	public BufferedImage getSprite2(int x, int y) { 
		BufferedImage spriteSheet = DataLoader.getImage("yard.png"); 
		return spriteSheet.getSubimage(y * 64, x * 64, 64, 64);
	}
	
	public static ArrayList<Tile> getScene2Tiles() { 
		return scene2; 
	}
	
}
