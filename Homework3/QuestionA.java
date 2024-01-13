import java.util.Scanner;
class Clock{
	int T;
	int hour(){
		return T/3600;
	}
	int minute(){
		return (T%3600)/60;
	}
	int second(){
		return T%60;
	}
	public void setT(int T){
		this.T = T;
	}
}
public class QuestionA{
	public static void main(String[] args){ 
		int n;
		int hour;
		int minute;
		int second;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		Clock c = new Clock();
		for (int i = 0;i < n;i ++){
			c.setT(cin.nextInt());
			hour = c.hour();
			minute = c.minute();
			second = c.second();
			System.out.println(hour+":"+minute+":"+second);
		}
		cin.close();
	}
}
