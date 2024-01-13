//read file
import java.util.Scanner;
import java.io.*;
class Readout{
    public int readline;
    public Readout(int times){
        readline = times;
    }
    public void out() throws IOException{
        String fileName = "dictb.dic";
        try {          
            DataInputStream instr = new DataInputStream(
            new BufferedInputStream(new FileInputStream( fileName )));
            int i = instr.readInt();
            boolean b = instr.readBoolean();
            double d = instr.readDouble();
            String s = instr.readUTF();
            for(int count = 1;count < readline;count ++){
                i = instr.readInt();
                b = instr.readBoolean();
                d = instr.readDouble();
                s = instr.readUTF();
            }
            System.out.println(i);
            System.out.println(b);
            System.out.println(d);
            System.out.println(s);
            instr.close();
        }
        catch ( IOException iox ) {
             System.out.println("Problem reading " + fileName ); 
        }   
    }
}
class QuestionB{
    public static void main(String[] args) throws IOException{
        int times;
        Scanner sc = new Scanner(System.in);
        times = sc.nextInt();
        Readout r = new Readout(times);
        r.out();
        sc.close();
    }
}
