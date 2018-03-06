package Sorts;

public class Merge {

	static int lowerIndex;
	static int higherIndex;
	public static int[] mergeOrder (int []a, int []b){
		int[] answer = new int[a.length + b.length];
		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length)
		{
			if (a[i] < b[j])
			{
				answer[k] = a[i];
				i++;
			}
			else
			{
				answer[k] = b[j];
				j++;
			}
			k++;
		}

		while (i < a.length)
		{
			answer[k] = a[i];
			i++;
			k++;
		}

		while (j < b.length)
		{
			answer[k] = b[j];
			j++;
			k++;
		}
		return answer;
	}

	public static void main (String [] args){
		int one [] ={1,3,5,7,9,11};
		int  two[] = {2,4,6,8,10,12,14,16};
		int three[]= mergeOrder(one, two);
		display(three);
	}

	private static void display(int[] three) {
		for (int x: three)
			System.out.print (x + "  ");
		
	}

	public static int[] mergeSort(int[] nos) {
		int length = nos.length;
		doMergeSort(0, length - 1, nos);
		return nos;
	}
	
	private static void doMergeSort(int lowerIndex, int higherIndex, int[] nos) {
		if(lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			doMergeSort(lowerIndex, middle, nos);
			doMergeSort(middle + 1, higherIndex, nos);
			mergeParts(lowerIndex, middle, higherIndex, nos);
		}
				
	}
	
	private static void mergeParts(int lowerIndex, int middle, int higherIndex, int[] nos) {
		int[] tempMerge = new int[nos.length];
		for(int i = lowerIndex; i <= higherIndex; i++) {
			tempMerge[i] = nos[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while(i <= middle && j <= higherIndex) {
			if(tempMerge[i] <= tempMerge[j]) {
				nos[k] = tempMerge[i];
				i++;
			}
			else {
				nos[k] = tempMerge[j];
				j++;
			}
			k++;
		}
		while(i <= middle) {
			nos[k] = tempMerge[i];
			k++;
			i++;
		}
	}
}