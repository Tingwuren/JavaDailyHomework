import java.util.Scanner;
import java.util.Arrays;
public class QuestionA{
	public static void main(String[] args){
		int n;
		int[] intArray;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		intArray = new int[n];
		for(int i = 0;i < n;i++){
			intArray[i] = sc.nextInt();
		}
		Arrays.sort(intArray);
		if(n%2 == 0){
			for(int i = 0;i < n/2;i++){
				if(intArray[i]%2 == 0)
					sum += intArray[i]/2;
				else if(intArray[i]%2 == 1)
					sum += (intArray[i]+1)/2;
			}
		}
		else if(n%2 == 1){
			for(int i = 0;i < (n+1)/2;i++){
				if(intArray[i]%2 == 0)
					sum += intArray[i]/2;
				else if(intArray[i]%2 == 1)
					sum += (intArray[i]+1)/2;
			}
		}
		sc.close();
		System.out.println(sum);
	}
}
