
/*
 * 问题B：集合运算
 * 
 * 题目描述：
 * 给出两个整数集合A、B，求出他们的交集、并集以及B在A中的余集。
 * 
 * 输入：
 * 第一行为一个整数n，表示集合A中的元素个数。
 * 第二行有n个互不相同的用空格隔开的整数，表示集合A中的元素。
 * 第三行为一个整数m，表示集合B中的元素个数。
 * 第四行有m个互不相同的用空格隔开的整数，表示集合B中的元素。
 * 集合中的所有元素均为int范围内的整数，n、m<=1000。	
 * 
 * 输出：
 * 第一行按从小到大的顺序输出A、B交集中的所有元素。
 * 第二行按从小到大的顺序输出A、B并集中的所有元素。
 * 第三行按从小到大的顺序输出B在A中的余集中的所有元素。
 * 
 * 样例输入：
5
1 2 3 4 5
5
2 4 6 8 10
 * 样例输出：
2 4
1 2 3 4 5 6 8 10
1 3 5
 */
import java.util.Scanner;//实现输入
import java.util.Set;//接口，无序、不重复元素集合
import java.util.TreeSet;
import java.util.HashSet;//存储集合并实现集合运算

class Compute {
    Set<Integer> setA;
    Set<Integer> setB;

    public Compute() {
    }

    public Set<Integer> storeA(int n) {
        this.setA = new HashSet<>(n);
        return setA;
    }

    public Set<Integer> storeB(int m) {
        this.setB = new HashSet<>(m);
        return setB;
    }

    public void compint() {
        Set<Integer> intersection = new TreeSet<>(setA);
        intersection.retainAll(setB);
        for (Integer num : intersection) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public void comuni() {
        Set<Integer> union = new TreeSet<>(setA);
        union.addAll(setB);
        for (Integer num : union) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public void comcom() {
        Set<Integer> complement = new TreeSet<>(setA);
        complement.removeAll(setB);
        for (Integer num : complement) {
            System.out.print(num + " ");
        }
    }
}
public class QuestionB {
    public static void main(String[] args) {
        try (// 存储A和B集合
        Scanner scanner = new Scanner(System.in)) {
            Compute compute = new Compute();
            // 存储A集合
            int n = scanner.nextInt();
            Set<Integer> setA = compute.storeA(n);
            for (int i = 1; i <= n; i++) {
                setA.add(scanner.nextInt());
            }
            // 存储B集合
            int m = scanner.nextInt();
            Set<Integer> setB = compute.storeB(n);
            for (int i = 1; i <= m; i++) {
                setB.add(scanner.nextInt());
            }

            // 按从小到大的顺序输出A、B交集中的所有元素
            compute.compint();

            // 按从小到大的顺序输出A、B并集中的所有元素
            compute.comuni();

            // 按从小到大的顺序输出B在A中的余集中的所有元素
            compute.comcom();
        }
    }
}