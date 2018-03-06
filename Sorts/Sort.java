package Sorts;
import java.util.Random;

public class Sort { 

	private int[] nos; 
	private int steps; 

	// Constructs a default array of size 10 
	public Sort() { 
		nos = new int[10]; 
		nos[0] = -10001; 
		nos[1] = 3; 
		nos[2] = 7; 
		nos[3] = 19; 
		nos[4] = 15; 
		nos[5] = 19; 
		nos[6] = 7; 
		nos[7] = 3; 
		nos[8] = 19; 
		nos[9] = -100;

	} 

	public Sort(int[] temp) { 
		nos = temp; 

	} 

	// Constructs an array with size random Sorts from [0,range) 
	public Sort(int size, int range) { 
		nos = new int[size]; 
		for (int i = 0; i<nos.length; i++)
			nos[i]=(int)(Math.random() *range);
	} 

	// Constructs an array of random Sorts [0-range) array of size count with a 
	// seed 
	// The seed allows you to use the same set of random numbers 
	public Sort(int count, int range, long seed) { 
		nos = new int[count]; 
		Random s =  new Random(seed);
		for (int i = 0; i<nos.length;i++)
			nos[i]=s.nextInt();
	} 

	// This constructor will create an ordered array of consecutive integers 
	// true will yield ascending order 
	// false will yield descending order 

	public Sort(int count, boolean ordered) { 
		nos = new int[count];
		if (ordered){
			for (int i =0; i<nos.length; i++)
				nos[i]=i+1;
		}
		else{
			for (int i =0; i<nos.length; i++)
				nos[nos.length-1-i]=i+1;
		}
	} 

	public int getSteps() { 
		return steps; 
	} 

	public void display() { 
		for (int x : nos) 
			System.out.print(x + " "); 
		System.out.println(); 

	} 

	public int[] getNos() { 
		return nos; 

	} 

	public void swap(int x, int y) { 
		int temp = nos[x]; 
		nos[x] = nos[y]; 
		nos[y] = temp; 
		steps += 3; 
	} 

	public void bubbleSort() { 
		//Consecutive values are compared and swapped if necessary 
		steps = 0; 
		boolean swapped = true; 
		steps++; 
		int lastSwap = nos.length - 1; 
		steps++; 
		int temp = 0; 
		steps++; 
		steps++; // initialize for loop 

		for (int i = 0; i < nos.length; i++) { 
			steps += 3; // boundary check, increment,if 
			if (swapped) { 
				swapped = false; 
				steps++; 
				steps++; // initialize for loop 
				for (int j = 0; j < lastSwap; j++) { 
					steps += 3; // boundary check, increment,if 
					if (nos[j] > nos[j + 1]) { 
						swap(j, j + 1); 
						swapped = true; 
						steps++; 
						temp = j; 
						steps++; 
					} 
				} 
				lastSwap = temp; 
				steps++; 
			} 
		} 
	} 

	public static void main(String[] args) { 
		Sort one = new Sort(); 
		StopWatch timer = new StopWatch(); 
		timer.start(); 
		one.bubbleSort(); 
		timer.stop(); 
		one.display();
		System.out.println("Default Array Steps:     " + one.getSteps()); 
		System.out.println("Default Array time: " + timer.getElapsedTime()+ 
				" milliseconds.");
//		This is a sample code for testing bubble sort  for data in  reverse 
//		order  BUBBLE SORT WITH (400,800,1200,1600,2000,2400)
		Sort two = new Sort (400,400, 10); 
		 timer.reset();
		 timer.start();
		 two.bubbleSort(); 
		 timer.stop(); 
		 two.display();
		 System.out.println("Reverse order Steps: " + two.getSteps()); 
		 System.out.println("Reverse order time: " + timer.getElapsedTime()+ 
		 " milliseconds"); 
		 System.out.println(); 

	}
}