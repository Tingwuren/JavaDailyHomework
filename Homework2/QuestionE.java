import java.util.Scanner;
public class QuestionE{
	public static void main(String[] args){
		int n;
		int[][] score;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		score = new int[n][];
		int[] compare = new int[n];
		for(int i = 0;i < n;i++){
			int m;
			m = cin.nextInt();
			score[i] = new int[m];
			int sum = 0;
			for(int j = 0;j < m;j++){
				score[i][j] = cin.nextInt();
				sum+=score[i][j];
			}
			compare[i] = sum/m;
		}
		for(int i = 0;i < n-1;i++){
			for(int j = 0;j < n-1;j++){
				if(compare[j]>compare[j+1]){
					int t;
					int[] temp = new int[score[j].length];
					t = compare[j];
					temp = score[j];
					compare[j] = compare[j+1];
					score[j] = score[j+1];
					compare[j+1] = t;
					score[j+1] = temp;
				}
			}
		}
		for(int i = 0;i < n;i++){
			int j;
			for(j = 0;j < score[i].length-1;j++){
				System.out.print(score[i][j]+" ");
			}
			System.out.print(score[i][j]+"\n");
		}
	}
}
