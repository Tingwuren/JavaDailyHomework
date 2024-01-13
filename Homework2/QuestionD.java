import java.util.Scanner;
public class QuestionD{
	public static void main(String[] args){
		int n;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		for(int i = 1;i <= n;i++){
			for(int j = 1;j <= n-1;j++){
				int m;
				if(i < j)
					m = j-1;
				else				
					m = i-1;
				if(i <= j){
					System.out.print(m*m+i+" ");
				}
				else if(i > j){
					System.out.print(m*m+i+i-j+" ");
				}
		}
			System.out.print((n-1)*(n-1)+i+"\n");
		}
		cin.close();
	}
}
