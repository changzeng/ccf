import java.util.Scanner;

public class ReversePicture{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int height = in.nextInt();
		int width = in.nextInt();

		int[][] pictrue = new int[height][width];

		int i,j;
		for(i=0;i<height;i++)
			for(j=0;j<width;j++)
				pictrue[i][j] = in.nextInt();

		int[][] pictrue_reversed = reverse(pictrue,height,width);

		for(i=0;i<width;i++){
			for(j=0;j<height;j++){
				System.out.print(pictrue_reversed[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}

	public static int[][] reverse(int[][] pictrue,int height,int width){
		int[][] pictrue_reversed = new int[width][height];

		int i,j;
		for(i=0;i<height;i++)
			for(j=0;j<width;j++)
				pictrue_reversed[width-1-j][i] = pictrue[i][j];
	
		return pictrue_reversed;
	}
}