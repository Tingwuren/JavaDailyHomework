/*
问题 E: 24点
1.题目描述：
“24点”是一种扑克牌游戏。具体玩法是一副牌中抽去大小王剩下52张，任意抽取4张牌，利用四则运算把牌面上的数算成24。每张牌能且只能用一次。如5、1、7、1，可以用（5-1）×（7-1）或（5+7）×（1+1）两种方法得到。
经计算机准确计算，一副牌（54张,其中去掉两张王牌）中，任意抽取4张可有1820种不同组合，其中有458个牌组算不出24点，如1、1、1、5。
现我们将规则修改如下：1、每次是5张牌；2、只能用加法或减法，不允许用乘法和除法；3、5张牌不要求都用，但如果要用只能用一次；4、牌面点数的范围是大于等于-30且小于等于30。
现在就请你写一段程序来判断某5张牌是否能算出24点。
2.输入：
第一行为一个整数T(0<T<20),代表测试数据组数。后边是T行，每行均为5个用空格分隔的整数（每个整数都大于等于-30且小于等于30），代表牌点。
3.输出：
为T行，每行对应前边的T组测试数据，如果根据规则能算出24则该行输出YES，否则输出NO。
4.样例输入：
2
6 6 6 6 6
5 5 5 5 5
5.样例输出：
YES
NO
*/
/*
问题分析：
1.使用Scanner类进行输入；
2.将能组成24点的情况分类：
1）一张牌组成24点；
2）两张牌组成24点；
3）三张牌组成24点；
4）四张牌组成24点；
5）五张牌组成24点；
3.分别用1、-1、0乘以这五个数，并将结果相加，则有3的5次方种情况；
4.用二维数组存储元素；
*/
/*
调试过程：
1）sum需要在每次计算前初始化
2）系数数组multiply需要在每行开始的时候初始化
*/
import java.util.Scanner;
public class QuestionE{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		int T;
		T = cin.nextInt();//输入数据行数
		int[][] myArray = new int[T][5];
		for(int i = 0;i < T;i++){
			for(int j = 0;j < myArray[i].length;j++){
				myArray[i][j] = cin.nextInt();
			}
		}//输入二维数组，存储多组五张牌
		cin.close();
		boolean is24 = false;
		int sum = 0;
		int[] multiply = new int[5];//声明系数数组
		//for(int i = 0;i < multiply.length;i++){
		//	multiply[i]=-1;
		//}//系数数组初始化为全-1
		int count = 0;
		int mod,temp,m;//三个变量用于转换三进制数
		//遍历每一行
		for(int i = 0;i < T;i++){
			for(int j = 0;j < 5;j++){
				multiply[j] = -1;
			}
			//每一行遍历243次，即3的5次方次
			for(count = 0;count < 243;count++){
				//System.out.println("count:"+count);
				sum = 0;
				for(temp = count,m = 0;temp > 0&&m < 5;temp = temp/3,m++){
					mod = temp%3;
					multiply[m] = mod-1;
				}//将count转换为三进制数，并将低位赋予系数数组的低位
				for(int j = 0;j < 5;j++){
					sum += myArray[i][j]*multiply[j];
					//System.out.println("multiply["+j+"]:"+multiply[j]);
				}
				//System.out.println("sum:"+sum);
				if(sum == 24){
					is24 = true;
					break;
				}
			}
			if(is24 == true){
                        	System.out.println("YES");
				is24 = false;
			}
                	else if(is24 == false)
                        	System.out.println("NO");
		}
	}
}