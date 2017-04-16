import java.util.*;

class BreakPoint{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int count = in.nextInt();
		int[] numbers = new int[count];
		for(int i=0;i<count;i++){
			numbers[i] = in.nextInt();
		}

		int result=0;
		for(int i=1;i<count-1;i++){
			if(numbers[i] > numbers[i-1] && numbers[i] > numbers[i+1] || numbers[i] < numbers[i-1] && numbers[i] < numbers[i+1])
				result += 1;
		}

		System.out.println(result);
	}
}