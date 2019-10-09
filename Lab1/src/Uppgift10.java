import javax.swing.*;
import java.util.Scanner;

public class Uppgift10 {
    public static void main(String[] args) {
        int date = Integer.parseInt(JOptionPane.showInputDialog("Skriv in ett datum på formen yymmdd"));

        int mm = (date%10000)/100;
        int dd = date%100;
        int yy = date/10000;

        String newDate = String.format("%02d/%d/%d", mm, dd, yy);

        JOptionPane.showMessageDialog(null, String.format("Datumet, %d på formen mm/dd/yy ser ut så här: %s", date, newDate));
    }
}
