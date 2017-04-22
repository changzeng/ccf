import java.util.*;
import java.util.regex.*;
	
public class Markdown{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);


		Pattern head = Pattern.compile("(#+) +(.+)");
		Pattern em = Pattern.compile("_(.+?)_");
		Pattern li = Pattern.compile("\\* +(.+)");
		Pattern link = Pattern.compile("\\[(.+)\\]\\((.+)\\)");

		Matcher matcher;
		String result="",text="",line;

		while(in.hasNextLine()){
			line = in.nextLine();

			if(line.length() != 0){
				if(text.length() != 0)
					text += "\n" + line;
				else
					text = line;
			}

			if(line.length() == 0 || !in.hasNextLine()){
				if(text.length() == 0)
					continue;

				if(text.startsWith("#")){
					matcher = head.matcher(text);
					matcher.find();
					String num = Integer.toString(matcher.group(1).length());
					
					text = "<h"+num+">"+matcher.group(2)+"</h"+num+">";
				}else if(text.startsWith("*")){

					matcher = li.matcher(text);
					text = matcher.replaceAll("<li>$1</li>");
					text = "<ul>\n"+text+"\n</ul>";
				}else{
					text = "<p>" + text + "</p>";
				}

				matcher = em.matcher(text);
				text = matcher.replaceAll("<em>$1</em>");

				matcher = link.matcher(text);
				text = matcher.replaceAll("<a href=\"$2\">$1</a>");

				result += text+"\n";
				text = "";
			}
		}

		result = result.substring(0,result.length()-1);

		System.out.println(result);
	}
}