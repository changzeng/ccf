import java.util.*;

public class BuyTickets{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int[] seats = new int[20];
		for(int i=0;i<20;i++)
			seats[i] = 5;

		int instructor_count = in.nextInt();
		int[] instructor = new int[instructor_count];
		int[][] result = new int[instructor_count][5];

		for(int i=0;i<instructor_count;i++){
			instructor[i] = in.nextInt();
			getSeats(seats,instructor[i],result[i]);
		}

		for(int i=0;i<instructor_count;i++){
			for(int j=0;j<instructor[i];j++){
				System.out.print(result[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}

	}

	public static void getSeats(int[] seats,int tickets_number,int[] result){
		for(int i=0;i<20;i++){
			if(tickets_number <= seats[i]){
				for(int j=0;j<tickets_number;j++)
					result[j] = i*5 + j + 1 + 5 - seats[i];
				seats[i] -= tickets_number;

				return;
			}
		}

		int i=0,index=0,seat_remain;
		while(tickets_number > 0 && i < 20){
			seat_remain = seats[i];
			for(int j=0;j<seat_remain;j++){
				result[index++] = getSeatNumber(seats[i],i);
				tickets_number -= 1;
				seats[i] -= 1;

				if(tickets_number <= 0)
					return;
			}

			i++;
		}
	}

	public static int getSeatNumber(int seat_remain,int row){
		return row*5 + 1 + 5 - seat_remain;
	}
}