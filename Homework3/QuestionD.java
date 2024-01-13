import java.util.Scanner;
class StudentList{
	Student[] list;
	static int total;
	public StudentList(int length){
		list = new Student[length];
	}
	public StudentList(){
	}
	boolean add(Student stu){ //增加stu到数组中，成功，返回true，否则false
		if(total < list.length){
			list[total] = new Student();
			list[total] = stu;
			total++;
			return true;
		}
		else
			return false; 
			
	}
	boolean remove(String number){ //删除学号为number的学生，删除成功，返回true，否则false
		int search;
		int m,n;
		for(search = 0;search < total;search++){
			if(list[search].studentNumber.equals(number))
				break;
		}
		if(search == total)
			return false;
		else{
			for(;search < total-1;search++){
				list[search] = list[search+1];
			}
			total--;
			return true;
		}
	}
	boolean updateItem(String number,int math,int english,int science){
		int search;
		for(search = 0;search < total;search++){
			if(list[search].studentNumber.equals(number))
				break;
		}
		if(search == total)
			return false;
		else{
			list[search].markForMaths = math;
			list[search].markForEnglish = english;
			list[search].markForScience = science;
			return true;
		}
	}
	boolean isEmpty(){
		if(total == 0)
			return true;
		else
			return false;
	}
	int getTotal(){ //返回学生总人数
		return total;
	}
	Student getItem(String number){ //返回学号为number的学生，若该生不存在，返回null
		int search;
		for(search = 0;search < total;search++){
			if(list[search].studentNumber.equals(number))
				break;
		}
		if(search == total)
			return null;
		else{
			Student s = new Student();
			s.studentNumber = list[search].studentNumber;
			s.studentName = list[search].studentName;
			s.markForMaths = list[search].markForMaths;
			s.markForEnglish = list[search].markForEnglish;
			s.markForScience = list[search].markForScience;
			return s;
		}
	}
}
public class QuestionD{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		StudentList list = new StudentList(n);
		for(int i = 1;i <= n;i++){
			int choice = cin.nextInt();
			switch(choice){
				case 1://添加学生信息
					//System.out.println("Case1:");
					Student m = new Student(cin.next(),cin.next());
					m.enterMarks(cin.nextInt(),cin.nextInt(),cin.nextInt());
					if(list.getItem(m.studentNumber) != null){
						System.out.println("Students already exist");
						break;
					}
					if(list.add(m)){
						System.out.println("Add success");
						break;
					}
				case 2://删除学生信息
					String destu = cin.next();
					if(list.remove(destu)){
						System.out.println("Delete success");
						break;
					}
					else{
						System.out.println("Students do not exist");
						break;
					}
				case 3://更改学生成绩信息
					if(list.updateItem(cin.next(),cin.nextInt(),cin.nextInt(),cin.nextInt())){
						System.out.println("Update success");
						break;
					}
					else{
						System.out.println("Students do not exist");
						break;
					}
				case 4://显示学生平均分成绩
					Student l = list.getItem(cin.next());
					if(l == null){
						System.out.println("Students do not exist");
						break;
					}
					else{
						System.out.printf(l.toString());
						break;
					}
				case 5://判断是否为空
					if(list.isEmpty()){
						System.out.println("List is empty");
						break;
					}
					else{
						System.out.println("List is not empty");
						break;
					}
				case 6://输出学生总人数
					System.out.println(list.getTotal());
					break;
			}
		}
	}
}
