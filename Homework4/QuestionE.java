import java.util.Scanner;
class Stringmatch{
	String styleString;
	String matchString;
	public Stringmatch(){
	}
	public Stringmatch(String styleString,String matchString){
		this.styleString = styleString;
		this.matchString = matchString;
	}
	boolean isMatch(){
		styleString = styleString.replace("%",".*");
		styleString = styleString.replace("_",".");
		//System.out.println(styleString);
		return matchString.matches(styleString);
	}
}
public class QuestionE{
	public static void main(String[] args){
		int n;
		Scanner sc = new Scanner(System.in); 
		n = sc.nextInt();
		String[] styleString = new String[n];
		String[] matchString = new String[n];
		for(int i=0;i<n;i++){
			styleString[i] = sc.next();
			matchString[i] = sc.next();
		}
		for(int i=0;i<n;i++){
			Stringmatch match = new Stringmatch(styleString[i],matchString[i]);
			if(match.isMatch())
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
}
