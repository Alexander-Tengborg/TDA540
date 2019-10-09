import java.text.DecimalFormat;
import java.util.Scanner;

public class Uppgift7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("Skriv in euro kursen:");
        double euroKurs = scanner.nextDouble();

        System.out.println("Skriv in hur m�nga kronor du vill v�xla till euro:");
        double antalKronor = scanner.nextDouble();

        String krTillEuro = df.format(antalKronor * euroKurs);

        System.out.println(String.format("F�r %f kronor s� f�r du %s euro", antalKronor, krTillEuro));
    }
}
