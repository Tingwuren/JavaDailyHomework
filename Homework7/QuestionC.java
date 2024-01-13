import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.Scanner;

public class QuestionC {
    public static void main(String[] args) {
        try {
            ZipFile zipFile = new ZipFile("dict.dic");
            try (Scanner sc = new Scanner(System.in)) {
                int line = sc.nextInt();
                int count = 0;
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    count ++;
                    ZipEntry entry = entries.nextElement();
                    if(count == line)
                        System.out.println(entry.getName());
                }
            }
            zipFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}