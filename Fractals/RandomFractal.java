package Fractals;
 import java.awt.BasicStroke;  
 import java.awt.Color;  
 import java.awt.Dimension;  
 import java.awt.Graphics2D;  
 import java.awt.RenderingHints;  
 import java.awt.image.BufferedImage;  
 import java.util.Random;  
   
 import javax.swing.ImageIcon;  
 import javax.swing.JFrame;  
 import javax.swing.JLabel;  
 import javax.swing.JScrollPane;  
 import javax.swing.SwingUtilities;  
   

 @SuppressWarnings("serial")
public class RandomFractal extends JLabel {  
   
      public static void main(String args[]) {  
   
           SwingUtilities.invokeLater(new Runnable() {  
   
                public void run() {
                     JFrame frame = new JFrame();  
                     frame.setMinimumSize(new Dimension(600, 800));  
                     frame.setContentPane(new JScrollPane(new RandomFractal()));  
                     frame.setVisible(true);  
                }  
           });  
      }  
   
      public RandomFractal() {  
   
           BufferedImage newFrameImg = new BufferedImage(600, 800,  
                     BufferedImage.TYPE_INT_ARGB);  
           this.setIcon(new ImageIcon(newFrameImg));  
   
           Graphics2D g2d = (Graphics2D) newFrameImg.getGraphics();  
           g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                     RenderingHints.VALUE_ANTIALIAS_ON);  
   
           g2d.setColor(Color.black);  
           g2d.fillRect(0, 0, 800, 800);  
           generateTree(g2d, 800/3, 800/3, 10, 200);  
           generateTree(g2d, 800/3, 800/3, 6, 60);  
   
      }  
   
      private static Color brightness(Color c, double s) {  
           int r = Math.min(255, (int) (c.getRed() * s));  
           int g = Math.min(255, (int) (c.getGreen() * s));  
           int b = Math.min(255, (int) (c.getBlue() * s));  
           return new Color(r, g, b);  
      }  
   
      private void generateTree(Graphics2D g2d, double x, double y,  
                double lineWidth, double lineLength) {  
   
           //multipliers for recursion. Must be between 0 and 1  
           //WARNING: the closer these are to 1 the longer the run time will be  
           final double linex = .80;  
           final double linelx = .85;  
   
           // base case - we need to stop somewhere  
           // or else we'll get a stack overflow  
           if (lineWidth <= 1 || lineLength <= 2) {  
                return;  
           }  
   
           Random rand = new Random();  
   
           // compute random number of lines to draw. Play with this.  
           int numOfLinesToDraw = 2 + rand.nextInt(2);  
   
           BasicStroke bs = new BasicStroke((float) lineWidth,  
                     BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);  
           g2d.setStroke(bs);  
           g2d.setColor(Color.gray);  
   
           // mess with the color  
           Color c = g2d.getColor();  
           // need a number from 0-1 to scale the color... I made this equation up  
           // it gives a cool shaded almost 3d effect. This should be played with  
           // to get better looking effects  
           c = brightness(  
                     c,  
                     Math.abs(Math.cos(x * x + y * y + lineWidth * lineWidth  
                               + lineLength * lineLength)));  
           g2d.setColor(c);  
   
           // draw lines  
           for (int i = 0; i < numOfLinesToDraw; i++) {  
                // first calculate random positive vector  
                double x1 = rand.nextDouble() - .5;  
                double y1 = rand.nextDouble() - .5;  
   
                // divide by magnitude so we get a unit vector  
                double mag = Math.sqrt(x1 * x1 + y1 * y1);  
                x1 = x1 / mag;  
                y1 = y1 / mag;  
   
                // scale by lineLength  
                x1 = x1 * lineLength;  
                y1 = y1 * lineLength;  
   
                // move to center  
                x1 = x1 + x;  
                y1 = y1 + y;  
   
                // now (x1,y1) represents point on circle with radius lineLength and  
                // centered around (x,y)  
                g2d.drawLine((int) x, (int) y, (int) x1, (int) y1);  
   
                // now recurse  
                generateTree(g2d, x1, y1, lineWidth * linex,  
                          		lineLength * linelx);  
   
           }  
   
      }  
   
 }  
   