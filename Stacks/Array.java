package Stacks;

import java.util.Stack;

public class Array implements MyStack{

	private Object[] data;

	public Array(){
		data = new Object[0];
	}
	public Object push(Object item) {
		Object[] temp = new Object[data.length+1];
		for (int i = 0; i<data.length; i++)
			temp[i+1]=data[i];
		temp[0] = item;
		data = temp;
		return data[0];
	}


	public Object pop() {
		Object[] temp = new Object[data.length-1];
		Object o = data[0];
		for (int i = 1; i<data.length; i++)
			temp[i-1]=data[i];
		data = temp;
		return o;
	}

	public Object peek() {
		return data[0];
	}

	public boolean isEmpty() {
		return data.length==0;
	}

	public int size() {
		return data.length;
	}

	public int search(Object a) {

		for (int i = 0; i<data.length; i++)
			if (data[i].equals(a))
				return i+1;
		return -1;
	}

	public String toString(){
		String s = "[";
		for (int i = data.length-1; i>0; i--)
			s+=data[i] + ", ";
		s+= data[0];
		s += "]";
		return s;
	}

	static void arrayListStack()
	{
	Array tc = new Array();
	System.out.println(tc.push("quarter"));
	System.out.println(tc.push("dime"));
	System.out.println(tc.push("nickel"));
	System.out.println(tc.push("penny"));
	System.out.println( "toString() " + tc);
	System.out.println( "peek() " + tc.peek());
	System.out.println( "search for dime " + tc.search("dime"));
	System.out.println( "search for euro " + tc.search("euro"));
	System.out.println( "Size " + tc.size());
	System.out.println("pop() and isEmpty()");
	while (!tc.isEmpty())
	System.out.println(tc.pop());
	}
	
	public static void main (String [] args){
		arrayListStack();
		System.out.println();
		System.out.println("NOW WE USE STACKS");
		Stack<String> c = new Stack<String>();
		System.out.println(c.push("quarter"));
		System.out.println(c.push("dime"));
		System.out.println(c.push("nickel"));
		System.out.println(c.push("penny"));
		System.out.println( "toString() " + c);
		System.out.println( "peek() " + c.peek());
		System.out.println( "search for dime " + c.search("dime"));
		System.out.println( "search for euro " + c.search("euro"));
		System.out.println( "Size " + c.size());
		System.out.println("pop() and isEmpty()");
		while (!c.isEmpty())
		System.out.println(c.pop());
//		


	}

}
