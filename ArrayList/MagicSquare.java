package ArrayList;
import java.util.ArrayList;
import java.util.Random;

public class MagicSquare {
	private long steps;
	private int [][] board;
	private int size;
	private ArrayList<Integer> poss;
	private int sum;

	public MagicSquare(int size){
		board = new int [size][size];
		steps=0;
		this.size=size;
		poss=getList(size*size);
		sum = (size)*(size*size+1)/2;
	}


	private ArrayList<Integer> getList(int size2) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 1; i<=size; i++)
			temp.add(i);
		return temp;
	}

	boolean checkRowSum(int r){
		int rSum=0;
		for (int i =0; i<size;i++){
			rSum+=board[r][i];
		}
		return rSum==sum;
	}

	boolean checkColSum(int c){
		int cSum=0;
		for (int i =0; i<size;i++){
			cSum+=board[i][c];
		}
		return cSum==sum;
	}

	void fillBoard(){
		fillBoard(0,0);
	}
	void fillBoard(int r, int c) {


	}
	boolean  fillBoard(int r) {
		steps++;
		if (board[size-1][size-1]!=0){
			System.out.println("done");
			return true;
		}

		Random gen = new Random();
		for (int c = 0; c<size;c++){
			Integer next = poss.get(gen.nextInt(poss.size()));
			poss.remove(next);
			board[r][c]=next;
		}
		if(!checkRowSum(r)){
			for (int c = 0; c<size;c++){
				poss.add(board[r][c]);
				board[r][c]=0;
			}
			fillBoard(r);
			return false;
		}
		fillBoard(r+1);
		return true;
	}


	public void display(){
		for (int r = 0; r<board.length; r++){
			for (int c = 0; c<board[0].length; c++){
				System.out.printf("%5d", board[r][c]);
			}
			System.out.println();
		}
	}

	public long getSteps(){
		return steps;
	}
	
	public static void main (String[] args) {
		
	}

}
