import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String path = "notlar.txt";

        while (true) {
            System.out.println("1 - Metin Giriniz");
            System.out.println("2 - Son Kaydedilen Metni Goruntule");
            System.out.println("3 - Cikis");
            System.out.print("Secim : ");
            int select = scan.nextInt();
            scan.nextLine();

            switch (select) {
                case 1:
                    System.out.print("Bir metin girin: ");
                    String metin = scan.nextLine();
                    try {
                        FileWriter fileWriter = new FileWriter(path);
                        PrintWriter printWriter = new PrintWriter(fileWriter);
                        printWriter.print(metin);

                        System.out.println("Metin dosyaya kaydedildi.");
                    } catch (Exception e) {
                        System.err.println("Dosya yazma hatasi: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        FileReader fileReader = new FileReader(path);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String readText = bufferedReader.readLine();
                        bufferedReader.close();
                        if (readText != null) {
                            System.out.println("Son kaydedilen metin: " + readText);
                        } else {
                            System.out.println("Henuz kaydedilen metin yok.");
                        }
                    } catch (Exception e) {
                        System.err.println("Dosya okuma hatasi: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Cikis yapiliyor...");
                    System.exit(0);
                default:
                    System.out.println("Gecersiz secim. Lutfen tekrar deneyin.");
            }
        }
    }
}