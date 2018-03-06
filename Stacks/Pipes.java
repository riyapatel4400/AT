package Stacks;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Stack;

import javax.swing.JFrame;

public class Pipes extends JFrame {
	private Stack<Pipes> lin =new Stack<Pipes>();
	Line2D.Double one;
	public Pipes(){
		super("Pipes");
		setSize(600,600);
		setVisible(true);
	}
	
	public Pipes(int x, int y, int x2, int y2)
	{
		one = new Line2D.Double(x, y, x2, y2);
	
	}

	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		    g2.setStroke(new BasicStroke(10));
		Rectangle x = new Rectangle(0,0,600,600);
		g2.setPaint(Color.BLACK);
		g2.draw(x);
		g2.fill(x);
		
		int xPos = (int)(Math.random()*600+1);
		int y = (int)(Math.random()*500+1);
		for(int i=1; i<25;i++){
		
			try {
			      Thread.sleep(500);   
			  
			    } catch (InterruptedException e) {

			    }
			
			int xPos2 =  (int)(Math.random()*600+1);
			int y2 = (int)(Math.random()*500+1);
			Pipes idk = new Pipes(xPos,y,xPos2,y2);
			lin.push(idk);
			int r = (int)(Math.random()*255+1);
			int hg = (int)(Math.random()*255+1);
			int b = (int)(Math.random()*255+1);
			Color col = new Color(r,hg,b);
			g2.setPaint(col);
			g2.draw(idk.one);
			xPos = xPos2;
			y=y2;
			
		}
		
		
		while(!lin.isEmpty()){
			g2.setPaint(Color.black);
			
			g2.draw(lin.pop().one);
			try {
			      Thread.sleep(500);
			    } catch (InterruptedException e) {

			    }
		}
		
		
	}
	
	public static void main(String[] args){

		Pipes one = new Pipes();
		one.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}