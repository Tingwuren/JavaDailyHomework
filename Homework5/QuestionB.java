import java.util.Scanner;
class Plural{
	float a;
	float b;
	float c;
	float d;
	public Plural(){
	}
	public Plural(float a,float b,float c,float d){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	void add(){
		float e = a + c;
		float f = b + d;
		if(f<0)
			System.out.printf("%.1f%.1fi\n",e,f);
		else
			System.out.printf("%.1f+%.1fi\n",e,f);
	}
	void sub(){
		float e = a - c;
		float f = b - d;
		if(f<0)
			System.out.printf("%.1f%.1fi\n",e,f);
		else
			System.out.printf("%.1f+%.1fi\n",e,f);
	}
	void mul(){
		float e = a*c - b*d;
		float f = b*c + a*d;
		if(f<0)
			System.out.printf("%.1f%.1fi\n",e,f);
		else
			System.out.printf("%.1f+%.1fi\n",e,f);
	}
	void div() throws ComplexDivException{
		if(c*c+d*d==0)
			throw new ComplexDivException("1001","Divide by zero.");
		float e = (a*c+b*d)/(c*c+d*d);
		float f = (b*c-a*d)/(c*c+d*d);
		if(f<0)
			System.out.printf("%.1f%.1fi\n",e,f);
		else
			System.out.printf("%.1f+%.1fi\n",e,f);
	}
}
class ComplexDivException extends Exception{
	String code;
	String message;
	public ComplexDivException(String code,String message){
		this.code = code;
		this.message = message;
	}
}
public class QuestionB{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String mod = sc.next();
		int n = sc.nextInt();
		switch(mod){
		case "add":
			for(int i =1;i<=n;i++){
				Plural plu = new Plural(sc.nextFloat(),sc.nextFloat(),sc.nextFloat(),sc.nextFloat());
				plu.add();
			}
			break;
		case "sub":
			for(int i=1;i<=n;i++){
				Plural plu = new Plural(sc.nextFloat(),sc.nextFloat(),sc.nextFloat(),sc.nextFloat());
				plu.sub();
			}
			break;
		case "mul":
			for(int i=1;i<=n;i++){
				Plural plu = new Plural(sc.nextFloat(),sc.nextFloat(),sc.nextFloat(),sc.nextFloat());
				plu.mul();
			}
			break;
		case "div":
			for(int i=1;i<=n;i++){
				Plural plu = new Plural(sc.nextFloat(),sc.nextFloat(),sc.nextFloat(),sc.nextFloat());
				try{
					plu.div();
				}
				catch(ComplexDivException e){
					System.out.println("Error No : "+e.code);
					System.out.println("Error Message : "+e.message);
					continue;
				}
			}
			break;
		}
		sc.close();
	}
}
