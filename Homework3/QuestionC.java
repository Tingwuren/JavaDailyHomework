import java.util.Scanner;
class Student{
	String studentNumber;
	String studentName;
	int markForMaths;
	int markForEnglish;
	int markForScience;
	public Student(String number, String name){
		studentNumber = number;
		studentName = name;
	}
	public Student(){
	}
	public String getNumber(){
		return studentNumber;
	}
	public String getName(){
		return studentName;
	}
	void enterMarks(int markForMaths, int markForEnglish, int markForScience){
		this.markForMaths = markForMaths;
		this.markForEnglish = markForEnglish;
		this.markForScience = markForScience;
	}
	int getMathsMark(){
		return markForMaths;
	}
	int getEnglishMark(){
		return markForEnglish;
	}
	int getScienceMark(){
		return markForScience;
	}
	double calculateAverage(){
		return (markForMaths+markForEnglish+markForScience)/3.0;
	}
	public String toString(){
		String m;
		m = "Student ID:"+studentNumber+"\n";
		m += "Name:"+studentName+"\n";
		m += "Math:"+markForMaths+"\n";
		m += "English:"+markForEnglish+"\n";
		m += "Science:"+markForScience+"\n";
		double a = (int)(caculateAverage()*10)/10.0;
		m += "Average Score:"+(int)((calculateAverage()+0.05)*10)/10.0+"\n";
		return m;
	}
}
public class QuestionC{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		Student test = new Student(cin.next(),cin.next());
		test.enterMarks(cin.nextInt(),cin.nextInt(),cin.nextInt());
		System.out.printf(test.toString());
		cin.close();
	}
}
