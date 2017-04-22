import java.util.*;

public class SubwayBuildDS{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int spot_count = in.nextInt();
		int tunnel_count = in.nextInt();
		
		int[] pre = new int[spot_count+1];
		for(int i=0;i<=spot_count;i++)
			pre[i] = -1;
			
		Tunnel[] tunnels = new Tunnel[tunnel_count];
		
		int sta,end,val;
			
		for(int i=0;i<tunnel_count;i++){
			sta = in.nextInt();
			end = in.nextInt();
			val = in.nextInt();
			
			tunnels[i] = new Tunnel(sta,end,val);
		}
		
		Arrays.sort(tunnels);

		for(int i=0;i<tunnel_count;i++){
			sta = tunnels[i].sta;
			end = tunnels[i].end;
			val = tunnels[i].val;

			u(pre,sta,end);

			if(f(pre,1) == f(pre,spot_count)){
				System.out.println(val);
				break;
			}
		}
	}
	
	public static int f(int[] pre,int s){
		int t = s;
		int p;
		while(pre[t] > 0) t = pre[t];
		while(pre[s] > 0){
			p = pre[s];
			pre[s] = t;
			s = p;
		}
		
		return t;
	}
	
	public static void u(int[] pre,int s1,int s2){
		int f1 = f(pre,s1);
		int f2 = f(pre,s2);
		
		if(f1 != f2){
			if(pre[f1] < pre[f2]){
				pre[f1] += pre[f2];
				pre[f2] = f1;
			}else{
				pre[f2] += pre[f1];
				pre[f1] = f2;
			}
		}
	}
}

class Tunnel implements Comparable<Tunnel>{
	public int sta,end,val;
	
	public Tunnel(int _sta,int _end,int _val){
		sta = _sta;
		end = _end;
		val = _val;
	}
	
	@Override
	public int compareTo(Tunnel tunnel){
		if(this.val < tunnel.val)
			return -1;
		else if(this.val == tunnel.val)
			return 0;
		else 
			return 1;
	}
}