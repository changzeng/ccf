import java.util.*;

public class SubwayBuild{
	static Node[] nodes;
	static int max=0x7fffffff,tmp_node,tmp_leng,point_count;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		point_count = in.nextInt();
		int tunnel_count = in.nextInt();

		nodes = new Node[point_count+1];
		for(int i=1;i<=point_count;i++)
			nodes[i] = new Node();

		int sta,end,dis;

		for(int i=0;i<tunnel_count;i++){
			sta = in.nextInt();
			end = in.nextInt();
			dis = in.nextInt();

			nodes[sta].next.add(end);
			nodes[sta].leng.add(dis);
		}

		findWay(1,0);

		System.out.println(max);
	}

	public static void findWay(int start,int cur_max){
		if(start == point_count){
			if(cur_max < max)
				max = cur_max;

			return;
		}

		if(cur_max >= max)
			return;

		for(int i=0;i<nodes[start].next.size();i++){
			tmp_node = nodes[start].next.get(i);
			tmp_leng = nodes[start].leng.get(i);

			if(cur_max < tmp_leng)
				findWay(tmp_node,tmp_leng);
			else
				findWay(tmp_node,cur_max);
		}
	}
}

class Node{
	public ArrayList<Integer> next = new ArrayList<Integer>(2);
	public ArrayList<Integer> leng = new ArrayList<Integer>(2);

	public Node(){

	}
}