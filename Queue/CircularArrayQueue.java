package Queue;

import Stacks.Patient;

public class CircularArrayQueue implements MyQueue{

	private int head;
	private int tail;
	private int size;
	private int capacity;
	private Object [] elements;

	public CircularArrayQueue(int c){
		capacity = c;
		elements = new Object[capacity];
		size = 0;
		head = 0;
		tail = 0;
	}

	public boolean empty() {
		return size == 0;
	}


	private void doubleCapacity(){
		Object[] larger = (new Object[capacity*2]);   
		int count = 0;
		for (int i = head; i<elements.length; i++){
			larger[count]= elements[i];
			count++;
		}

		for (int i = 0; i<=tail; i++){
			larger[count] = elements[i];
			count++;
		}
		
		head = 0; 
		tail=elements.length-1;
		elements = larger;
		
//		Object[] temp = (Object[]) new Object[capacity*2];
//        for (int i = 0; i < size; i++) {
//            temp[i] = elements[(head + i) % elements.length];
//        }
//        elements = temp;
//        head = 0;
//        tail  = tail+1;
	}

	public boolean offer(Object item) {
		if (size==0)
			elements[0] = item;
		else if (size == elements.length) {
			doubleCapacity();
			elements[tail+1] = item;
			
		}
		else if (tail == elements.length-1){
			tail = 0;
			elements[tail] = item;
		}
		else{
			tail = (tail+1);
			elements[tail] = item;
		}
		size++;
		return true;

	}
	public Object poll() {
		if (empty())
			return null;
		Object result = elements[head];
		elements[head] = null;
		head = (head+1) % elements.length;
		size--;
		return result;
	}

	public Object peek() {
		return elements[head];
	}

	public String toString(){
		String s = "";
		int count = 0;

		while(count < elements.length)
		{
			if (elements[count] == null)
				s+="null"+"\t";
			else
				s += elements[count].toString()+"\t";
			count++;
		}
		return s;
	}

	public static void main(String[] args){
		CircularArrayQueue a = new CircularArrayQueue(10);
		a.offer(1);
		a.offer(2);
		a.offer(3);
		a.offer(4);
		a.offer(5);
		a.offer(6);
		a.offer(7);
		a.offer(8);
		a.offer(9);
		System.out.println(a);
		System.out.println("NEXT: " +a.poll());
		System.out.println("NEXT: "+a.poll());
		System.out.println("NEXT: "+a.poll());
		System.out.println(a);
		a.offer(10);
		System.out.println(a);
		a.offer(11);
		System.out.println(a);
		a.offer(12);
		System.out.println(a);
		System.out.println("NEXT: "+a.poll());
		System.out.println(a);
		a.offer(13);
		System.out.println(a);
		a.offer(14);
		System.out.println(a);
		a.offer(15);
		System.out.println(a);
		System.out.println("NEXT: "+a.poll());
		System.out.println(a);
	}
}


