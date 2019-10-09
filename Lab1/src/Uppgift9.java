import javax.swing.*;
import java.util.Scanner;

public class Uppgift9 {
    public static void main(String[] args) {

        String båtInfo = JOptionPane.showInputDialog(null, "Skriv in båtens omfång, segelyta, längd och fribordshöjd");
        Scanner scanner = new Scanner(båtInfo);

        double omfång = scanner.nextDouble();
        double segelyta = scanner.nextDouble();
        double längd = scanner.nextDouble();
        double fribordshöjd = scanner.nextDouble();

        double båtensVärde = (2*omfång+Math.sqrt(segelyta)+längd-fribordshöjd)/2.37;

        if(Math.abs(båtensVärde-12) <= 0.05) System.out.println("Båten är en 12:a!");
    }
}
