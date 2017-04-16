import java.util.*;

class CompressCode{
	private final static int inf = 0x7fffffff;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int number_count = in.nextInt();
		int[][] sum = new int[number_count][number_count];
		int[] number = new int[number_count];
		int[][] result = new int[number_count][number_count];

		for(int i=0;i<number_count;i++)
			number[i] = in.nextInt();

		for(int i=0;i<number_count;i++){
			sum[i][i] = number[i];
			for(int j=i+1;j<number_count;j++){
				sum[i][j] = sum[i][j-1] + number[j];
				////////////////
				result[i][j] = 0;
			}
		}

		for(int i=2;i<=number_count;i++){
			for(int j=0;j<number_count-i+1;j++){
				result[j][j+i-1] = inf;
				for(int k=j;k<j+i-1;k++){
					result[j][j+i-1] = min(result[j][j+i-1],result[j][k]+result[k+1][j+i-1]+sum[j][j+i-1]);
				}
			}
		}

		System.out.println(result[0][number_count-1]);
	}

	public static int min(int a,int b){
		return a>b? b:a;
	}
}