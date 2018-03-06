package LinkedList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListMethods {

	public static void main(String[] args) {
		LinkedList<String> bowl = new LinkedList<String>();
		LinkedList<String> bowl2 = new LinkedList<String>();
		bowl.addLast("apple");
		bowl.addLast("banana");
		bowl.addLast("cherry");
		bowl.addLast("lemon");
		bowl2.addLast("lime");
		bowl2.addLast("orange");
		bowl2.addLast("papaya");
		bowl2.addLast("strawberry");
		bowl2.addLast("watermelon");	
		display(append(bowl2, bowl));
		System.out.println();
		display(merge(bowl, bowl2));
	}

	public static LinkedList<String> append (LinkedList<String> a, LinkedList <String> b){
		LinkedList<String> c = new LinkedList<String>();
		for (String t : a)
			c.addLast(t);
		for (String y : b)
			c.addLast(y);
		return c;
	}

	public static LinkedList<String> merge (LinkedList<String> a, LinkedList <String> b){
		LinkedList<String> c = new LinkedList<String>();
		ListIterator<String> it = a.listIterator();
		ListIterator<String> it2 = b.listIterator();
		while (it.hasNext() && it2.hasNext()){
			c.addLast(it.next());
			c.addLast(it2.next());
		}
		while (it.hasNext())
			c.addLast(it.next());
		while (it2.hasNext())
			c.addLast(it2.next());

		return c;
	}

	public static void reverse (LinkedList<String> staff){
		ListIterator<String>  it = staff.listIterator();
		while (it.hasNext())
			it.next();
		while (it.hasPrevious())
			System.out.println (it.previous());
	}

	public static void delete (LinkedList<String> staff, String lookFor){
		ListIterator<String>  it = staff.listIterator();
		while (it.hasNext()){
			String current = (String) it.next();
			if (current.equals(lookFor)){
				it.previous();
				it.remove();
			}
		}
	}

	public static void repeat (LinkedList<String> staff){
		ListIterator<String>  it = staff.listIterator();
		while (it.hasNext()){
			System.out.println (it.next());
		}
	}

	public static void display(LinkedList<String> a){
		for (String t : a)
			System.out.println(t);
	}
}
