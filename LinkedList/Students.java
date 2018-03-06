package LinkedList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Students {
	public static void main (String [] args){
		LinkedList<String> roster = new LinkedList<String>();
		roster.addLast("Riya");
		roster.addLast("Dan");
		roster.addFirst("Ajay");
		roster.addFirst("Ziwei");
		roster.addLast("Tejas");

		System.out.println(roster);
		System.out.println(roster.add("Divya"));
		System.out.println(roster);
		roster.addLast("Bhasit");
		roster.addFirst("Alex");
		System.out.println(roster);

		System.out.println(roster.remove());
		System.out.println(roster.removeFirst());
		System.out.println(roster.removeLast());
		System.out.println(roster);

		ListIterator<String> iter = roster.listIterator();
		iter.add("Koushik");
		System.out.println(roster);
		iter.add("Amali");
		System.out.println(roster);
		System.out.println(iter.next());
		iter.add("Michael");
		System.out.println(roster);
		iter.next();
		iter.remove();
		System.out.println(roster);
		
		ListIterator<String> iter2 = roster.listIterator();
		System.out.println("TESTING REMOVE");
		iter2.next();
		iter2.next();
		iter2.previous();
		iter2.next();
		iter2.remove();
		iter2.next();
		iter2.set("Bryan");
		System.out.println(roster);
	}
}
