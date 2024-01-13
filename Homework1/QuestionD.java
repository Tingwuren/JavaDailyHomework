/*
问题 D: 质数统计
1.题目描述：
现有若干行正整数，请你写一段程序分别统计每一行中有多少个质数。
2.输入：
第一行为一个整数n(0<n<=10)，代表测试用例行数。后边是n行，每行为若干个用空格分隔的正整数。这些正整数的最后是-1，表示此行结束。
3.输出：
为n行，每行一个整数，对应于输入的每一行中质数的个数。
测试用例保证输入合法，且所有整数可以用int存储。
4.样例输入：
2
37 54 18 92 39 45 8 84 75 15 33 83 85 54 81 33 89 -1
17 19 60 77 2 92 38 63 92 69 91 94 11 -1
5.样例输出： 
3
4
*/
/*
题目分析：
采用Scanner类进行数据的输入；
利用循环语句统计每一行的质数个数；
不需要建立数组存储每一行的数据；
一个数若不能被2~(n+1)/2之间的数整除，则它是质数；
*/
import java.util.Scanner;
public class QuestionD{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		int n;//总的行数
		int x;//当前遍历到的数
		int y;//当前行的质数个数
		int i,m,count;
		n = cin.nextInt();
		for(i=1,y=0;i<=n;i++){
			x=cin.nextInt();
			for(;x!=-1;x=cin.nextInt()){
				for(m=2,count=0;m<=(x+1)/2;m++){
					if(x%m==0)
						count++;
				}	
				if(count==0)
					y++;
			}//遍历一行			
			System.out.println(y);//输出当前行的质数个数
			y=0;
		}
		cin.close();
	}
}
