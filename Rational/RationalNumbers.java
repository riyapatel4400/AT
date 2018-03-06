package Rational;
import javax.swing.JOptionPane;

public class RationalNumbers {

	private int num;
	private int den;
	public static void main(String[] args) {
		String inputValue = JOptionPane.showInputDialog("Please input a value");
		RationalNumbers a = new RationalNumbers (inputValue);
		System.out.println("Numerator: "+ a.getNum() + " Denominator: "+ a.getDen());
		inputValue = JOptionPane.showInputDialog("Please input a value");
		RationalNumbers b = new RationalNumbers (inputValue);
		System.out.println(a.subtract(b));
	}

	public RationalNumbers(String s){
		int i = s.indexOf("/");
		num = Integer.parseInt(s.substring(0, i));
		den = Integer.parseInt(s.substring(i+1));
		RationalNumbers c = new RationalNumbers (num,den);
		simplify();
	}
	public RationalNumbers(int num1, int den1) {
		num=num1;
		den=den1;
		simplify();
	}

	public int getNum(){
		return num;
	}
	public int getDen(){
		return den;
	}

	RationalNumbers multiply(RationalNumbers x)
	{

		RationalNumbers answer = new RationalNumbers(num*x.getNum(), den*x.getDen());
		return answer;
	}
	public RationalNumbers divide(RationalNumbers x){
		return multiply (x.getReciprocal());
	}

	public RationalNumbers add(RationalNumbers x){
		int newNum = ((num*x.den) +
	            (x.num*den));
	    int newDen = den*x.den;
	    return new RationalNumbers(newNum, newDen);

	}
	public RationalNumbers subtract(RationalNumbers x){
		  int newNum = ((num*x.den) -
		            (x.num*den));
		    int newDen = den*x.den;
		    return new RationalNumbers(newNum, newDen);
		    
	}
	public void setNum(int i) {
		num=i;

	}

	public void setDen(int den2) {
		den = den2;
	}

	public String getNumber(){
		simplify();
		return num+"/"+den;
	}
	public int findGCD(int a, int b)
	{
		if (b==0) return a;
		return findGCD(b,a%b);
	}
	public void simplify(){
		int gcd = findGCD(num, den);
		num=(num/gcd);
		den=(den/gcd);
		if (den<0){
			den = -(den);
			num = -(num);
		}
	}

	public int compareTo(RationalNumbers r2) {
		int myCommon = num * r2.den;
		int r2Common = r2.num * den;
		return myCommon - r2Common;
	}

	public RationalNumbers getReciprocal() {
		return new RationalNumbers (den,num);
	}
}
