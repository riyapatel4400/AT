package Math;

public class Knights {

	private long steps; 
	private int [][]board;
	int size; int rows; int cols;

	public Knights (int s){
		size=s;rows=size;
		cols=size;
		board =new int[size][size];
	}

	public int getRows(){
		return rows;
	}
	public int getCols(){
		return cols;
	}
	public long getSteps(){
		return steps;
	}
	public int[][] getBoard(){
		return board;
	}
	private boolean move (int startx, int starty){
		return move (startx, starty, 1);
	}
	private boolean move(int i, int j, int moveNum) {
		steps++;
		if (i<0 || j<0 || i>=rows || j>= cols )
			return false;
		if (board [i][j]>0)
			return false;
		board [i][j] = moveNum;
		if (moveNum == rows*cols)
			return true;
		int [] myHorizonMove = {0,1,1,-1,-1,2,2,-2,-2};
		int[] myVerticalMove = {0,-2,2,-2,2,1,-1,-1,1};
		for (int c = 1; c<=8; c++){
			int nextI = i+myHorizonMove[c];
			int nextJ = j+myVerticalMove[c];
			display();
			if (move (nextI,nextJ, moveNum+1))
				return true;
		}
		board [i][j] =0;
		display();
		return false;
	}

	private void display() {
		for (int i =0; i<rows; i++){
			for (int x = 0; x<cols; x++){
				System.out.print(board [i][x]+"  ");
			}
			System.out.println();
		}
		System.out.println();
	}



	public static void main(String[] args) {
		Knights a = new Knights(3);
		a.move(0, 0);
		a.getBoard();
		a.display();
		System.out.printf ("%,d", a.getSteps());
	}


}
