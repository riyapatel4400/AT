package Sorts;
public class QuickSort {

	private int arr[];
	private int length;

	public void sort(int[] inArr) {

		if (inArr == null || inArr.length == 0) {
			return;
		}
		this.arr = inArr;
		length = inArr.length;
		quickSort(0, length - 1);
	}

	private void quickSort(int low, int high) {

		int i = low;
		int j = high;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = arr[low+(high-low)/2];
		// Divide into two arrs
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which
			 * is greater then the pivot value, and also we will identify a number
			 * from right side which is less then the pivot value. Once the search
			 * is done, then we exchange both numbers.
			 */
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers(i, j);
				//move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (low < j)
			quickSort(low, j);
		if (i < high)
			quickSort(i, high);
	}

	private void exchangeNumbers(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String a[]){

		QuickSort sorter = new QuickSort();
		int[] in = {24,2,45,20,56,75,2,56,99,53,12};
		sorter.sort(in);
		for(int i:in){
			System.out.print(i);
			System.out.print(" ");
		}
	}
}