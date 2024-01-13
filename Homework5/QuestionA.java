import java.util.Scanner;
class Student{
	String studentNumber;
	String studentName;
	int markForMaths;
	int markForEnglish;
	int markForScience;
	public Student(String number, String name)throws StudentNumberException{
		boolean judge = false;
		if(number.length()!=10)
			throw new StudentNumberException();
		for(int i=2;i<10;i++){
			if(number.charAt(i)<'0'||number.charAt(i)>'9')
				judge = true;
		}
		if(number.charAt(0)!='2'||number.charAt(1)!='0'||
				judge == true)
			throw new StudentNumberException();
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
	void enterMarks(int markForMaths, int markForEnglish, int markForScience)throws ScoreException{
		if((markForMaths > 100 || markForMaths < 0)||
				(markForEnglish > 100 || markForMaths < 0)||
				(markForScience > 100 || markForScience <0))
			throw new ScoreException();
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
	double Average(){
		return (markForMaths+markForEnglish+markForScience)/3.0;
	}
	public String toString(){
		String m;
		m = "Student ID:"+studentNumber+"\n";
		m += "Name:"+studentName+"\n";
		m += "Math:"+markForMaths+"\n";
		m += "English:"+markForEnglish+"\n";
		m += "Science:"+markForScience+"\n";
		double a = (int)(Average()*10)/10.0;
		m += "Average Score:"+(int)((Average()+0.05)*10)/10.0+"\n";
		return m;
	}
}
class ScoreException extends Exception{
	public ScoreException(){
	}
}
class StudentNumberException extends Exception{
	public StudentNumberException(){
	}
}
public class QuestionA{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		try{
			Student test = new Student(cin.next(),cin.next());
			test.enterMarks(cin.nextInt(),cin.nextInt(),cin.nextInt());
			System.out.printf(test.toString());
			cin.close();
		}
		catch(StudentNumberException e){
			System.out.println("Illegal number format");
			System.exit(-1);
		}
		catch(ScoreException e){
			System.out.println("Illegal score format");
			System.exit(-1);
		}
	}
}
