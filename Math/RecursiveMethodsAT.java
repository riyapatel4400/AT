package Math;
import java.util.Arrays;

public class RecursiveMethodsAT {

	/**
	 * 1. Recursively find and return the product of the first y whole numbers.
	 * 
	 * @param y
	 * @return y! as a long integer
	 */

	public static long factorial(int y) {
		if (y == 1)
			return 1;
		return y * factorial(y - 1);
	}

	/**
	 * 2. Recursively find and return the sum of the first y whole numbers.
	 * 
	 * @param y
	 * @return sum as an int
	 */

	public static int sumInt(int n) {
		if (n == 1)
			return 1;

		return n + sumInt(n - 1);
	}

	/**
	 * 3. Recursively finds the value of 2 to the yth power
	 * 
	 * @param y
	 * @return 2^y as a long integer
	 */

	public static long powerOfTwo(int x) {
		if (x == 1)
			return 2;
		return (2 *powerOfTwo(x - 1));
	}

	/**
	 * 4. Recursively find the nth term of the Fibonacci Sequence
	 * 1,1,2,3,5,8,13.......
	 * 
	 * @param n
	 * @return nth term as an int
	 */

	public static int fib(int n) {
		if (n == 1 || n == 2)
			return 1;
		return fib(n - 2) + fib(n - 1);
	}

	/**
	 * 
	 * 5. Recursively finds and returns the sum of the digits of n
	 * 
	 * @param n
	 * @return
	 */

	public static int sumDigits(int n) {
		if (n < 10)
			return n;
		return (n % 10) + sumDigits(n / 10);
	}

	/**
	 * 
	 * 6. Recursively find and return the reverse of a String s
	 * 
	 * @param s
	 * @return the reverse of s
	 */

	public static String reverse(String s) {
		if (s.length() == 0)
			return "";
		return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
	}

	/**
	 * 7. Recursively the sum of the first y terms of the binary series. 1/2 +
	 * 1/4 + 1/8+ ...
	 * 
	 * @param y
	 *            the number of terms of the sequence
	 * @return the sum of y terms as a double
	 */

	public static double binarySeries(int y) {
		if (y == 1)
			return 1.0/2;
		else
			return (1.0 / (y * y)) + binarySeries(y - 1);
	}

	/**
	 * 8. Recursively finds the maximum element of an array
	 * 
	 * @param arr
	 * @return the maximum element in the array
	 */
	public static int findMax(int[] a){
		return maxValue(a, a.length-1);
	}
	public static int maxValue(int arr[], int index) {

		if (index > 0) {
			return Math.max(arr[index-1], maxValue(arr, index-1));
		} else {
			return arr[0];
		}

	}
	/**
	 * 9. Recursively finds the sum element of an int array
	 * 
	 * @param arr
	 * @return the sum of the elements in the array
	 */

	public static int findSum(int[] a) {
		/*
		 * if (a.length==1) return a[0]; int x =0; while (a.length>1){ int[]y =
		 * new Array; return a[x]+findSum(); }
		 */
		return findSum(a, a.length - 1);
	}

	public static int findSum(int[] a, int count) {
		if (count == 0)
			return a[0];
		else
			return a[count] + findSum(a, count - 1);
	}

	/**
	 * 10. Recursively finds the index number of lookFor in an array
	 * 
	 * @param arr
	 * @return the index number of lookFor. -1 if not found
	 */

	public static int search(int[] arr, int lookFor) {
		if (arr.length==1)
			if (arr[0]==lookFor)
				return 0;
			else
				return -1;
		int [] temp= Arrays.copyOf(arr, arr.length-1);
		if (arr[arr.length-1] ==lookFor)
			return arr.length-1;
		else return search(temp ,lookFor);

	}

	public static int sumOfArray(int [][] array, int row, int col){
		if (row<array.length){
			if (col<array.length-1){
				return array[row][col]+sumOfArray (array, row, col+1);
			}
		}
		else{
			return array[row][col] + sumOfArray(array, row+1, 0);
		}
		return 0;
	}

	public static void fillArray2(char[][]array, char c){
		fillArray2(array, 0,0,c);
	}

	public static void fillArray2(char[][]array,int row, int col, char c){
		if (row<array.length){
			if (col <array[row].length){
				array [row][col]=c;
				fillArray2(array, row, col+1, c);
			}
			else
				fillArray2(array, row+1, 0, c);
		}
	}


	public static void main(String[] args) {
 

		System.out.println(" 20! "+ factorial(20)); 

		System.out.println("Sum of first 16 Positive integers: " + sumInt(16)); 

		System.out.println("2^12: "+ powerOfTwo(12)); 

		System.out.println("12th Fibonacci number: " + fib(12)); 

		System.out.println("Digit Sum of 12345: " + sumDigits(12345)); 

		System.out.println("RACECAR reversed: " + reverse("RACECAR")); 

		System.out.println("Sum of 5 terms of binary Series: "+ 

		binarySeries(4)); 

		int[] x = { 1, 22, 133, 34, 56, 62, 79 }; 

		System.out.println(); 

		System.out.println("MaxValue: " +findMax(x)); 

		System.out.println("Sum: " + findSum(x)); 

		System.out.println("Search for 111: " + search(x,111)); 

		System.out.println("Search for 79: " + search(x,79));

		int[][] y = { { 1, 2 }, { 3, 4 }, { 5, 6 } }; 

		System.out.println("Sum of 2Dim array: " + sumOfArray(y, 0, 0)); 

		char[][] b = new char[5][19]; 

		fillArray2(b, '@'); 

		for (char[] r : b) { 

			for (char c : r) 

				System.out.print(c); 

			System.out.println();

		} 

		/* 

		Output 

		20! 2432902008176640000

		Sum of firsr 16 Positive integers: 136 

		2^12: 4096 

		12th Fibonacci number: 144 

		Digit Sum of 12345: 15 

		RACECAR reversed: RACECAR

		Sum of 5 terms of binary Series: 0.9375 

		MaxValue: 133 

		Sum: 387 

		Search for 111: -1 

		Search for 79: 6 

		Sum of 2Dim array: 21 

		@@@@@@@@@@@@@@@@@ 

		@@@@@@@@@@@@@@@@@ 

		@@@@@@@@@@@@@@@@@ 

		@@@@@@@@@@@@@@@@@ 

		@@@@@@@@@@@@@@@@@ 

		 */



	}
}