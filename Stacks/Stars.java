package Stacks;

import java.awt.*;
import java.util.Stack;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Stars extends JFrame{
	Stack<Dot> list = new Stack<Dot>();
	public Stars(){
		super ("Stars");
		setSize (600, 600);
		setVisible(true);
		getContentPane().setBackground(Color.black);
	}
	
	
	
	public void paint (Graphics g)
	{
		super.paint (g);
		for (int i =0; i<=15; i++)
		{
			Dot a = new Dot();
			list.push(a);
			g.setColor(a.getColor());
			g.fillOval(a.getX(), a.getY(),a.getWidth(), a.getWidth());
			try {
				Thread.currentThread();
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
		for (int i =0; i<=25; i++)
		{
			Dot a = list.pop();
			g.setColor(Color.BLACK);
			g.fillOval(a.getX(), a.getY(),a.getWidth(), a.getWidth());
			try {
				Thread.currentThread();
				Thread.sleep(300);
			} catch (InterruptedException e) {}
		}
		
	}
	
	public static void main(String[] args) {
		Stars app = new Stars();
		app.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	}
}
