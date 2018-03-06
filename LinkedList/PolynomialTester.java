package LinkedList;
public class PolynomialTester
{

	public static void main(String[] args)
	{ 
		Polynomial o = new Polynomial();
		Polynomial p = new Polynomial();
		Polynomial q = new Polynomial();

		o.insertTerm(3,4);
		o.insertTerm (-2,0);
		o.insertTerm (1,3);

		p.insertTerm(2, 0);
		p.insertTerm(1, 2);
		p.insertTerm(3, 3);
		p.insertTerm(2,1);
		p.insertTerm(1, 5);

		q.insertTerm(-3,3);
		q.insertTerm(1, 2);
		q.insertTerm(1,0);

		System.out.println("O");
		System.out.println(o);
		System.out.println("P");
		System.out.println(p);

		System.out.println();
		System.out.println("Q");
		System.out.println(q);


		Polynomial r = new Polynomial();
		r= p.add(q);
		System.out.println("P+Q");
		System.out.println(r);
		Polynomial u = new Polynomial();
		u= o.add(q);
		System.out.println("O+Q");
		System.out.println(u);
		System.out.println("Q*Q");
		Polynomial s = new Polynomial();
		s= q.multiply(q);
		System.out.println(s);

		System.out.println("O*P");
		Polynomial v = new Polynomial();
		v= o.multiply(p);
		System.out.println(v);
		Polynomial t = new Polynomial();
		System.out.println("P'");
		t = p.derivative();
		System.out.println(t);
		Polynomial x = new Polynomial();
		System.out.println("O'");
		x = o.derivative();
		System.out.println(x);

	}
}