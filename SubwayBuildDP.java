import java.util.*;

public class SubwayBuildDP{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int point_count = in.nextInt();
		int tunnel_count = in.nextInt();

		int[] nodes = new int[point_count+1];
		Edge[] edges = new Edge[tunnel_count];

		int sta,end,dis,tmp;

		for(int i=0;i<tunnel_count;i++){
			sta = in.nextInt();
			end = in.nextInt();
			dis = in.nextInt();

			edges[i] = new Edge(sta,end,dis);
		}

		Arrays.sort(edges);

		for(int i=0;i<tunnel_count;i++){
			sta = edges[i].sta;
			end = edges[i].end;
			dis = edges[i].val;

			if(nodes[sta] < dis)
				tmp = dis;
			else
				tmp = nodes[sta];

			if(nodes[end] == 0 || tmp < nodes[end])
				nodes[end] = tmp;
		}

		System.out.println(nodes[point_count]);
	}
}

class Edge implements Comparable<Edge>{
	public int sta,end,val;

	public Edge(int _sta,int _end,int _val){
		sta = _sta;
		end = _end;
		val = _val;
	}

	@Override
	public int compareTo(Edge edge){
		if(this.sta < edge.sta)
			return -1;
		else if(this.sta == edge.sta)
			return 0;
		else
			return 1;
	}
}