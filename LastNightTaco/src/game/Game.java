//weapons: 
//1. sword
//- attack 
//- dash attack 
//- block 
//- perfect block 
//
//2. wand (magic) 
//- explosion 
//- water
//- 
package game;

import javax.swing.JFrame;

import entity.Player;
import helpers.CollisionChecker;
import managers.TileManager;
import scene.*;

import java.awt.Color;
import java.util.ArrayList; 
import java.util.Arrays;

public class Game extends JFrame implements Runnable {

	public static final int unit = 48;
	
	private static int FPS = 120; 
	private static int UPS = 60; 
	
	private Thread gameThread; 
	
	private GamePanel gamePanel; 
	private Render render; 
	
	private Player player; 
	
	private TileManager tileManager; 
	private CollisionChecker collisionChecker; 
	
	private Menu menu; 
	private SceneSelect sceneSelect; 
	private Playing play; 
	private Death death; 
	
	public Game() { 
		initClasses();
		gamePanel.initInputs();
		
		this.setTitle("Not a Dating Sim");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(gamePanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);		
	}

	public void initClasses() { 
		gamePanel = new GamePanel(this); 
		render = new Render(this);
		
		player = new Player(this, gamePanel.getKeyListener());
		
		menu = new Menu(this); 
		play = new Playing(this);
		death = new Death(this);
		sceneSelect = new SceneSelect(this);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for(int i = 0; i < 18; i++) { 
//			for(int k = 0; k < 30; k++) { 
//				System.out.print("0 "); 
//			}
//			System.out.println();
//		}
		Game game = new Game(); 
		game.startThread(); 

	}
	
	public void startThread() { 
		gameThread = new Thread(this);
		gameThread.run(); 
	}
	
	public void run() 
	{
		long lastFrame = System.nanoTime();
		long lastUpdate = System.nanoTime();
		long lastTimeCheck = System.currentTimeMillis();
		long current;
		double timePerFrame = 1000000000.0 / FPS;
		double timePerUpdate = 1000000000.0 / UPS;
		int frames = 0;
		int updates = 0;
		
		while (true)
		{
			current = System.nanoTime(); 
			if (current - lastFrame >= timePerFrame)
			{
				repaint();
				lastFrame = current;
				frames++;
			}
			if (current - lastUpdate >= timePerUpdate)
			{
				updateGame();
				lastUpdate = current;
				updates++;
			}
			if (System.currentTimeMillis() - lastTimeCheck >= 1000)
			{
				//System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;
				lastTimeCheck = System.currentTimeMillis();
			}
		}
	}
	
	public void updateGame() { 
		switch (GameState.state)
		{
		case MENU:
			break;
		case PLAYING:
			play.update();
			break;
		default:
			break;
		}
	}
	
	
	public GamePanel getGamePanel() {
		return gamePanel;
	}
	
	public Render getRender() { 
		return render; 
	}
	
	public Player getPlayer() {
		return player; 
	}
	public Menu getMenu() {
		return menu;
	}

	public SceneSelect getSceneSelect() {
		return sceneSelect;
	}
	
	public Playing getPlay() {
		return play;
	}
	
	public Death getDeath() { 
		return death; 
	}

	
	private static int collatzSteps(int n) { 
		if(n == 1) return 0; 
		if(n%2 == 0) return 1 + collatzSteps(n/2); 
		else return 1 + collatzSteps(3 * n + 1); 
	}
	
	private static int sumArr(int[] ints, int n) { 
		if(n <= 0) return ints[n]; 
		return sumArr(ints, n - 1) + ints[n - 1]; 
	}
	
	private static int traverseArrList(int n, ArrayList<Integer> ints) { 
		if(n >= ints.size()) {
			return ints.get(ints.size() - 1); 
		}
		int i = traverseArrList(n + 1, ints);
		if(ints.get(n) < i) { 
			return ints.get(n); 
		} else return i; 
	}
	
	private static void req() {
		// TODO Auto-generated method stub
		System.out.println(collatzSteps(10)); 
		int[] i = {3, 5, 6, 7, 2, 2, 4};
		System.out.println(sumArr(i, 0));
		ArrayList<Integer> ins = new ArrayList<>(Arrays.asList(4, 5, 6, 1, 3, 5, 8, 4, 2));
		System.out.println(traverseArrList(3, ins)); 
	}

}
