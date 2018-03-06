package Math;

public class Hanoi {

	public static void main(String[] args) {
		// 4 disks from pole 1 to pole 3
		move (4,1,3);
		System.out.println(count);
	}

	private static int count=0;
	private static void move(int n, int s, int e) {
		if (n==0){
			return;
		}
		int i = 6-s-e;
		move (n-1, s, i);
		System.out.println ("Move: " + n+ " from " + s + "to "+e);
		move (n-1, i , e);
		count++;
	}
}