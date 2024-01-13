import java.util.Calendar;
import java.util.Scanner;
public class QuestionC{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		int month = sc.nextInt();
		sc.close();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.DATE, -1);
		int num = cal.get(Calendar.DATE);
		cal.add(Calendar.DATE, -(num - 1));
		//cal.set(Calendar.DATE, 1);
		//int date = cal.get(Calendar.DAY_OF_WEEK)-2;
		int date = cal.get(Calendar.DAY_OF_WEEK)-2;
		date = (date + 7)%7;
		//System.out.println(date);
		printfcal(date, num);
	}
	public static void printfcal(int date,int num){
		System.out.println(" Mon Tue Wed Thu Fri Sat Sun");
		int day = 1;
		month: for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (i == 0 && j < date) {
					System.out.print("    ");
					continue;
				}
				if (day > num) {
					System.out.println();
					break month;
				}
				if(day < 10)
					System.out.print("   " + day);
				else
					System.out.print("  " + day);
				day++;
			}
			System.out.println();
		}
	}
}
