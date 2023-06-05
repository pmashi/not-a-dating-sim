package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ValueBar {
	
	private String stat, text; 
	private Rectangle frame; 
	
	private int value, maxValue;
	private Color body, backBody; 
	
	public ValueBar(String stat, int max, Color back, Color front) { 
		this.stat = stat; 
		this.value = max; 
		this.maxValue = max; 
		body = front; 
		backBody = back; 
	}
	
	public ValueBar(String stat, Rectangle frame, int maxValue, Color backBody, Color body) {
		this.stat = stat; 
		this.frame = frame; 
		this.value = maxValue; 
		this.maxValue = maxValue; 
		this.backBody = backBody; 
		this.body = body; 
	}
	
	

	public void updateText() { 
		text = stat + ": " + value + "/" + maxValue; 
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
		g.drawRect(frame.x, frame.y, frame.width, frame.height);
	}
	
	public void drawBody(Graphics g) 
	{
		g.setColor(backBody);
		g.fillRect(frame.x,  frame.y,  frame.width,  frame.height);
		g.setColor(body);
		g.fillRect(frame.x,  frame.y, (int) (frame.width * value / maxValue), frame.height);
	}

	public void drawText(Graphics g) 
	{
		int w = g.getFontMetrics().stringWidth(text);
		int h = g.getFontMetrics().getHeight();
		g.drawString(text, frame.x - w / 2 + frame.width / 2, frame.y + h / 2 - 3 + frame.height / 2);
	}
	
	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Color getBody() {
		return body;
	}

	public void setBody(Color body) {
		this.body = body;
	}

	public Color getBackBody() {
		return backBody;
	}

	public void setBackBody(Color backBody) {
		this.backBody = backBody;
	}
}
