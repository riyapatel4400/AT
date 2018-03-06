package Stacks;

public class Petal {

	int center;
	int a;
	int h;
	int width;
	
	public Petal(){
		center = 300; //the centerX and Y coordinates of our flower.
		width = 100;
	}
	public Petal(int c, int ab , int height, int w){
		center = c; //the centerX and Y coordinates of our flower.
		width = w;
		a = ab;
		h = height;
	}
	
	public int getCenter(){
		return center;
	}
	public int getA(){
		return a;
	}
	public int getH(){
		return h;
	}
	public int getWidth(){
		return width;
	}
}