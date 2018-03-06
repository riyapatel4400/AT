package Queue;

import java.util.ArrayList;

import Stacks.Patient;

public class LiverTransplantQueue implements PriorityQueue{

	ArrayList <Object> list = new ArrayList<Object>();



	public boolean isEmpty() {
		return list.isEmpty();
	}


	public void add(Object x) {
		list.add(x);
	}


	public Object poll() {
		int min = 0;
		int index = 0;
		for (int i = 0; i< list.size(); i++){
			if (((Patient) list.get(i)).getPriority() > min){
				index = i;
				min = ((Patient) list.get(i)).getPriority();			
			}
		}
		return list.remove(index);
	}


	public Object peek() {
		if (list.isEmpty())
			return null;
		return list.remove(0);
	}


	public int size() {
		return list.size();
	}

	public String toString(){
		String s="";
		for (int i = 0; i< list.size(); i++)
			s+= ((Patient) list.get(i)).getName() + ": " + ((Patient) list.get(i)).getPriority()+ ",  ";
		return s;
	}
	public static void main(String[] args)
	{
		LiverTransplantQueue pq= new LiverTransplantQueue();
		pq.add(new Patient("Smith", 3));
		pq.add(new Patient("Chen", 2));
		pq.add(new Patient("Jones", 3));
		pq.add(new Patient("Wong", 3));
		pq.add(new Patient("Gupta", 2));
		pq.add(new Patient("Garcia",1));
		pq.add(new Patient("Brown", 3));
		System.out.println("The list is");
		System.out.println(pq);  
		while(pq.size()>0)
		{
			System.out.print("The next patient for the liver transplant is ");
			System.out.println(pq.poll());
		}
	}
}

