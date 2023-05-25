package game;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import entity.Player;
import inputs.*;

public class GamePanel extends JPanel {
	private Game game;
	private MyMouseListener mouseListener;
	private MyKeyListener keyListener;
	
	private Player player; 
	
	public static final int screenWidth = 16 * 90;
	public static final int screenHeight = 16 * 60; 
	private Dimension size = new Dimension(screenWidth, screenHeight);
	
	public GamePanel(Game game) 
	{ 
		this.game = game;
		//setPanelSize();
	}
	
	public void setPanelSize()
	{
		setMinimumSize(size);
		setMaximumSize(size);
		setPreferredSize(size);
	}
	
	public void initInputs() { 
		mouseListener = new MyMouseListener(game);
		keyListener = new MyKeyListener(game);
	}
	
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		game.getRender().render(); 
	}
}
