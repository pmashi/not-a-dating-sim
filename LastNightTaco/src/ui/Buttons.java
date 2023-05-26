package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Buttons {
	private String text; 
	private Rectangle bounds; 
	private int x, y, width, height; 
	private int id; 
	boolean isHover, isPressed; 
	
	public Buttons(String text, int x, int y, int width, int height, int id) 
	{
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
		
		initBounds();
	}
	
	public Buttons(String text, int x, int y, int width, int height) 
	{
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = -1;
		
		initBounds();
	}
	
	public void initBounds() 
	{
		this.bounds = new Rectangle(x, y, width, height);
	}

	public void draw(Graphics g) 
	{
		drawBody(g);
		drawBorder(g);
		drawText(g);
	}

	public void drawBorder(Graphics g) 
	{
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
		
		if (isPressed) 
		{
			g.drawRect(x + 1, y + 1, width - 2, height - 2);
			g.drawRect(x + 2, y + 2, width - 4, height - 4);
		}
	}
	
	public void drawBody(Graphics g) 
	{
		if (isHover)
		{
			g.setColor(Color.DARK_GRAY);
		}
		else 
		{
			g.setColor(Color.white);
			g.fillRect(x, y, width, height);	
		}
	}

	public void drawText(Graphics g) 
	{
		int w = g.getFontMetrics().stringWidth(text);
		int h = g.getFontMetrics().getHeight();
		g.drawString(text, x - w / 2 + width / 2, y + h / 2 - 3 + height / 2);
	}
	
	public void resetBooleans() 
	{
		this.isHover = false;
		this.isPressed = false;
	}
	
	public void setText(String text)
	{
		this.text = text;
	}
	
	public void setMousePressed(boolean mousePressed) 
	{
		this.isPressed = mousePressed;
	}

	public void setMouseOver(boolean mouseOver) 
	{
		this.isHover = mouseOver;
	}
	
	public boolean isMouseOver()
	{
		return isHover;
	}
	
	public boolean isMousePressed()
	{
		return isPressed;
	}

	public Rectangle getBounds() 
	{
		return bounds;
	}
	
	public int getID()
	{
		return id;
	}
}
