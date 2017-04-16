import java.util.*;
import java.util.regex.*;
	
public class Test{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		String str = "__jjkljl__fsdfsd";

		Pattern pattern = Pattern.compile("__(.+?)__(.+)");
		Matcher matcher = pattern.matcher(str);

		// System.out.println(matcher.replaceAll("**$1**"));
		matcher.find();
		System.out.println(matcher.group(2));
		System.out.println(matcher.replaceAll("$1"));
	}
}