import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Card implements Comparable<Card> {//一张扑克牌，用Comparable接口实现Card的排序功能
    private String suit;//该牌的花色
    private String point;//该牌的点数

    public Card(String suit, String point) {//构造方法
        this.suit = suit;
        this.point = point;
    }

    @Override
    public String toString() {//toString方法
        if (point.equals("A")) {
            return suit + " 1 11";
        } else if (point.equals("J") || point.equals("Q") || point.equals("K")) {
            return suit + " 10";
        } else {
            return suit + " " + point;
        }
    }

    public int getValue() {//牌数值的get方法
        if (point.equals("A")) {
            return 11;
        } else if (point.equals("J") || point.equals("Q") || point.equals("K")) {
            return 10;
        } else {
            return Integer.parseInt(point);//将字符串转换为对应的整数
        }
    }

    public int getOrder() {//牌面顺序的get方法
        if (point.equals("A")) {
            return 1;
        } else if (point.equals("J")) {
            return 11;
        } else if (point.equals("Q")) {
            return 12;
        } else if (point.equals("K")) {
            return 13;
        } else {
            return Integer.parseInt(point);//将字符串转换为对应的整数
        }
    }
    public String getSuit() {//牌花色的get方法
        return suit;
    }

    @Override
    public int compareTo(Card other) {//比较两张牌的顺序
        if(this.getOrder() > other.getOrder()) {
            return 1;
        } else if(this.getOrder() < other.getOrder()) {
            return -1;
        } else {
            if (this.getSuit().equals(other.getSuit())) {//牌面和花色都相同
                return -1;
            } else if (this.getSuit().equals("Spade")) {
                return -1;
            } else if (this.getSuit().equals("Heart")) {
                if(other.getSuit().equals("Spade")) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (this.getSuit().equals("Diamond")) {
                if (other.getSuit().equals("Club")) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }

    public String getPoint() {//
        return point;
    }
}

class Hand {//一手牌
    private List<Card> cards;//一手牌

    public Hand() {//构造方法
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {//添加手牌
        cards.add(card);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();//提高连接字符串效率
        Collections.sort(cards);//将手牌排序
        for(Card card : cards) {
            sb.append(card.getSuit()+card.getPoint()).append(" ");
        }
        return sb.toString().trim();//转换为字符串并去掉首尾空格
    }

    public int getValue() {//计算点数
        int value = 0;//点数
        int aces = 0;//手牌中的A的数量
        for (Card card : cards) {
            value += card.getValue();
            if (card.getValue() == 11) {
                aces++;
            }
        }
        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }
        return value;
    }

    public int size() {
        return cards.size();
    }
}

public class QuestionE {
    public static void main(String[] args) {
        Hand hand = new Hand();
        try (Scanner sc = new Scanner(System.in)) {
            hand.addCard(new Card(sc.next(), sc.next()));//添加第一张牌
            hand.addCard(new Card(sc.next(), sc.next()));//添加第二张牌
            while (hand.getValue() < 17 && hand.size() <= 9) {//如果总点数小于17则继续要下一张牌
                System.out.println("Hit");//要下一张牌
                String addsuit = sc.next();
                String addpoint = sc.next();
                Card addcard = new Card(addsuit, addpoint);
                hand.addCard(addcard);//添加下一张牌
                System.out.println(addcard);//输出该牌的花色与点数
            }
        }
        System.out.println("Stand");//不再要牌
        System.out.println(hand);//输出手牌
        if (hand.getValue() > 21) {//总点数超过21点
            System.out.println("Bust");
        } else if (hand.size() == 2 && hand.getValue() == 21) {//总点数为21点且总牌数是2
            System.out.println("Blackjack");
        } else {//总点数小于21点，或者总点数等于21点但总牌数多于2点
            System.out.println(hand.getValue());
        }
    }
}
