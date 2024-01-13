//package Homework2;
import java.util.Scanner;
public class QuestionB{
	public static void main(String[] args){
		int n;
		int m;
		int[] a;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();
		a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = cin.nextInt();
		}
		int[] b = new int[n];
		System.arraycopy(a,m,b,0,n-m);
		System.arraycopy(a,0,b,n-m,m);
		for(int i : b){
			System.out.print(i+" ");
		}
		System.out.print("\n");	
		cin.close();
	}
}
