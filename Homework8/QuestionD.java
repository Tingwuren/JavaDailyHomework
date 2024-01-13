import java.util.Scanner;
import java.util.TreeMap;
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

class EmployeeException extends Exception {
    private int code;
    private String message;

    public EmployeeException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

class Factory {
    private TreeMap<String, Employee> employees;

    public Factory() {
        employees = new TreeMap<>();
    }

    public Employee getEmployee(String empSecNum) throws EmployeeException {
        if (employees.containsKey(empSecNum)) {
            return employees.get(empSecNum);
        } else {
            throw new EmployeeException(1004, "employee not found.");
        }
    }

    public Employee deleteEmployee(String empSecNum) throws EmployeeException {
        if (employees.containsKey(empSecNum)) {
            return employees.remove(empSecNum);
        } else {
            throw new EmployeeException(1002, "employee not found.");
        }
    }

    public Employee addEmployee(Employee emp) throws EmployeeException {
        if (employees.containsKey(emp.getSocialSecurityNumber())) {
            throw new EmployeeException(1001, "employee exists.");
        } else {
            employees.put(emp.getSocialSecurityNumber(), emp);
            return emp;
        }
    }

    public Employee updateEmployee(String empSecNum, Employee emp) throws EmployeeException {
        if (employees.containsKey(empSecNum)) {
            employees.put(empSecNum, emp);
            return emp;
        } else {
            throw new EmployeeException(1003, "employee not found.");
        }
    }

    public void printEmployees() {
        for (Employee emp : employees.values()) {
            //System.out.println(emp.toString() + emp.earning());
            System.out.printf("%s%.2f\n",emp.toString(),emp.earning());
        }
    }
}

public class QuestionD {
    public static void main(String[] args) {
        Factory factory = new Factory();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String command = scanner.next();

                try {
                    if (command.equals("add")) {
                        int type = scanner.nextInt();
                        String firstName = scanner.next();
                        String lastName = scanner.next();
                        String socialSecurityNumber = scanner.next();

                        if (type == 0) {
                            double weeklySalary = scanner.nextDouble();
                            Employee emp = new SalaridEmployee(firstName, lastName, socialSecurityNumber, weeklySalary);
                            factory.addEmployee(emp);
                            //System.out.println(emp.toString() + emp.earning());
                            System.out.printf("%s%.2f\n",emp.toString(),emp.earning());
                        } else if (type == 1) {
                            double wage = scanner.nextDouble();
                            double hours = scanner.nextDouble();
                            Employee emp = new HourlyEmployee(firstName, lastName, socialSecurityNumber, wage, hours);
                            factory.addEmployee(emp);
                            //System.out.println(emp.toString() + emp.earning());
                            System.out.printf("%s%.2f\n",emp.toString(),emp.earning());
                        } else if (type == 2) {
                            double grossSales = scanner.nextDouble();
                            double commissionRate = scanner.nextDouble();
                            Employee emp = new CommisionEmployee(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
                            factory.addEmployee(emp);
                            //System.out.println(emp.toString() + emp.earning());
                            System.out.printf("%s%.2f\n",emp.toString(),emp.earning());
                        } else if (type == 3) {
                            double grossSales = scanner.nextDouble();
                            double commissionRate = scanner.nextDouble();
                            double baseSalary = scanner.nextDouble();
                            Employee emp = new basePlusCommisionEmployee(firstName, lastName, socialSecurityNumber, grossSales, commissionRate, baseSalary);
                            factory.addEmployee(emp);
                            //System.out.println(emp.toString() + emp.earning());
                            System.out.printf("%s%.2f\n",emp.toString(),emp.earning());
                        }
                    } else if (command.equals("get")) {
                        String empSecNum = scanner.next();
                        Employee emp = factory.getEmployee(empSecNum);
                        //System.out.println(emp.toString() + emp.earning());
                        System.out.printf("%s%.2f\n",emp.toString(),emp.earning());
                        
                    } else if (command.equals("delete")) {
                        String empSecNum = scanner.next();
                        Employee emp = factory.deleteEmployee(empSecNum);
                        //System.out.println(emp.toString() + emp.earning());
                        System.out.printf("%s%.2f\n",emp.toString(),emp.earning());
                    } else if (command.equals("update")) {
                        int type = scanner.nextInt();
                        String firstName = scanner.next();
                        String lastName = scanner.next();
                        String socialSecurityNumber = scanner.next();
                        double grossSales = 0;
                        double commissionRate = 0;
                        double baseSalary = 0;
                        double weeklySalary = 0;
                        double wage = 0;
                        double hours = 0;

                        if (type == 0) {
                            weeklySalary = scanner.nextDouble();
                            Employee emp = new SalaridEmployee(firstName, lastName, socialSecurityNumber, weeklySalary);
                            factory.updateEmployee(socialSecurityNumber, emp);
                            //System.out.println(emp.toString() + emp.earning());
                            System.out.printf("%s%.2f\n",emp.toString(),emp.earning());
                        } else if (type == 1) {
                            wage = scanner.nextDouble();
                            hours = scanner.nextDouble();
                            Employee emp = new HourlyEmployee(firstName, lastName, socialSecurityNumber, wage, hours);
                            factory.updateEmployee(socialSecurityNumber, emp);
                            //System.out.println(emp.toString() + emp.earning());
                            System.out.printf("%s%.2f\n",emp.toString(),emp.earning());
                        }else if (type == 2) {
                            grossSales = scanner.nextDouble();
                            commissionRate = scanner.nextDouble();
                            Employee emp = new CommisionEmployee(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
                            factory.updateEmployee(socialSecurityNumber, emp);
                            //System.out.println(emp.toString() + emp.earning());
                            System.out.printf("%s%.2f\n",emp.toString(),emp.earning());
                        } else if (type == 3) {
                            grossSales = scanner.nextDouble();
                            commissionRate = scanner.nextDouble();
                            baseSalary = scanner.nextDouble();
                            Employee emp = new basePlusCommisionEmployee(firstName, lastName, socialSecurityNumber, grossSales, commissionRate, baseSalary);
                            factory.updateEmployee(socialSecurityNumber, emp);
                            //System.out.println(emp.toString() + emp.earning());
                            System.out.printf("%s%.2f\n",emp.toString(),emp.earning());
                        }
                    } else if (command.equals("print")) {
                        factory.printEmployees();
                    } else if (command.equals("exit")) {
                        break;
                    }
                } catch (EmployeeException e) {
                    System.out.println(e.getCode());
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
