import java.util.Scanner;

interface Discount{
	public int discount(int price);
}

interface Ticket{
	public String ticket();
}

class Soldier implements Discount{
	public int discount(int price){
		return 0;
	}
}

class Child implements Discount{
	public int discount(int price){
		return price - 30;
	}
}

class Student implements Discount{
	public int discount(int price){
		return price * 8 / 10;
	}
}

class Adult implements Discount{
	public int discount(int price){
		return price;
	}
}

class Paper implements Ticket{
	public String ticket(){
		return "PaperTicket";
	}
}

class Electronical implements Ticket{
	public String ticket(){
		return "E_ticket";
	}
}

class ParkTicket{
	private Discount d;
	private Ticket t;

	public ParkTicket(Discount d, Ticket t){
		this.d = d;
		this.t = t;
	}

	public int getPrice(int price){
		return d.discount(price);
	}

	public String getTicket(){
		return t.ticket();
	}
}

public class QuestionB{
	public static void main(String[] args){
		int price;
		Scanner sc = new Scanner(System.in);
		price = sc.nextInt();
		int n;
		n = sc.nextInt();
		for(int i = 1;i <= n;i ++){
			String discount = sc.next();
			String kind = sc.next();
			//System.out.println(discount+kind);
			switch(discount){
			case "soldier":
				if(kind.equals("paper")){
					ParkTicket pt = new ParkTicket(new Soldier(),new Paper());
					System.out.println(pt.getTicket());
					System.out.println("Price:"+pt.getPrice(price));
				}
				if(kind.equals("electronical")){
					ParkTicket pt = new ParkTicket(new Soldier(),new Electronical());
					System.out.println(pt.getTicket());
					System.out.println("Price:"+pt.getPrice(price));
				}
				break;
			case "children":
				if(kind.equals("paper")){
					ParkTicket pt = new ParkTicket(new Child(),new Paper());
					System.out.println(pt.getTicket());
					System.out.println("Price:"+pt.getPrice(price));
				}
				if(kind.equals("electronical")){
					ParkTicket pt = new ParkTicket(new Child(),new Electronical());
					System.out.println(pt.getTicket());
					System.out.println("Price:"+pt.getPrice(price));
				}
				break;
			case "adult":
				if(kind.equals("paper")){
					ParkTicket pt = new ParkTicket(new Adult(),new Paper());
					System.out.println(pt.getTicket());
					System.out.println("Price:"+pt.getPrice(price));
				}
				if(kind.equals("electronical")){
					ParkTicket pt = new ParkTicket(new Adult(),new Electronical());
					System.out.println(pt.getTicket());
					System.out.println("Price:"+pt.getPrice(price));
				}
				break;
			case "student":
				if(kind.equals("paper")){
					ParkTicket pt = new ParkTicket(new Student(),new Paper());
					System.out.println(pt.getTicket());
					System.out.println("Price:"+pt.getPrice(price));
				}
				if(kind.equals("electronical")){
					ParkTicket pt = new ParkTicket(new Student(),new Electronical());
					System.out.println(pt.getTicket());
					System.out.println("Price:"+pt.getPrice(price));
				}
				break;
			}	
		}
		sc.close();
	}
}