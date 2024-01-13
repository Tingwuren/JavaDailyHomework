import java.util.Scanner;
import java.util.Arrays;
//import java.util.Collections;
import java.lang.Comparable;

abstract class Employee implements Comparable<Employee>{
	public String firstName;
	public String lastName;
	public String socialSecurityNumber;
	public abstract double earning();
	public Employee(String firstName,String lastName,String socialSecurityNumber){
		this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public String getFirstName(){
		return firstName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public String getLastName(){
		return lastName;
	}
	public String getSocialSecurityNumber(){
		return socialSecurityNumber;
	}
	@Override
	public int compareTo(Employee e){
		if(this.earning() < e.earning())
			return -1;
		else if(this.earning() == e.earning())
			return 0;
		else
			return 1;
	}
}

class SalaridEmployee extends Employee{
	public double weeklySalary;
	public double earning(){
		return 4 * weeklySalary;
	}
	public SalaridEmployee(String firstName,String lastName,String socialSecurityNumber,double weeklySalary){
		super(firstName,lastName,socialSecurityNumber);
		this.weeklySalary = weeklySalary;
	}
	public String toString(){
        return "firstName:"+firstName+"; lastName:"+lastName+"; socialSecurityNumber:"+socialSecurityNumber+"; earning:";
	}
	public void setWeeklySalary(double weeklySalary){
		this.weeklySalary= weeklySalary;
	}
	public double getWeeklySalary(){
		return weeklySalary;
	}
}

class HourlyEmployee extends Employee{
	public double wage;
	public double hours;
	public double earning(){
		return wage * hours;
	}
	public HourlyEmployee(String firstName,String lastName,String socialSecurityNumber,double wage, double hours){
		super(firstName,lastName,socialSecurityNumber);
		this.wage = wage;
		this.hours = hours;
	}
	public String toString(){
        return "firstName:"+firstName+"; lastName:"+lastName+"; socialSecurityNumber:"+socialSecurityNumber+"; earning:";
    }
	public void setWage(double wage){
		this.wage = wage;
	}
	public double getWage(){
		return wage;
	}
	public void setHours(double hours){
        this.hours = hours;
    }
    public double getHours(){
        return hours;
    }
}

class CommisionEmployee extends Employee{
	public double grossSales;
	public double commissionRate;
	public double earning(){
		return grossSales * commissionRate;
	}
	public CommisionEmployee(String firstName,String lastName,String socialSecurityNumber,double grossSales, double commissionRate){
		super(firstName,lastName,socialSecurityNumber);
		this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }
    public String toString(){
        return "firstName:"+firstName+"; lastName:"+lastName+"; socialSecurityNumber:"+socialSecurityNumber+"; earning:";
    }
	public void setGrossSales(double grossSales){
        this.grossSales = grossSales;
    }
    public double getGrossSales(){
        return grossSales;
    }
    public void setCommissionRate(double commissionRate){
        this.commissionRate = commissionRate;
    }
    public double getCommissionRate(){
        return commissionRate;
    }
}

class basePlusCommisionEmployee extends CommisionEmployee{
	public double baseSalary;
	public double earning(){
		return grossSales * commissionRate + baseSalary;
	}
	public basePlusCommisionEmployee(String firstName,String lastName,String socialSecurityNumber,double grossSales, double commissionRate,double baseSalary){
		super(firstName,lastName,socialSecurityNumber,grossSales,commissionRate);
		this.baseSalary = baseSalary;
    }
    public String toString(){
        return "firstName:"+firstName+"; lastName:"+lastName+"; socialSecurityNumber:"+socialSecurityNumber+"; earning:";
    }
	public void setBaseSalary(double baseSalary){
        this.baseSalary = baseSalary;
    }
    public double getBaseSalary(){
        return baseSalary;
    }
}

public class QuestionA{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Employee[] employee;
		int n = sc.nextInt();
		employee = new Employee[n];
		for(int i = 0;i < n;i ++){
			int kind = sc.nextInt();
			switch(kind){
			case 0:
				employee[i] = new SalaridEmployee(sc.next(),sc.next(),sc.next(),sc.nextDouble());
				break;
			case 1:
				employee[i] = new HourlyEmployee(sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.nextDouble());
				break;
			case 2:
				employee[i] = new CommisionEmployee(sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.nextDouble());
				break;
			case 3:
				employee[i] = new basePlusCommisionEmployee(sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
				break;
			}
		}
		//Collections.sort(employee);
		Arrays.sort(employee);
		int m = sc.nextInt();
		for(int j = 0;j < m;j++){
			int inquire = sc.nextInt();
			switch(inquire){
			case 0:
				String name = sc.next();
				for(int a = 0;a < n;a ++){
					if(name.equals(employee[a].firstName)){
						double earning = employee[a].earning();
						//System.out.println(employee[a].toString()+earning);
						System.out.printf("%s%.2f\n",employee[a].toString(),earning);
					}
				}
				break;
			case 1:
				String number = sc.next();
				for(int b = 0;b < n;b ++){
					if(number.equals(employee[b].socialSecurityNumber)){
						double earning = employee[b].earning();
						//System.out.println(employee[b].toString()+earning);
						System.out.printf("%s%.2f\n",employee[b].toString(),earning);
					}
				}
				break;
			}
		}
		sc.close();
	}
}
/*
测试用例1：
4
0 Ai Meng 2012673901 4312
1 NanXiong Qimu 2016782340 15.2 200
2 Guo Yang 2017672347 46781.3 0.1
3 Rong Huang 2018768901 7854.4 0.28 7098
4
0 Ai
1 2016782340
1 2018768901
0 Guo

测试用例2：
4
0 Ai Meng 2012673901 4312
1 Ai Qimu 2016782340 15.2 200
2 Guo Yang 2017672347 46781.3 0.1
3 Ai Huang 2018768901 7854.4 0.28 7098
4
0 Ai
1 2016782340
1 2018768901
0 Guo
 */
