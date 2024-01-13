import java.util.Scanner;
public class QuestionC{
	public static void main(String[] args){
		int[] count = new int[26];
		Scanner cin = new Scanner(System.in);
		int l = 0;
		for(int i = 0;i < 26;i++){
			count[i] = 0;
		}
		String s = cin.next();
		char c;
		for(int i = 0;i < s.length();i++){
			c = s.charAt(i);
			count[(int)(c-'a')]++;
		}
		for(int n = 0;n < 26;n++){
			if(count[n]!=0){
				char m = (char)(n+'a');
				System.out.println(m+":"+count[n]);
			}
		}
		cin.close();
	}
}
