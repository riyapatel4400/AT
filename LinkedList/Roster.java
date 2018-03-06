package LinkedList;
import java.awt.Component;
import java.awt.List;
import java.util.NoSuchElementException;

public class Roster {




	public String toString() {
		if (teamList == null) {
			return "[]";
		} else if (teamList.getNext() == null) {
			return "[" + teamList + "]";
		} else {
			String res = "[" + teamList + ", ";
			ListNode t = teamList.getNext();


			while (t.getNext() != null) {
				res += t + ", ";
				t = t.getNext();
			}
			res += t + "]";
			return res;
		}
	}
	private ListNode teamList;
	public Roster() {
		teamList = null;
	}


	public ListNode wrestlerBefore(int weight) {
		ListNode team = teamList;
		ListNode current = team;
		if (((Wrestler) team.getValue()).getWeight() > weight)
			return null;
		else {
			ListNode over;
			while (team.getNext() != null) {
				team = team.getNext();
				if (((Wrestler) team.getValue()).getWeight() > weight) {
					over = team;
					while (!current.getNext().equals(over))
						current = current.getNext();
					return current;
				}
			}
			return null;
		}
	}


	/**
	 * precondition: the teamList field is null or it points to the
	 * first node of a linked list
	 * postcondition: w has been added to the list in sorted order (by weight)
	 */

	public void addWrestler(Wrestler w) {
		boolean s = false;
		if (teamList == null) {
			teamList = new ListNode(w, null);
			s = true;
		}
		else if(w.getWeight() < ((Wrestler) teamList.getValue()).getWeight()) {
			ListNode a = new ListNode(w , teamList);
			teamList = a;
			s = true;
		}
		else {
			ListNode over;
			ListNode initial = teamList;
			ListNode t = teamList;
			while (t.getNext() != null) {
				t = teamList.getNext();
				if (((Wrestler) t.getValue()).getWeight() > w.getWeight()) {
					over = t;
					while (!initial.getNext().equals(over))
						initial = initial.getNext();
					initial.setNext(new ListNode(w, initial.getNext()));
					s = true;
				}
			}
		}
		if (!s) {
			ListNode t = teamList;
			while (t.getNext() != null) {
				t = teamList.getNext();
			}
			t.setNext(new ListNode(w, null));
		}
	}


	public Object remove(Wrestler w) {
		if (teamList == null)
			throw new NoSuchElementException("Can't remove from an empty list");
		else if ((teamList.getValue().equals(w))) {
			teamList = teamList.getNext();
			return true;
		} else {
			ListNode current = teamList;
			while (current.getNext() != null) {
				if (current.getNext().getValue().equals(w)) {
					if(current.getNext() != null) {
						current.setNext(current.getNext().getNext());
						return true;
					} else {
						current.setNext(null);
						return true;
					}
				}
				current = current.getNext();
			}
			return false;
		}
	}


	/**
	 * Displays wrestlers less than weight
	 */

	public void SmallerList(int weight) {
		ListNode team = teamList;
		System.out.print("[");
		while (team.getNext() != null) {
			team = team.getNext();
			if (((Wrestler) team.getValue()).getWeight() < weight) {
				System.out.print ((Wrestler) team.getValue());
				team = team.getNext();
				if (((Wrestler) team.getValue()).getWeight() < weight)
					System.out.print (", "+ (Wrestler) team.getValue());
			}
		}
		System.out.print("]");
	}


	public static void main (String [] args){
		Roster a = new Roster();
		Wrestler pyrros = new Wrestler("Pyrros Dimas", 243);
		Wrestler kakhi = new Wrestler("Kakhi Kakhiashvili", 250);
		a.addWrestler(pyrros);
		a.addWrestler(new Wrestler("John Cena", 244));
		a.addWrestler(kakhi);
		System.out.println(a);
		System.out.println(a.wrestlerBefore(245));
		a.addWrestler(new Wrestler("Halil Mutlu", 157));
		System.out.println(a);
		a.remove(kakhi);
		System.out.println(a);
		a.SmallerList(249);
	}
}




