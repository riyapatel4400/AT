package Queue;

public interface MyQueue {
	
	//tests if this stack is empty
	public boolean empty();
	
	//inserts the specified element into this queue
	public boolean offer (Object item);
	
	//retrieves and removes the head of the queue
	//returns null if the queue is empty
	public Object poll();
	
	//retrieves not does not remove the head of this queue
	//returns null if the queue is empty
	public Object peek();

}
