package LinkedList;

import java.util.NoSuchElementException;

public class DListIterator  {
	private DListNode current; 
	private DListNode previous; 
	private DLinkedList myList; 
	private boolean canRemove; // for remove() method. true if OK to call 

	// remove() 
	public DListIterator(DLinkedList list) { 
		myList = list; 
		current = list.getFirst(); 
		previous = null; 
		canRemove = false;
	} 

	public String toString() {
		return ("prev" + previous + "curr " + current);
	}

	public boolean hasNext() {
		if(myList.isEmpty()) 
			return false;
		else if(current.getNext() == null) {
			return false;
		}
		else if(current != null && current.getNext() != null) {

			return true;	
		}
		else {
			return false;
		}
	}
	
	public boolean hasPrevious() {
		if(myList.isEmpty()) 
			return false;
		else if(current.getPrevious() == null) {
			return false;
		}
		else if(current != null && current.getPrevious() != null) {
			return true;	
		}
		else {
			return false;
		}
	}
	
	public Object next() {

		if(myList.isEmpty()) 
			throw new NoSuchElementException("List is empty");
		if(current == null)
			throw new NoSuchElementException("No more elements in this list");
		if(current.getNext() == null) {
			throw new NoSuchElementException("No more elements in this list");
		}	
		else {
			previous = current;
			current = current.getNext();
			canRemove = true;
			return current.getValue();
		}
	}

	public Object previous() {
		if(myList.isEmpty()) 
			throw new NoSuchElementException("List is empty");
		if(current == null)
			current = myList.getFirst();
		else if(current.getNext() == null) {
			current = previous;
			canRemove = true;
			return current.getNext().getValue();
		}

		else {
			current = previous;
			previous = previous.getPrevious();
			if(current == null) 
				throw new NoSuchElementException("No more elements in this list");			
		}
		canRemove = true;
		return current.getValue();
	}

	public void remove() {
		if(!canRemove) 
			throw new NoSuchElementException("List is empty");

		else {
			previous.setNext(current.getNext());
		}
	}

	public void add(Object element) { //first
		canRemove = false;
		if(current == null) {
			myList.addFirst(element);
			current = myList.getFirst();
		}

		else if (current.getNext() == null) { //last
			DListNode newNode = new DListNode (element, null, current);
			current.setNext(newNode);
		}

		else { //any other case
			DListNode newNode = new DListNode(element, current.getNext(), current); 
			current.getNext().setPrevious(newNode);
			current.setNext(newNode);
			previous = current;
			current = newNode;
		}
	}

	public void set(Object element) {
		if (myList.isEmpty()) {
			myList.addFirst(element);
		}

		else if(current == null) {
			myList.addLast(element);
		}

		else {
			current.setValue(element);
		}
	}

}
