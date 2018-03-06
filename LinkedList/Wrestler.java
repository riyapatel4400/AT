package LinkedList;

public class Wrestler implements Comparable

{

	private String name;
	private int weight;

	/**
	 * Constructor for objects of class Wrestler
	 */
	public Wrestler( String theName, int theWeight)
	{
		name= theName;
		weight=theWeight;
	}

	public int getWeight()
	{
		// put your code here
		return weight;
	}



	public String getName()
	{
		// put your code here
		return name;
	}

	public String toString()
	{

		// put your code here
		return name + "  " +weight;

	}

	public int compareTo(Object w) {
		Wrestler x = (Wrestler)(w);
		return this.getWeight() - x.getWeight();
	}

}