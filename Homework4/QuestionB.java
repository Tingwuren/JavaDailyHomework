import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class QuestionB{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		try{
			String time = cin.next();
			DateTimeFormatter df = DateTimeFormatter.ofPattern(cin.next());
			LocalDate date = LocalDate.parse(time, df);
			String redate = date.format(DateTimeFormatter.ofPattern(cin.next()));
			System.out.println(redate);
		}catch(DateTimeParseException e){
			System.out.println("Text could not be parsed .");
		}
	}
}
