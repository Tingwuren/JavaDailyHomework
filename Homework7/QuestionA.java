//read file
import java.util.Scanner;
import java.io.*;
class Readout{
    public int readline;
    public Readout(int times){
        readline = 1 + (times - 1) * 4;
    }
    public void out() throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("dict.dic") );
        try (LineNumberReader reader = new LineNumberReader(in)) {
            String s = reader.readLine();
            while(s != null){
                if(reader.getLineNumber() == readline){
                    for(int count = 0; count < 4;count ++){
                        System.out.println(s);
                        s = reader.readLine();
                    }
                    //System.out.println(s);
                    System.exit(0);
				}
				s = reader.readLine();
            }
			in.close();
        }
    }
}
class QuestionA{
    public static void main(String[] args) throws IOException{
        int times;
        Scanner sc = new Scanner(System.in);
        times = sc.nextInt();
        Readout r = new Readout(times);
        r.out();
        sc.close();
    }
}
