import javax.swing.*;
import java.util.Scanner;

public class Uppgift9 {
    public static void main(String[] args) {

        String b�tInfo = JOptionPane.showInputDialog(null, "Skriv in b�tens omf�ng, segelyta, l�ngd och fribordsh�jd");
        Scanner scanner = new Scanner(b�tInfo);

        double omf�ng = scanner.nextDouble();
        double segelyta = scanner.nextDouble();
        double l�ngd = scanner.nextDouble();
        double fribordsh�jd = scanner.nextDouble();

        double b�tensV�rde = (2*omf�ng+Math.sqrt(segelyta)+l�ngd-fribordsh�jd)/2.37;

        if(Math.abs(b�tensV�rde-12) <= 0.05) System.out.println("B�ten �r en 12:a!");
    }
}
