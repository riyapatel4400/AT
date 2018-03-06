package LinkedList;
public class DListNode

{

	private Object value;

	private DListNode next;

	private DListNode previous;

	public DListNode(Object initValue, DListNode initNext, DListNode initPrev)

	{
		value= initValue;
		next = initNext; 
		previous = initPrev;
	}
	
	public Object getValue()
	{ 
		return value;
	}

	public DListNode getNext()
	{
		return next;
	}
	
	public DListNode getPrevious()
	{
		return previous;
	}
	
	public void setPrevious(DListNode theNewValue)
	{
		previous = theNewValue;
	}
	
	public void setValue( Object theNewValue)
	{
		value=theNewValue;
	}

	public void setNext( DListNode theNewNext)
	{
		next=theNewNext;
	} 
	public String toString()
	{
		return "" + value;
		
	}


}
