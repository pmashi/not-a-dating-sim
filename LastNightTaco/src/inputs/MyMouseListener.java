package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import game.Game;
import game.GameState;

public class MyMouseListener implements MouseListener, MouseMotionListener {
	
	private Game game; 
	public MyMouseListener(Game g) { 
		game = g; 
	}
	
	public void mouseDragged(MouseEvent e) 
	{	
		switch(GameState.STATE)
		{
		case MENU:
			game.getMenu().mouseDragged(e.getX(), e.getY());
			break;
		case SCENE_SELECT: 
			game.getSceneSelect().mouseDragged(e.getX(), e.getY());
		case PLAYING:
			game.getPlay().mouseDragged(e.getX(), e.getY());
			break;
		default:
		case DEATH: 
			game.getDeath().mouseDragged(e.getX(), e.getY());
			break;
			
		}
	}

	public void mouseMoved(MouseEvent e) 
	{		
		switch(GameState.STATE)
		{
		case MENU:
			game.getMenu().mouseMoved(e.getX(), e.getY());
			break;
		case SCENE_SELECT: 
			game.getSceneSelect().mouseMoved(e.getX(), e.getY());
			break; 
		case PLAYING:
			game.getPlay().mouseMoved(e.getX(), e.getY());
			break;
		default:
		case DEATH:
			game.getDeath().mouseMoved((e.getX()), e.getY());
			break;
		}
	}

	public void mouseClicked(MouseEvent e) 
	{	
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			switch(GameState.STATE)
			{
			case MENU:
				game.getMenu().mouseClicked(e.getX(), e.getY());
				break;
			case SCENE_SELECT: 
				game.getSceneSelect().mouseClicked(e.getX(), e.getY());
				break; 
			case PLAYING:
				game.getPlay().mouseClicked(e.getX(), e.getY());
				break;
			default:
			case DEATH:
				game.getDeath().mouseClicked((e.getX()), e.getY());
				break;
			}
		}
	}

	public void mousePressed(MouseEvent e) 
	{	
		switch(GameState.STATE)
		{
		case MENU:
			game.getMenu().mousePressed(e.getX(), e.getY());
			break;
		case SCENE_SELECT: 
			game.getSceneSelect().mousePressed(e.getX(), e.getY());
			break; 
		case PLAYING:
			game.getPlay().mousePressed(e.getX(), e.getY());
			break;
		default:
		case DEATH:
			game.getDeath().mousePressed((e.getX()), e.getY());
			break;
		}
	}

	public void mouseReleased(MouseEvent e) 
	{
		switch(GameState.STATE)
		{
		case MENU:
			game.getMenu().mouseReleased(e.getX(), e.getY());
			break;
		case SCENE_SELECT: 
			game.getSceneSelect().mouseReleased(e.getX(), e.getY());
			break; 
		case PLAYING:
			game.getPlay().mouseReleased(e.getX(), e.getY());
			break;
		default:
		case DEATH:
			game.getDeath().mouseReleased((e.getX()), e.getY());
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
