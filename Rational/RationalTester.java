package Rational;
public class RationalTester {

	public static void main(String[] args) {
		RationalNumbers r1 = new RationalNumbers(3, -12);
		RationalNumbers r2 = new RationalNumbers(11, 22);

		RationalNumbers rSum, rDiff, rProd, rQuot, rRecip;
		System.out.println("First rational number: " + r1.getNumber());
		System.out.println("Second rational number: " + r2.getNumber());

		if (r1.equals(r2))
			System.out.println("r1 and r2 are equal.");
		else
			System.out.println("r1 and r2 are not equal.");

		if (r1.compareTo(r2) < 0)
			System.out.println("r1 is less than r2.");
		else if (r1.compareTo(r2) > 0)
			System.out.println("r1 is greater than r2.");
		else
			System.out.println("r1 and r2 are equal.");

		rRecip = r1.getReciprocal();
		System.out.println("The reciprocal of r1 is: " + rRecip.getNumber());

		rSum = r1.add(r2);
		rDiff = r1.subtract(r2);
		rProd = r1.multiply(r2);
		rQuot = r1.divide(r2);

		System.out.println("r1 + r2: " + rSum.getNumber());
		System.out.println("r1 - r2: " + rDiff.getNumber());
		System.out.println("r1 * r2: " + rProd.getNumber());
		System.out.println("r1 / r2: " + rQuot.getNumber());
	}

	
}