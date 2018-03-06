
package Stacks;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Flower extends JFrame {

	int r = 5;
	int g = 5;
	int b = 5;
	int count =0;

	private static Stack <Petal> flower = new Stack<Petal>();


	public Flower(){
		super ("Flower");

		setSize (600, 600);

		setVisible(true);

	}

	public void paint(Graphics g){
		final int centerX = 300; //the centerX and Y coordinates of our flower.
		final int centerY = 300;
		final int ovalWidth = 100; //the width of the oval. A petal is an oval.
		int h = 300;
		//			Graphics2D g2 = (Graphics2D) g;
		for (int x = 0; x<5; x++){
			h-=50;
			for (int i = 0; i<24; i++){
				g.setColor(randColor());
				int a = centerY - ovalWidth / 2;
				flower.push(new Petal(centerX, a, h, ovalWidth));
				g.fillOval(centerX, a, h, ovalWidth); 
				try {
					Thread.currentThread();
					Thread.sleep(50);
				} catch (InterruptedException e) {}
				//rotate the coordinate system by 15 degrees, around the centerX/Y.
				((Graphics2D) g).rotate(Math.toRadians(15),centerX,centerY);
			}
		}
					while (!flower.isEmpty()){
						Petal a = flower.pop();
						g.setColor(Color.BLACK);
						g.fillOval(a.getCenter(), a.getA(), a.getH(), a.getWidth()); 
						try {
							Thread.currentThread();
							Thread.sleep(50);
						} catch (InterruptedException e) {}
						((Graphics2D) g).rotate(Math.toRadians(345),centerX,centerY);
					}
	}

	private Color randColor() {
		count++;
		if (count %7 ==0){
			r = 5;
			g = 5;
			b = 5;
		}
		if (r<255){
			r += 30;
			g += 2;
			b += 5;
		}
//		
		return new Color (r, g, b);
	}
	// You do NOT need to change anything in main(). Leave it as is.
	public static void main(String[] args) {
		Flower a = new Flower();
		a.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		System.out.println("Size of Stack :"+flower.size());
	}
}

