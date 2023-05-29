package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.Game;
import game.GameState;

import static game.GameState.*;

public class MyKeyListener implements KeyListener{
	
	private Game game; 
	public MyKeyListener(Game g) {
		game = g; 
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if(GameState.state == PLAYING) {
			game.getPlay().keyPressed(e);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(GameState.state == PLAYING) {
			game.getPlay().keyReleased(e); 
		}
	}

}
