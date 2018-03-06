package Stacks;

import java.util.Iterator;
import java.util.Stack;

import javax.print.DocFlavor.STRING;


public class CDStack {
	Stack<String> myStack;

	public CDStack(){
		myStack = new Stack<String>();
		myStack.push("Surfers Paradise");
		myStack.push("Chill Bill");
		myStack.push("X");
		myStack.push("Eterno Augusto");
		myStack.push("LONG.LIVE.A$AP");
		myStack.push("Four Pink Walls");
		myStack.push("AM");
		myStack.push("The Belle Brigade");
		myStack.push("Unorthodox Jukebox");
		myStack.push("Overtime EP");
		myStack.push("Coloring Book");
	}

	public String nextCD(){
		return myStack.peek();
	}

	public String playNextCD(){
		//prints top to bottom
		return myStack.pop();
	}

	public void printCDs(){
		//prints bottom to top
		while (!myStack.empty())
			System.out.print(myStack.pop()+" ");
	}

	public void printCDs2(){
		//prints bottom to top
		Iterator<String> i = myStack.iterator();
		while (i.hasNext())
			System.out.print(i.next()+" ");
	}

	public void printCDs3(){
		//prints bottom to top
		for (String x: myStack)
			System.out.print(x+" ");
	}

	public int find (String name){
		return myStack.search(name);
	}

	public static Stack<String> reverse (Stack<String> x){
		Stack<String> t = new Stack <String>();
		Stack<String> y = x;
		while (!y.empty())
			t.push(y.pop());
		return t;
	}

	public static Stack<String> combine (Stack<String> x, Stack<String> y){
		Stack<String> temp = reverse(y);
		while (!temp.empty())
			x.push(temp.pop());
		return x;
	}

	public static Stack<String> alternate (Stack<String> x, Stack<String> y){
		Stack<String> temp = new Stack<String>();

		while (!x.empty() || !y.empty()){
			if (!x.empty())
				temp.push(x.pop());

			if (!y.empty())
				temp.push(y.pop());
		}
		return reverse(temp);
	}

	public static double getAverage (Stack<Integer> x){
		if (x.empty())
			return 0;
		else{
			int count = 0;
			double sum = 0;
			for (int i: x){
				sum += i;
				count++;
			}
			return sum/count;
		}
	}

	public static Stack<String> removeEO (Stack<String> x){
		Stack<String> temp = new Stack<String>();
		String s = "";
		while (!x.empty()){
			x.pop();
			if (!x.empty()){
				temp.push(x.pop());
			}
		}
		Stack<String> t = new Stack<String>();
		while (!temp.isEmpty())
			t.push(temp.pop());
		return t;
	}

	public static String convertBinary (int n){
		Stack<String> temp = new Stack<String>();
		while (n > 0){
			temp.push(n%2+"");
			n/=2;
		}
		String s ="";
		while (!temp.isEmpty())
			s+=temp.pop();
		return s;
	}

	
	public static void main (String [] args){
		//		CDStack tc = new CDStack();
		//		//tc.printCDs();
		//		//System.out.println();
		//		//tc.printCDs2();
		//		//System.out.println();
		//		tc.printCDs3();
		//		System.out.println();
		//		//toString goes from bottom to top
		//		System.out.println(tc.myStack);
		//
		Stack<String> t = new Stack <String>();
		//		t.add("A");
		//		t.add("B");
		//		t.add("C");
		Stack<String> d = new Stack <String>();
		//		d.add("D");
		//		d.add("E");
		//		d.add("F");
		//
		//		System.out.println("Original: " +  t);
		//		System.out.println("Reverse: " + reverse(t));
		//		t.add("A");
		//		t.add("B");
		//		t.add("C");
		//		System.out.println("Combine: " + combine(t,d));
		//		t = new Stack <String>();
		//		t.add("A");
		//		t.add("B");
		//		t.add("C");
		//		d.add("D");
		//		d.add("E");
		//		d.add("F");
		//		d.add("G");
		//		d.add("H");
		//		System.out.println("Original: " +  t);
		//		System.out.println("Original: " +  d);
		//		System.out.println("Alternate" + alternate(t,d));
		//
		//		Stack<Integer> a = new Stack <Integer>();
		//		a.push(5);
		//		a.push(2);
		//		a.push(15);
		//		a.push(3);
		//		System.out.println("Average: " + getAverage(a));
		//
		//		d.add("D");
		//		d.add("E");
		//		d.add("F");
		//		d.add("G");
		//		d.add("H");
		//		System.out.println("Original: " +  d);
		//		System.out.println("Remove EO: " + removeEO(d));
		System.out.println("Convert to Binary (47): " + convertBinary(47));
		System.out.println("Convert to Binary (120): " + convertBinary(120));
	}
}
