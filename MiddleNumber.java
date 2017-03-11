import java.util.Scanner;
import java.util.Arrays;

public class MiddleNumber{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int number = in.nextInt();
		int[] array = new int[number];

		for(int i=0;i<number;i++)
			array[i] = in.nextInt();

		Arrays.sort(array);

		int left_count,right_count;
		if(number %2 == 0){
			left_count = integerCount(array,array[number/2],0,number/2-1);
			right_count = integerCount(array,array[number/2],number/2,number-1);
		}else{
			left_count = integerCount(array,array[number/2],0,number/2 -1);
			right_count = integerCount(array,array[number/2],number/2 + 1,number-1);
		}

		if(left_count == right_count)
			System.out.println(array[number/2]);
		else
			System.out.println(-1);
	}

	public static int integerCount(int[] array,int number,int left,int right){
		int count = 0;

		for(;left<=right;left++)
			if(number == array[left])
				count++;

		return count;
	}
}