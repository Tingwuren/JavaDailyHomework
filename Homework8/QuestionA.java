/*

题目A：查词典

题目描述：
现在有一本将汪星人语言翻译成喵星人语言的词典，请你写一段查该词典的程序。 

输入：
第一行为一个整数n(0<n<=1000)，后边是n行，每行均为两个用空格分隔的字符串，
前边的字符串代表喵星人的单词，后边的字符串代表汪星人的单词，
而且在词典中不会有某个汪星人的单词出现两次或两次以上。
从第n+2行开始有若干行（行数大于1且小于等于1000），每行均为一个字符串，
代表汪星人语言的文档，该文档最后一行一定是dog。
测试用例保证
1、输入中出现所有单词都只包含小写字母，而且长度不会超过10；
2、输入中只会在最后一行出现一次dog。

输出：
在输出中，你需要把输入文档翻译成喵星人语言，每行输出一个喵星人单词。
如果某个汪星人单词不在词典中，就把这个单词翻译成“dog”。 

样例输入：

3
mmm www
m w
mm ww
ww
wwww
w
dog

样例输出：

mm
dog
m

*/
import java.util.HashMap;
import java.util.Scanner;

public class QuestionA {
    private HashMap<String, String> dictionary;

    public QuestionA() {
        this.dictionary = new HashMap<>();
    }

    public void addTranslation(String catWord, String dogWord) {
        this.dictionary.put(dogWord, catWord);
    }

    public String translate(String word) {
        if (this.dictionary.containsKey(word)) {
            return this.dictionary.get(word);
        } else {
            return "dog";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuestionA translator = new QuestionA();

        // Read in dictionary
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String catWord = scanner.next();
            String dogWord = scanner.next();
            translator.addTranslation(catWord, dogWord);
        }

        // Translate words
        String word;
        while (!(word = scanner.next()).equals("dog")) {
            System.out.println(translator.translate(word));
        }

        scanner.close();
    }
}
