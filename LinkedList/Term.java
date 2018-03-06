package LinkedList;

public class Term {

	int co;
	int x;
	
	public Term(){
		co = 5;
		x=10;
	}
	
	public Term (int t, int ex){
		co = t;
		x= ex;
	}
	
	public void setCo (int t){
		co = t;
	}
	
	public void setX (int ex){
		x=ex;
	}
	
	public int getX (){
		return x;
	}
	
	public int getCo (){
		return co;
	}
	
	public String toString(){
		return "+ " +co + "x^" + x + "\t";
	
	}
	public String getTerm(){
		return  co + "x^" + x;
	}

	public Term add(Term q) {
		return new Term (co+q.getCo(), x);
				
	}

//	public String multiply(Term r) {
//		return (co*r.getCo())+ "x^" +(x+r.getX());
//	}
	public Term multiply(Term r) {
		return new Term (co*r.getCo(),x+r.getX());
		
	}
}
