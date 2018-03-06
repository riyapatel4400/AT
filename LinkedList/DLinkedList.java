package LinkedList;

import java.util.NoSuchElementException;

public class DLinkedList {

	private DListNode firstNode; 

	private DListNode lastNode; 

	/** 

	 * Construct an empty list 

	 */ 

	public DLinkedList() { 
		firstNode = null; 
		lastNode = null; 
	} 

	public void setFirst(DListNode node) {
		firstNode = node;
	}

	public DListNode getLast() {
		return lastNode;
	}

	public void setLast(DListNode node) {
		lastNode = node;
	}


	/** 

	 * Returns true if the list contains no elements 

	 */ 

	public boolean isEmpty() {
		return (firstNode == null && lastNode == null);
	}

	/** 

	 * Inserts the argument as the first element of this list. 

	 */ 

	public void addFirst(Object o) { 
		if(isEmpty()) {
			firstNode = new DListNode(o, null, null);
			lastNode = firstNode; 
		}
		else {
			DListNode current = firstNode;
			firstNode = new DListNode(o, firstNode, null);
			current.setPrevious(firstNode);
		}
		
	}

	/**  

	 * Inserts the argument as the last element of this list. 

	 */ 

	public void addLast(Object o) {
		if(isEmpty()) {
			firstNode = new DListNode(o, null, null);
			lastNode = firstNode; 
		}
		else {
			DListNode current = lastNode;
			lastNode = new DListNode(o, null, lastNode);
			current.setNext(lastNode);
		}

	}

	/** 

	 * Removes and returns the first element of this list. 

	 */ 

	public Object removeFirst() {
		if(isEmpty()) 
			throw new NoSuchElementException("Can't remove from an empty list");

		DListNode temp = firstNode;
		//DListNode tempNext = firstNode.getNext();
		
		firstNode = firstNode.getNext();
		firstNode.setPrevious(null);
		
		return temp.getValue();
	}

	/** 

	 * Removes and returns the last element of this list. 

	 */ 

	public Object removeLast() {
		if(isEmpty()) 
			throw new NoSuchElementException("Can't remove from an empty list");

		DListNode current = firstNode;
		DListNode follow = null;

		while(current != null) { //at least two nodes
			follow = current;
			current = current.getNext();
			//System.out.println("follow: " +  follow + " current: " + current);
		}
		current = follow;
		follow= follow.getPrevious();
		
		if(follow == null) 
			firstNode = null;
		else  {
			follow.setNext(null);
			lastNode = follow;
		}
			

		return current.getValue();
	}

	/** 
	 * Returns a String representation of the list. 
	 */ 

	public String toString() {
		if(isEmpty()) {
			return "[]";
		}
		String s = "[";
		DListNode current = firstNode;

		while(current != null) {
			s += current.getValue() + ",  ";
			current = current.getNext();
		}	
		return s.substring(0, s.length() - 3) + "]";
	}

	private boolean remove(Object o) {
		DListNode current = firstNode;
		DListNode follow = null;
		DListNode after = null;
		DListNode temp = null;

		if(isEmpty()) 
			throw new NoSuchElementException("Can't remove from an empty list");


		else if(getFirst().getValue().equals(o)) {
			firstNode = firstNode.getNext();
			return true;
		}
		
		else {

			while(current.getNext() != null) {
				follow = current;
				current = current.getNext();

				if(current.getValue().equals(o)) {
					follow.setNext(current.getNext());
					//current.getNext().setPrevious(follow);
					current.setNext(current.getPrevious());
					return true;
				}

			}
		}

		return false;
	}


	/** 
	 * Returns the number of elements in the list as an int. 
	 */

	public int size() { 
		int count = 1;

		DListNode temp = firstNode;
		if(isEmpty()) 
			return 0;

		else if(temp.getNext() == null) {
			return 1;
		}


		else {
			while(temp.getNext() != null) {
				count++;
				temp = temp.getNext();
			}
		}

		return count;
	}

	/** 
	 * Removes all of the elements from this list. 
	 */ 

	private void clear() { 
			firstNode = null;
	}
	
	public DListNode getFirst() {
		return firstNode;
	}
	
	/** 
	 * Returns a DListIterator. 
	 */

	public DListIterator iterator() { 

		return new DListIterator(this);

	}

	public static void main(String[] args) {

		DLinkedList bowl = new DLinkedList();
		bowl.addLast("three");
		bowl.addLast("four");
		bowl.addLast("five");
		bowl.addLast("six");
		bowl.addFirst("two");
		bowl.addLast("seven");
		bowl.addLast("eight");
		bowl.addLast("nine");
		bowl.addLast("ten");
		bowl.addFirst("one");
		System.out.println("Testing addFirst(),addLast() methods");
		System.out.println(bowl);
		System.out.println();
		System.out.println("Testing removeFirst() and removeLast() methods");
		bowl.removeFirst();
		System.out.println("first after remove"+ bowl.getFirst());
		
		
		bowl.removeLast();
		System.out.println(bowl);
		System.out.println();
		System.out.println("Testing MyLinkedList Iterator");
		System.out.println("Testing hasNext() next()");
		DListIterator iter1 = new DListIterator(bowl);
		System.out.println("bowl first" + bowl.getFirst());

		while(iter1.hasNext()) {
			System.out.println(" "+ iter1.next());
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("Testing hasPrevious() previous()");
		
		while (iter1.hasPrevious())
			System.out.print(" " + iter1.previous());
	
		System.out.println();
		System.out.println();
		
		System.out.println("Testing set()");
		DListIterator iter2 = new DListIterator(bowl);
		iter2.next();
		iter2.next();
		iter2.set("3");
		System.out.println("FORWARD");
		 iter1 = new DListIterator(bowl);
		while (iter1.hasNext())
			System.out.print(iter1.next() + " ");
		System.out.println();
//		System.out.println();
//		System.out.println("BACKWORD");
//		while (iter1.hasPrevious())
//			System.out.print(iter1.previous() + " ");
//		System.out.println();
//		System.out.println("Testing add()");
//		DListIterator iter3 = (DListIterator) bowl.iterator();
//		iter3.next();
//		iter3.next();
//		iter3.next();
//		iter3.add("5");
//		System.out.println("FORWARD");
//		 iter1 = (DListIterator) bowl.iterator();
//		while (iter1.hasNext())
//			System.out.print(iter1.next() + " ");
//		System.out.println();
//		System.out.println();
//		System.out.println("BACKWORD");
//		while (iter1.hasPrevious())
//			System.out.print(iter1.previous() + " ");
//		System.out.println();
//		
//		System.out.println("Testing remove()");
//		DListIterator iter4 = (DListIterator) bowl.iterator();
//		iter4.next();
//		iter4.next();
//		iter4.next();
//		iter4.next();
//		iter4.next();
//		iter4.remove();
//		System.out.println("FORWARD");
//		 iter1 = (DListIterator) bowl.iterator();
//		while (iter1.hasNext())
//			System.out.print(iter1.next() + " ");
//		System.out.println();
//		System.out.println();
//		System.out.println("BACKWORD");
//		while (iter1.hasPrevious())
//			System.out.print(iter1.previous() + " ");
//		System.out.println();
		
	}

}
