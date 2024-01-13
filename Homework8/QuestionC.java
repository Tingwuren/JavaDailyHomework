/*
 * 问题 C: 括号匹配二
 * 
 * 题目描述：
 * 假设表达式中包含三种括号：(),[],{}。
 * 其嵌套顺序随意，即 () 或 {[{}]} 均为正确格式， [(])或 (()]均为不正确格式。
 * 现给出一个只包含这三种括号的括号序列，试判断该括号序列是否合法。	
 * 
 * 输入：
 * 只包含一行，为只包含(),[],{}的括号序列。（序列长度不超过100个字符）
 * 
 * 输出：
 * 若括号序列合法，输出”YES”，反之输出”NO”。
 * 
 * 样例输入：
 * {([]())}
 * 
 * 样例输出：
 * YES
 */
import java.util.Scanner;
import java.util.Stack;
public class QuestionC {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String str = sc.next();
            if(isValid(str)){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); // 创建一个栈用于存储左括号
        for(char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
