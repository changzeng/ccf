import java.util.*;

public class Tetris{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int[][] board = new int[15][10];
		int[][] block = new int[4][4];

		for(int i=0;i<15;i++)
			for(int j=0;j<10;j++)
				board[i][j] = in.nextInt();

		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				block[i][j] = in.nextInt();

		int start = in.nextInt() - 1;
		int i;
		for(i=14;i>=0;i--)
			if(safetyHeight(board,block,i,start))
				break;

		if(i >= 0){
			int j;
			for(j=1;j<4;j++)
				if(!safetyHeight(board,block,i+j,start))
					break;

			put(board,block,i+j-1,start);
		}

		output(board);
	}

	public static void put(int[][] board,int[][] block,int height,int start){
		int constrain,s=0;

		if(height <= 14 && height >= 4)
			constrain = 4;
		else if(height > 14){
			constrain = 4-(height - 14);
			s = height - 14;
			height = 14;
		}else
			constrain = height;

		for(int i=0;i<constrain;i++){
			for(int j=0;j<4;j++){
				if(board[height-i][start+j] == 1||block[3-i-s][j]==1)
					board[height-i][start+j] = 1;
				else
					board[height-i][start+j] = 0;
			}
		}
	}

	public static void output(int[][] board){
		for(int i=0;i<15;i++){
			for(int j=0;j<10;j++){
				System.out.print(board[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static boolean safetyHeight(int[][] board,int[][] block,int height,int start){
		int constrain,s=0;

		if(height <= 14 && height >= 4)
			constrain = 4;
		else if(height > 14){
			constrain = 4-(height - 14);
			s = height - 14;
		}else
			constrain = height;

		for(int i=0;i<constrain;i++){
			for(int j=0;j<4;j++){
				if(board[height-i-s][start+j]+block[3-i-s][j] == 2)
					return false;
			}
		}

		return true;
	}
}