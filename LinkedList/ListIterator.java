package LinkedList;

import java.util.NoSuchElementException;

public class ListIterator implements Iterator{

	private ListNode current;
	private ListNode previous;
	private LinkedList myList;
	private boolean canRemove;

	public ListIterator(LinkedList list){
		myList = list;
		current = null;
		previous = null;
		canRemove = false;
	}

	public String toString(){
		return ("prev " + previous + " curr " + current);
	}


	public Object next() {
		if (myList.isEmpty())
			throw new NoSuchElementException ("Can't remove from an empty List");
		if (current == null)
			current = myList.getFirst();
		else{
			previous = current;
			current = current.getNext();
		}
		if (current == null)
			throw new NoSuchElementException ("Can't remove from an empty List");
		canRemove = true;
		return current.getValue();
	}


	public boolean hasNext() {
		if (myList.isEmpty())
			return false;
		else if (current == null)
			return true;
		else 
			return current.getNext() != null;
	}


	public void add(Object element) {
		canRemove = false;
		if (current == null)
		{
			myList.addFirst(element);
			current = myList.getFirst();
		}

		else if (current.getNext() == null){
			ListNode newNode = new ListNode (element, null);
			current.setNext(newNode);
		} 
		else {
			ListNode newNode = new ListNode (element, current.getNext());
			current.setNext(newNode);
			previous = current;
			current = newNode;
		}
	}

	public void remove() {


	}

	public void set(Object element) {
		if (!canRemove){
			ListNode newNode = new ListNode (element, null);
			myList.add(newNode);
		}
		else if (current == null){
			ListNode newNode = new ListNode (element, current.getNext());
			previous.setNext(newNode);
		}	
	}

	public static void main (String [] args){
		LinkedList bowl = new LinkedList();
		bowl.addLast("apple");
		bowl.addLast("banana");
		bowl.addLast("cranberry");
		bowl.addLast("date");
		bowl.addLast("emblic");
		ListIterator it1 = bowl.iterator();
		while (it1.hasNext())
			System.out.print (it1.next() + " ");
		ListIterator it2 = new ListIterator(bowl);
		System.out.println();
		//it2.add("aardvark");
		it2.add("acai");
		it2.next();
		it2.next();
		it2.remove();
		it2.add("cantalogue");

	}
}
