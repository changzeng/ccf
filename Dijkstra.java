import java.util.*;

public class Dijkstra{
	public static final int INF = 0x7fffffff;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int number;
		number = in.nextInt();

		int[][] m_matrix = new int[number][number];
		for(int i=0;i<number;i++)
			for(int j=0;j<number;j++){
				m_matrix[i][j] = in.nextInt();
				if(m_matrix[i][j] == 0)
					m_matrix[i][j] = INF;
			}

		dijkstra(m_matrix,number,0,number-1);
	}

	public static void dijkstra(int[][] m_matrix,int number,int start,int end){
		int[] dis = new int[number];
		int[] pre = new int[number];
		boolean[] visit = new boolean[number];

		for(int i=0;i<number;i++){
			dis[i] = m_matrix[start][i];

			if(dis[i] == INF)
				pre[i] = -1;
			else
				pre[i] = start;

			visit[i] = false;
		}

		visit[start] = true;
		int k=0;
		for(int i=0;i<number;i++){
			int tmp = INF;
			for(int j=0;j<number;j++){
				if(visit[j] == false && dis[j]<tmp){
					tmp = dis[j];
					k = j;
				}
			}

			visit[k] = true;
			if(k == end)
				break;

			for(int j=0;j<number;j++){
				if(visit[j] == false && (m_matrix[k][j] == INF ? INF:(dis[k] + m_matrix[k][j])) < dis[j]){
					dis[j] = dis[k] + m_matrix[k][j];
					pre[j] = k;
				}
			}
		}

		visit(pre,end);
		System.out.println();
	}

	public static void visit(int[] pre,int start){
		if(pre[start] == -1){
			System.out.print(start);
			System.out.print(" ");
			return ;
		}

		visit(pre,pre[start]);
		System.out.print(start);
		System.out.print(" ");
	}
}