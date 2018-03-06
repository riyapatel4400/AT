package Sorts;
import java.util.Random;


public class Sorts { 
	private int[] nos; 
	private int steps; 
	// Constructs a default array of size 10 
	public Sorts() { 
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

	public Sorts(int[] temp) { 
		nos = temp; 
	} 


	// Constructs an array with size random Sorts from [0,range) 


	public Sorts(int size, int range) { 
		nos = new int [size];
		for(int i = 0; i < nos.length; i++) {
			nos[i] = (int) (Math.random() * range);
		}
	} 


	// Constructs an array of random Sorts [0-range) array of size count with a 
	// seed 
	// The seed allows you to use the same set of random numbers 


	public Sorts(int count, int range, long seed) {


		nos = new int[count];
		for(int i = 0; i < nos.length; i++) {
			Random gen = new Random(seed);	
			nos[i] = gen.nextInt();
		}
	} 


	// This constructor will create an ordered array of consecutive integers 
	// true will yield ascending order 
	// false will yield descending order 


	public Sorts(int count, boolean ordered) { 
		nos = new int [count];

		if(ordered) {
			for(int i = 0; i < nos.length; i++) {
				nos[i] = i;
			}
		}
		else {
			for(int i = 0; i < nos.length; i++) {
				nos[i] = count - i;
			}
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

	public void insertionSort() {
		int i, j, newValue;
		for (i = 1; i < nos.length; i++) {
			newValue = nos[i];
			steps++;
			j = i;
			steps++;
			while (j > 0 && nos[j - 1] > newValue) {
				nos[j] = nos[j - 1];
				steps++;
				j--;
			}
			nos[j] = newValue;
			steps++;
		}
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

	public void selectionSort()
	{
		for (int i = 0; i < nos.length - 1; i++)
		{
			int index = i;
			steps++;
			for (int j = i + 1; j < nos.length; j++)
				if (nos[j] < nos[index]) {
					index = j;
					steps++;
				}
			int smallerNumber = nos[index];  
			nos[index] = nos[i];
			steps++;
			nos[i] = smallerNumber;
			steps++;
		}
	}

	public void quickSort(){
		quickSort(0, nos.length-1);
	}

	private void quickSort(int from, int to) {
		if (from >= to)
			return;
		int p = partition(from, to);
		quickSort(from, p);
		quickSort(p+1, to);
	}

	private int partition(int from, int to) {
		int pivot = nos[from];
		int i = from -1;
		int j = to+1;
		while (i<j){
			i++;
			while (nos[i] <pivot)
				i++;
			
			j--;
			while (nos[j] >pivot)
				j--;
			
			if (i<j)
				swap(i,j);
		}
		return j;
	}


public static void main(String[] args) { 
	Sorts one = new Sorts(3000, false); 
	StopWatch timer = new StopWatch(); 
	timer.start(); 
	one.quickSort(); 
	timer.stop(); 
	one.display(); 
	System.out.println("Default Array Steps:     " + one.getSteps()); 
	System.out.println("Default Array time: " + timer.getElapsedTime()+
			" milliseconds."); 
	//This is a sample code for testing bubble sort  for data in  reverse 
	//order 
	//				//Sorts two = new Sorts (100000,false); 
	//				// timer.reset(); 
	//				// timer.start(); 
	//				// two.bubbleSort(); 
	//				// timer.stop(); 
	//				// two.display(); 
	//				// System.out.println("Reverse order Steps: " + two.getSteps()); 
	//				// System.out.println("Reverse order time: " + timer.getElapsedTime()+ " 
	//				// milliseconds");
	// System.out.println(); 


}
}
