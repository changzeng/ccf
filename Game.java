import java.util.*;

public class Game{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int i,j;
		int row,col,count;
		row = in.nextInt();
		col = in.nextInt();
		count = in.nextInt();

		Node[][] board = new Node[row+1][col+1];
		Boolean[][] accessable = new Boolean[row+1][col+1];

		for(i=1;i<row+1;i++)
			for(j=1;j<col+1;j++){
				board[i][j] = new Node(i,j);
				accessable[i][j] = false;
			}


		ArrayList<Node> list = new ArrayList<Node>();
		int a,b,c,d;
		for(i=0;i<count;i++){
			a = in.nextInt();
			b = in.nextInt();
			c = in.nextInt();
			d = in.nextInt();

			board[a][b].start = c;
			board[a][b].end = d;

			list.add(board[a][b]);
		}

		Node tmp;
		int time=0;
		while(true){
			for(i=0;i<list.size();i++){
				tmp = list.get(i);
				accessable[tmp.row][tmp.col] = tmp.available();
			}
		}
	}
}

class Node{
	public int start,end;
	public int row,col;

	public Node(int row,int col){
		this.row = row;
		this.col = col;
		this.start = -1;
		this.end = -1;
	}

	public boolean available(int t){
		if(start == -1 && end == -1)
			return true;

		if(t >= start && t<= end)
			return false;

		return true;
	}
}
