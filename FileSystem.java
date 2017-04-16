import java.util.*;

public class FileSystem{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		Node root = new Node("",null,false);
		Node cur = root;

		cur.create("d1",false);
		cur.create("d2",false);
		cur = cur.changeDir("d1");
		cur.create("f1",true);
		cur.create("f2",true);
		cur = cur.changeDir("../d2");
		cur.create("d3",false);
		cur.create("d4",false);
		cur.create("f4",true);
		cur = cur.changeDir("d3");
		cur.create("f3",true);
		cur = cur.changeDir("../d4");
		cur.create("f1",true);

		int number = in.nextInt();
		String pwd = in.next();

		Node result;
		String[] output = new String[number];
		String input;
		cur = root.changeDir(pwd);
		for(int i=0;i<number;i++){
			input = in.next();

			if(input.equals("")){
				result = cur;
			}else{
				result = cur.changeDir(input);
			}

			output[i] = Node.absolutePath(result,1);
		}

		for(int i=0;i<number;i++)
			System.out.println(output[i]);

	}
}

class Node{
	public String file_name;
	public boolean is_file;

	public Node pre;

	public HashMap<String,Node> next;

	public Node(String name,Node pre,boolean is_file){
		this.file_name = name;
		this.pre = pre;
		this.is_file = is_file;

		if(!is_file)
			next = new HashMap<String,Node>();
	}

	public void create(String name,boolean is_file){
		Node tmp = new Node(name,this,is_file);

		this.next.put(name,tmp);
	}

	public Node changeDir(String path){
		Node result = this;

		path = path.replaceAll("//+","/");

		if(path.startsWith("/")){
			result = getRoot();
			path = path.replaceFirst("/","");
		}

		String[] path_list = path.split("/");

		for(int i=0;i<path_list.length;i++){
			// System.out.print(path_list[i]+"  ");

			if(path_list[i].length() == 0)
				break;

			if(path_list[i].equals("..")){
				if(result.pre != null)
					result = result.pre;
			}else if(!path_list[i].equals(".")){
				if(result.next.get(path_list[i]) != null)
					result = result.next.get(path_list[i]);
			}
		}

		return result;
	}

	public static String absolutePath(Node node,int i){
		if(node.pre == null)
			if(i != 1)
				return "";
			else
				return "/";

		return absolutePath(node.pre,i+1) + "/" + node.file_name;
	}

	public Node getRoot(){
		Node cur = this;

		while(cur.pre != null)
			cur = cur.pre;

		return cur;
	}
}