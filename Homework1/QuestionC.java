/*
问题 C: 求三角形的面积
1.问题描述
已知三角形的三条边长a、b、c，求三角形的面积。三角形的面积可以根据海伦公式来计算，这里S代表周长的一半，Area代表三角形的面积：
S=(A+B+C)/2 
Area=(S(S-a)(S-b)(S-c))1/2
在java中求一个数的平方根可以用函数Math.sqrt(x)。参数x尽量使用双精度浮点型(double型)变量，避免使用单精度浮点型(float 型)变量。
输出x并保留3位小数可以这样写：System.out.printf("%.3f\n", x);
2.输入：包括三个正整数a、b、c，即三角形的三边长度。
3.输出：当输入的三条边a、b、c可以构成三角形时（即两条边的长度和大于第三条边的长度）输出三角形的面积，输出结果保留3位小数，假如a=5,b=12,c=13，则输出“30.000”；当a、b、c三条边无法构成三角形时,则输出“The edges cannot make up of a triangle.”
4.样例输入：5 12 13
5.样例输出：30.000
*/
import java.util.Scanner;
import java.lang.Math;
public class QuestionC{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		double x;
		double S,Area;
		int a,b,c;
		a = cin.nextInt();
		b = cin.nextInt();
		c = cin.nextInt();
		if(a+b<=c||a+c<=b||b+c<=a)
			System.out.println("The edges cannot make up of a triangle.");
		else{
			S=(a+b+c)/2f;
			x=S*(S-a)*(S-b)*(S-c);
			Area=Math.sqrt(x);
			System.out.printf("%.3f\n", Area);
		}
        cin.close();
	}
}