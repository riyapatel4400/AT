package Stacks;

import java.awt.Color;

public class Dot {

	private int width;
	private int x;
	private int y;
	private Color c;
	
	public Dot (){
		width = (int) (Math.random()*60 +1);
		x = (int) (Math.random()*600 +1);
		y = (int) (Math.random()*600 +1);
		c = randColor();
	}
	public Color randColor(){
		int r = (int) (Math.random()*255 +1);
		int g = (int) (Math.random()*255 +1);
		int b = (int) (Math.random()*255 +1);
		
		return new Color (r, g, b);
	}
	
	public void setWidth(int w){
		width = w;
	}
	public void setX(int xPos){
		x = xPos;
	}
	public void setY(int yPos){
		y = yPos;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public Color getColor(){
		return c;
	}
}
