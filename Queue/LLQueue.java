package Queue;

import java.util.LinkedList;

public class LLQueue implements MyQueue{

	LinkedList<Object> list = new LinkedList<Object>();
	public boolean empty() {
		return list.isEmpty();
	}

	public boolean offer(Object item) {
		list.addFirst(item);
		return true;
	}

	public Object poll() {
		if (list.isEmpty())
			return null;
		else{
			return list.removeFirst();
		}

	}

	public Object peek() {
		if (list.isEmpty())
			return null;
		else return list.getFirst();
	}

	public void append (Object q){
		while (!((LLQueue) q).empty()){
			this.list.offer(((LLQueue) q).poll());
		}
	}
	
	public int size(){
		return list.size();
	}

	public LLQueue alternate (LLQueue q, LLQueue p){
		LLQueue a = new LLQueue();
		int min = 0;
		boolean x = false;
		if (q.size() > p.size()){
			x = true;
			min = p.size();
		}
		else min = q.size();
		while (min>0){
			a.offer(q.poll());
			min--;
		}
		if (x){
			while (q.size()>0)
				a.offer(q.poll());
		}
		else{
			while (q.size()>0)
				a.offer(q.poll());
		}
		return a;
	}

	public void reverse(){
		LLQueue a = new LLQueue();
		while (list.size()>0)
			a.offer(this.list.poll());

	}
	public String toString(){
		String s = "";

		while (!list.isEmpty())
			s=list.poll() +" " + s;
		s= "[" +s+"]";
		return s;
	}

	public static void main (String [] args){
		LLQueue tc = new LLQueue();
		System.out.println(tc.offer("quarter"));
		System.out.println(tc.offer("dime"));
		System.out.println(tc.offer("nickel"));
		System.out.println( "peek() " + tc.peek());
		System.out.println(tc.offer("penny"));
		System.out.println( "toString() " + tc);
		LLQueue tc2 = new LLQueue();
		System.out.println(tc2.offer("quarter"));
		System.out.println(tc2.offer("dime"));
		System.out.println(tc2.offer("nickel"));
		System.out.println("toString() " + tc2);
		tc.append(tc2);
		System.out.println("toString() " + tc);
	}

}
