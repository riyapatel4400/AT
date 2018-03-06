package LinkedList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial {

	LinkedList<Term> poly; 

	public Polynomial(){
		poly = new LinkedList<Term>();
	}

	public Polynomial(LinkedList<Term> poly2) {
		poly = poly2;
	}

	public void insertTerm(Term t) {
		int c = t.getCo();
		int x = t.getX();
		ListIterator<Term> it = poly.listIterator();

		while (it.hasNext()){
			Term current = it.next();
			if (x==current.getX()){
				if (c == -current.getCo()){
					it.remove();
					return;
				}
				else {
					it.set(current.add(t));
					return;
				}
			}
			else if (x > current.getX()){
				it.previous();
				it.add(t);
				return;
			}
		}
		it.add(t);
	}

	public LinkedList<Term> getP(){
		return poly;
	}

	public Polynomial add(Polynomial x){
		ListIterator <Term> it = (x.getP().listIterator());
		Polynomial p = new Polynomial ();
		for (Term t : poly)
			p.insertTerm(t);
		while (it.hasNext()){
			Term current = it.next();
			p.insertTerm(current);
		}
		return p;

	}

	public Polynomial multiply(Polynomial x){
		Polynomial p = new Polynomial ();
		for (Term t : poly){
			for (Term y : x.getP()){
				p.insertTerm(t.multiply(y));
			}
		}
		return p;

	}
	public Polynomial derivative(){
		Polynomial p = new Polynomial();
		Term n = new Term();
		for (Term t : poly){
			if (t.getX() <1)
				return p;
			p.insertTerm(t.getCo()*t.getX(),t.getX()-1 );
		}
		return p;
	}

	public void insertTerm(int c, int d){
		insertTerm (new Term(c,d));
	}

	public String toString(){
		String s = "";
		for (Term t : poly){
			if (t.getX() == 0)
				s+= "+" + t.getCo();
			else
				s+=t.toString();
		}
		return s;
	}
}
