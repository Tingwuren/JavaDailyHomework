import java.util.Scanner;
class Fraction{
	int nume;
	int deno;
	public void setNume(int nume){
		this.nume = nume;
	}
	public void setDeno(int deno){
		this.deno = deno;
	}
}
class Compute{
	public static String fraction(Fraction a){
		Compute.approxpoints(a);
		return a.nume+"/"+a.deno;
	}
	public static void approxpoints(Fraction a){
		int m;
		int n;
		if (a.nume < 0)
			m = -a.nume;
		else
			m = a.nume;
		if (a.deno < 0)
			n = -a.deno;
		else
			n = a.deno;
		if (m < n) {// 保证m>n,若m<n,则进行数据交换
			int temp = m;
			m = n;
			n = temp;
		}
		while (m % n != 0) {// 在余数不能为0时,进行循环
			int temp = m % n;
			m = n;
			n = temp;
		}
		a.nume = a.nume/n;
		a.deno = a.deno/n;
		if (a.nume < 0&&a.deno < 0){
			a.nume = -a.nume;
			a.deno = -a.deno;
		}
		if(a.nume > 0&&a.deno < 0){
			a.nume = -a.nume;
			a.deno = -a.deno;
		}
	}
	public static String plus(Fraction a,Fraction b){
		Fraction c = new Fraction();
		c.nume = a.nume*b.deno+a.deno*b.nume;
		c.deno = a.deno*b.deno;
		Compute.approxpoints(c);
		return c.nume+"/"+c.deno;
	}
	public static String sub(Fraction a, Fraction b){
		Fraction c = new Fraction();
		c.nume = a.nume*b.deno-a.deno*b.nume;
		c.deno = a.deno*b.deno;
		Compute.approxpoints(c);
		return c.nume+"/"+c.deno;
	}
	public static String mult(Fraction a,Fraction b){
		Fraction c = new Fraction();
		c.nume = a.nume*b.nume;
		c.deno = a.deno*b.deno;
		Compute.approxpoints(c);
		return c.nume+"/"+c.deno;
	}
	public static String div(Fraction a,Fraction b){
		Fraction c = new Fraction();
		c.nume = a.nume*b.deno;
		c.deno = a.deno*b.nume;
		Compute.approxpoints(c);
		return c.nume+"/"+c.deno;
	}
	public static String reci(Fraction a){
		Fraction c = new Fraction();
		c.nume = a.deno;
		c.deno = a.nume;
		Compute.approxpoints(c);
		return c.nume+"/"+c.deno;
	}
	public static float deci(Fraction a){
		float m = a.nume;
		float n = a.deno;
		return m/n;
	}
}
public class QuestionB{
	public static void main(String[] args){
		Fraction a = new Fraction();
		Fraction b = new Fraction();
		Scanner cin = new Scanner(System.in);
		a.setNume(cin.nextInt());
		a.setDeno(cin.nextInt());
		b.setNume(cin.nextInt());
		b.setDeno(cin.nextInt());
		System.out.println(Compute.fraction(a));
		System.out.println(Compute.fraction(b));
		System.out.println(Compute.plus(a,b));
		System.out.println(Compute.sub(a,b));
		System.out.println(Compute.mult(a,b));
		System.out.println(Compute.div(a,b));
		System.out.println(Compute.reci(a));
		float c = Compute.deci(a);
		System.out.printf("%.1f\n",c);
		cin.close();
	}
}
