import java.lang.Math;
import java.util.*;

public class MaxFluctuation{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int count = in.nextInt();
		int[] number = new int[count];
		for(int i=0;i<count;i++)
			number[i] = in.nextInt();

		int max = 0;
		for(int i=1;i<count;i++)
			if(Math.abs(number[i]-number[i-1]) > max)
				max = Math.abs(number[i]-number[i-1]);

		System.out.println(max);
	}
}