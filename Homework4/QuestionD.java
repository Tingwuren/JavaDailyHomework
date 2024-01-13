import java.util.regex.*;
import java.util.Scanner;
class Stringmatch{
	String regex;
	String target;
	public Stringmatch(String regex,String target){
		this.regex = regex;
		this.target = target;
	}
	public Stringmatch(){
	}
	public String shortest(){
		Pattern p = Pattern.compile(regex.replace("*",".*?"));
		Matcher m = p.matcher(target);
		String get = "";
		if(m.find())
			get = m.group();
		return get;
	}
	public String longest(){
		Pattern p = Pattern.compile(regex.replace("*",".*"));
		Matcher m = p.matcher(target);
		String get = "";
		if(m.find()){
			get = m.group();
			//System.out.println("get "+get);
		}
		return get;
	}
}
public class QuestionD{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String regex = sc.next();
		String target = sc.next();
		String shortest;
		String longest;
		sc.close();
		Stringmatch match = new Stringmatch(regex,target);
		shortest = match.shortest();
		longest = match.longest();
		System.out.println(shortest);
		System.out.println(longest);
	}
}
