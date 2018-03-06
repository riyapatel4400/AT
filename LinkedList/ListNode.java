package LinkedList;
public class ListNode
{
	// instance variables - replace the example below with your own
	private Object value;
	private ListNode next;

	/**
	 * Constructor for objects of class ListNode
	 */
	public ListNode(Object initValue, ListNode initNext)
	{
		value= initValue;
		next = initNext; 
	}


	public Object getValue()
	{ 
		return value;
	}

	public ListNode getNext()
	{
		return next;
	}

	public void setValue(Object theNewValue)
	{
		value=theNewValue;
	}

	public void setNext(ListNode theNewNext)
	{
		next=theNewNext;
	} 
	public String toString()
	{
		return "" + value;
	}

}