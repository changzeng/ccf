import java.util.*;

public class WriteNumber{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    String str = in.next();

    int total = 0;

    for(int i=0;i<str.length();i++){
    	total += Integer.parseInt(str.substring(i,i+1));
    }

    Stack<Integer> stack = new Stack<Integer>();

    while(total != 0){
    	stack.push(total % 10);
    	total /= 10;
    }

 	while(stack.size() > 1){
 		output(stack.pop(),true);
 	}

 	output(stack.pop(),false);

 	System.out.println();
  }

  public static void output(int i,boolean flag){
  	String tmp;

  	if(i == 0)
  		tmp = "ling";
  	else if(i == 1)
  		tmp = "yi";
  	else if(i == 2)
  		tmp = "er";
  	else if(i == 3)
  		tmp = "san";
  	else if(i == 4)
  		tmp = "si";
  	else if(i == 5)
  		tmp = "wu";
  	else if(i == 6)
  		tmp = "liu";
  	else if(i == 7)
  		tmp = "qi";
  	else if(i == 8)
  		tmp = "ba";
  	else
  		tmp = "jiu";


	System.out.print(tmp);
	if(flag)
		System.out.print(" ");
  }
}