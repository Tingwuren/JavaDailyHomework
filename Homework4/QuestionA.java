import java.util.regex.*;
import java.util.Scanner;
import java.util.Arrays;
public class QuestionA{
	public static void main(String[] args){
		String[] commend;
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		commend = new String[n];
		for(int i = 0;i < n;i ++){
			commend[i] = cin.next();
		}
		Arrays.sort(commend);
		String regex = cin.next();
		Pattern p = Pattern.compile(regex);
		for(int i = 0;i < n;i ++){
			//Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(commend[i]);
			if(m.lookingAt()){
				System.out.println(commend[i]);
			}
		}
		cin.close();
	}
}
