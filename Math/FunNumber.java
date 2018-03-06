package Math;

public class FunNumber {

	private int original;
	public static void main (String[]args) {
		System.out.println ("NUMBER: 13");
		System.out.println ("Sum of Digits: " +sumDigits(13));
		System.out.println ("Number of Digits: " +findNumDigits(13));
		System.out.println ("Sum of Integers: " +sumInts(13));
		System.out.println ("Factorial: " +findFactorial(13));
		System.out.print ("Factors:");
		printFactors(13);
		System.out.println ("\nPrime? " +isPrime(13));
		System.out.println ("Perfect? " +isPerfect(13));
		System.out.println ("Reversed: " +reverseNum(13));

	}

	public static int factorial(int n){
		int prod=1;
		for (int i = 1; i<=n; i++)
			prod*=i;
		return prod;
	}

	public static long factorial2(int n){
		if (n==1)
			return 1;
		return n * factorial2(n-1);
	}

	/**
	 * constructs a FunNumber with value num 
	 */ 

	public FunNumber(int num)
	{ 
		original = num; 
	} 

	/** 
	 * counts the digits in this FunNumber value 
	 * @return the number of the digits 
	 */ 

	public  static int findNumDigits(int original) 
	{ 
		int n=0;
		while (original>0){
			n++;
			original/=10;
		}
		return n;
	} 

	/** 
	 * sums the digits in this FunNumber value 
	 * @return the sum of the digits 
	 */ 

	public static int sumDigits(int original) 
	{ 
		if (original < 10) 
			return original;
		return (original % 10) + sumDigits(original/10);
	} 

	/** sums the integers that are less than or equal to this 
	 * FunNumber value 
	 * @return the sum of the integers <= this FunNumber value 
	 */ 

	public static int sumInts(int original) 
	{ 
		int sum= 0;
		for (int i =1; i<=original; i++)
			sum+=i;
		return sum;
	} 

	/** 
	 * determines the factorial of this FunNumber value 
	 * @return this FunNumber value's factorial 
	 */ 

	public static long findFactorial(int original) 
	{ 
		if(original == 0) {
			return 1;
		}
		else {
			return original * findFactorial(original - 1);
		}
	} 

	/** 
	 * prints all of the factors of this FunNumber value 
	 */ 

	public static void printFactors(int original) 
	{ 
		for (int i =1; i<=original; i++)
			if (original%i ==0)
				System.out.print(i+" ");
	} 

	/** 
	 * determines if this FunNumber value is prime 
	 * @return true if this value is prime, false otherwise 
	 */ 

	public static boolean isPrime(int original) 
	{ 
		boolean flag = true;
		for (int i =2; i<original; i++)
			if (original%i ==0)
				flag=false; 
		return flag;
	} 

	/** 
	 * returns true if this FunNumber value is a “perfect” number 
	 * a perfect number is a number that has a sum of proper factors 
	 * equal to the value of this number. 6 is a perfect number 
	 * because 6 = 1 + 2 + 3. 
	@ return true if this FunNumber value is a perfect number, false 
	 * otherwise. 
	 */ 
	public static boolean isPerfect(int original)
	{ 
		int sum = 0;
		for (int i =1; i<original; i++)
			if (original%i ==0)
				sum+=i;
		if (sum == original)
			return true;
		return false;
	} 

	public static int reverseNum(int original){
		int num = 0;
		int temp = 0;
		while(original > 0){
			temp = original%10;
			num = num * 10 + temp;
			original = original/10;
		}
		return num;
	}
}