import java.text.DecimalFormat;
import java.util.Scanner;

public class Uppgift7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("Skriv in euro kursen:");
        double euroKurs = scanner.nextDouble();

        System.out.println("Skriv in hur många kronor du vill växla till euro:");
        double antalKronor = scanner.nextDouble();

        String krTillEuro = df.format(antalKronor * euroKurs);

        System.out.println(String.format("För %f kronor så får du %s euro", antalKronor, krTillEuro));
    }
}
