import java.util.Scanner;

public class WagesCalculation{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int input_wages = in.nextInt();
		int tax_wages = input_wages - 3500;
		if(tax_wages <= 0)
			System.out.println(input_wages);

		int[] max_cost = new int[6];
		int[] sep = {1500,4500,9000,35000,55000,80000};
		double[] rate = {0.03,0.1,0.2,0.25,0.3,0.35,0.45};
		int[] new_sep = new int[6];

		int tmp,i,j;

		max_cost[0] = (int)(1500*0.03);
		for(i=1;i<6;i++){
			max_cost[i] = (int)((sep[i] - sep[i-1])*rate[i]);
		}

		for(i=0;i<6;i++){
			tmp = sep[i];
			for(j=0;j<=i;j++)
				tmp -= max_cost[j];
			new_sep[i] = tmp;
		}

		int out = 0;
		for(i=0;i<6;i++){
			if(tax_wages < new_sep[i]){
				if(i == 0)
					out = tax_wages;
				else
					out = tax_wages - new_sep[i-1];
				break;
			}
		}

		int max = i;
		int total_salary = (int)(out/(1-rate[max])) + 3500 + tax_wages - out;

		for(i=0;i<max;i++){
			total_salary += max_cost[i];
		}

		System.out.println(total_salary);
	}
}