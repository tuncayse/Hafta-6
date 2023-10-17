import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader readFile = new FileReader("src/numbers.txt");
            BufferedReader readBuff = new BufferedReader(readFile);
            String line;
            int total = 0;
            while ((line = readBuff.readLine()) != null){
                System.out.println(line);
                total += Integer.parseInt(line);
            }
            readBuff.close();
            readFile.close();
            System.out.println("Toplam: " + total);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
