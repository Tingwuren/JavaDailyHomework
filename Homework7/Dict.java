import java.io.*;
import java.util.Scanner;
public class Dict{
	public static void main(String[] args) throws FileNotFoundException{
		 int a ;
		boolean b = true ;
		double c , f ;
		String d ;
		PrintWriter out = new PrintWriter("dict.dic");
		Scanner cin = new Scanner(System.in);

		for (int i = 0 ; i < 5 ; i ++ ) {
			a = cin.nextInt() ;
			f = Math.random() ;
			if ( f > 0.5 ) b = true ;
			else b = false ;
			c = cin.nextDouble() ;
			d = cin.next() ;
			out.println(a) ;
			out.println(b) ;
			out.println(c) ;
			out.println(d) ;
		}

		out.close(); // Remember this!
		cin.close();
	}
}

