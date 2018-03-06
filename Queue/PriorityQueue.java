package Queue;

public interface PriorityQueue
{ 
	public boolean isEmpty(); 
	public void add(Object x); 
	//Retrieves, but does not remove, the head of this queue, returning null if this queue is empty. 
	public Object poll(); 
	//Retrieves and removes the head of this queue, or null if this queue is empty. 
	public Object peek(); 
	public int size();

}