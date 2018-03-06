package LinkedList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Fruits {

	LinkedList<String> bowl;

	public Fruits(){
		bowl = new LinkedList<String>();
		//		bowl.addLast("apple");
		//		bowl.addLast("banana");
		//		bowl.addLast("cherry");
		//		bowl.addLast("lemon");
		//		bowl.addLast("lime");
		//		bowl.addLast("orange");
		//		bowl.addLast("papaya");
		//		bowl.addLast("strawberry");
		//		bowl.addLast("watermelon");		
	}

	public void display(){
		System.out.println(bowl);
	}

	public void display2(){
		for (String t : bowl)
			System.out.println(t);
	}

	public void display3(){
		ListIterator<String> it = bowl.listIterator();
		while (it.hasNext())
			System.out.println(it.next());
	}

	public void displayEO(){
		ListIterator<String> it = bowl.listIterator();
		while (it.hasNext()){
			System.out.println(it.next());
			if (it.hasNext())
				it.next();
		}
	}

	public void removeEO(){
		ListIterator<String> it = bowl.listIterator();
		while (it.hasNext()){
			it.next();
			it.remove();
			if (it.hasNext())
				it.next();
		}
	}

	public void displayRev(){
		ListIterator<String> it = bowl.listIterator();
		while (it.hasNext())
			it.next();
		while (it.hasPrevious())
			System.out.println(it.previous());
	}

	public void testIterator(){
		ListIterator<String> tc = bowl.listIterator();
		tc.remove();
	}

	public void removeLastTwoFruit(){
		ListIterator<String> it = bowl.listIterator();
		while (it.hasNext())
			it.next();
		it.remove();
		if (it.hasPrevious()){
			it.previous();
			it.remove();
		}
	}

	public void deleteByFirstLetter(String firstLett){
		ListIterator<String> it = bowl.listIterator();
		while (it.hasNext()){
			if (it.next().substring (0, 1).equals(firstLett)){
				it.remove();
			}
		}
	}

	public void insertInOrder(String food){
		ListIterator<String> it = bowl.listIterator();

		while (it.hasNext()){

			if (it.next().compareTo(food) > 0){
				it.previous();
				it.add(food);
				return;
			}
		}
		it.add(food);
	}
	
	 public void merge(Fruits other){
		 ListIterator<String> it2 = other.bowl.listIterator();
		 while (it2.hasNext())
			 insertInOrder(it2.next());
	
	 }
	 
	public static void main (String [] args){
		Fruits a = new Fruits();
		//a.displayEO();
		//System.out.println();
		//a.deleteByFirstLetter("l");
		Fruits b = new Fruits();
		b.insertInOrder("acai");
		b.insertInOrder("tomato");
		b.insertInOrder("blueberry");
		a.merge(b);
		a.display2();
	}


}
