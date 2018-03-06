package LinkedList;
import java.util.NoSuchElementException;

public class LinkedList implements MyList
{
	private ListNode firstNode;

	public LinkedList(){
		firstNode=null;
	}

	public ListNode getFirst(){
		return firstNode;
	}

	public boolean add(Object o) {
		return false;
	}

	public void addLast(Object o) {
		if (isEmpty())
			firstNode = new ListNode (o, null);
		else{
			ListNode current = firstNode;
			while (current.getNext() != null)
				current = current.getNext();
			current.setNext(new ListNode (o, null));
		}
	}

	public void addFirst(Object o) {
		firstNode = new ListNode (o, firstNode);
	}

	public void clear() {
		firstNode = null;
	}

	public boolean isEmpty(){
		return (firstNode==null);
	}

	public Object getLast(){
		if (isEmpty())
			return firstNode.getValue();
		else{
			ListNode current = firstNode;
			while (current.getNext() != null)
				current = current.getNext();
			return current;
		}
	}

	public Object removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException ("Can't remove from an empty List");
		ListNode temp = firstNode;
		firstNode = firstNode.getNext();
		return temp.getValue();
	}

	public Object removeLast() {
		if (isEmpty())
			throw new NoSuchElementException ("Can't remove from an empty List");
		ListNode current = firstNode;
		ListNode follow = null;
		while  (current .getNext() != null){
			follow = current;
			current = current.getNext();
		}
		if (follow == null)
			firstNode = null;
		else
			follow.setNext(null);
		return current.getValue();
	}
	public void append(LinkedList other){
		((ListNode) getLast()).setNext(other.getFirst());

	}

	public int size() {
		if(isEmpty())
			return 0;
		else{
			int count = 0;
			ListNode temp = firstNode;
			while(temp.getNext() != null)
			{
				temp = temp.getNext();
				count++;
			}
			return count;
		}
	}

	public String toString(){
		if (isEmpty())
			return "[]";
		String s = "[";
		ListNode current = firstNode;
		while (current !=null){
			s+=current.getValue() + ", ";
			current = current.getNext();
		}
		return s.substring(0, s.length()-2) + "]";
	}

	//	public void display(){
	//		for(ListNode n:theList)
	//			System.out.println(n.print();
	//	}

	public void reverse(){
		LinkedList temp = new LinkedList();
		while (size()>0)
			temp.addFirst(removeFirst());
		firstNode = temp.getFirst();
	}

	public boolean remove(Object o){
		if (isEmpty())
			throw new NoSuchElementException ("Can't remove from an empty List");
		else if (getFirst().getValue().equals(o)){
			firstNode = firstNode.getNext();
			return true;
		}
		else {
			ListNode current = firstNode;
			ListNode follow = null;
			while (current.getNext() != null){
				follow = current;
				current = current.getNext();
				if (current.getValue().equals(o)){
					follow.setNext(current.getNext());
					return true;
				}
			}
			if (follow.getValue().equals(o)){
				follow.setValue(null);
				return true;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		LinkedList bowl = new LinkedList(); 
		bowl.addLast("two");
		bowl.addLast("three");
		bowl.addLast("four");
		bowl.addLast("five");
		bowl.addLast("six");
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
		bowl.removeLast(); 
		System.out.println(bowl); 
		System.out.println(); 
		System.out.println("Testing remove(object)"); 
		System.out.println();
		System.out.println("remove eleven? " + bowl.remove("eleven")); 
		System.out.println(bowl); 
		System.out.println();
		System.out.println("remove six? " + bowl.remove("six")); 
		System.out.println(bowl); 
		System.out.println();
		System.out.println("remove two? " + bowl.remove("two")); 
		System.out.println(bowl); 
		System.out.println();
		System.out.println("remove nine? " + bowl.remove("nine")); 
		System.out.println(bowl); 
		System.out.println();
		System.out.println("Testing size() " + bowl.size()); 
		System.out.println();
		System.out.println("Testing clear()"); 
		bowl.clear(); 
		System.out.println("New Size " + bowl.size()); 
		System.out.println("RemoveLast() if 1 element"); 
		bowl.addFirst("two");
		bowl.addFirst("one");
		System.out.println(bowl);
		System.out.println();
		for (int i = 0; i <= 1; i++) 
			System.out.println(bowl.removeLast());
		System.out.println(bowl);
		System.out.println();
		System.out.println("RemoveFirst() if 1 element"); 
		bowl.addFirst("two");
		bowl.addFirst("one");
		System.out.println(bowl);
		for (int i = 0; i <= 1; i++) 
			System.out.println(bowl.removeFirst());
		System.out.println(bowl);
		System.out.println();
		System.out.println("Remove(o) if 1 element"); 
		bowl.addFirst("two"); 
		bowl.addFirst("one"); 
		System.out.println(bowl);
		bowl.remove("two"); 
		bowl.remove("one"); 
		System.out.println(bowl);}

	public ListIterator iterator() {
		return new ListIterator(this);
	}
}
